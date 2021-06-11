/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_managment_system;

/**

 @author EMAM
 */
public class Teacher extends Employee {

      private int classNo;

      public Teacher(int _numberOfClasses) {
            this.classNo = _numberOfClasses;
      }

      public Teacher(int _numberOfClasses, String _name, int _id, String _address, String _phone, String _email, double _basicSalary) {
            super(_name, _id, _address, _phone, _email, _basicSalary);
            this.classNo = _numberOfClasses;
      }

      public Teacher(Teacher _teacher) {
            this(_teacher.getClassNo(), _teacher.getName(), _teacher.getId(), _teacher.getAddress(), _teacher.getPhone(), _teacher.getEmail(), _teacher.getBasicSalary());
      }

      public Teacher() {
      }

      public int getClassNo() {
            return classNo;
      }

      public void setClassNo(int _classNo) {
            this.classNo = _classNo;
      }

      @Override
      public double getSalary() {
            return super.getBasicSalary() + super.getLiveExpensive() + 20 * this.getClassNo();
      }

      @Override
      public String toString() {
            return super.toString()
                    + "numberOfClasses: $" + this.classNo;
      }

}
