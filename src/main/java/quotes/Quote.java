package quotes;

public class Quote implements Quotable {
  private String author;
  private String text;

  Quote(String author, String text) {
    this.author = author;
    this.text = text;
  }

  @Override
  public String toString() {
    return String.format(
      "Quote: %s - %s\n",
        this.text.trim(), this.author
        );
  }
}
