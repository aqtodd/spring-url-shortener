package babycenter.urlshortener;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import javax.json.Json;
import javax.json.JsonObject;

public class UrlRecordTest {

  @Test
  public void createsUrlRecord() {
    String longUrl = "http://babycenter.com";
    UrlRecord urlRecord = new UrlRecord(longUrl);
    assertTrue( longUrl.equals(urlRecord.getLongUrl()) );
    assertTrue( urlRecord.getId() == null );
  }

  @Test
  public void getsShortUrl() {
    String longUrl = "http://babycenter.com";
    String expectedId = "12345678";
    String expectedShortUrl = "http://localhost:8080/url/12345678";
    UrlRecord urlRecord = new UrlRecord(longUrl, expectedId);
    // String test_results = String.format("expected Json:  %s\ngenerated Json: %s\n", expectedJson(expectedShortUrl), urlRecord.getShortUrlAsJson());
    // System.out.println(test_results);
    assertTrue( expectedJson(expectedShortUrl).equals(urlRecord.getShortUrlAsJson()) );
  }

  private JsonObject expectedJson(String expectedShortUrl) {
    JsonObject result = Json.createObjectBuilder()
                  .add("shortUrl", expectedShortUrl)
                  .build();
    return result;
  }

}