import java.lang.Math;
class Solution{

  public static void main(String[] args){
   System.out.println(recurSum(4));
   System.out.println(iterSum(4));
   System.out.println(recurFactorial(5));
  }

  public static double recurSum(int k){
    if(k==1){
      return 3;
    }
    else{
      return (Math.pow(2, k)+1)+recurSum(k-1);

    }
  }

  public static double iterSum(int k){
    int total = 0;
    for(int i = 1; i<=k; i++){
      total+=Math.pow(2,i)+1;
    }
    return total;
  }

  public static int recurFactorial(int n){
    if(n==1){
      return 1;
    }
    else{
      return n*recurFactorial(n-1);
    }
  }


}
