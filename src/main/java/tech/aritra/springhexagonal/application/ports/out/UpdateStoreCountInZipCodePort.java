package tech.aritra.springhexagonal.application.ports.out;

public interface UpdateStoreCountInZipCodePort {
  void incrementStoreCount(String zipCode);
}
