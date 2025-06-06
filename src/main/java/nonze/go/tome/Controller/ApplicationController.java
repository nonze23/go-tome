package nonze.go.tome.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.domain.MentoringRequest;
import nonze.go.tome.service.ApplicationService;
import nonze.go.tome.service.MentorService;
import nonze.go.tome.service.MentoringRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final MentorService mentorService;
    private final MentoringRequestService requestService;

    @PostMapping("/apply")
    public String apply(@RequestParam("requestId") Long requestId, HttpSession session) {
        Object user = session.getAttribute("loginUser");
        if (!(user instanceof Mentor)) {
            return "redirect:/login";
        }
        Mentor mentor = (Mentor) user;
        MentoringRequest request = requestService.findOne(requestId);
        applicationService.apply(mentor, request);
        return "redirect:/requests";
    }
}