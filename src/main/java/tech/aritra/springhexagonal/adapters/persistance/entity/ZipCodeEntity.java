package tech.aritra.springhexagonal.adapters.persistance.entity;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Document(collection = "zip-codes")
public class ZipCodeEntity {
  @Id
  String id;
  String zipCode;
  int storeCount;
}
