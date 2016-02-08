import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRecordRepository extends MongoRepository<UrlRecord, String> {

    public UrlRecord findOne(String id);

    public UrlRecord save(UrlRecord record);

}