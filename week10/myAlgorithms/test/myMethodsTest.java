import java.util.ArrayList;

import org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class myMethodsTest {

    ArrayList<String> stringList = new ArrayList<String>();
    ArrayList<String> stringList2 = new ArrayList<String>();
    ArrayList<String> duplicates = new ArrayList<String>();
    MyMethods myMethods = new MyMethods();

    @Before
    public void beforeEachTest() {
        stringList.add("This");
        stringList.add("text");
        stringList.add("and");
        stringList.add("text");
        stringList.add("has");
        stringList.add("unnecessary");
        stringList.add("repetitions");
        stringList.add("It");
        stringList.add("has");
        stringList.add("them");
        stringList.add("to");
        stringList.add("test");
        stringList.add("this");
        stringList.add("algorithm");
        stringList.add("for");
        stringList.add("text");

        stringList2.add("this");
        stringList2.add("has");
        stringList2.add("no");
        stringList2.add("repetitions");

        duplicates.add("text");
        duplicates.add("has");
    }

    @Test
    public void testDuplicate(){
        System.out.println(myMethods.duplicate(stringList));

        assertEquals(myMethods.duplicate(stringList), duplicates);
    }

    @Test
    public void testDuplicate2(){
        assertEquals(0, myMethods.duplicate(stringList2).size());
    }

}