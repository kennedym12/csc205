//This class is to practice and brush up on basic concepts
import java.lang.String;

public class Practice{
    public Practice(){}


    //method that will reverse a string
    public static String reverseString(String str){
        String result="";
        for(int i=str.length()-1;i>=0;i--){
            if(i==str.length()-1){
                result+=str.substring(i);
            }
            else{
                result+=str.substring(i,i+1);
            }
        }
        return result;
    }

    public static void main(String args[]){
        String name = "Kennedy";
        String result=reverseString(name);
        System.out.printf("%s is %s reversed",result,name);
    }
}