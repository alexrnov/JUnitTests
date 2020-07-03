package other;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTest {

  private House house;
  @Before
  public void setUp() throws Exception {
    house = new House(House.TypeHouse.LOW_RISE, 5);
  }

  @After
  public void tearDown() throws Exception {
    house = null;
  }

  @Test
  public void typeHouse() {
    assertEquals(House.TypeHouse.LOW_RISE, house.getTypeHouse());
  }

  @Test
  public void getAmountPeople() {
    assertEquals(5, house.getAmountPeople());
  }
}