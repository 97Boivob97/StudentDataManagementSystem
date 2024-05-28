
package student_management;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("                    Welcome to Student's Data Management System");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String username = "admin";
        System.out.print("Enter username: ");
        String user = sc.next();
        int password = 1234567;
        System.out.print("Enter password: ");
        int pass = sc.nextInt();
        int c = 0;
        while (c == 0) {
           
            if (pass == password  && user.equals(username)) {
                System.out.println("Log in Successfull");

                int choice = -1;
                ArrayList<Student> A = new ArrayList<>();
                File file = new File("std.txt");
                ObjectInputStream input = null;
                ObjectOutputStream output = null;
                ListIterator list = null;
                if (file.isFile()) {
                    input = new ObjectInputStream(new FileInputStream(file));
                    A = (ArrayList<Student>) input.readObject();
                    input.close();

                }

                do {
                    System.out.println("1.Add");
                    System.out.println("2.Display");
                    System.out.println("3.Search");
                    System.out.println("4.Delete");
                    System.out.println("5.Update");
                    System.out.println("0.Exit");
                    System.out.println("Please Enter Your Choice: ");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("How many Students: ");
                            int n = sc.nextInt();
                            for (int i = 0; i < n; i++) {
                                System.out.println("Enter Name: ");
                                String name = sc.next();
                                System.out.println("Enter Id: ");
                                String id = sc.next();
                                System.out.println("Enter Department: ");
                                String dept = sc.next();
                                System.out.println("Enter Age: ");
                                int age = sc.nextInt();
                                System.out.println("Enter Cgpa: ");
                                float cgpa = sc.nextFloat();
                                A.add(new Student(name, id, dept, age, cgpa));
                            }
                            output = new ObjectOutputStream(new FileOutputStream(file));
                            output.writeObject(A);
                            output.close();

                            break;
                        case 2:
                       try {
                            input = new ObjectInputStream(new FileInputStream(file));
                            A = (ArrayList<Student>) input.readObject();
                            input.close();
                            System.out.println("---------------------------------");
                            list = A.listIterator();
                            while (list.hasNext()) {
                                System.out.println(list.next());

                            }
                           System.out.println("---------------------------------");
                        } catch (Exception E) {
                            System.out.println(E);
                        }
                        break;

                        case 3:
                        try {
                            input = new ObjectInputStream(new FileInputStream(file));
                            A = (ArrayList<Student>) input.readObject();
                            input.close();

                            boolean found = false;
                            System.out.println("Enter Name to Search:");
                            String name = sc.next();
                            System.out.println("Enter Id to Search:");
                            String id = sc.next();

                            System.out.println("-------------------");
                            list = A.listIterator();
                            while (list.hasNext()) {
                                Student S = (Student) list.next();

                                if (S.name.equals(name) && S.id.equals(id)) {
                                    System.out.println(S);
                                    found = true;
                                }
                            }

                            if (!found) {
                                System.out.println("Data not found");
                            }

                            System.out.println("-------------------");
                        } catch (Exception E) {
                            System.out.println(E);
                        }
                        break;
                        case 4: 
                        
                         try {
                            input = new ObjectInputStream(new FileInputStream(file));
                            A = (ArrayList<Student>) input.readObject();
                            input.close();

                            boolean found = false;
                            System.out.println("Enter Name to Delete:");
                            String name = sc.next();
                            System.out.println("Enter Id to Delete:");
                            String id = sc.next();

                            System.out.println("-------------------");
                            list = A.listIterator();
                            while (list.hasNext()) {
                                Student S = (Student) list.next();

                                if (S.name.equals(name) && S.id.equals(id)) {
                                    list.remove();
                                    found = true;
                                }
                            }

                            if (found) {
                                output = new ObjectOutputStream(new FileOutputStream(file));
                                output.writeObject(A);
                                output.close();
                                System.out.println("Delete Successfully");
                            } else {

                                System.out.println("Data not found");
                            }

                            System.out.println("-------------------");
                        } catch (Exception E) {
                            System.out.println(E);
                        }
                        break;
                        case 5:
                        try {
                            input = new ObjectInputStream(new FileInputStream(file));
                            A = (ArrayList<Student>) input.readObject();
                            input.close();

                            boolean found = false;
                            System.out.println("Enter Name to Update:");
                            String name = sc.next();
                            System.out.println("Enter Id to Update:");
                            String id = sc.next();

                            System.out.println("-------------------");
                            list = A.listIterator();
                            while (list.hasNext()) {
                                Student S = (Student) list.next();

                                if (S.name.equals(name) && S.id.equals(id)) {
                                    System.out.println("Enter new id:");
                                    String new_id = sc.next();
                                    System.out.println("Enter new dept:");
                                    String new_dept = sc.next();
                                    System.out.println("Enter new age:");
                                    int new_age = sc.nextInt();
                                    System.out.println("Enter new cgpa:");
                                    float new_cgpa = sc.nextFloat();
                                    list.set(new Student(name, new_id, new_dept, new_age, new_cgpa));
                                    found = true;
                                }
                            }

                            if (found) {
                                output = new ObjectOutputStream(new FileOutputStream(file));
                                output.writeObject(A);
                                output.close();
                                System.out.println("Updated Successfully");
                            } else {

                                System.out.println("Data not found");
                            }

                            System.out.println("-------------------");
                        } catch (Exception E) {
                            System.out.println(E);
                        }
                        break;
                        case 0:
                            System.out.println("Exit from the System");
                            System.exit(0);
                            break;
                        default : 
                               System.out.println("Wrong choice of Number!!!");
                               System.out.println("Try Again!");
                               
                    }
                } while (choice != 0);

                c = 1;

            } else {
                

                System.out.println("Wrong Information");
                System.out.println("Please ReEnter username and password again!...: ");
                System.out.print("Enter username: ");
                user = sc.next();
                System.out.print("Enter password : ");
                pass = sc.nextInt();

            }
        }

    }
    
}
