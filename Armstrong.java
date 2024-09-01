import java.util.*;
public class Armstrong 
{
    public static void main(String[] args)
    {
        System.out.println("enter a number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n=num;
        int count = 0;
        double sum=0;
        while (n>0)
        {
            n/=10;
            count++;
        }
        System.out.println("count: " + count);
        n=num;
        while (n>0)
        {
            int digit=n%10;
            n=n/10;
            sum=sum+(Math.pow(digit,count));
        }
        System.out.println("the sum of digits to the power of number of digits is "+sum);
        if(sum==num)
        System.out.println("the number is an armstrong number");
        else
        System.out.println("the number is not an armstrong number");    
       sc.close();

    }
    
}
