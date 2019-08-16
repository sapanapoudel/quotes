package quotes;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
  @Test
  public void testUrlReader() {
    Gson gson = new Gson();
    Parser parser = new Parser();
    assertNotNull(
        "testUrlReader should return: ",
        parser.urlReader(gson)
    );
  }

  @Test
  public void testJsonReader() {
    Gson gson = new Gson();
    Parser parser = new Parser();
    assertNotNull(
        "testJsonReader should return: ",
        parser.jsonReader(gson));
  }
}
