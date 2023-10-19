package hello.demo.domain;
// member 객체 Entity
public class Member {
    // 임의의 값
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
