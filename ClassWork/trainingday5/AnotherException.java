public class AnotherException {
    // Looping and Handling Exception
    public static void main(String[] args) {
        int a = 5;
        for (int i = 0; i < 10; i++){
            try{
                double res = 1.0 / (a - i);
                System.out.println(res);
            }
            catch (Exception e) {
                System.out.println("Caught exception");
                
            }  
        }
        try{
            System.out.println();
            int arr[] = new int[5];
            int res = arr[0] / 0;
        }
        catch (Exception e) {
            System.out.println("Caught exception");
            System.out.println(e.getMessage());
            System.out.println(e);
        }
        finally{
            System.out.println("This is finally block");
        }
    }
}
