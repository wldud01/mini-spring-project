package hello.demo.domain;

import jakarta.persistence.*;

// member 객체 Entity
@Entity
public class Member {
    // 임의의 값 anno - pk generatedvalue identity type 은 DB가 자동 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
