package hello.demo.controller;


import hello.demo.domain.Member;
import hello.demo.domain.MemberForm;
import hello.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private MemberService service;

    //@Autowired ==> 1)필드 service = new service; 2) 생성자에 Autowired => Best! 3)셋터메소드에 Autowired
    @Autowired //생성자에 Autowired :
    public MemberController(MemberService service) {
        this.service = service;
        /*private void setService(MemberService){
        셋터메소드에 Autowired  =>가능하긴 하나 논리에 안맞음.
    }*/
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/members/new")
    public String join() {
        return "membersnew"; //이름 입력받는 화면을 뿌려준다
    }

    @PostMapping("/members/new")
    public String joinprocess(MemberForm form) { //입력받은 이름을 db에 추가해준다
        Member member = new Member();
        member.setName(form.getName());
        member.setPhone(form.getPhone());
        member.setAddress(form.getAddress());
        member.setEmail(form.getEmail());

         service.memberJoin(member);
         return "redirect:/";
    }

    @GetMapping("/members")
    public String memberList(Model model) { //db에 있는 회원정보를 화면에 뿌려준다
        List<Member> members = service.findAllMembers();

        model.addAttribute("members",members);
        return "memberlist";
    }

}
