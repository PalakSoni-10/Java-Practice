//even or odd
//sum of even and odd numbers
//positive or negative
import java.util.*;
public class EvenOdd 
{
    public static void main(String[] args)
    {   
        int ev=0;
        int od=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number");
        int n = sc.nextInt();
        System.out.println("enter " + n + " numbers");
        for(int i = 0; i < n; i++)
        {
        int num = sc.nextInt();
        if (num%2==0)
        {
       //System.out.println("number is even");
        ev+=num;
        }
        else 
        {
        //System.out.println("number is odd");
        od+=num;
        }
        
    }
    System.out.println("even sum = "+ev);
    System.out.println("odd sum = "+od);

    sc.close();
}



}

