package garden;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * В этом тесте используется подставной объект (mock) с void-методом
 */
public class SiteTest {
    private Site site;
    private Tree tree;
    private int k;

    @Before
    public void setUp() throws Exception {
        tree = mock(Tree.class);
        site = new Site(tree);
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
        site = null;
    }

    /*
    В этом примере выбрасывается IllegalArgumentException, когда в заглушке
    tree вызывается void-метод oak с неверным параметром(0 или -1) .
    "Мы с лёгкостью проверяем", что site пробрасывает такой эксепшн наружу.
     */
    @Test(expected = IllegalArgumentException.class)
    public void plant1() throws Exception {
        doThrow(IllegalArgumentException.class).when(tree).oak(-1);
        site.plant(0, -1);
        //в этом вызове мы проверяем, что site совершает вызов oak во вложенном tree
        verify(tree).oak(anyInt());

        doThrow(IllegalArgumentException.class).when(tree).oak(0);
        site.plant(0, 0);
        verify(tree).oak(anyInt());
    }

    @Test
    public void plant2() throws Exception {
        doNothing().when(tree).oak(anyInt()); //ни чего не делать
        site.plant(0, 3);

    }

    @Test //как проверить побочный эффект
    public void plant3() throws Exception {
        //doAnswer(new SpiceAnswer()).when(tree).oak(anyInt());

        site.plant(0 , 1);
        site.plant(0,2);
        site.plant(0, 5);
        //site.setAmountTree(k);
        assertEquals(3, site.getAmountTree());
    }
    /*
    private class SpiceAnswer implements Answer {
        @Override
        public String answer(InvocationOnMock invocation) throws Throwable {
            //String arg = (String) invocation.getArguments()[0];
            k = k + 1;
            return null;
        }
    }
    */
}

