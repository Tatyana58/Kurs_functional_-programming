import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Primer_Olga {

    static Integer count;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //Строка для ввода :  quick brown fox jumps over the lazy dog the the the brown fox jumps over the lazy dog the the the sgf drgdr geert erte rferf
        System.out.print("Введите строку : ");
        String messageWord = in.nextLine();
        checkWords(messageWord);
    }
    public static void checkWords(String str) {
        String[] words = str.split("\\W+");
        long count = Arrays.stream(words).map(String::toLowerCase)
                .filter(Predicate.not(String::isBlank))
                .count();
        System.out.printf("В тексте: %d слов \n", count);
        System.out.println("TOP 10:");
        Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(System.out::println);
    }
}