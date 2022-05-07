import java.io.*;
class SalariedEmployee extends Employee implements Serializable
{
  
  double annualSalary;
  
  public SalariedEmployee(String n, double annualSalary)
  {
    name=n;
    this.annualSalary=annualSalary;
    hourlyWage=annualSalary/(52*40);
  }

  public double computePay(int hoursWorked)
  {
    return annualSalary;
  }

  public String toString()
  {
    return name+" $"+String.format("%.02f",(hourlyWage*52*40));
  }

  public double getAnnualSalary()
  {
    return annualSalary;
  }

  public void setAnnualSalary(double as)
  {
    annualSalary=as;
  }

}
