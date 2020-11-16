package tech.aritra.springhexagonal.adapters.persistance.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tech.aritra.springhexagonal.application.domain.Location;
import tech.aritra.springhexagonal.application.domain.Store;

import java.util.List;

@Document(collection = "stores")
public class StoreEntity {
  @Id
  private String id;
  private final String name;
  private final String zipCode;
  private final GeoJSONPoint geoJSONPoint;

  public StoreEntity(String name, String zipCode, GeoJSONPoint geoJSONPoint) {
    this.name = name;
    this.zipCode = zipCode;
    this.geoJSONPoint = geoJSONPoint;
  }

  public static StoreEntity fromDomain(Store store) {
    return new StoreEntity(
      store.getName(),
      store.getLocation().getZipCode(),
      new GeoJSONPoint(List.of(store.getLocation().getLongitude(), store.getLocation().getLatitude())));
  }

  public Store toDomain() {
    return new Store(id, name, new Location(zipCode, geoJSONPoint.getCoordinates().get(1), geoJSONPoint.getCoordinates().get(0)));
  }
}
