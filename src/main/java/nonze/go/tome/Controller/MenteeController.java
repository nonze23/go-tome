package nonze.go.tome.Controller;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Mentee;
import nonze.go.tome.service.MenteeService;
import nonze.go.tome.web.form.MenteeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mentees")
public class MenteeController {

    private final MenteeService menteeService;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("menteeForm", new MenteeForm());
        return "mentees/createMenteeForm";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("menteeForm") MenteeForm form) {
        Mentee mentee = new Mentee();
        mentee.setName(form.getName());
        mentee.setEmail(form.getEmail());
        mentee.setPassword(form.getPassword());
        mentee.setSchool(form.getSchool()); // 🆕
        mentee.setGrade(form.getGrade());   // 🆕
        menteeService.register(mentee);
        return "redirect:/";
    }
}