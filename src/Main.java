/*## Задача на функциональное программирование

Напишите приложение, которое на входе получает через консоль текст, а в ответ выдает статистику:

1. Количество слов в тексте.
2. Топ-10 самых часто упоминаемых слов, упорядоченных по количеству упоминаний в
обратном порядке. В случае одинакового количества упоминаний слова должны быть отсортированы по алфавиту.

**Например:**
Input:
yourapp the quick brown fox jumps over the lazy dog

 */

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Main {
    static Scanner in = new Scanner(System.in);
    static String massage;
    public static void main(String[] args) {
        //String messageWord = "quick brown fox jumps over the lazy dog the the the";
        System.out.print("Введите строку : ");
        String messageWord = in.nextLine();
        String[] words = messageWord.toLowerCase().replace("[-,.;:?!№@%^&*()_=+~` |]","").split("\\s");

        Map<String,Integer> mapWord = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                Integer count = mapWord.get(word);
                if (count == null) {
                    count=0;
                }
                    mapWord.put(word, ++count);
            }
        }
        System.out.println("Всего " + words.length + " слов в тексте");
        for (String word : mapWord.keySet()) {
            System.out.println(mapWord.get(word) + " -  " + (word));
        }
    }
    public static String input() {
        massage = String.valueOf(in.hasNextLine());
        return massage;
    }
}