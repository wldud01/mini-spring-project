package hello.demo.controller;

public class MemberForm {
    // Controller 에서 MemberForm 객체를 찾아서 key이름과 같은 변수에 값을 넣어줌
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}
