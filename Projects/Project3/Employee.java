import java.io.*;
abstract class Employee implements Serializable
{
  String name;
  double hourlyWage;

  //constructor?
  
  public String getName()
  {
    return name;
  }

  public double getHourlyWage()
  {
    return hourlyWage;
  }

  abstract double computePay(int hoursWorked);

}
