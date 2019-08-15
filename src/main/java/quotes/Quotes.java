package quotes;

public class Quotes {
  public String author;
  public String text;

  Quotes(String author, String text) {
    this.author = author;
    this.text = text;
  }

  @Override
  public String toString() {
    return String.format(
      "Author: %s\n" +
          "Quote: %s\n",
        this.author, this.text
    );
  }
}
