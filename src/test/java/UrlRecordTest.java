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
    assertTrue( expectedJson("shortUrl",expectedShortUrl).equals(urlRecord.getShortUrlAsJson()) );
  }

  @Test
  public void getsLongUrl() {
    String longUrl = "https://i.ytimg.com/vi/b6dT4kyVUuY/maxresdefault.jpg";
    UrlRecord urlRecord = new UrlRecord(longUrl);
    assertTrue( expectedJson("longUrl", longUrl).equals(urlRecord.getLongUrlAsJson()) );

  }

  private String expectedJson(String urlName, String expectedUrl) {
    JsonObject result = Json.createObjectBuilder()
                  .add(urlName, expectedUrl)
                  .build();
    return result.toString();
  }

}