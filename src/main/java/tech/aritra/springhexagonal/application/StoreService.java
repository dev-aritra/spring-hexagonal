package tech.aritra.springhexagonal.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import tech.aritra.springhexagonal.application.domain.Store;
import tech.aritra.springhexagonal.application.ports.in.StoreManagementUseCase;
import tech.aritra.springhexagonal.application.ports.out.UpdateStoreCountInZipCodePort;
import tech.aritra.springhexagonal.application.ports.out.StorePort;

import javax.naming.directory.InvalidAttributesException;

@Service
public class StoreService implements StoreManagementUseCase {
  private final StorePort storePort;
  private final UpdateStoreCountInZipCodePort updateStoreCountInZipCodePort;

  @Autowired
  public StoreService(StorePort storePort, UpdateStoreCountInZipCodePort updateStoreCountInZipCodePort) {
    this.storePort = storePort;
    this.updateStoreCountInZipCodePort = updateStoreCountInZipCodePort;
  }

  @Override
  @Transactional
  public Mono<Store> addStore(Store store) {
    if (store.isValid()) {
      final Mono<Store> result = storePort.addStore(store);
      updateStoreCountInZipCodePort.incrementStoreCount(store.getLocation().getZipCode());
      return result;
    }
    return Mono.error(InvalidAttributesException::new);
  }
}
