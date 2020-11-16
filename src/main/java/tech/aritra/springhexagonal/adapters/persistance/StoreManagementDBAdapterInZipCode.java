package tech.aritra.springhexagonal.adapters.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import tech.aritra.springhexagonal.adapters.persistance.entity.StoreEntity;
import tech.aritra.springhexagonal.adapters.persistance.entity.ZipCodeEntity;
import tech.aritra.springhexagonal.application.domain.Store;
import tech.aritra.springhexagonal.application.ports.out.UpdateStoreCountInZipCodePort;
import tech.aritra.springhexagonal.application.ports.out.StorePort;

@Component
public class StoreManagementDBAdapterInZipCode implements StorePort, UpdateStoreCountInZipCodePort {
  private final StoreRepository storeRepository;
  private final ZipCodeRepository zipCodeRepository;

  @Autowired
  public StoreManagementDBAdapterInZipCode(StoreRepository storeRepository, ZipCodeRepository zipCodeRepository) {
    this.storeRepository = storeRepository;
    this.zipCodeRepository = zipCodeRepository;
  }

  @Override
  public Mono<Store> addStore(Store store) {
    return storeRepository.save(StoreEntity.fromDomain(store)).map(StoreEntity::toDomain);
  }

  @Override
  public void incrementStoreCount(String zipCode) {
    zipCodeRepository.findByZipCode(zipCode)
      .flatMap(zipCodeEntity -> zipCodeRepository.save(new ZipCodeEntity(zipCodeEntity.getId(), zipCodeEntity.getZipCode(), zipCodeEntity.getStoreCount() + 1)))
      .subscribe();
  }
}
