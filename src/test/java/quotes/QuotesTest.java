package quotes;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuotesTest {

  @Test
  public void testToString() {
    Parser parser = new Parser();
    Quotes[] quotes = parser.jsonReader();
    assertEquals("should be same", "Author: Marilyn Monroe\n" +
                    "Quote: “I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.”\n",
            quotes[0].toString());

  }
}