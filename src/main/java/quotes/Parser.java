package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

class Parser {
  Quote[] jsonReader(){
    Gson gson = new Gson();
    Quote[] allQuotes = new Quote[]{};
    StringBuilder quotes = new StringBuilder();

    try {
      Scanner scanner = new Scanner(new File("./src/main/resources/recentquotes.json"));
      while (scanner.hasNextLine()) {
        quotes.append(scanner.nextLine());
      }
      allQuotes = gson.fromJson(quotes.toString(), Quote[].class);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return allQuotes;
  }

  int randomNum(Quote[] quotes) {
    return (int) (Math.random() * quotes.length);
  }

  String printQuote(Quote[] quotes) {
    int randomNum = randomNum(quotes);
    return quotes[randomNum].toString();
  }
}
