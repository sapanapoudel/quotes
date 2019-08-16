package quotes;

import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    public App() throws IOException {
    }

    public static void main(String[] args) throws IOException, IllegalStateException {
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


            //Appending API quote to JSON file
            Quote newQuote = new Quote("Ron Swanson", content.toString());
            Parser parser = new Parser();
            Quote[] quotesFromFile = parser.jsonReader();
            FileWriter file = new FileWriter("src/main/resources/recentquotes.json");
            file.write(content.toString());
//            file.append(quotesFromFile)




        }catch (IOException e) {
            Parser parser = new Parser();
            Quote[] quotes = parser.jsonReader();
            String message = parser.printQuote(quotes);

            System.out.println("Quote from JSON: \n");
            System.out.println(message);

            }

        }

}
