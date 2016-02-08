import org.springframework.data.annotation.Id;

public class UrlRecord {

  static final int MAX_LENGTH_URL = 2000;

  @Id
  private String id;
  private String longUrl

  public UrlRecord() {}

  public UrlRecord(String longUrl) {
    this.longUrl = longUrl;
  }

}