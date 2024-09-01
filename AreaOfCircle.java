import java.util.*;
public class AreaOfCircle 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        float r = sc.nextFloat();
        final float pi = 3.14f; //pi value should not change 
        float area = pi*r*r;
        System.out.println("The area of the circle is "+area+" square units");
        sc.close();
        
    }
}
