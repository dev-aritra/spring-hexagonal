package tech.aritra.springhexagonal.application.ports.out;

import reactor.core.publisher.Mono;
import tech.aritra.springhexagonal.application.domain.Store;

public interface StorePort {
  Mono<Store> addStore(Store store);
}
