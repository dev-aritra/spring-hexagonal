package tech.aritra.springhexagonal.application.domain;

public class Location {
  private final String zipCode;
  private final Double latitude;
  private final Double longitude;

  public Location(String zipCode, Double latitude, Double longitude) {
    this.zipCode = zipCode;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  boolean isValid() {
    // Some validation logic
    return true;
  }

  public String getZipCode() {
    return zipCode;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }
}
