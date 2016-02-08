package babycenter.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlRecordController {

  @Autowired
  private UrlRecordRepository repository;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  UrlRecord create(@RequestBody UrlRecord urlRecord) {
    return repository.insert(urlRecord);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  UrlRecord findById(@PathVariable("id") String id) {
        return repository.findById(id);
  }

}