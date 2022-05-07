Personnel Program by Kennedy Mays 4/6/22

Abstract class Employee
- attributes: String name and double hourly wage 
- methods: getters and setters for attributes, modifier for hourly wage (by given percent), abstract method computePay (given hours worked)

class HourlyEmployee extends Employee
- constructor: take in and set name and hourly wage
- methods: computePay multiplies hrs<=40 by hourly wage and hrs>40 by 1.5x hourly wage; toString() returns "lname, fname \t $00.00/hr or yr"

class SalariedEmployee extends Employee
- constructor: take in a name and annual salary (convert to hourly)
- methods: getter and setter for annual salary, computePay always returns 1/52 of the annual salary (regardless of hours), toString returns formatting as above

class Personnel (has hourly and salaried employees)
- arraylist of employees
- main method: introductory message, request ~appropriate input using Scanner,& swtich statement for main menu options (methods)
