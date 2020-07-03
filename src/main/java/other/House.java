package other;

/**
 * Класс дома, содержит характеристики: количество жильцов и
 * тип(малоэтажное, многоэтажное)
 */
public class House {
  public static enum TypeHouse {LOW_RISE, MULTISTORY}

  private int people;
  private TypeHouse typeHouse;

  public House(TypeHouse typeHouse, int people) {
    this.people = people;
    this.typeHouse = typeHouse;
  }

  public TypeHouse getTypeHouse() {
    return typeHouse;
  }

  public int getAmountPeople() {
    return people;
  }
}
