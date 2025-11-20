package src.com;

import java.util.ArrayList;
import java.util.List;

public class TechMahindra_14Nov_Round1 {

    // Write a java program to display numbers between 100-200, whose sum of first & third digit is equal to the middle.
    // Ex: 132,154,176,187,198

    static void main() {
        List<Integer> result = new ArrayList<>();
        for (int i = 101; i < 200; i++) {
            int temp = i; //101
            int third = temp % 10; //third = 1
            temp = temp / 10; // temp = 10
            int middle = temp % 10; // middle = 0
            temp = temp / 10; // temp  = 1
            int first = temp % 10; // first = 1
            if (first + third == middle) {
                result.add(i);
            }
        }
        System.out.println(result);
    }
}



