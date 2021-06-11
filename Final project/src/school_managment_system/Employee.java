/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_managment_system;

/**

 @author EMAM
 */
public abstract class Employee {

      private String name;
      private int id;
      private String address;
      private String phone;
      private String email;
      private double basicSalary;
      private double liveExpensive;

      public Employee() {
      }

      public Employee(String _name, int _id, String _address, String _phone, String _email, double _basicSalary) {
            this.name = _name;
            this.id = _id;
            this.address = _address;
            this.phone = _phone;
            this.email = _email;
            this.basicSalary = _basicSalary;
            this.liveExpensive = _basicSalary * 10 / 100;
      }

      public abstract double getSalary();

      public String getAddress() {
            return address;
      }

      public void setAddress(String _address) {
            this.address = _address;
      }

      public double getBasicSalary() {
            return basicSalary;
      }

      public void setBasicSalary(double _basicSalary) {
            this.basicSalary = _basicSalary;
      }

      public String getEmail() {
            return email;
      }

      public void setEmail(String _email) {
            this.email = _email;
      }

      public int getId() {
            return id;
      }

      public void setId(int _id) {
            this.id = _id;
      }

      public double getLiveExpensive() {
            return liveExpensive;
      }

      public void setLiveExpensive(double _liveExpensive) {
            this.liveExpensive = _liveExpensive;
      }

      public String getName() {
            return name;
      }

      public void setName(String _name) {
            this.name = _name;
      }

      public String getPhone() {
            return phone;
      }

      public void setPhone(String _phone) {
            this.phone = _phone;
      }

      @Override
      public String toString() {
            return "name: " + this.getName()
                    + ", id: " + this.getId()
                    + ", address: " + this.getAddress()
                    + ", phone: " + this.getPhone()
                    + ", email: " + this.getEmail()
                    + ", basicSalary: $" + this.getBasicSalary()
                    + ", salary: $" + this.getSalary();
      }

}
