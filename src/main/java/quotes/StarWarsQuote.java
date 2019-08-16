package quotes;

public class StarWarsQuote implements Quotable {
  private String starWarsQuote;

  StarWarsQuote() {};

  StarWarsQuote(String starWarsQuote) {
    this.starWarsQuote = starWarsQuote;
  }

  @Override
  public String toString() {
    return String.format("Quote: %s\n", this.starWarsQuote.trim());
  }
}
