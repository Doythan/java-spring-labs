package ex01;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Doythan");
        map.put("job", "developer");
        System.out.println("name: " + map.get("name"));
        System.out.println("------------------------");
        map.put("name", "changed");  // 키 중복 -> 덮어쓰기
        System.out.println("name: " + map.get("name"));
        System.out.println("job: " + map.get("job"));
        System.out.println("----------------------");
        System.out.println(map.keySet());  // keySet() 메서드: keySet() 메서드는 이 Map 안에 있는 모든 키들을 Set 인터페이스를 구현한 객체에 담아 반환.
        // 전체 순회
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
