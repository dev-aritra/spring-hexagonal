package tech.aritra.springhexagonal.adapters.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StoreRouter {
  @Bean
  public RouterFunction<ServerResponse> routes(StoreHandler handler) {
    return route(POST("/stores").and(accept(MediaType.APPLICATION_JSON)), handler::addStore);
  }
}
