
import java.util.Scanner;

public class Armstrong 
{
    public static void main(String[] args) 
    {
        int num1 ,num2 ,s;
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter a number to check armstrong : ");
        int a = sc.nextInt();

        num2 = a;
        num1 = 0;

        while (a != 0)
        {
            s = a % 10 ;
            num1 += (s*s*s);
            a = a/10;
        }

        if (num1 == num2)
        System.out.println(num2 +" is a Armstrong Number...");
        else
        System.out.println(num2 +" is not an Armstrong Number...");

    }    
}

// OUTPUT : 
// =========
// ex1 - Enter a number to check armstrong : 370
// 370 is a Armstrong Number...

// ex2 - Enter a number to check armstrong : 371
// 371 is a Armstrong Number...

// ex3 - Enter a number to check armstrong : 153
// 153 is a Armstrong Number...