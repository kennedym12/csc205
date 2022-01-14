import java.util.Scanner;

public class MagicSquare {
    public MagicSquare() {
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner("matrix.txt");
        //read the rows by line as a string
        //convert each string to array 
        //combine the arrays to create a matrix
        String row1=sc.nextLine();
        String row2=sc.nextLine();
        String row3=sc.nextLine();
        char[] one=row1.toCharArray();
        char[] two=row2.toCharArray();
        char[] three=row3.toCharArray();
        char[][] matrix={one,two,three};
        System.out.println(matrix);
        /*if(matrix.length()==m[].length){

        } 
        int rowsNum=0;
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());

        } */
        sc.close();
    }

    public static boolean isMagicSquare(){
        boolean yes=false;
        return yes;
    }
}
