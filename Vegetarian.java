import java.util.*;

public class Vegetarian
{
    public static void main(String[] args)
    {
        int chicken;
        int egg;
        int fish;

        Scanner sc = new Scanner(System.in);

        System.out.println("enter 0 if false and 1 if true");
        System.out.println("does the user eat chicken?");
        chicken = sc.nextInt();
        System.out.println("does the user eat egg?");
        egg = sc.nextInt();
        System.out.println("does the user eat fish?");
        fish = sc.nextInt();


        if (chicken  == 1)
        System.out.println("the person is a non vegetarian");
        else if (egg == 1)
        System.out.println("the person is a non vegetarian");
        else if (fish == 1)
        System.out.println("the person is a non vegetarian");
        else
        System.out.println("the person is a vegetarian");

        sc.close();
        
    }

}