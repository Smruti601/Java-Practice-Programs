import java.util.*;

class Registration 
{
    
    static Scanner sc = new Scanner(System.in);

    static void signUp() 
    {
        System.out.println("  Make New Account Here");
        System.out.println("-------------------------");

        System.out.print("Enter Full Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        long accountNo = sc.nextLong();

        System.out.print("Enter Mobile Number: ");
        long mobileNo = sc.nextLong();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Email-ID: ");
        String email = sc.nextLine();

        System.out.print("Set Password: ");
        String password = sc.nextLine();

        System.out.print("Confirm Password: ");
        String confirmPassword = sc.nextLine();

        if (!(password.equals(confirmPassword))) 
        {
            System.out.println();
            System.out.println("Password does not match...");
            return;
        }

        System.out.println("Account created successfully...");

    }

    static void signIn() 
    {
        System.out.println("  Sign-in Here");
        System.out.println("----------------");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
    }

    public static void main(String[] args) 
    {
        System.out.println("       Welcome");
        System.out.println("=====================");
    
        System.out.println("For SIGN UP Press: 1 ");
        System.out.println("For SIGN IN Press: 0 ");
        System.out.println("=====================");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        if (choice == 1) 
        {
            signUp();
        } 
        else if (choice == 0) 
        {
            signIn();
        } 
        else 
        {
            System.out.println("Invalid choice. Exiting.");
            return;
        }
    }
}
