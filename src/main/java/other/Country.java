package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Country {

  private String name;
  private List<City> cities = new ArrayList<>();

  public Country(String name) {
    this.name = name;
  }

  public void addCity(City city) {
    cities.add(city);
  }

  public String getName() {
    return name;
  }

  public int amountCity() {
    return cities.size();
  }

  public long amountHouses() {
    return cities.stream()
                 .mapToInt(City::getAmountHouses)
                 .sum();
  }

  public long amountPeople() {
    return cities.stream()
                 .mapToInt(City::getPopulation)
                 .sum();
  }

  public City largestCity() {
    cities.sort((a, b) -> b.getPopulation().compareTo(a.getPopulation()));
    return cities.get(0);
  }

  public City smallestCity() {
    cities.sort(Comparator.comparing(City::getPopulation));
    return cities.get(0);
  }


}
