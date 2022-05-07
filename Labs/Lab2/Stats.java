import java.util.Scanner;
public class Stats
{
	private static final int MAX_SIZE = 100;
	public static void main(String[] args)
	{
        	int[] List = new int[MAX_SIZE];		
		int numItems;

        	numItems = fillUp (List);

        	System.out.println("\n\10\7" + " The range of your " +
                                   numItems + " items is :  " + 
				   range (List, numItems));

        	System.out.println("\n\10\7" + " The mean of your " + 
                                   numItems + " items is  :  " +
				   mean (List, numItems));
	}

	public static  int fillUp(int [] list){
		int numOfTerms=0;
		Scanner scanny=new Scanner(System.in);
		System.out.println("Please enter your values (Enter 0 to stop)");
		int input=scanny.nextInt();
		while(input>0){
			list[numOfTerms]=input;
			input=scanny.nextInt();
			numOfTerms+=1;
		}
		return numOfTerms;
	}

	public static int range(int[] list, int numItems){
		int min=list[0];
		int max=list[0];
		for(int i=0; i<numItems; i++){
			if(list[i]<min){
				min=list[i];
			}
			if(list[i]>max){
				max=list[i];
			}
		}
		return max-min;
	}

	public static double mean(int[] list, int numItems){
		double total=0;
		for(int i = 0; i<numItems; i++){
			total+=list[i];
		}
		return total/(double)numItems;
	}






}
