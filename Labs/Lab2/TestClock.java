import java.util.Scanner;

public class TestClock {
    public static void main(String[] args){
        int hrs,mins,secs;
        Clock dvr=new Clock();
        Scanner scan=new Scanner(System.in);
        System.out.println("What time would you like to set your dvr to?");
        
        //make sure the input for hours is valid
        System.out.println("Hours: ");
        hrs=scan.nextInt();
        while(hrs>23 || hrs<0){
            System.out.println("Please enter a value between 0 and 23 for hours: ");
            hrs=scan.nextInt();
        }

        //make sure the input for minutes is valid
        System.out.println("Minutes: ");
        mins=scan.nextInt();
        while(mins>59 || mins<0){
            System.out.println("Please enter a value between 0 and 59 for hours: ");
            mins=scan.nextInt();
        }

        //make sure the input for seconds is valid
        System.out.println("Seconds: ");
        secs=scan.nextInt();
        while(secs>59 || secs<0){
            System.out.println("Please enter a value between 0 and 59 for hours: ");
            secs=scan.nextInt();
        }
        //close the scanner
        scan.close();

        dvr.reset(hrs, mins, secs);
        System.out.println("The time is now "+dvr);

        dvr.advance();
        System.out.println("The time is now "+dvr);
    }
}

