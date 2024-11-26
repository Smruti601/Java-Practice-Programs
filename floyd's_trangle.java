
import java.util.Scanner;



class Floyd_trangle
{
    static void printTriangle(int n)
    {
        int Counter = 1;
        //for rows
        for(int i = 1; i<= n;i++)
        {
            //for print
            for(int j = 1;j<=i;j++)
            {
                System.out.print(Counter+ " ");
                Counter++ ;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter number of rows : ");
       int n = sc.nextInt();
       printTriangle(n);

    }    
}
