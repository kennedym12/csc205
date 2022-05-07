import java.io.*;
class HourlyEmployee extends Employee implements Serializable
{

  public HourlyEmployee(String n, double hw)
  {
    name = n;
    hourlyWage = hw;
  }

  public double computePay(int hoursWorked)
  {
    if(hoursWorked>40)
    {
      return (40*hourlyWage)+((hoursWorked-40)*1.5*hourlyWage);
    }
    return hoursWorked*hourlyWage;
  }

  public String toString()
  {
    //String formattedWage = String.format(
    return name+" $"+String.format("%.02f",hourlyWage);
  }




}
