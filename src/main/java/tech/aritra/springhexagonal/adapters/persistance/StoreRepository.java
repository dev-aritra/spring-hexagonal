package tech.aritra.springhexagonal.adapters.persistance;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import tech.aritra.springhexagonal.adapters.persistance.entity.StoreEntity;

@Repository
public interface StoreRepository extends ReactiveMongoRepository<StoreEntity, String> {
}
