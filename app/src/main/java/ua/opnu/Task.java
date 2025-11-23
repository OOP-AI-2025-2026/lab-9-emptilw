package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.HashMap;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        for (int i = 0; i < list.size() - 1; i += 2) {
            String a = list.get(i);
            String b = list.get(i + 1);
            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i--;
        }
    }

    public void stutter(List<String> list) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        for (int i = 0; i < list.size() - 1; i += 2) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
        }
    }

    public void removeDuplicates(List<String> list) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        for (int i = 1; i < list.size(); ) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        if (queue.isEmpty()) return true;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            queue.add(val);
            stack.push(val);
        }

        boolean result = true;
        for (int i = 0; i < size; i++) {
            int qVal = queue.remove();
            int sVal = stack.pop();
            if (qVal != sVal) result = false;
            queue.add(qVal);
        }

        return result;
    }

    public void reorder(Queue<Integer> queue) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        // Використовуємо лише один ArrayDeque як допоміжний стек
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Переносимо всі елементи з черги в стек (тепер стек має елементи в зворотному порядку)
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Обробляємо рівно n елементів (n - початковий розмір)
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            int val = stack.pop();
            if (val < 0) {
                // негатvивні одразу додамо в чергу (вони будуть у потрібному порядку)
                queue.add(val);
            } else {
                // позитивні тимчасово кладемо в кінець стеку
                stack.addLast(val);
            }
        }

        // Тепер у stack залишилися тільки позитивні числа, але в такому порядку,
        // що видалення елементів з хвоста дає їх у зростаючому порядку
        while (!stack.isEmpty()) {
            queue.add(stack.removeLast());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v % 2 == 0) stack.push(v);
            queue.add(v);
        }

        while (!stack.isEmpty())
            queue.add(stack.removeLast());

        for (int i = 0; i < size; i++) {
            int v = queue.remove();
            if (v % 2 != 0) queue.add(v);
        }
    }

    public int maxLength(Set<String> set) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        int max = 0;
        for (String s : set) max = Math.max(max, s.length());
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        Set<Integer> set = new HashSet<>(list1);
        Set<Integer> result = new HashSet<>();
        for (int v : list2) if (set.contains(v)) result.add(v);
        return result.size();
    }

    public boolean isUnique(Map<String, String> map) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        Set<String> seen = new HashSet<>();
        for (String v : map.values())
            if (!seen.add(v)) return false;
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        Map<String, Integer> out = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key)))
                out.put(key, map1.get(key));
        }
        return out;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        Map<String, Integer> out = new HashMap<>();
        for (var e : map.entrySet()) {
            out.put(e.getValue(), e.getKey());
        }
        return out;
    }

    public int rarest(Map<String, Integer> map) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        if (map.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int v : map.values())
            freq.put(v, freq.getOrDefault(v, 0) + 1);

        int minFreq = Integer.MAX_VALUE;
        int bestVal = Integer.MAX_VALUE;

        for (var e : freq.entrySet()) {
            int val = e.getKey();
            int count = e.getValue();
            if (count < minFreq || (count == minFreq && val < bestVal)) {
                minFreq = count;
                bestVal = val;
            }
        }

        return bestVal;
    }

    public int maxOccurrences(List<Integer> list) {
        // TODO: напишіть вміст методу згідно умовам для того, щоб пройти тести
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;

        for (int v : list) {
            int f = freq.getOrDefault(v, 0) + 1;
            freq.put(v, f);
            max = Math.max(max, f);
        }

        return max;
    }

}
