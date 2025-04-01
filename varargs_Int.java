class VarargsExample {
    public static void show(int... numbers)
    {
        System.out.print("numbers : ");
        for(int number : numbers)
        {
            System.out.print(number+ " ");
        }

    }

    public static void main(String[] args) {
        show(); 
        show(1, 2); 
        show(1, 2, 3, 4, 5); 
    }
}