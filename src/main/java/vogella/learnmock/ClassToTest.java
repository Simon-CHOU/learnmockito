package vogella.learnmock;

public class ClassToTest {
    private MyDatabase myDatabase;

    public ClassToTest(MyDatabase myDatabase) {
        this.myDatabase = myDatabase;
    }

    public boolean query(String s) {
        return myDatabase.query(s);
    }
}
