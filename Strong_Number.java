
import java.util.Scanner;

public class Strong_Number 
{
    static int fact(int num)
    {
        int  f = 1;
        while( num != 0)
        {
            f *= num--;
        } 
        return f;
    }

    static void checkStrong(int n)
    {
        int before = n;
        int after = 0 ; 

        while(n!= 0)
        {
            after += Strong_Number.fact(n%10);
            n = n / 10; 
        }
        if (before == after)
        System.out.println("Strong number ");
        else
        System.out.println("Not Strong Number");
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();

        Strong_Number.checkStrong(n);       
        
    }    
}

// OUTPUT : 
// ==========
// EXAMPLE :
// -----------
// Enter a number : 12
// Not Strong Number

// EXAMPLE 2: 
// -------------
// Enter a number : 145
// Strong number 