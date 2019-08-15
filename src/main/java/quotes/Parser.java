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
    return  allQuotes;
  }

  void randomQuote(Quotes[] quotes) {
    int random = (int) (Math.random() * quotes.length);
    System.out.println(quotes[random]);
  }
}
