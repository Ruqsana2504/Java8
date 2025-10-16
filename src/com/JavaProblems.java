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

        System.out.println("Missing Number : " + missingNum(new int[]{8, 2, 4, 5, 3, 7, 1})); //Output : 6
    }

    //3. Missing number in list - EPAM
    public static int missingNum(int[] arr) {
        int n = arr.length + 1;

        // Create hash array of size n+1
        int[] hash = new int[n + 1];

        // Store frequencies of elements
        for (int i = 0; i < n - 1; i++) {
            hash[arr[i]]++;
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}
