public class Person {
    //instance variables
    private static int personCount;//used to assign an id to ppl
    private int id;
    private String name;

    //constructors
    public Person(){
        personCount+=1;
        id=-1;
        name="N/A";
    }

    public Person(String legalName){
        personCount+=1;
        id=100+personCount;
        name=legalName;
    }

    //toString
    public String toString(){
        return "name: " + name + "  id: " + id 
        + "  (Person count: " + personCount + ")";
    }

    //accessor methods
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return personCount;
    }

    //modifier method
    public void reset(int idNum, String legalName){
        id=idNum;
        name=legalName;
    }


}
