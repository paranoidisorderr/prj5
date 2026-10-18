package ivan;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String javaString = "Java";
        String reversedJavaString = reverseString(javaString);

        String palindromString = "А роза упала на лапу Азора";

        System.out.println(truncate("ds 44 r", 5));
    }

    public static String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }


    public static Boolean isPalindrome(String s) {
        String sWithoutSpaces = s.toLowerCase(Locale.ROOT);
        String s1 = new StringBuilder(s).reverse().toString();
        if (s.equals(s1)) {
            return true;
        } else {
            return false;
        }
    }

    public static int countChar(String s, char c) {
        int count = 0;
        for (char letter : s.toCharArray()) {
            if (letter == 'a') {
                count++;
            }
        }
        return count;
    }

    public static String removeSpaces(String s) {
        String s1 = s.replace(" ", "");
        return s1;
    }

    public static String capitalizeWords(String s) {
        StringBuilder result = new StringBuilder();
        boolean isStart = true;

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                result.append(ch);
                isStart = true;
            } else {
                if (isStart) {
                    result.append(Character.isUpperCase(ch));
                    isStart = false;
                } else {
                    result.append(Character.isLowerCase(ch));

                }
            }
        }

        return result.toString();
    }

    public static String truncate(String s, int max) {
        return s.substring(0, 5);
    }

    
}
