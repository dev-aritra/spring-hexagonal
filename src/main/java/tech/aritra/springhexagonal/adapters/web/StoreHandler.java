package tech.aritra.springhexagonal.adapters.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tech.aritra.springhexagonal.adapters.web.presenter.StorePresenter;
import tech.aritra.springhexagonal.application.ports.in.StoreManagementUseCase;

@Component
public class StoreHandler {
  private final StoreManagementUseCase useCase;

  @Autowired
  public StoreHandler(StoreManagementUseCase useCase) {
    this.useCase = useCase;
  }

  public Mono<ServerResponse> addStore(ServerRequest request) {
    return request.bodyToMono(StorePresenter.class)
      .flatMap(storePresenter -> ServerResponse.status(HttpStatus.CREATED)
        .contentType(MediaType.APPLICATION_JSON)
        .body(useCase.addStore(storePresenter.toDomain()).map(StorePresenter::fromDomain), StorePresenter.class));
  }
}
