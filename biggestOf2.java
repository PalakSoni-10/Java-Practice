import java.util.*;
public class biggestOf2 
{
    public static void main (String[] args) 
    {
        System.out.println("enter 2 numbers");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("the numbers are: " + x +" and " + y);
        if(x>y)
        System.out.println(x+" is the biggest");
        else 
        System.out.println(y+" is the biggest");
        sc.close();
        
    }
}
