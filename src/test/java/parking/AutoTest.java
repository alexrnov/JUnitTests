package parking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutoTest {
    private Transport auto;

    @Before
    public void setUp() throws Exception {
        auto = new Auto();
    }

    @After
    public void tearDown() throws Exception {
        auto = null;
    }

    @Test
    public void auto_number_test() throws Exception {
        int k = 0;
        System.out.println("Пять разных номеров в формате AA001A: ");
        while (k < 5) {
            System.out.println(auto.getNumber());
            k += 1;
        }
    }

}