package hello.demo;



import hello.demo.aop.TimeTraceAop;
import hello.demo.repository.FoodRecInputRepository;
import hello.demo.repository.JpaFoodRecInputRepository;
import hello.demo.repository.JpaMemberRepository;
import hello.demo.repository.MemberRepository;
import hello.demo.service.FoodRecInputService;
import hello.demo.service.MemberService;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class SpringConfig {


    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
       // return new MemoryMemberRepository();
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
    @Bean
    public FoodRecInputService foodRecInputService(){
        return new FoodRecInputService(foodRecInputRepository());
    }

    @Bean
    public FoodRecInputRepository foodRecInputRepository(){
        // return new MemoryMemberRepository();
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaFoodRecInputRepository(em);
    }
    // time trace Aop
    @Bean
    public TimeTraceAop timeTraceAop(){
        return  new TimeTraceAop();
    }

    //Swagger
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Springdoc 테스트")
                .description("Springdoc을 사용한 Swagger UI 테스트")
                .version("1.0.0");
    }
}
