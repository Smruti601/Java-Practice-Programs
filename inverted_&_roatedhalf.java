
import java.util.Scanner;

class Test
{
    static void printStar(int n)
    {
        // rows
        for (int i = 1;  i<=n ; i++) 
        {
            //spaces
            for(int j = 1;j<= n-i ;j++)
            {
                System.out.print("  ");
            } 

            // stars
            for (int k = 1; k<= i ; k++) 
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to print stars : ");
        int n = sc.nextInt();
        printStar(n);    
    }
}