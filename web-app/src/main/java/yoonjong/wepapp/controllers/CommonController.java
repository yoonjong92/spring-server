package yoonjong.wepapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello(Model model) {
        model.addAttribute("hello", "하이하이");
        return "/hello";
    }
}
