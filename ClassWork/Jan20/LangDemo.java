package ClassWork.Jan20;

public class LangDemo {
    public static void main(String[] args) {
        String s1 = "hi";
        System.out.println(s1);
        s1 = "hello";
        System.out.println(s1);

        // Existing object is not checked for modification
        // We have to assign it to a new object
        s1 = s1.toUpperCase();
        System.out.println(s1);

        StringBuffer sb1 = new StringBuffer("hi");
        sb1.append("Hello");
        System.out.println(sb1);

        try{
            Runtime rt = Runtime.getRuntime();
            // start chrome
            Process p4 = rt.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            // start vscode
            // Process p5 = rt.exec("C:\\Users\\user\\AppData\\Local\\ Programs\\Microsoft VS Code\\Code.exe");
            System.out.println(" Opening the notepad in 5 seconds");
            Thread.sleep(5000);
            Process p1 = rt.exec("notepad.exe");
            System.out.println("Opening the calculator in 5 seconds");
            Thread.sleep(5000);
            Process p2 = rt.exec("calc.exe");
            System.out.println("Opening the paint in 5 seconds");
            Thread.sleep(5000);
            Process p3 = rt.exec("mspaint.exe");

            Thread.sleep(10000);
            p1.destroy();
            p2.destroy();
            p3.destroy();
            p4.destroy();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
