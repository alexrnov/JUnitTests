package other;

import java.util.ArrayList;
import java.util.List;

public class City {
  private String name;
  private List<House> houses = new ArrayList<>();

  City(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addHouse(House house) {
    houses.add(house);
  }

  public int getAmountHouses() {
    return houses.size();
  }

  public Integer getPopulation() {
    return houses.stream()
                 .mapToInt(House::getAmountPeople)
                 .sum();
  }

  public long getAmountTypeHouse(House.TypeHouse typeHouse) {
    return houses.stream()
                 .filter(house -> house.getTypeHouse().equals(typeHouse))
                 .count();
  }
}
