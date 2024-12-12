import java.util.Scanner;

class Prime
{
    static void checkPrime(int n)
    {
        int c = 0;
        for(int i = 1 ; i <= 5 ;i++ )
        {
            if(n % i == 0)
            {
                c++;
            }
        }

        if(c == 2)
        System.out.println(n+" is a Prime number...");
        else
        System.out.println(n+" is not a Prime number...");
        
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter a number : ");
        int n  = sc.nextInt();
        
        checkPrime(n);
        
    }
}

// output : 
// =========
// example 1 : 
// ---------------
// Enter a number : 2
// 2 is a Prime number...

// example 2 :
// -------------
// Enter a number : 6
// 6 is not a Prime number...