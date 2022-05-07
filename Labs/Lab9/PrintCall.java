
public class PrintCall
{
        public static void main(String[] args)
        {
                printMe(1);
        }

        public static void printMe(int n)
        {

         /* if ( (n != 1)  && (n != 5) )
          {
             for (int i = 1;  i <= n;  i++)
                 System.out.print(' ');
             System.out.println("This was written by call number " + n + ".");
          }*/
		if(n==1){
			printMe(n+1);
			System.out.println("This was ALSO written by call number 1.");
		}
		else if(n<5){
			System.out.println("This was written by call number "+n+".");
			printMe(n+1);
			System.out.println("This was ALSO written by call number"+n+".");
		}
		else{System.out.print("");} 
	  //I'm not sure what the base case is supposed to be
	  //i(n<5){
	    // printMe(n-1)
	    //
	   }
}
