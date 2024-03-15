package yoonjong.webapp.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yoonjong.webapp.adapters.services.MemberService;
import yoonjong.webapp.dtos.Member.CreateMemberDto;
import yoonjong.webapp.dtos.Member.LoginDto;
import yoonjong.webapp.dtos.Member.MemberSimpleDto;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute CreateMemberDto createContext) {
        MemberSimpleDto dto = memberService.CreateMember(createContext);
        if(dto == null) {
            System.out.println("dto is null");
            return "index";
        }

        System.out.println("memberEmail = " + dto.getEmail() + ", id = " + dto.getId() + ", memberName = " + dto.getName());
        return "index";
    }

    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }


    @PostMapping("/member/login") // session : 로그인 유지
    public String login(@ModelAttribute LoginDto loginDto, HttpSession session) {
        MemberSimpleDto loginResult = memberService.Login(loginDto);
        if (loginResult != null) {
            // login 성공
            session.setAttribute("loginEmail", loginResult.getEmail());
            return "main";
        } else {
            // login 실패
            return "login";
        }
    }
}
