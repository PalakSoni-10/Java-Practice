import java.util.*;
public class SimpleCalculator 
{
    public static void main(String args[])
    {
        System.out.println("To add, enter 1");
        System.out.println("To subtract, enter 2");
        System.out.println("To multiply, enter 3");
        System.out.println("To divide, enter 4");
        Scanner sc = new Scanner(System.in);
        int s=sc.nextInt();
        switch(s)
        {
            case 1:
            {
                System.out.println("enter 2 numbers");
                int x =sc.nextInt();
                int y =sc.nextInt();
                System.out.println("after adding, "+x+" and "+y+" give "+(x+y)); 
                break;
            }
            case 2:
            {
                System.out.println("enter 2 numbers");
                int x =sc.nextInt();
                int y =sc.nextInt();
                System.out.println("after subtracting, "+x+" and "+y+" give "+(x-y)); 
                break; 
            }
            case 3: 
            {
                System.out.println("enter 2 numbers");
                int x =sc.nextInt();
                int y =sc.nextInt();
                System.out.println("after multiplying, "+x+" and "+y+" give "+(x*y)); 
                break;    
            }
            case 4:
            {
                System.out.println("enter 2 numbers");
                float x =sc.nextInt();
                float y =sc.nextInt();
                //float d = x/y;
                System.out.println("after dividing, "+x+" and "+y+" give "+(x/y)); 
                break;   
            }
            default:
            System.out.println("invalid input");
        }
        sc.close();

    }
}
