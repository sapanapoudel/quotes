package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

class Parser {
  Quotes[] jsonReader(){
    Gson gson = new Gson();
    Quotes[] allQuotes = new Quotes[]{};
    StringBuilder quotes = new StringBuilder();

    try {
      Scanner scanner = new Scanner(new File("./src/main/resources/recentquotes.json"));
      while (scanner.hasNextLine()) {
        quotes.append(scanner.nextLine());
      }
      allQuotes = gson.fromJson(quotes.toString(), Quotes[].class);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return allQuotes;
  }

  int randomNum(Quotes[] quotes) {
    return (int) (Math.random() * quotes.length);
  }

  String printQuote(Quotes[] quotes) {
    int randomNum = randomNum(quotes);
    return quotes[randomNum].toString();
  }
}
