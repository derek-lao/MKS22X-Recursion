// import java.lang.Math;
import java.util.ArrayList;

public class recursion{
  /*You may write additional private methods */

  /*Recursively find the sqrt using Newton's approximation
   *tolerance is the allowed percent error the squared answer is away from n.
   *precondition: n is non-negative

  */
  public static double sqrt(double n, double tolerance){
    if(n==0) return 0;
    if(n==1) return 1;
    else
    {
      return sqrtHelper(n,n/2,tolerance);
    }
  }

  public static double sqrtHelper(double n,double guess,double tolerance){
    if(Math.abs(((guess*guess)-n)/n) <= tolerance/100)
    {
      return guess;
    }
    else
    {
      // System.out.println(guess);
      return sqrtHelper(n,(guess+n/guess)/2, tolerance);
    }
  }

  /*Recursively find the n'th fibbonaci number in linear time
   *fib(0) = 0
   *fib(1) = 1
   *fib(5) = 5
   *precondition: n is non-negative
   */
  public static int fib(int n){
    return fibHelper(n,0,0,1,0);
  }

  public static int fibHelper(int n, int currentNum,int fibFirst,int fibSecond,int count){
    if(n<=0) return currentNum+0;
    if(n==1) return currentNum+1;
    if(n>=2)
    {
      if(count>=n)
      {
        return currentNum;
      }
      if(count==0) return fibHelper(n,1,0,1,count+1);
      if(count==1) return fibHelper(n,1,0,1,count+1);
      else
      {
        fibFirst=fibSecond;
        fibSecond=currentNum;
        // System.out.println(currentNum);
        return fibHelper(n,fibFirst+fibSecond,fibFirst,fibSecond,count+1);
      }
    }

    return currentNum;
  }

  /*As Per classwork*/
  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> stuff=new ArrayList<Integer>();
    makeSums(n,stuff,0);
    return stuff;
  }

  public static void makeSums(int n,ArrayList<Integer> holder,int sum){
    if(n<=0)
    {
      holder.add(sum);
      // System.out.println(sum);
    }
    else
    {
      // holder.add(sum+n);
      // holder.add(sum);
      // System.out.println(sum+n);
      // System.out.println(sum);
      makeSums(n-1,holder,sum+n);
      makeSums(n-1,holder,sum);
    }
  }



  public static void main(String[] args) {
          System.out.println("sqrt()");
          System.out.println("-----------------------\n");

          System.out.println("sqrt(4, 0.00001)");
          System.out.println("EXPECTED: 2");
          System.out.println(sqrt(4, 0.00001));         // 2

          System.out.println("----");

          System.out.println("sqrt(8, 0.00001)");
          System.out.println("EXPECTED: ~2.8284");
          System.out.println(sqrt(8, 0.00001));         // ~2.8284

          System.out.println("----");

          System.out.println("sqrt(0, 0.00001)");
          System.out.println("EXPECTED: 0");
          System.out.println(sqrt(0, 0.00001));         // 0

          System.out.println("\n");

          System.out.println("fib()");
          System.out.println("-----------------------\n");

          System.out.println("fib(0)");
          System.out.println("EXPECTED: 0");
          System.out.println(fib(0));                   // 0

          System.out.println("----");

          System.out.println("fib(1)");
          System.out.println("EXPECTED: 1");
          System.out.println(fib(1));                   // 1

          System.out.println("----");

          System.out.println("fib(7)");
          System.out.println("EXPECTED: 13");
          System.out.println(fib(7));                   // 13

          // System.out.println("fib(2)");
          // System.out.println("EXPECTED: 1");
          // System.out.println(fib(2));                   // 1
          // System.out.println("----");

          System.out.println("makeAllSums()");
          System.out.println("-----------------------\n");

          System.out.println("makeAllSums(0)");
          System.out.println("EXPECTED: [0]");
          System.out.println(makeAllSums(0));           // [0]

          System.out.println("----");

          System.out.println("makeAllSums(1)");
          System.out.println("EXPECTED: [1, 0]");
          System.out.println(makeAllSums(1));           // [1, 0]

          System.out.println("----");

          System.out.println("makeAllSums(3)");
          System.out.println("EXPECTED: [0, 3, 2, 5, 1, 4, 3, 6]");
          System.out.println(makeAllSums(3));           // [0, 3, 2, 5, 1, 4, 3, 6]

          System.out.println("makeAllSums(2)");
          System.out.println("EXPECTED: [0,1,2,3]");
          System.out.println(makeAllSums(2));           // [0,1,2,3]
        }
}
