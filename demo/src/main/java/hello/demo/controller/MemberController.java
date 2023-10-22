package hello.demo.controller;

import hello.demo.domain.Member;
import hello.demo.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class MemberController {
    // 선언을 하고 생성자로 만들어서 사용하면 된다
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setEmail(form.getEmail());
        member.setGender(form.getGender());
        member.setMbti(form.getMbti());
        member.setUserId(form.getUserId());
        member.setCreatedDate(form.getCreatedDate());

        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String members(Model model){
        List<Member> member = memberService.findMembers();
        model.addAttribute("members", member);
        return "members/memberList";
    }

}
