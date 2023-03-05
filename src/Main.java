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
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toMap;

public class Main {
    static Integer count;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //String messageWord = "quick brown fox jumps over the lazy dog the the the";
        System.out.print("Введите строку : ");
        String messageWord = in.nextLine();
        String[] words = messageWord.toLowerCase().replace("[-,.;:?!№@%^&*()_=+~` |]","").split("\\s");

        Map<String,Integer> mapWord = new TreeMap<String,Integer>(Comparator.reverseOrder());
        for (String word : words) {
            if (!word.isEmpty()) {
                count = mapWord.get(word);
                if (count == null) {
                    count=0;
                }
                    mapWord.put(word, ++count);

            }
        }
        System.out.println(maxBy(count)-1);
        System.out.println("Всего " + words.length + " слов в тексте");
        for (String word : mapWord.keySet()) {
            System.out.println(mapWord.get(word) + " -  " + (word));
        }
    }

    private static int maxBy(Integer count) {
        count++;
        return count;
    }
}