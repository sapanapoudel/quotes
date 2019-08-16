<a name=top></a>
## Lab 08 - Quotes & Lab 09 - Potent Quotables
### Table of Contents
* [Team](#team)
* [Resources](#resources)
* [Files](#files)
* [Methods](#methods)

<a name="team"></a>
#### Team:
* Nicholas Paro
* Sapana Poudel

<a name="resources"></a>
#### Resources:
* Bomi Bear
* Melfi Perez
* Travis Cox
* Marisha Hoza
* [HTTP Java Request](https://www.baeldung.com/java-http-request)

<a name="files"></a>
#### Files:
* quotes
  * src/main 
    * [App.java](./src/main/java/quotes/App.java)
    * [Parser.java](./src/main/java/quotes/Parser.java)
    * [Quotable.java](./src/main/java/quotes/Quotable.java)
    * [Quote.java](./src/main/java/quotes/Quote.java)
    * [StarWarsQuote.java](./src/main/java/quotes/StarWarsQuote.java)
  * src/test
    * [ParserTest.java](./src/test/java/quotes/ParserTest.java)

<a name="methods"></a>
#### Methods:
**Interface**
* **Quotable**
  * Methods:
    * String toString();

**Classes**
* **App**
  * Methods:
    * `main()`
      * Creates an instance of the Parser class and calls `jsonReader()`

* **Parser**
  * Methods:
    * `public String inputReader()`
    * `public String urlReader(Gson gson)`
      * opens an HTTP connection and pulls in a random quote from the Star Wars quote API
      * Assigns the quote to an instance of `StarWarsQuote` as a `Quotable` object
      * returns a call to `printQuote` and passes in the `starWarsQuote` as a non array argument
    * `public String jsonReader(Gson gson)`
      * reads the json file using Gson
      * adds all lines of the json file to an instance of the Quotes class, as an instance of the Quotable interface, as an array called `quotes`
      * returns a call to `printQuote` and passes in `quotes` as an array argument 
    * `int randomNum(Quotable[] quotes)`
      * returns a random number between 0 and `quotes.length`
    * `String printQuote(Quotable[] quotes)`
      * returns a quote at the random number as a string
    * `String printQuote(Quotable quote)`
      * returns the quote as a string
  
* **Quotes extends Quotable**
  * Variables:
    * `String author`
    * `String text`
  * Methods:
    * `public String toString()`
      * returns a string with the quote and author

* **StarWarsQuote extends Quotable**
  * Variables:
    * `String starWarsQuote`
  * Methods:
    * `public String toString()`
      * returns a string with the quote
  
**[Back to Top](#top)**