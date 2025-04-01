public class varargs_string {
    public static void showStrings(String... strings)
    {
            System.out.print("Strings : ");
            for(String s : strings)
            {
                System.out.print(s+" ");
            }
            System.out.println();
    }
    
    public static void main(String[] args)
     {
        showStrings();
        showStrings("hii","Smruti");
        showStrings("Hello","Smruti","Ranjan");
        
    }
}
