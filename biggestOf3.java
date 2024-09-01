import java.util.*;
public class biggestOf3 
{
    public static void main (String[] args) 
    {
        System.out.println("enter 3 numbers");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println("the numbers are: " + x +", " + y+" and " + z);
        if(x>y && x>z)
        System.out.println(x+" is the biggest");
        else if(y>x && y>z)
        System.out.println(y+" is the biggest");
        else
        System.out.println(z+" is the biggest");
        sc.close();
 
}
}
