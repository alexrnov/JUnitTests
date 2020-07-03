package other;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CityTest {

  private City city;
  @Before
  public void setUp() throws Exception {
    city = new City("A");
    House house1 = mock(House.class);
    when(house1.getAmountPeople()).thenReturn(5);
    when(house1.getTypeHouse()).thenReturn(House.TypeHouse.LOW_RISE);
    House house2 = mock(House.class);
    when(house2.getAmountPeople()).thenReturn(100);
    when(house2.getTypeHouse()).thenReturn(House.TypeHouse.MULTISTORY);
    city.addHouse(house1);
    city.addHouse(house2);
  }

  @After
  public void tearDown() throws Exception {
    city = null;
  }

  @Test
  public void getName() {
    assertEquals("A", city.getName());
  }

  @Test
  public void addHouse() {
    assertEquals(2, city.getAmountHouses());
  }

  @Test
  public void getAmountHouses() {
    assertEquals(2, city.getAmountHouses());
  }

  @Test
  public void getPopulation() {
    assertEquals((Integer)105, city.getPopulation());
  }

  @Test
  public void getAmountTypeHouse() {
    assertEquals(1, city.getAmountTypeHouse(House.TypeHouse.LOW_RISE));
    assertEquals(1, city.getAmountTypeHouse(House.TypeHouse.MULTISTORY));
  }
}