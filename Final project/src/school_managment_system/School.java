/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_managment_system;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**

 @author EMAM
 */
public class School {

      static ArrayList<Student> students = new ArrayList<>();
      static ArrayList<Teacher> teachers = new ArrayList<>();
      static ArrayList<Subject> subjects = new ArrayList<>();
      static Principal principal;

      static String filePath = "project.dat";

      static Scanner in = new Scanner(System.in);

      private static void readData() throws IOException, ClassNotFoundException {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(new File(filePath)));
            String type = "";
            Object s = "";
            while ( (s = file.readObject()) != null ) {
                  if ( (s.toString()).equalsIgnoreCase("Students") || (s.toString()).equalsIgnoreCase("Teachers") || (s.toString()).equalsIgnoreCase("Subjects") ) {
                        type = (s.toString());
                  } else {
                        switch ( type ) {
                              case "Students":
                                    students.add((Student)s);
                                    break;
                              case "Teachers":
                                    teachers.add((Teacher)s);
                                    break;
                              case "Subjects":
                                    subjects.add((Subject)s);
                                    break;
                              default:
                                    throw new AssertionError();
                        }
                  }
            }
      }

      public static void main(String[] args) {
            // read data from file
            try {
                  readData();
            } catch ( IOException | ClassNotFoundException ex ) {
                  System.err.println("something went wrong while reading the file ");
                  System.exit(0);
            }
loop:       while ( true ) {
                  // display the menu to choose from 
                  displayMenu();
                  // take the choise number from user
                  int choice = getChoice();
                  switch ( choice ) {
                        case 1: choice = principalOrTeacherChoise();
                              switch ( choice ) {
                                    case 1: principal = (Principal)getEmployee("Principal");
                                          displaySuccessfull("principal " + principal.getName());
                                          break;
                                    case 2: Teacher p = (Teacher)getEmployee("Teacher");
                                          teachers.add(p);
                                          displaySuccessfull("teacher " + p.getName());
                                          break;
                                    default:
                                          System.err.println("!!!!! Wrong input. try Again !!!!!");
                              }
                              break;
                        case 2: addStudent();
                              break;
                        case 3: addSubject();
                              break;
                        case 4: displaySubjects();
                              break;
                        case 5: choice = principalOrTeacherChoise();
                              switch ( choice ) {
                                    case 1: displayPrincipalSalary();
                                          break;
                                    case 2: displayTeachersSalary();
                                          break;
                                    default:
                                          System.err.println("!!!!! Wrong input. try Again !!!!!");
                              }
                              break;
                        case 6: Subject subject = getSubject();
                              displayCountOfStudents(subject);
                              break;
                        case 7: {
                              try {
                                    saveData();
                              } catch ( IOException ex ) {
                                    System.err.println("!!!!! Some thing went wrong try again !!!!!");
                              }
                        }
                        break;
                        case 8:
                              System.out.println("Good Bye :-)");
                              break loop;
                        default:
                              System.err.println("!!!!! Wrong input. try Again !!!!!");
                  }
            }

      }

      private static void addSubject() {
            displayTeachersAndStudents();
            chooseTeacherAndStudent();
      }

      private static void chooseTeacherAndStudent() {
            System.out.println("choose from teachers:: ");
            int n1 = in.nextInt() - 1;
            System.out.println("choose from Students:: ");
            int n2 = in.nextInt() - 1;
            if ( teachers.get(n1) == null || students.get(n2) == null ) {
                  System.err.println("Wrong input! The course is not added");
            } else {
                  System.out.println("Enter course name:: ");
                  String name = in.next();
                  if ( searchSubject("name") == null ) {
                        subjects.add(new Subject(name, teachers.get(n1), students.get(n2)));
                        displaySuccessfull("course " + name);
                  } else {
                        System.out.println("The course is already exist !! ");
                  }
            }
      }

      private static void displayCountOfStudents(Subject _subject) {
            System.out.println(_subject.getStudents().size());
      }

      private static void displayMenu() {
            System.out.println("1- Add Employee"
                    + "\n2- Add Student"
                    + "\n3- Add subject"
                    + "\n4- Show subjects"
                    + "\n5- Show employees salaries"
                    + "\n6- Count of students in any subject"
                    + "\n7- Save data in file"
                    + "\n8- Exit"
                    + "\nEnter your choice : "
            );
      }

      private static void displayPrincipalSalary() {
            System.out.println(principal.getSalary());
      }

      private static void displaySuccessfull(String _string) {
            System.out.println("The " + _string + " has been added successfully");
      }

      private static void displayTeachersAndStudents() {
            System.out.println("Teachers: ");
            displayTeachersName();
            System.out.println("Students: ");
            displayStudentsName();
      }

      private static void displayTeachersSalary() {
            for ( Teacher t: teachers ) {
                  System.out.println(t.getName() + " -> " + t.getSalary());
            }
      }

      private static int getChoice() {
            return in.nextInt();
      }

      private static Employee getEmployee(String _string) {
            System.out.println("Enter name:: ");
            String name = in.next();

            System.out.println("Enter id:: ");
            int id = in.nextInt();

            System.out.println("Enter address:: ");
            String address = in.next();

            System.out.println("Enter phone number:: ");
            String phone = in.next();

            System.out.println("Enter email:: ");
            String email = in.next();

            System.out.println("Enter basic salary:: ");
            double salary = in.nextDouble();

            switch ( _string ) {
                  case "Principal":
                        System.out.println("Enter principal bonus:: ");
                        double bonus = in.nextDouble();
                        Principal p = new Principal(bonus, name, id, address, phone, email, salary);
                        return p;
                  case "Teacher":
                        System.out.println("Enter number of classes he/she teaches:: ");
                        int classNo = in.nextInt();
                        Teacher t = new Teacher(classNo, name, id, address, phone, email, salary);
                        return t;
                  default: return null;
            }
      }

      private static void addStudent() {
            System.out.println("Enter student id:: ");
            int id = in.nextInt();
            System.out.println("Enter student name:: ");
            String name = in.next();
            System.out.println("Enter student level:: ");
            int level = in.nextInt();
            students.add(new Student(id, name, level));
            displaySuccessfull("student " + name);
      }

      private static Subject getSubject() {
            displaySubjectsName();
            System.out.println("Enter subject name:: ");
            String name = in.next();
            return searchSubject(name);
      }

      private static Subject searchSubject(String _name) {
            for ( Subject s: subjects ) {
                  if ( s.getName().equalsIgnoreCase(_name) ) {
                        return s;
                  }
            }
            return null;
      }

      private static int principalOrTeacherChoise() {
            System.out.println("1- Principal"
                    + "\n2- Teacher"
                    + "\n Enter your choise : ");
            return getChoice();
      }

      public static void displaySubjects() {
            subjects.forEach((s) -> {
                  System.out.println(s);
            });
      }

      public static void displaySubjectsName() {
            int i = 1;
            for ( Subject s: subjects ) {
                  System.out.println(i++ + "- " + s.getName());
            }
      }

      private static void displayTeachersName() {
            int i = 1;
            for ( Teacher t: teachers ) {
                  System.out.println("\t" + i++ + "- " + t.getName());
            }
      }

      public static void displayStudentsName() {
            int i = 1;
            for ( Student s: students ) {
                  System.out.println("\t" + i++ + "- " + s.getName());
            }
      }

      private static void saveData() throws IOException {
            try ( ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(new File(filePath))) ) {
                  file.writeUTF("Students\n");
                  for ( Student s: students ) {
                        file.writeObject(s);
                  }
                  file.writeUTF("Teachers\n");
                  for ( Teacher t: teachers ) {
                        file.writeObject(t);
                  }
                  file.writeUTF("Subjects\n");
                  for ( Subject s: subjects ) {
                        file.writeObject(s);
                  }
            }
      }

}
