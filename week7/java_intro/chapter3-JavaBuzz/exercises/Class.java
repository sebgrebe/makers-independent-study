// can you remember how to set up your main function?
public class JavaBuzz {
  static void main(String[] args) {
    for (int i = 1; i < 101; i++) {
      System.out.println(check(i));
    }
  }

  public String check (int i) {
    if (i % 15 == 0) {
      return "JavaBuzz";
    } else if (i % 3 == 0) {
      return "Java";
    } else if (i % 5 == 0) {
      return "Buzz";
    } else {
      return Integer.toString(i);
    }
  }
}
