package ex02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // 컴파일, 런타임 등 어느 시점에 작동할 것 인지 ..
@Target(ElementType.METHOD)  // 어노테이션 위치를 정하는 것, 이 코드는 메소드 위에만 할 수 있음
public @interface RequestMapping {
    String value();
}
