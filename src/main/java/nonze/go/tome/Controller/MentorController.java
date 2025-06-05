package nonze.go.tome.Controller;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.service.MentorService;
import nonze.go.tome.web.form.MentorForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mentors")
public class MentorController {

    private final MentorService mentorService;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("mentorForm", new MentorForm());
        return "mentors/createMentorForm";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("mentorForm") MentorForm form) throws IOException {
        Mentor mentor = new Mentor();
        mentor.setName(form.getName());
        mentor.setEmail(form.getEmail());
        mentor.setPassword(form.getPassword());
        mentor.setUniversity(form.getUniversity());
        mentor.setDepartment(form.getDepartment());

        // 파일 업로드
        if (form.getProofFile() != null && !form.getProofFile().isEmpty()) {
            String uploadPath = "/tmp/" + form.getProofFile().getOriginalFilename();
            form.getProofFile().transferTo(new File(uploadPath));
            mentor.setProofFilePath(uploadPath);
        }

        mentorService.register(mentor);
        return "redirect:/";
    }
}