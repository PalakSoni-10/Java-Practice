import java.util.*;
public class RevNum 
{
    public static void main(String args[]) 
    {
        System.out.println("enter a number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int revnum = 0;
        while (num>0)
        {
            revnum=(revnum*10)+(num%10);
            num/=10;
        }
        System.out.println("the reverse of the number is " + revnum);
        sc.close();
        
    }
}
