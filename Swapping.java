public class Swapping 
{
    public static void main(String[] args)
    {
        System.out.println("swapping using third variable: ");
        int x = 5;
        int y = 10;
        System.out.println("the numbers before swapping are: " + x + " " + y);
        int temp = x;
        x = y;
        y = temp;
        System.out.println("the numbers after swapping are: " + x + " " + y);
    
        System.out.println("swapping without using third variable: ");
        int a = 5;
        int b = 10;
        System.out.println("the numbers before swapping are: " + a + " " + b);
        a = a+b;
        b = a-b;
        a = a-b;    
        System.out.println("the numbers after swapping are: " + a + " " + b);

    }
    
}
