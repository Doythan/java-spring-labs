package ex01;

import java.util.*;

// GenericExample.java 안에 public class Box 선언 시 에러남
// Box가 public인데, 파일명이 Box.java가 아니기 때문
// 자바 규칙: 하나의 .java 파일에 public class는 단 하나만 있어야 하며, 그 클래스의 이름과 파일 이름이 반드시 같아야 한다.

class Box<T> {  // Box<T>에서 T는 타입을 매개변수처럼 쓰는 것
    private T value;  // 외부에서 직접 접근 ❌

    // Setter
    // Setter는 값을 저장(설정) : 외부에서 내부 변수에 값을 넣는 메서드 (setName(), setAge() 등)
    public void set(T value) {
        this.value = value;
    }

    // Getter
    // Getter는 값을 읽어옴 : 외부에서 내부 변수 값을 가져오는 메서드 (getName(), getAge() 등)
    public T get() {
        return value;
    }

    // Setter와 Getter를 쓰는 이유
    // 왜 쓰는가? (핵심 개념)
    // 자바는 캡슐화(encapsulation) 철학을 따름.
    // 즉, 멤버 변수는 외부에서 직접 접근 못하게 private로 막고, 대신 공개된 메서드(public)로만 간접 접근하게 만듦
}

// 제네릭 메서드 만들기
class Util {
    public static <T> void printTwice(T item) {  // <T>는 메서드 앞에 꼭 써야 제네릭 메서드라는 걸 인식함
        System.out.println(item);
        System.out.println(item);
    }
}

// 와일드카드(?)
// <?>는 모든 타입을 받을 수 있는 와일드카드
// 제네릭 클래스/메서드와 달리 호출 쪽이 아니라 받는 쪽에서 유연성 보장
// List<?>는 List<String>, List<Integer> 등 어떤 타입의 리스트든 받아들이겠다는 의미
class Printer {
    public static void printlist(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
        System.out.println(list);
    }
}

public class GenericExample {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println(stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println(intBox.get());

        Util.printTwice(stringBox.get());  // Hello 두번 출력함
        Util.printTwice(intBox.get());  // 123 두번 출력함
        Util.<Double>printTwice(3.14);  // 타입 명시도 가능

        List<String> strings = Arrays.asList("A", "B", "C");
        List<Integer> ints = Arrays.asList(1, 2, 3);

        Printer.printlist(strings);
        Printer.printlist(ints);
    }
}
