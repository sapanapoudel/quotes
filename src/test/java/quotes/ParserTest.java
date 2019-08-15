package quotes;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

  @Test
  public void testJsonReader() {
    Parser parser = new Parser();
    Quotes[] quotes = parser.jsonReader();
    assertEquals("should be same", "Author: Marilyn Monroe\n" +
            "Quote:  “I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.” \n",
            quotes[0].toString());
  }

  @Test
  public void testRandomNum() {
    Parser parser = new Parser();
    Quotes[] quotes = parser.jsonReader();
    for (int i = 0; i < 1000; i++) {
      int randomNum = parser.randomNum(quotes);
      assertTrue(randomNum >= 0 && randomNum < quotes.length);
    }
  }

  @Test
  public void testPrintQuote() {
    Parser parser = new Parser();
    Quotes[] quotes = parser.jsonReader();
    for (int i = 0; i < 1000; i++) {
      String quote = parser.printQuote(quotes);
      assertNotNull(quote);
    }
  }
}