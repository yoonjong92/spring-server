package yoonjong.webapp.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yoonjong.webapp.adapters.services.MemberService;
import yoonjong.webapp.dtos.Member.CreateMemberDto;
import yoonjong.webapp.dtos.Member.LoginDto;
import yoonjong.webapp.dtos.Member.MemberDto;
import yoonjong.webapp.dtos.Member.MemberSimpleDto;

import java.util.List;

// WEB과 API 구분하자.
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/")
    public String GetList(Model model) {
        List<MemberSimpleDto> memberDTOList = memberService.GetList();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    @GetMapping("/member/{id}")
    public String GetById(@PathVariable Long id, Model model) {
        MemberDto memberDTO = memberService.GetDetail(id);
        // login 처럼 return 값에 따라 분류 할 수 있음
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @GetMapping("/member/save")
    public String SaveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String Save(@ModelAttribute CreateMemberDto createContext) {
        MemberSimpleDto dto = memberService.CreateMember(createContext);
        if(dto == null) {
            System.out.println("dto is null");
            return "index";
        }

        System.out.println("memberEmail = " + dto.getEmail() + ", id = " + dto.getId() + ", memberName = " + dto.getName());
        return "index";
    }

    @GetMapping("/member/delete/{id}") // api로 빼야함, "DELETE" 메소드
    public String deleteById(@PathVariable Long id){
        memberService.DeleteMember(id);
        return "redirect:/member/";
    }

    @GetMapping("/member/login")
    public String LoginForm(){
        return "login";
    }


    @PostMapping("/member/login") // session : 로그인 유지
    public String Login(@ModelAttribute LoginDto loginDto, HttpSession session) {
        MemberSimpleDto loginResult = memberService.Login(loginDto);
        if (loginResult != null) {
            session.setAttribute("loginEmail", loginResult.getEmail());
            return "main";
        } else {
            return "login";
        }
    }
}
