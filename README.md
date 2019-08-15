<a name=top></a>
## Lab 08 - Quotes
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

<a name="files"></a>
#### Files:
* quotes
  * src/main 
    * [App.java](./src/main/java/quotes/App.java)
    * [Parser.java](./src/main/java/quotes/Parser.java)
    * [Quotes.java](./src/main/java/quotes/Quotes.java)
  * src/test
    * [ParserTest.java](./src/test/java/quotes/ParserTest.java)
    * [QuotesTest.java](./src/test/java/quotes/QuotesTest.java)

<a name="methods"></a>
#### Methods:
**App**
* Methods:
  * `main()`
    * Creates an instance of the Parser class and calls `jsonReader()`

**Parser**
* Methods:
  * `void jsonReader()`
    * reads the json file using Gson
    * adds all lines of the json file to an instance of the Quotes class as an array
    * calls `randomQuote()` and uses the instance of the Quotes as the argument
  * `int randomNum(Quotes[] quotes)`
    * returns a random number between 0 and `quotes.length`
  * `String printQuote(Quotes[] quotes)`
    * returns a quote at the random number

**Quotes**
* Variables:
  * `String author`
  * `String text`
* Methods:
  * `public String toString()`
    * returns a string with the author and quote

**[Back to Top](#top)**