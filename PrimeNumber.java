import java.util.*;
public class PrimeNumber 
{
    public static void main(String[] args)
    {
        System.out.println("enter a number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int prime =0;
        for (int i = 2; i <= num/2; i++)
        {
            if(num%i==0)
            {
            prime=0;
            break;
            }
            else
            prime=1;
        }
        
        if(prime!=0 || num==2 || num==3)
        System.out.println("the number is a prime number");
        else
        System.out.println("the number is not a prime number");
        sc.close();
    }
}
