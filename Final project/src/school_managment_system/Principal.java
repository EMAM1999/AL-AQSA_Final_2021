/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_managment_system;

/**

 @author EMAM
 */
public class Principal extends Employee {

      private double bonus;

      public Principal() {
      }

      public Principal(double _bonus) {
            this.bonus = _bonus;
      }

      public Principal(double _bonus, String _name, int _id, String _address, String _phone, String _email, double _basicSalary) {
            super(_name, _id, _address, _phone, _email, _basicSalary);
            this.bonus = _bonus;
      }

      public double getBonus() {
            return bonus;
      }

      public void setBonus(double _bonus) {
            this.bonus = _bonus;
      }

      @Override
      public double getSalary() {
            return super.getBasicSalary() + super.getLiveExpensive() + this.getBonus();
      }

      @Override
      public String toString() {
            return super.toString()
                    + "bonus: $" + this.bonus;
      }

}
