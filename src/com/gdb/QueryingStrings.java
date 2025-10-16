package src.com.gdb;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueryingStrings {

    static void main() {

        String input = "Java articles are Awesome and4 educational";

        List<String> sentences = Arrays.asList(
                "Java streams are powerful",
                "Streams help process collections",
                "Java supports functional programming",
                "Functional programming makes code concise",
                "Streams can filter map and reduce data",
                "Java is platform independent",
                "Code once run anywhere",
                "Collections and streams work well together",
                "Java developers love streams",
                "Practice makes you better at Java");

        //1.Remove duplicates
        List<String> removedDuplicates = Arrays.stream(input.split(" ")).distinct().toList();
        System.out.println("1.Removed duplicates : " + removedDuplicates);
        System.out.println();

        //2.Having particular words
        String havingParticularWord = Arrays.stream(input.split(" "))
                .filter(word -> word.equalsIgnoreCase("Java")).collect(Collectors.joining(" "));
        System.out.println("2.Having particular word : " + havingParticularWord);
        System.out.println();

        //3.Remove word that starts with
        String removeWordThatStartsWith = Arrays.stream(input.split(" "))
                .filter(word -> !word.startsWith("Java")).collect(Collectors.joining(" "));
        System.out.println("3.Remove word that starts with : " + removeWordThatStartsWith);
        System.out.println();

        //4.length of each name in the list
        Map<String, Integer> lengthOfNames = Arrays.stream(input.split(" "))
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("4.Length of names in the list : " + lengthOfNames);
        System.out.println();

        //5.find the first element in the list that starts with a particular character
        String firstElementStartingWithParticularCharacter = Arrays.stream(input.split(" ")).filter(word -> word.startsWith("a")).findFirst().get();
        System.out.println("5.First element in the list that starting with particular character : " + firstElementStartingWithParticularCharacter);
        System.out.println();

        //6. sort the list of Strings based on their lengths in ascending/descending order
        List<String> sortedListAscending = Arrays.stream(input.split(" ")).sorted(Comparator.comparingInt(String::length)).toList();
        List<String> sortedListDescending = Arrays.stream(input.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).toList();
        System.out.println("6.a.List of strings sorted based on their lengths in Ascending order : " + sortedListAscending);
        System.out.println("6.b.List of strings sorted based on their lengths in Descending order : " + sortedListDescending);
        System.out.println();

        //7. find the longest word or string in the list
        String longestWord = Arrays.stream(input.split(" ")).max(Comparator.comparingInt(String::length)).get();
        System.out.println("7.Longest word in the string : " + longestWord);
        System.out.println();

        //8.get the list of string having vowels
        List<String> listOfStringHavingVowels = Arrays.stream(input.split(" "))
                .filter(word -> word.toLowerCase().matches(".*[aeiou].*")).toList();
        System.out.println("8.List Of Strings having vowels : " + listOfStringHavingVowels);
        System.out.println();

        //9.Convert a list of strings into a string separated by commas
        List<String> names = Arrays.asList("Ruqsana", "Shibra", "Sehrish", "Khairunnisa", "Khuratul-Ain");
        String listOfStringsSeparatedByComma = names.stream().collect(Collectors.joining(","));
        System.out.println("9.List of strings separated by comma : " + listOfStringsSeparatedByComma);
        System.out.println();

        //10.To create a list of string where each string is reversed from the original
//        List<String> listOfStringsWhereStringIsReversed = Arrays.stream(input.split(" ")).sorted(Comparator.reverseOrder()).toList();
        String listOfStringsWhereStringIsReversed = Arrays.stream(input.split(" ")).map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println("10.List of string where each string is reversed from the original list : " + listOfStringsWhereStringIsReversed);
        System.out.println();

        //11.Remove empty and null elements in the list
        List<String> tempNames = Arrays.asList("Ruqsana", " ", null);
        List<String> nonEmptyList = tempNames.stream().filter(word -> null != word && !word.trim().isEmpty()).toList();
        System.out.println("11.Remove empty and null elements in the list : " + nonEmptyList);
        System.out.println();

        //12.Group the list of string by the first letter of each string
        Map<Character, List<String>> wordMap = Arrays.stream(input.split(" ")).collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println("12.List of strings grouped by the first letter of each string : " + wordMap);
        System.out.println();

        //13.Group the list of string by the length of the strings
        Map<Integer, List<String>> wordLengthMap = Arrays.stream(input.split(" ")).collect(Collectors.groupingBy(String::length));
        System.out.println("13.List of strings grouped by the length of the strings : " + wordLengthMap);
        System.out.println();

        //14.Group the list of string with vowel
        Map<Boolean, List<String>> wordsWithVowel = Arrays.stream(input.split(" "))
//                .collect(Collectors.groupingBy(word -> word.toLowerCase().chars().anyMatch(ch -> ".*aeiou.*".indexOf(ch) != -1)));
                .collect(Collectors.groupingBy(word -> "aeiou".indexOf(word.toLowerCase().charAt(0)) != -1));
        System.out.println("14.List of strings with vowel : " + wordsWithVowel.get(true));
//        System.out.println("14.List of strings with vowel: " + wordsWithVowel.get(true));
        System.out.println();

        //15.Group the list of string with have only character except numbers
        List<String> listWithCharactersExceptNumbers = Arrays.stream(input.split(" ")).filter(word -> word.matches("[a-zA-Z]+")).toList();
        System.out.println("15.list of string with have only character except numbers : " + listWithCharactersExceptNumbers);
        System.out.println();

        //16.find the first element having length 10 if not handle exception
        String firstElementHavingLength10 = Arrays.stream(input.split(" ")).filter(word -> word.length() > 10).findFirst().orElseThrow(() -> new RuntimeException("Not Found"));
        System.out.println("16.First element having length 10 : " + firstElementHavingLength10);
        System.out.println();

        //17.first repeated character, first non-repeated character, character count
        HashSet<Character> seen = new HashSet<>();
        Character firstRepeatedCharacter = input.chars().mapToObj(ch -> (char) ch).filter(c -> !seen.add(c)).findFirst().get();
        System.out.println("17.a.First repeated character : " + firstRepeatedCharacter);
        HashSet<Character> finalSeen = new HashSet<>();
        Character firstNonRepeatedCharacter = input.chars().mapToObj(ch -> (char) ch)
                .filter(finalSeen::add)
//                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst().get();
        System.out.println("17.b.First non-repeated character : " + firstNonRepeatedCharacter);
        long characterCount = input.chars().mapToObj(ch -> (char) ch).count();
        System.out.println("17.c.Character count: " + characterCount);
        System.out.println();

        //18.Frequency of characters
        Map<Character, Long> frequencyOfCharacters = input.chars().mapToObj(ch -> (char) ch)
                .filter(character -> !character.equals(' '))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("18.Frequency of characters : " + frequencyOfCharacters);
        System.out.println();

        //19. Word Frequency in a sentence
        Map<String, Long> wordFrequency = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("19.Word Frequency in a sentence : " + wordFrequency);
        System.out.println();

        //20. Most Common Word in a sentence
        System.out.print("20.Most Common Word in a sentence : ");
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .findFirst()
//                .ifPresent(entry -> System.out.println(entry.getKey()));
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println(entry.getKey()));
        System.out.println();

        //21. Length of Second-Longest word in a sentence - EPAM
        Optional<String> secondLongestWordLength = Arrays.stream(input.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .skip(1)
                .findFirst();
        System.out.println("21.Length of Second-Longest word in a sentence : " + secondLongestWordLength.get().length());
        System.out.println();
    }
}
