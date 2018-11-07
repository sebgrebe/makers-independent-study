import java.util.ArrayList;

import org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class myMethodsTest {

    CreateLists createLists = new CreateLists();
    ArrayList<String> stringList = createLists.pool;
    ArrayList<String> stringList2 = new ArrayList<String>();
    MyMethods myMethods = new MyMethods();

    @Before
    public void beforeEachTest() {

        stringList2.add("this");
        stringList2.add("has");
        stringList2.add("no");
        stringList2.add("repetitions");

    }

    @Test
    public void testDuplicate(){
        System.out.println(myMethods.duplicate(stringList));

        assertThat(myMethods.duplicate(stringList), hasItems("This"));
        assertThat(myMethods.duplicate(stringList), not(hasItems("Superkalafristik")));
    }

    @Test
    public void testDuplicate2(){
        assertEquals(0, myMethods.duplicate(stringList2).size());
    }

    @Test
    public void testDuplicateWithHash(){
        assertThat(myMethods.duplicateWithHash(stringList), hasItems("This"));
        assertThat(myMethods.duplicateWithHash(stringList), not(hasItems("Superkalafristik")));
    }

    @Test
    public void testDuplicateWithHash2(){
        assertEquals(myMethods.duplicateWithHash(stringList2).size(), 0);
    }

    @Test
    public void testFrequency() {
        assertThat(myMethods.frequency(stringList), hasItems("This"));
        assertThat(myMethods.frequency(stringList), hasItems("because"));
        assertThat(myMethods.frequency(stringList), not(hasItems("Superkalifristik")));

    }


}