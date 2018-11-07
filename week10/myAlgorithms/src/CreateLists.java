import java.util.*;

public class CreateLists {

    public ArrayList<String> pool;

    public CreateLists() {
        this.pool = pool;
        this.setPool();
    }

    public void setPool() {
        ArrayList<String> pool = new ArrayList<String>();
        pool.add("This");
        pool.add("This");
        pool.add("This");
        pool.add("is");
        pool.add("is");
        pool.add("is");
        pool.add("pool");
        pool.add("pool");
        pool.add("ambience");
        pool.add("ambience");
        pool.add("words");
        pool.add("words");
        pool.add("twice");
        pool.add("twice");
        pool.add("more");
        pool.add("more");
        pool.add("worte");
        pool.add("worte");
        pool.add("added");
        pool.add("added");
        pool.add("because");
        pool.add("because");
        pool.add("Superkalafristik");
        pool.add("we");
        pool.add("need");
        pool.add("for");
        pool.add("testing");
        pool.add("I am unique");
        this.pool = pool;
    }

    public ArrayList<Integer> createIntList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i < (size + 1); i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public ArrayList<String> createStringList(int size) {
        ArrayList<String> stringList = new ArrayList<String>();
        for (int i=0; i < size/10; i++) {
            this.setPool();
            ArrayList<String> pool = this.pool;
            for (int j =0; j < 10; j++) {
                Random random = new Random();
                String word = pool.get(random.nextInt(pool.size()));
                stringList.add(word);
                pool.remove(word);
            }
        }
        return stringList;
    }

}