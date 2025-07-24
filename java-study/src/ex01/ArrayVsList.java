package ex01;

import java.util.*;

public class ArrayVsList {
    public static void main(String[] args) {
        // 배열
        String[] arr = new String[3];
        arr[0] = "apple";
        arr[1] = "orange";
        arr[2] = "pear";
        System.out.println("배열출력");
        for (String s : arr) {
            System.out.println(s);
        }

        // List
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("orange");
        list.add("pear");
        System.out.println("List 출력");
        for (String s : list) {
            System.out.println(s);
        }

        // 동적 크기 변경
        list.add("dragonfruit");
        list.remove("apple");
        System.out.println(list);
    }
}