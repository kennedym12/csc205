import java.util.Scanner;

public class TestClock {
    public static void main(String[] args){
        Clock dvr=new Clock();
        System.out.println("What time would you like to set your dvr to?");
        Scanner scan=new Scanner(System.in);
        System.out.println("Hours: ");
        int hours=Integer.parseInt(scan.nextLine());
        System.out.println("Minutes: ");
        int mins=Integer.parseInt(scan.nextLine());
        System.out.println("Seconds: ");
        int secs=Integer.parseInt(scan.nextLine());
        scan.close();

        dvr.reset(hours, mins, secs);
        System.out.println("The time is now "+dvr);

        dvr.advance();
        System.out.println("The time is now "+dvr);
    }
}
