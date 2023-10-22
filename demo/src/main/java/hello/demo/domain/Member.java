package hello.demo.domain;

import jakarta.persistence.*;



// User Entity
@Entity
public class Member {
    // 임의의 값 anno - pk generatedvalue identity type 은 DB가 자동 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String name;
    private String email;
    private String createdDate;
    private String mbti;
    private String gender;



    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getUserId(){
        return userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){return email;}
    public void setEmail(String email){this.email =email;}


    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getMbti(){return mbti;}
    public void setMbti(String mbti) {this.mbti = mbti;}
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }



}
