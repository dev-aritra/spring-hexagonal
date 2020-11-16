package tech.aritra.springhexagonal.adapters.persistance.entity;

import lombok.Value;

import java.util.List;

@Value
public class GeoJSONPoint {
  String type = "Point";
  List<Double> coordinates;
}
