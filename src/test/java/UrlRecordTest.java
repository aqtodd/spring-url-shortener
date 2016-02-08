package babycenter.urlshortener;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class UrlRecordTest {

  @Test
  public void createsUrlRecord() {
    String babyCenterUrl = "http://babycenter.com";
    UrlRecord urlRecord = new UrlRecord(babyCenterUrl);
    assertTrue( babyCenterUrl.equals(urlRecord.getLongUrl()) );
    assertTrue( urlRecord.getId() == null );
  }

}