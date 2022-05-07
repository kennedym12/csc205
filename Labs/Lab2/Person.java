public class Person
{
  private String name;
  private int    id;
  private static int personCount = 0;

  // constructors
  public Person(String pname)
  {
    name = pname;
    personCount++;
    id = 100 + personCount;
  }

  public Person(){
	name="N/A";
	personCount++;
	id = -1;
  }

  
  public String  toString()
  {
    return "name: " + name + "  id: " + id 
      + "  (Person count: " + personCount + ")";
  }

  // static/class method
  public static int getCount()
  {
    return personCount;
  }
 
  public int getId(){
	return id;
  }

  public String getName(){
	return name;
  }

  public void reset(String legalName, int idNum){
	id=idNum;
	name=legalName;
  }



 
}
