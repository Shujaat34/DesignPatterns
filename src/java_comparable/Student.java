package java_comparable;

import java.util.ArrayList;
import java.util.Collections;

/***
 * Comparable interface is used to sort the objects of same class in ascending or descending order. It compares this or current object with
 * the object passed in as parameter in compareTo method.
 * It has only one method compareTo(Object o),
 * so it is a Functional interface (SAM) Single Abstract Method. It provides a single sorting sequence only, i.e.,
 * you can sort the elements on the basis of single data member only. For example, it may be rollno, name, age or anything else.
 *
 * In this example we sort by Roll Number.
 */

public class Student implements Comparable<Student>{
    int rollNum;
    String name;
    int age;

    public Student(int rollNum, String name, int age) {
        this.rollNum = rollNum;
        this.name = name;
        this.age = age;
    }

    // Method
    // Sorting in ascending order of roll number
    @Override
    public int compareTo(Student other) {
        return this.rollNum - other.rollNum;
    }

//    public int compareTo(Student st){
//        if(age==st.age)
//            return 0;
//        else if(age>st.age)
//            return 1;
//        else
//            return -1;
//    }

    public static void main(String[] args) {
        ArrayList<Student> al=new ArrayList<Student>();
        al.add(new Student(110,"Rehan",23));
        al.add(new Student(106,"Babar",27));
        al.add(new Student(105,"Akshay",21));

        Collections.sort(al);

        for(Student st:al){
            System.out.println(st.rollNum+" "+st.name+" "+st.age);
        }
    }
}
