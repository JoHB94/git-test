package hello.spring2.hello2.controller;

import hello.spring2.hello2.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class MemberController {

    private Memberservice memberService;

    @Autowired
    public MemberController(Memberservice memberService) {
        this.memberService = memberService;
    }
}
