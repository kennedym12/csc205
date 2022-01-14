public class Homework1 {
    //#1
    static int[] array={5,3,-6,1,0};

    public Homework1(){}
    public static void main(String[] args){
        //#3
        System.out.println(sumUp(array));
    }
    

    //#2
    public static int sumUp(int[] array){
        int sum=0;
        for(int num:array){
            sum+=num;
        }
        return sum;
    }

    //#4 (didn't take CSC 204)
    //Integer and Character wrap their primitive variable counterparts so that they can be manipulated using the classes built in methods
    //String allows the user to string together characters and manipulate them
}
