package tech.aritra.springhexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringHexagonalApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringHexagonalApplication.class, args);
  }

}
