import java.util.ArrayList;

import org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class TimingTest {

    CreateLists createLists = new CreateLists();
    ArrayList<String> stringList = createLists.pool;
    ArrayList<String> stringList2 = new ArrayList<String>();

    @Before
    public void beforeEachTest() {

        stringList2.add("this");
        stringList2.add("has");
        stringList2.add("no");
        stringList2.add("repetitions");

    }

    @Test
    public void testDuplicate(){

        assertThat(Timing.myDuplicateWithHash.apply(stringList), hasItems("This"));
        assertThat(Timing.myDuplicateWithHash.apply(stringList), not(hasItems("Superkalafristik")));
    }

    @Test
    public void testDuplicate2(){
        assertEquals(0, Timing.myDuplicateWithHash.apply(stringList2).size());
    }

    @Test
    public void testFrequency() {
        assertThat(Timing.myDuplicateWithHash.apply(stringList), hasItems("This"));
        assertThat(Timing.myDuplicateWithHash.apply(stringList), hasItems("because"));
        assertThat(Timing.myDuplicateWithHash.apply(stringList), not(hasItems("Superkalifristik")));

    }

    @Test
    public void testFrequencyWithHash(){
        assertThat(Timing.myDuplicateWithHash.apply(stringList), hasItems("This"));
        assertThat(Timing.myDuplicateWithHash.apply(stringList), hasItems("because"));
        assertThat(Timing.myDuplicateWithHash.apply(stringList), not(hasItems("Superkalifristik")));
    }


}