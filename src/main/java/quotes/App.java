package quotes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    public App() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        quotesFromAPI();
        }

        //Getting quotes from API call
    public static void quotesFromAPI() throws  IOException, IllegalStateException {
        try {
            URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int status = connection.getResponseCode();
            System.out.println("My status: " + status);

            //read the response of the request and place it in a content String:
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();
            System.out.println("Quote From API: " + content);

        }catch (IOException e) {
            noInternet();
        }
    }

    //Getting Quotes from JAS
    public static void noInternet() {
        Parser parser = new Parser();
        Quote[] quotes = parser.jsonReader();
        String message = parser.printQuote(quotes);

        System.out.println("Quote from JSON: \n");
        System.out.println(message);
    }

    //Appending API quotes to JSON file
    public static JsonArray addQuote (String jsonString) throws FileNotFoundException {
        JsonArray quotesFromAPI  = new JsonArray();

        try {
            Gson gson = new Gson();
            JsonObject inputObj = gson.fromJson(jsonString, JsonObject.class);
            JsonObject updateObj = new JsonObject();
            updateObj.add("text", inputObj.get("Ron Swanson"));
            quotesFromAPI = gson.fromJson(new FileReader("src/main/resources/recentquotes.json"),
                    JsonArray.class);
            quotesFromAPI.add(inputObj);
        } catch (IOException e) {
            e. printStackTrace();
        }

        return quotesFromAPI;

    }

    public static void addToJson(String jsonString) throws FileNotFoundException {
        JsonArray quotesFromAPI  = addQuote(jsonString);
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/recentquotes.json"));
            writer.write(quotesFromAPI.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
