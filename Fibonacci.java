import java.util.*;
public class Fibonacci 
{
    public static void main(String[] args)
    {
        System.out.println("enter the length of the series to be printed");
        Scanner sc=new Scanner(System.in);
        int len = sc.nextInt();
        int a= 0;
        int b=1;
        System.out.print(a+" "+b);
        for (int i=0; i<len-2; i++)
        {
            int c=a+b;
            System.out.print(" "+c);
            a=b;
            b=c;
        }
        sc.close();
    }
}
