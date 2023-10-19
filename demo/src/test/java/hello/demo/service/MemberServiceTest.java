package hello.demo.service;

import hello.demo.domain.Member;
import hello.demo.repository.MemberRepository;
import hello.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository ;
    MemberService memberService;

    // before each 동작하기 전에 실행하는 각각  메소드 생성
    @BeforeEach
    public void beforeEach(){
        memberRepository  = new MemoryMemberRepository();
        memberService  = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);
        //then
        Member one =  memberService.findOne(saveId).get();
        Assertions.assertEquals(member.getName(), one.getName());

    }
    @Test
    public void duplicate_member(){
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");


        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        Assertions.assertEquals(e.getMessage(), "이미 존재하는 회원입니다");


        //        try{
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e){
//            Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다");
//        }
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}