package src.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class JavaProblems {

    static void main() {
        // Count the occurrences of each character in a string (pure Java, no streams)

        String str = "hello world";

        //1.Using HashMap
        HashMap<Character, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println("Occurrences of each character using HashMap: " + occurrences);

        //2.Using count array
        int[] arr = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                arr[ch]++;
            }
        }

        System.out.println("Occurrences of each character using Count Array:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println((char) i + " : " + arr[i]);
            }
        }

        System.out.println("Count array (full): " + Arrays.toString(arr));

    }
}
