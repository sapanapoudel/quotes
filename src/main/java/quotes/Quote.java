package quotes;

import java.io.Serializable;

public class Quote implements Serializable {
  private String author;
  private String text;

  Quote(String author, String text) {
    this.author = author;
    this.text = text;
  }

  @Override
  public String toString() {
    return String.format(
      "Author: %s\n" +
          "Quote: %s\n",
        this.author, this.text.trim()
    );
  }
}
