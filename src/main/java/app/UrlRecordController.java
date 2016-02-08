package babycenter.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.json.*;

@RestController
@RequestMapping("/url")
public class UrlRecordController {

  @Autowired
  private UrlRecordRepository repository;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  JsonObject create(@RequestBody UrlRecord urlRecord) {
    return repository.insert(urlRecord).getShortUrlAsJson();
  }

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  UrlRecord findById(@PathVariable("id") String id) {
        return repository.findById(id);
  }

}