package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

class Parser {
  public String inputReader(){
    Gson gson = new Gson();
    String parsedQuotes = jsonReader(gson);
    String swQ = urlReader(gson);

    System.out.println(parsedQuotes);
    System.out.println(swQ);
    return parsedQuotes;
  }

  public String urlReader(Gson gson) {
    try {
      URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");

      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuilder content = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      in.close();
      Quotable starWarsQuote = gson.fromJson(content.toString(), StarWarsQuote.class);
      return printQuote(starWarsQuote);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String jsonReader(Gson gson) {
    try {
      Quotable[] quote = gson.fromJson(
          new FileReader("./src/main/resources/recentquotes.json"),
          Quote[].class
      );
      return printQuote(quote);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  public int randomNum(Quotable[] quotes) {
    System.out.println(quotes.length);
    return (int) (Math.random() * quotes.length);
  }

  public String printQuote(Quotable[] quotes) {
    return quotes[randomNum(quotes)].toString();
  }

  public String printQuote(Quotable quote) {
    return quote.toString();
  }
}
