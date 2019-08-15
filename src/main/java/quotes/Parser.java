package quotes;

import com.google.gson.Gson;

import java.io.*;

class Parser {
  public Quote[] jsonReader(){
    Gson gson = new Gson();
    Quote[] allQuotes = new Quote[]{};

    try {
      allQuotes = gson.fromJson(
          new FileReader("./src/main/resources/recentquotes.json"),
          Quote[].class
      );
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return allQuotes;
  }

  public int randomNum(Quote[] quotes) {
    return (int) (Math.random() * quotes.length);
  }

  public String printQuote(Quote[] quotes) {
    return quotes[randomNum(quotes)].toString();
  }
}
