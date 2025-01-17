package ClassWork.Jan15.Program4;
// This class is Singleton
// Early initialization
final class Principal{

    private static final Principal p1 = new Principal();
    private Principal(){
        System.out.println("Object created");
    }
    public static Principal getPrincipal(){
        return p1;
    }
}

// Lazy initialization
// final class Principal{
//     private static Principal p1 = null;
//     private Principal(){
//         System.out.println("Inside constructor");
//     }
//     public static Principal getPrincipal(){
//         if(p1 == null){
//             p1 = new Principal();
//         }
//         return p1;
//     }
// }

public class SingletonTry {
    static{
        try{
            Class.forName("Principal");
        }
        catch(ClassNotFoundException e){
            System.out.println("Principal class not found");
        }
    }
    public static void main(String[] args) {
        Principal principal1 = Principal.getPrincipal();
        Principal principal2 = Principal.getPrincipal();
        System.out.println(principal1.hashCode());
        System.out.println(principal2.hashCode());
    }
    
}
