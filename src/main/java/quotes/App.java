package quotes;

public class App {
    public static void main(String[] args){
        Parser parser = new Parser();
        Quotes[] quotes = parser.jsonReader();
        System.out.println(parser.printQuote(quotes));
    }
}
