package babycenter.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.json.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/url")
public class UrlRecordController {

  private UrlRecordService service;

  @Autowired
  UrlRecordController(UrlRecordService service) {
    this.service = service;
  }

  @RequestMapping(method = RequestMethod.POST, produces="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  String create(@RequestBody @Valid UrlRecord urlRecord) {
    return service.insert(urlRecord);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.GET, produces="application/json")
  String findById(@PathVariable("id") String id) {
    return service.findById(id);
  }

}