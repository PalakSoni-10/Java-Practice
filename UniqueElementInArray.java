import java.util.*;
public class UniqueElementInArray {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size");
        int size=sc.next();
        int arr[]=new int[size];
        System.out.println("Enter array elements");
        for (int i=0; i<size; i++)
        {
            arr[i]=sc.nextInt();
        }

        for (int i=1; i<=size; i++)
        {
            int count=1;
            for(int j=1; j<=size; j++)
            {
                if(i!=j)
                {
                    if(arr[i]==arr[j])
                    {
                        count++;
                    }
                }
            }
            if (count==1)
            {
                System.out.println("the unique element is "+arr[i]);
                break;
            }

        }

    }
    
}
