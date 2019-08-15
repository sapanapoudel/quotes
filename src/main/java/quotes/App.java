package quotes;

public class App {
    public static void main(String[] args){
        Parser parser = new Parser();
        Quote[] quotes = parser.jsonReader();
        System.out.println(parser.printQuote(quotes));
    }
}
