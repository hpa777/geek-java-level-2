package lesson3;

import java.util.HashMap;

public class Main {

    private static void part1() {
        String[] words = {
                "apple",
                "apricot",
                "avocado",
                "pineapple",
                "nectarine",
                "nectarine",
                "avocado",
                "banana",
                "bergamot",
                "durian",
                "grapefruit",
                "kiwi",
                "lime",
                "lemon",
                "loquat",
                "mango",
                "banana",
                "kiwi",
                "melon",
                "lime",
                "lime",
                "nectarine",
                "orange"
        };
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word :
                words) {
            Integer c = hashMap.getOrDefault(word, 0);
            hashMap.put(word, c + 1);
        }
        // Список уникальных слов
        System.out.println(hashMap.keySet());
        // Посчитать сколько раз встречается каждое слово
        System.out.println(hashMap);
    }

    public static void main(String[] args) {
        part1();

        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Петров", "7945234234234");
        phoneDirectory.add("Петров", "79452546456456");
        phoneDirectory.add("Семенов", "74952345566554");
        System.out.println(phoneDirectory.get("Петров"));
        System.out.println(phoneDirectory.get("Семенов"));

    }
}
