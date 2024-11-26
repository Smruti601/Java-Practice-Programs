
import java.util.Scanner;

class Test
{
    static void drawPattern(int n)
    {
        //
        for(int i = n ; i >= 1 ; i--)
        {
            for(int j = 1 ; j<= i ;j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }
       

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();
        drawPattern(n);
    }
}