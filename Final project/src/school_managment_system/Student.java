/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_managment_system;

/**

 @author EMAM
 */
public class Student {

      private int id;
      private String name;
      private int level;

      public Student() {
      }

      public Student(Student _student) {
            this(_student.getId(), _student.getName(), _student.getLevel());
      }

      public Student(int _id, String _name, int _level) {
            this.id = _id;
            this.name = _name;
            this.level = _level;
      }

      public int getId() {
            return id;
      }

      public void setId(int _id) {
            this.id = _id;
      }

      public int getLevel() {
            return level;
      }

      public void setLevel(int _level) {
            this.level = _level;
      }

      public String getName() {
            return name;
      }

      public void setName(String _name) {
            this.name = _name;
      }

      @Override
      public String toString() {
            return "name: " + this.getName()
                    + ", id: " + this.getId()
                    + ", level: " + this.getLevel();
      }

}
