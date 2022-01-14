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
        String name = "37073";
        int[] nums={1,444,8,2,1,1,9,6,2};
        /*
        String result=reverseString(name);
        System.out.printf("%s is %s reversed",result,name);
            */
        //System.out.print(countVowels(name));

        //System.out.print(checkIfPalindrome(name));

        System.out.println(getMaxNum(nums));

    }

    //takes a string and counts its vowels
    public static int countVowels(String str){
        int numVowels=0;
        String compare;
        String[] vowels = {"a","e","i","o","u"};
        for(int i=0; i<str.length(); i++){
            if(i!=str.length()-1){
                compare=str.substring(i,i+1);
            }
            else{
                compare=str.substring(i);
            }
            for(String v: vowels){
                if(compare.equals(v)){
                    numVowels++;
                }
            }
        }
        return numVowels;
    }

    //checks whether the word backwards is the same forward
    public static boolean checkIfPalindrome(String word){
        String backwards="";
        for(int i=word.length()-1; i>=0; i--){
            if(i!=word.length()-1){
                backwards+=word.substring(i,i+1);
            }
            else{backwards+=word.substring(i);}
        }
        return(word.equals(backwards));
    }

    //count the number of words present
    public static int countWords(String sentence){
        char[] sen = sentence.toCharArray();
        int numSpaces=0;
        int numWords=0;
        for(char c:sen){
            if(Character.compare(c,' ')==0){
                numSpaces++;
            }
            //count the spaces,check the first and last char,
            //_sdf_ , _adc, asd_, _, asdf
            //check if there's a letter in front of it
            //check if there a letter behind the last one
        }
        return numWords;
    }

    //return the largest number in an array of integers
    public static int getMaxNum(int[] nums){
        int max=0;
        for(int n:nums){
            if(n>max){
                max=n;
            }
        }
        return max;
    }

}

    