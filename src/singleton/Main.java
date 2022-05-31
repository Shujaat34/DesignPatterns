package singleton;

public class Main {
    public static void main(String[] args) {
        //LET'S create TWO OBJECTS AND SEE IF THEY BOTH HAVE THE SAME INSTANCE.
        Database instance1 = Database.getInstance();

        Database instance2 = Database.getInstance();

        System.out.println("Instance1 Hashcode : "+instance1.hashCode());
        System.out.println("Instance2 Hashcode : "+instance2.hashCode());

        if(instance1 == instance2) {
            System.out.println("This is a Singleton Class");
        }

    }
}
