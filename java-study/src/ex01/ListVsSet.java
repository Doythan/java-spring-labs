package ex01;

import java.util.*;

public class ListVsSet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");  // 중복허용
        System.out.println("List: " + list);  // List: [apple, banana, apple]

        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple");  // 중복 제거됨
        System.out.println("Set: " + set);

    }
}
