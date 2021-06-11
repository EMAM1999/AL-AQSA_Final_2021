/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_managment_system;
import java.util.ArrayList;
import java.util.Arrays;

/**

 @author EMAM
 */
public class Subject {

      private String name;
      private Teacher teacher;
      private ArrayList<Student> students;

      public Subject() {
            students = new ArrayList<>();
      }

      public Subject(String _name, Teacher _teacher, Student... _students) {
            this();
            this.name = _name;
            this.teacher = _teacher;
            this.students.addAll(Arrays.asList(_students));
      }

      public boolean addStudent(Student _student) {
            return this.students.add(_student);
      }

      public String getName() {
            return name;
      }

      public void setName(String _name) {
            this.name = _name;
      }

      public ArrayList<Student> getStudents() {
            return students;
      }

      public Teacher getTeacher() {
            return teacher;
      }

      public void setTeacher(Teacher _teacher) {
            this.teacher = _teacher;
      }

      @Override
      public String toString() {
            String data
                    = "name: " + this.getName()
                    + "\nteacher: [" + this.getTeacher() + "]"
                    + "\nstudents: ";
            data = students.stream().map((student) -> "\n\t[" + student + "]").reduce(data, String::concat);
            return data;
      }

}
