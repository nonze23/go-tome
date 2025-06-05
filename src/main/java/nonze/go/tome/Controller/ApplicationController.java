package nonze.go.tome.Controller;

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
    public String apply(@RequestParam("requestId") Long requestId) {
        // 로그인 구현 전, mentorId=1로 임시 처리
        Mentor mentor = mentorService.findOne(1L);
        MentoringRequest request = requestService.findOne(requestId);
        applicationService.apply(mentor, request);
        return "redirect:/requests";
    }
}