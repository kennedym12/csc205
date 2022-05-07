import java.util.*;
import java.io.*;
class LibraryCatalog{
	
	static ArrayList<LibraryBook> catalog = new ArrayList<LibraryBook>(10);
	static int numBooks = 0;
	static ArrayList<LibraryBook> usersBooks = new ArrayList<LibraryBook> (10);

	public LibraryCatalog(){

	}



	public static void main(String[] args){
		//welcome prompt
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome to the library catalog database!");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
		//prompt user to enter .dat file, display available files to choose from
		System.out.println("Below are your choice of files to import books from:");
    System.out.println();
		File folder = new File("/home/mays_ka/Projects/Project2/");
    File[] listOfFiles = folder.listFiles();
    for(File file : listOfFiles){
      if(file.isFile()){
          System.out.print(file.getName()+"\t");
      }
    }
    System.out.println();
    System.out.println();
    System.out.println("Please select a file with the .dat extension");
		Scanner scanny = new Scanner(System.in);
		String file = scanny.nextLine();
    System.out.println();
		File f = new File(file);
		while(!file.contains(".dat") || !f.exists()){
			System.out.println("Please select a valid file type from the selection above");
			file = scanny.next();
      f = new File(file);
      System.out.println();
		}
		//call to input
		input(file);
   
		//statement to update the user then prompt user to press return when ready to move on
		System.out.println(numBooks +" books have been entered and sorted in the catalog from "+file);
		System.out.println();
    
		//prompt user to press return to continue when ready
		System.out.println("Press enter when you're ready to move on");
		String moveOn = scanny.nextLine();
   
		//displays menu, prompts user to choose a menu option, loop until exit
		int userInput = 1;
		String title = "";
		while(userInput!=3){
			displayMenu();
      try{
      userInput = scanny.nextInt();
      while(userInput!=1 && userInput!=2 && userInput!=3){
      System.out.println("Please enter a valid number");
      userInput=scanny.nextInt();
        }
      }
      catch(Exception InputMismatchException){
      System.out.println();
      System.out.println("Now leaving program. Make sure to enter a number..."); 
      System.out.println(":(");
      break;
      }
			switch(userInput){
				case 1:
        //option 1display catalog content
				System.out.println("Now displaying books in the catalog..."); 
        System.out.println();
				displayRecord(false);
				break;
				case 2: 
        //option2 finds a book
				System.out.print("Enter the title of the book you're looking for: ");
				String t = scanny.next()+scanny.nextLine();
        System.out.println();
				displayRecord(findBook(t));
				break;
				case 3:
        //option3 exits the program
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Thank you for using the Library Catalog Database. Bye!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
        default:
        System.out.println("Please enter a valid number");
			
      }
      System.out.println();
		}
	}
	public static void input(String file){
		try{
			Scanner scanny = new Scanner(new File(file));
			while(scanny.hasNext()){
				Scanner scannyjr = new Scanner(scanny.nextLine()).useDelimiter(";");
				String title = scannyjr.next();
				String name = scannyjr.next();
				int copyright = scannyjr.nextInt();
				double price = scannyjr.nextDouble();
				String genre = scannyjr.next();
				
				numBooks++;	
				catalog.add(new LibraryBook(title,name,copyright,price,genre));
			}
		}
		catch(IOException e){
		System.out.println(e.getMessage());
		}		
		sort();
	}
	//include code to make genre a full word
	public static void displayRecord(boolean titleOnly){
		for(int i = 0; i<catalog.size(); i++){
			LibraryBook book = catalog.get(i);
      System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			System.out.println("Record #"+i);
			System.out.println("Title : "+book.getTitle());
			if(titleOnly){
				//prints nothing else
				System.out.println();
			}
			else{
				//prints the rest of the book's information
				System.out.println("Author's Name: "+book.getAuthor());
				System.out.println("Copyright: "+book.getCopyright());
				System.out.println("Price: "+book.getPrice());
				switch(book.getGenre()){
					case "f": 
					System.out.println("Genre: Fiction");
					break;
					case "p":
					System.out.println("Genre: Poetry");
					break;
					case "d":
					System.out.println("Genre: Drama");
					break; 
				}
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
				System.out.println();
			}
		}	
	}
	public static void displayRecord(int index){
		if(index!=-1){
			System.out.println("Found it!");	
      System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");	
			LibraryBook book = catalog.get(index);
			System.out.println("Record #"+index);
			System.out.println("Title: "+book.getTitle());
			System.out.println("Author's Name: "+book.getAuthor());
			System.out.println("Copyright: "+book.getCopyright());
			System.out.println("Price: "+book.getPrice());
			switch(book.getGenre()){
				case "f":
				System.out.println("Genre: Fiction");
				break;
				case "p":
				System.out.println("Genre: Poem");
				break;
				case "d":
				System.out.println("Genre: Drama");
				break;
			}
      System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			System.out.println(); 	
		}
		else{
			System.out.println("The database couldn't find this book. Try again.");
		}
	}

	public static void sort(){
	 	for(int i =0; i<catalog.size()-1; i++){
			int least = i;
			for(int j = i+1; j<catalog.size(); j++){
				if(catalog.get(least).compareTo(catalog.get(j))>0){
					least=j;
				}
			}
			LibraryBook temp = catalog.get(i);
			catalog.set(i, catalog.get(least));
			catalog.set(least, temp);
		}
	 }

	public static int findBook(String title){
		//use binary search to find book based on title
		int first = 0;
		int last = catalog.size()-1;
		while(first<=last ){
			int mid = (first+last)/2;
			int comparison = title.compareTo(catalog.get(mid).getTitle());
			if(comparison==0){
				return mid;
			}
			else if(comparison>0){
				first=mid+1;
			}
			else{
				last=mid-1;
			}
		}
		return -1;

	}

	/*public static void checkoutBook(int index){
		usersBooks.add(catalog.get(index));
		catalog.remove(index);
		sort();
	}

	public static void returnBook(int index){
		catalog.add(usersBooks.get(index));
		usersBooks.remove(index);
		sort();
	}*/

	public static void displayMenu(){
  System.out.println("~~~~~~~~~~~~");
	System.out.println("Catalog Menu");
  System.out.println("~~~~~~~~~~~~");
	System.out.println("1 | Display the book record");
	System.out.println("2 | Find a book");
	System.out.println("3 | Exit");
	System.out.println();
	System.out.print("Select a number 1-3: ");
	}




}
