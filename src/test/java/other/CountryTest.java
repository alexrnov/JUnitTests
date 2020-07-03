package other;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryTest {

  private Country country = new Country("TestCountry");

  @Before
  public void setUp() throws Exception {

    City city1 = mock(City.class);
    when(city1.getName()).thenReturn("town 1");
    when(city1.getAmountHouses()).thenReturn(2);
    when(city1.getPopulation()).thenReturn(100);
    City city2 = mock(City.class);
    when(city2.getName()).thenReturn("town 2");
    when(city2.getAmountHouses()).thenReturn(2);
    when(city2.getPopulation()).thenReturn(120);
    country.addCity(city1);
    country.addCity(city2);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getName() {
    assertEquals("TestCountry", country.getName());
  }

  @Test
  public void amountCity() {
    assertEquals(2, country.amountCity());
  }

  @Test
  public void amountHouses() {
    assertEquals(4, country.amountHouses());
  }

  @Test
  public void amountPeople() {
    assertEquals(220, country.amountPeople());
  }

  @Test
  public void largestCity() {
    assertEquals("town 2", country.largestCity().getName());
  }

  @Test
  public void smallestCity() {
    assertEquals("town 1", country.smallestCity().getName());
  }
}