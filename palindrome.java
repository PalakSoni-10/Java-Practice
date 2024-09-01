import java.util.*;
public class palindrome 
{
    public static void main(String args[]) 
    {
        System.out.println("enter a number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n=num;
        int revnum = 0;
        while (n>0)
        {
            revnum=(revnum*10)+(n%10);
            n/=10;
        }
       
        if(revnum == num)
        
        System.out.println("the number is a palindrome");
        
        else
        
        System.out.println("the number is not a palindrome");
        
        sc.close();        
    }
}
