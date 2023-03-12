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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{
    static Integer count;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //Строка для ввода :  quick brown fox jumps over the lazy dog the the the brown fox jumps over the lazy dog the the the sgf drgdr geert erte rferf
        System.out.print("Введите строку : ");
        String messageWord = in.nextLine();
        String[] words = messageWord.toLowerCase().replace("[-,.;:?!№@%^&*()_=+~` |]","").split("\\s");

        Map<String,Integer> mapWord = new TreeMap<String,Integer>();//Comparator.reverseOrder()
        for (String word : words) {
            if (!word.isEmpty()) { //проверяет, пустая ли строка
                count = mapWord.get(word);
                if (count == null) {
                    count=0;
                }
                    mapWord.put(word, ++count);  //Чтобы добавить элементы, вызываем метод put()
            }
        }

        System.out.println("Всего слов в тексте - " + words.length);
        System.out.println("Топ - 10 часто используемых слов в данном тексте.");

        mapWord.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(System.out::println);
    }
}