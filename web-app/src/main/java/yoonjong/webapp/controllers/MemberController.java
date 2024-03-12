package yoonjong.webapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yoonjong.webapp.adapters.services.MemberService;
import yoonjong.webapp.dtos.Member.CreateMemberDto;
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
}
