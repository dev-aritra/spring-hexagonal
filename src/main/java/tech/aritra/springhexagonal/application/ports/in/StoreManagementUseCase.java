package tech.aritra.springhexagonal.application.ports.in;


import reactor.core.publisher.Mono;
import tech.aritra.springhexagonal.application.domain.Store;

public interface StoreManagementUseCase {
  Mono<Store> addStore(Store store);
}
