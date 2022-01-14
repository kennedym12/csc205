@SuppressWarnings ("unused")
public class Homework2 {

    public Homework2() {
    }
    
    //#1
    double[] array1=new double[24];
    int[] array2=new int[500];
    String[] array3=new String[50];
    char[] array4=new char[10];

    public static void main(String[] args){
        //#2
        final int SIZE = 10;
        int[] count = new int[SIZE];
        String[] rainbow = {"BLUE","RED","GREEN","RED","GREEN"};
        //a
        for(int i:count){
            i=0;
         }
         //b
        rainbow[1]="WHITE";
         //c
        int numGreen=0;
        for(String s:rainbow){
            if(s.equals("GREEN")){
                numGreen+=1;
            }
            //d
            System.out.println(s);
        }
        //e
        int sum=0;
        for(int i:count){
            sum+=i;
        }

        //#3
        int[][] table=new int[4][3];
        sum=0;
        for(int i[]:table){
            for(int j:i){
                sum+=j;
            }
        }

        //#4
        final int NUM_STUDENTS = 100;
        boolean[] failing = new boolean[NUM_STUDENTS];
        setToFalse(failing);
    }
    //#4 continued
    public static void setToFalse(boolean[] table){
        for(boolean b:table){
            b=false;
        }
    }
    
}
