package ClassWork.Jan14.Program3;
// package ClassWork.trainingday6.Program3;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternMatching {
    public static void main(String[] args) {
        // String s1 = "Wissen Technology";
        // String s2 = "Tech";
        // // The pattern that is to be searched in the string should be passed here
        // Pattern p1 = Pattern.compile(s2);

        // // 
        // Matcher m1 = p1.matcher(s1);

        // System.out.println(m1.find());
        // System.out.println(m1.matches());

        // String email = "abc@xyz.com";
        // String emailPattern = "[a-zA-Z0-9.]+@[a-zA-Z]+\\.com$";
        // Pattern p2 = Pattern.compile(emailPattern);
        // Matcher m2 = p2.matcher(email);
        // System.out.println(m2.matches());

        long l = 1234567890L;
        Pattern p3 = Pattern.compile("\\d{10}");
        Pattern p4 = Pattern.compile("[8-9][0-9]{9}");
        Matcher m3 = p3.matcher(Long.toString(l));
        System.out.println(m3.matches());
    }
}
