import java.util.*;
public class TestArrayList
{
    public static void main(String[] args)
    {
	ArrayList<String> myArrayList = new ArrayList<String>(10);
		
	//adding to the array
	myArrayList.add("Python");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("Java");
	myArrayList.add("C++");
	myArrayList.add("C++");
	myArrayList.add("C++");
	myArrayList.add("C++");

	//test methods below
	printArrayList(myArrayList);
	
	System.out.println("The word C++ appears in the ArrayList "+count(myArrayList, "C++")+" times.");

	delete(myArrayList, "Java");

	printArrayList(myArrayList);

	System.out.println("The copies of Java have now been deleted.");
    }

    private static void printArrayList(ArrayList<String> myArrayList)
    {
	// Pre  : myArrayList has been initialized
	// Post : The elements of Vector v are printed to the screen on separate lines
	for(int i = 0; i<myArrayList.size(); i++){
		System.out.println(myArrayList.get(i));
	}
    }

    private static void delete(ArrayList<String> myArrayList, String key)
    {
	// Pre  : myArrayList has been initialized
	// Post : All copies of key are removed from myArrayList
	for(int i = myArrayList.indexOf(key)+1; i<myArrayList.size(); i++){
		if(myArrayList.get(i).compareTo(key)==0){
			myArrayList.remove(i);
			i--;
		}
	}

    }

    private static int count(ArrayList<String> myArrayList, String key)
    {
	// Pre  : myArrayList has been initialized
	// Post : number of occurrences of key is computed and returned
	int count = 0;
	for(int i = 0; i<myArrayList.size(); i++){
		if(myArrayList.get(i).compareTo(key)==0){
			count+=1;
		}
	}
	return count;
    }
}
