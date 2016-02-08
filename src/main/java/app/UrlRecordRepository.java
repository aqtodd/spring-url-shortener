package babycenter.urlshortener;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRecordRepository extends MongoRepository<UrlRecord, String> {

    public UrlRecord findById(String id);

    public UrlRecord findByLongUrl(String longUrl);

    public UrlRecord insert(UrlRecord urlRecord);

}