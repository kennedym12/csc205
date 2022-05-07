import java.io.*;
import java.util.*;
class Personnel implements Serializable
{
  
  private static ArrayList<Employee> personnel = new ArrayList<Employee> (10);

  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    //welcome message
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Welcome to the personnel database");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    //employees for practice
    HourlyEmployee a = new HourlyEmployee("a", 18.99);
    SalariedEmployee b = new SalariedEmployee("b", 20000.22);
    personnel.add(a);
    personnel.add(b);
    
    //instantiate scanner and selection
    Scanner scanalot = new Scanner(System.in);
    String selection = "";
        
    //loop until selection is q (quit)
    while(!selection.equals("q"))
    {
    
      menu();
      
      selection = scanalot.next();
        while(!validInput(selection))
        {
          System.out.println("Please enter a valid character from the list of commands.");
          selection=scanalot.next();
        }
        
      switch(selection)
          {
            case "n":
              System.out.println("Enter the name of new employee: ");
              String name = scanalot.next();
              System.out.println("Hourly (h) or Salaried (s): ");
              String type = scanalot.next().toLowerCase();
              while(!type.equals("h") && !type.equals("s"))
              {
                System.out.println("Please enter either h or s");
                type = scanalot.next().toLowerCase();
              }
              if(type.equals("h"))
              {
                System.out.println("Enter hourly wage: ");
                double wage = scanalot.nextDouble();
                HourlyEmployee e = new HourlyEmployee(name, wage);
                personnel.add(e);
              }
              else
              {
                System.out.println("Enter annual salary: ");
                double salary = scanalot.nextDouble();
                SalariedEmployee e = new SalariedEmployee(name, salary);
                personnel.add(e);
              }
              break;
            case "c":
              //check that there's employees to compute paychecks for
              if(personnel.size()==0)
              {
                System.out.println("There aren't any employees to compute paychecks for right now.");
              }
              else
              {//ask for hours worked and compute paycheck
                for(int i=0; i<personnel.size(); i++)
                {
                  Employee em = personnel.get(i);
                  System.out.println("Enter the number of hours worked by "+em.getName());
                  int hours = scanalot.nextInt();
                  System.out.println("Pay: $"+String.format("%.02f",em.computePay(hours)));
                }
              }
              break;
            case "r":
               raiseWages();
               break;
            case "p":
               printRecords();
               break;
            case "d":
               downloadData();
               break;
            case "u":
               uploadData();
               break;
            case "q":
               break;
            }
      
       }
       scanalot.close();

  }
 
  public static void raiseWages()
  {
    //check that there's employees to raise wages for
      if(personnel.size()==0)
      {
        System.out.println("There aren't any employees to raise wages for right now.");
      }
      else
      {
        //get the raise percentage
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter the percent you'd like to raise values: ");
        double percent = scanny.nextDouble();
        
        //loop through personnel and raise values
        for(int i=0; i<personnel.size(); i++)
        {
          Employee em = personnel.get(i);
          if(em instanceof SalariedEmployee)
          {
          SalariedEmployee m = (SalariedEmployee)em;
          double newSalary = m.getAnnualSalary()*(1+(percent/100.0));
          m.setAnnualSalary(newSalary);
          m.hourlyWage=m.hourlyWage*(1+(percent/100.0));
          }
          else
          {
            em.hourlyWage=em.hourlyWage*(1+(percent/100.0));
          }
      }
    }
    
    //call print method to show updated database
    printRecords();
  }
  
  public static void printRecords()
  {
    //check that there's employees to print out
    if(personnel.size()==0)
    {
      System.out.println("There aren't any employees to display right now.");
    }
    else
    {//print employees as expected
      System.out.println("Now displaying all employees within the personnel database...");
      for(int i=0; i<personnel.size(); i++)
      {
        Employee em = personnel.get(i);
        System.out.println(em);
      }
    }
  }
  
  public static void downloadData() throws IOException, ClassNotFoundException
  {
    //read data from .dat file and puts it into personnel
    String fileName = "employee.dat";
    FileInputStream fis = new FileInputStream(fileName);
    ObjectInputStream ois = new ObjectInputStream(fis);
    
    try{
      for(;;)//works better than while(ois.available()) loop...
      {
        
        Employee ne = (Employee)ois.readObject();
        personnel.add(ne);
        System.out.println(ne);
      }
    }
    catch(EOFException e)
    {
      System.out.println("All employees have been downloaded into this database.");
    }
    ois.close();
  }
  
  public static void uploadData() throws IOException
  {
    //loops through personnel until every object has been written into .dat file
    String fileName = "employee.dat";
    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    
    for(int i = 0; i<personnel.size(); i++)
    {
      oos.writeObject(personnel.get(i));
    }
    System.out.println("All personnel have been uploaded to the employee.dat file");
  }

  public static boolean validInput(String in)
  {
    in=in.toLowerCase();
    if(in.equals("n") || in.equals("c") || in.equals("r") || in.equals("p") || in.equals("d") || in.equals("u") || in.equals("q"))
    {return true;}
    else{return false;}
  }
  
  public static void menu()
  {
    System.out.println();
    System.out.println("________________________");
    System.out.println("\t Commands");
    System.out.println("| n - New employee      |");
    System.out.println("| c - Compute paychecks |");
    System.out.println("| r - Raise wages       |");
    System.out.println("| p - Print records     |");
    System.out.println("| d - Download data     |");
    System.out.println("| u - Upload data       |");
    System.out.println("| q - quit              |");
    System.out.println("________________________");
    System.out.println();
    System.out.print("Enter command: ");
    //System.out.println();
  }






}
