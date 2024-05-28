
package student_management;

import java.io.Serializable;




public class Student implements Serializable {
    String name, id, dept;
    int age;
    float cgpa;

    Student(String name, String id, String dept, int age, float cgpa) {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.age = age;
        this.cgpa = cgpa;

    }

    @Override
    public String toString() {
        return "name: " + name + " id: " + id + " dept: " + dept + " age: " + age + " cgpa: " + cgpa;
    }
    
}


