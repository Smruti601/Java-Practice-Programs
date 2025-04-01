import java.util.*;

class Bank {
    static float amount = 0;

    static boolean checkPin(int pin) 
    {
        int pinlist[] = {111, 222, 333, 444, 555, 666, 777, 888, 999, 123, 234, 456, 678, 890};
        boolean isValid = false;

        for (int i = 0; i < pinlist.length; i++) 
        {
            if (pin == pinlist[i])
            {
                isValid = true;
                break;
            }
        }

        if (isValid) 
        {
            System.out.println("Asa Tamaku Mo Bank ku Swagat !!!");
            return true;
        } 
        else 
        {
            System.out.println("Ja be Bhikari !!!");
            return false;
        }
    }

    static void deposite(float rupees) 
    {
        amount += rupees;
        System.out.println("Current Balance is : " + amount);
    }

    static void withdraw(float rupees) 
    {
        if (amount < rupees) {
            System.out.println("Insufficient Balance re Bhikari...");
        } else {
            amount -= rupees;
            System.out.println("Withdraw completed...");
            System.out.println("Current Balance is : " + amount);
        }
    }

    public static void main(String[] args) 
    {
        Bank obj = new Bank();
        Scanner sc = new Scanner(System.in);

        try 
        {
            System.out.print("Enter Your PIN : ");
            int pin = sc.nextInt();

            if (checkPin(pin))
            {
                System.out.println();

                while (true) 
                {
                    Thread.sleep(1000);
                    System.out.println("--------------------");
                    System.out.println("Options For Mo Bank");
                    System.out.println("--------------------");
                    System.out.println();
                    System.out.println("Press (1) for Deposite");
                    System.out.println("Press (2) for Withdraw");
                    System.out.println("Press (3) for Check Balance");
                    System.out.println("Press (4) for Exit");
                    System.out.println();
                    System.out.print("Enter Your choice : ");

                    try 
                    {
                        int choice = sc.nextInt();

                        // For Deposite
                        if (choice == 1) 
                        {
                            System.out.print("Enter Deposite Amount : ");
                            float amount = sc.nextFloat();
                            System.out.println();
                            deposite(amount);
                        }
                        // For Withdraw
                        else if (choice == 2) 
                        {
                            System.out.print("Enter Withdraw Amount : ");
                            float amount = sc.nextFloat();
                            System.out.println();
                            withdraw(amount);
                        }
                        // For Check Balance
                        else if (choice == 3) 
                        {
                            System.out.println("Current Balance is : " + amount);
                        }
                        // For Exit
                        else if (choice == 4) 
                        {
                            System.out.println("OK Take Care ... Phir Milenge... Tataaaa");
                            return;
                        }
                        // Invalid Choice
                        else {
                            System.out.println("ERROR : Enter valid option ...");
                        }
                    } 
                    catch (InputMismatchException e) 
                    {
                        System.out.println("Invalid input! Please enter a number.");
                        sc.nextLine(); // Clear the invalid input
                    }
                }
            }
        }

        catch (Exception e) 
        {
            System.out.println("Bhasa Sunibu ki ...");
        }
    }
}
