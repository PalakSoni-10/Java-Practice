
public class Time
{
    public static void main(String []args)
    {
        int x = 20;
        int y = 23;
        int z = 06;

        if(x>12)
        System.out.println("The time is "+ (x-12)+" pm");
        else 
        System.out.println("The time is"+ x+ " am");

        /*if(x>04 && x<16)
        System.out.println("It is day");
        else
        System.out.println("It is night");*/
       // result = if(x>04 && x<16)?"It is day":"It is night";


        if(y>12)
        System.out.println("The time is "+ (y-12)+" pm");
        else 
        System.out.println("The time is"+ y+ " am");

        if(y>04 && y<16)
        System.out.println("It is day");
        else
        System.out.println("It is night");

        if(z>12)
        System.out.println("The time is "+ (z-12)+" pm");
        else 
        System.out.println("The time is "+ z+ " am");

        if(z>04 && z<16)
        System.out.println("It is day");
        else
        System.out.println("It is night"); 
    }
} 