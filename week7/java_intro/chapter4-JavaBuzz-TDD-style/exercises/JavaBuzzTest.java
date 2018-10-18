import static org.junit.Assert.*;
import org.junit.Test;

public class JavaBuzzTest {

  @Test
  public void check1() {
    String answer = JavaBuzz.check(5);
    assertEquals(answer, "Buzz");
  }

  @Test
  public void check2() {
    String answer = JavaBuzz.check(9);
    assertEquals(answer, "Java");
  }

  @Test
  public void check3() {
    String answer2 = JavaBuzz.check(15);
    assertEquals(answer2, "JavaBuzz");
  }

  @Test
  public void check4() {
    String answer3 = JavaBuzz.check(16);
    assertEquals(answer3, "16");
  }

}
