## 의존성 주입(Dependency Injection: DI)

1. 객체 자체가 코드 상에서 객체 생성에 관여하지 않아도 되기때문에 객체 사이의 의존도 낮춤
2. 유연하고 확장성이 뛰어난 코드 작성 가능
3. 스프링 컨테이너에서 객체 Bean을 먼저 생성해두고 생성한 객체를 지정한 객체에 주입하는 방식을 의존성 주입

- 의존성 주입 전
```java
public class PetOwner{
	private AnimalType animal;
    
    public PetOwner(){
    	this.animal = new Dog();
    }
}

interface AnimalType{}

class Dog implements AnimalType{}

class Cat implements AnimalType{}

// PetOwner 클래스가 AnimalType에 의존적
```

#### 의존성 주입 방식

- Spring에서 제공하는 @Autowired 어노테이션 사용

1. 필드 주입

```java
@Controller
public class PetController{

	@Autowired
  private PetService petService;
}
```

2. 수정자 주입

```java
@Controller
public class PetController{

  private PetService petService;

	@Autowired
  public void setPetService(PetService petService){
    	this.petService = petService;
  }
}
```

3. 생성자 주입

```java
@Controller
public class PetController{

  private final PetService petService;  

	@Autowired
  public PetController(PetService petService){
    	this.petService = petService;
  }
}
```


