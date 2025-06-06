package nonze.go.tome.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.User;
import nonze.go.tome.service.UserService;
import nonze.go.tome.web.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form, HttpSession session, Model model) {
        User user = userService.login(form.getEmail(), form.getPassword());
        if (user == null) {
            model.addAttribute("loginError", "이메일 또는 비밀번호가 일치하지 않습니다.");
            return "login";
        }
        session.setAttribute("loginUser", user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}