package java_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A comparator interface is used to sort the objects of same class in ascending or descending order. A comparator object is capable of
 * comparing two objects of the same class. It has many methods other than compare(Object o1, Object o2), so it is a Normal interface.
 */

public class Student {
    int rollNum;
    String name;
    int age;

    public Student(int rollNum, String name, int age) {
        this.rollNum = rollNum;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Student> ar = new ArrayList<>();

        // Adding entries in above List
        // using add() method
        ar.add(new Student(121, "Jameel", 20));
        ar.add(new Student(332, "Farhan", 25));
        ar.add(new Student(126, "Adnan", 19));
        ar.add(new Student(382, "Mujeeb", 18));

        // Display message on console for better readability
        System.out.println("Unsorted");

        // Iterating over entries to print them
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        // Sorting student entries by roll number
        Collections.sort(ar, new SortByRollNum());

        // Display message on console for better readability
        System.out.println("\nSorted by rollno");

        // Again iterating over entries to print them
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        // Sorting student entries by name
        Collections.sort(ar, new SortByName());

        // Display message on console for better readability
        System.out.println("\nSorted by name");

        // // Again iterating over entries to print them
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}

class SortByRollNum implements Comparator<Student> {
    // Method
    // Sorting in ascending order of roll number
    @Override
    public int compare(Student o1, Student o2) {
        return o1.rollNum - o2.rollNum;
    }
}

class SortByName implements Comparator<Student> {

    // Method
    // Sorting in ascending order of name
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}
