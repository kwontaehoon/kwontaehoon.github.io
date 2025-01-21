## Qualifier

```java
@Configuration
public class Test {

    @Bean
    public int testBean() {
        return 123;
    }

    @Bean
    public int testNotAnnotationBean() {
        return 456;
    }

    public void execute() {
        System.out.println("Execute");
    }
}

@RestController
public class TestController {

    private final int testBean;
    private final int testNotAnnotationBean;
    private final Test test;
    private final BannerRepository bannerRepository;

    @Autowired
    public TestController(
            @Qualifier("testBean") int testBean,
            @Qualifier("testNotAnnotationBean") int testNotAnnotationBean,
            Test test,
            BannerRepository bannerRepository) {
        this.testBean = testBean;
        this.testNotAnnotationBean = testNotAnnotationBean;
        this.test = test;
        this.bannerRepository = bannerRepository;
    }

    @GetMapping("/api/test")
    public List<Banner> test() {
        System.out.println(testBean); // 123
        System.out.println(testNotAnnotationBean); // 456
        test.execute(); // Execute
        
        return bannerRepository.findAll();
    }
}
```

- Bean 어노테이션 타입이 같은 타입으로 사용되면 Qualifier나 Primary 어노테이션을 사용해서 어떤 Bean을 주입할지 명시적으로 지정해야한다.