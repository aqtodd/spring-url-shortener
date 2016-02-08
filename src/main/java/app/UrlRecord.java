package babycenter.urlshortener;

import org.springframework.data.annotation.Id;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.json.Json;
import javax.json.JsonObject;

public class UrlRecord {

  static final int MAX_LENGTH_URL = 2000;
  static final String BASE_URL = "http://localhost:8080/url/";

  @Id
  private String id;

  @NotEmpty
  @Size(max = MAX_LENGTH_URL)
  private String longUrl;

  public UrlRecord() {}

  public UrlRecord(String longUrl) {
    this.longUrl = longUrl;
  }

  public UrlRecord(String longUrl, String id) {
    this.longUrl = longUrl;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public String getLongUrl() {
    return longUrl;
  }

  public String getShortUrl() {
    return BASE_URL + id;
  }

  public String getShortUrlAsJson() {
    JsonObject result = Json.createObjectBuilder()
                  .add("shortUrl", getShortUrl())
                  .build();
    return result.toString();
  }

  public String getLongUrlAsJson() {
    JsonObject result = Json.createObjectBuilder()
                  .add("longUrl", getLongUrl())
                  .build();
    return result.toString();
  }

}