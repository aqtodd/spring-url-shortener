package babycenter.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class UrlRecordService {

  private final UrlRecordRepository repository;
 
  @Autowired
  UrlRecordService(UrlRecordRepository repository) {
      this.repository = repository;
  }

  String insert(UrlRecord urlRecord) {
    UrlRecord queryResult = repository.findByLongUrl( urlRecord.getLongUrl() );
    if (queryResult != null )
      return queryResult.getShortUrlAsJson();
    else
      return repository.insert(urlRecord).getShortUrlAsJson();
  }

  String findById(String id) throws ResourceNotFoundException {
    UrlRecord queryResult = repository.findById(id);
    if (queryResult != null )
      return queryResult.getLongUrlAsJson();
    else
      throw new ResourceNotFoundException();
  }
}