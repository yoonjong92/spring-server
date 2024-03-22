package yoonjong.webapp.controllers.api;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yoonjong.webapp.adapters.services.MemberService;
import yoonjong.webapp.dtos.Common.ApiResponse;
import yoonjong.webapp.dtos.Member.LoginDto;
import yoonjong.webapp.dtos.Member.MemberSimpleDto;

@Controller
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("api/member/login")
    public ApiResponse Login(@ModelAttribute LoginDto loginDto, HttpSession session) {
        MemberSimpleDto loginResult = memberService.Login(loginDto);
        if (loginResult == null) {
            return ApiResponse.fail();
        }

        return ApiResponse.success(loginResult);
    }
}
