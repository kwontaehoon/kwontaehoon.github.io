---
layout : archive
title : lombok
categories : Java
date : 2022-01-30
---
## Lombok
* 반복되는 메소드를 Annotation을 사용해서 자동으로 작성해주는 library


> @Autowired
- 스프링 컨테이너가 관리하는 빈 중에서 해당 타입에 맞는 객체를 찾아 자동으로 주입
- 타입 매칭 사용
- 필드: 해당 필드 타입을 확인하고 컨테이너에서 찾아서 주입
- 생성자: 해당 생성자를 사용하여 빈 생성

```java


```

> @Getter / @Setter
```java

@Getter
@Setter
public class DTO {
    private Integer id;
    private String name;

    /* 이 부분을 @Getter를 선언해줌으로써 생략이 가능하다.*/
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /* */
}

```
<br />

> @ToString
```java

@toString
public class Test {
    private Integer id;
    private String name;

    public String toString() {
        return "id" + id + "name" + name;
    }

    public static void main(String[] args) {
        Test test = new Test(1, "test");
        System.out.println("test: " + test); 
        // toString 메소드가 없으면 test 객체값을 알 수 없다.
    }
}
```
* toString을 자동 생성해주는 annotaion
* toString을 사용해서 객체값을 볼 수 있는데 @ToString을 사용하여 toString 메소드를 생략할 수 있다.


<br />

> @EqualsAndHashCode
```java

@EqualsAndHashCode
public class Test {
    private Integer id;
    private String name;

    public static void main(String[] args) {
        Test test1 = new Test(1, "test");
        Test test2 = new Test(1, "test");
        test1.hashCode() == test2.hashCode(); // true
        test1.equals(test2); // false
    }
}
```
* equals와 hashCode 자동 생성해주는 annotation
* equals는 동등성, 같은 객체인지 판단한다.
* hashCode는 동일성, 내부에 같은 값을 가지는지 판단한다.

<br />

> @RequiredArgsConstructor
```java
@Controller
public class Test {

    private final TestService testService;

    // @RequireArgsConstructor을 선언할 경우 생략 가능
    @Autowired // 생성자가 1개일 경우 생략 가능
    public Test(TestService testService) {
        this.testService = testService;
    }
}
```
* DI(Dependency Injection) 방법 중 생성자 주입에서 사용되는 annotation
* 클래스에 선언된 final이 붙은 변수, 필드들을 매개변수로 하는 생성자를 자동으로 생성해주는 annotation

<br />

> @AllArgsConstructor
```java
@AllArgsConstructor
public class Movie {

    private Long id;
    private String director;
    private String movieName;
    private int attendance;

    public Movie(Long id, String director, String movieName, int attendance) {
        this.id = id;
        this.director = director;
        this.movieName = movieName;
        this.attendance = attendance;
    }
}
```
* 클래스의 모든 필드에 대한 생성자를 자동으로 생성해주는 annotation

<br />

> @NoArgsConstructor
```java
@NoArgsConstructor
public class Movie {

    private Long id;
    private String director;
    private String movieName;
    private int attendance;

    public Movie() {}
}
```
* 매개변수를 가지지 않는 기본생성자(default constructor)를 생성한다. 

<br />

> @Builder before
```java

@Entity
@Component
@Getter
@ToString
public class Student {

    Integer id;
    String name;
    Integer grade;
    Integer age;

    public Student(Integer id, String name, Integer grade, Integer age) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public static class StudentBuilder {

        Integer id;
        String name; // 필수
        Integer grade; // 필수
        Integer age; // 선택

        public StudentBuilder(Integer id) {
            this.name = name;
            this.grade = grade;
            this.age = age;
        }
        public StudentBuilder age(Integer age) {
            this.age = age;
            return this;
        }
        public Student build() {
            return new Student(this.name, this.grade, this.age);
        }
    }
}

@Test
SpringBootTest
class BoardServiceTest {

    Student student;

    @Test
    public void aa() {

        Student test = new Student.StudentBuilder("name", 90).age(29).build();

        // given

        // when

        // then
    }
}
```

<br />

> @Builder after
```java
@Entity
@Component
@Getter
@ToString
public class Student {

    Integer id;
    String name;
    Integer grade;
    Integer age;

    @Builder
    public Student(Integer id, String name, Integer grade, Integer age) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;
    }
}
```
* 클래스를 설계할 때 생성자를 생성하여 매개변수를 받는다면 추가적인 변수에 따라 생성자를 여러개 생성해야한다.
* 빌더패턴을 사용함으로써 아래와 같은 장점을 가질 수 있다.
    * 데이터 일관성: 반드시 생성해야하는 필수 매개변수
    * 데이터 불변성: 생성자의 위치
    * null 체크
    * 가독성 up


> @Data
- @Getter + @Setter + @RequiredArgsConstructor + @ToString + @EqualsAndHashCode

1. Setter 문제점
- 객체를 언제든지 변경할 수 있는 상태가 되서 객체의 안전성이 보장 문제
- 양방향 연관관계에서 toString 무한 순환 문제