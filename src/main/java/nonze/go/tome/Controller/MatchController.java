package nonze.go.tome.Controller;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.MentoringRequest;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.domain.RequestStatus;
import nonze.go.tome.service.MatchService;
import nonze.go.tome.service.MentoringRequestService;
import nonze.go.tome.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;
    private final MentoringRequestService requestService;
    private final MentorService mentorService;

    @PostMapping("/match")
    public String match(@RequestParam("requestId") Long requestId,
                        @RequestParam("mentorId") Long mentorId) {
        MentoringRequest request = requestService.findOne(requestId);
        Mentor mentor = mentorService.findOne(mentorId);

        matchService.match(request, mentor);

        request.setStatus(RequestStatus.MATCHED);
        requestService.save(request);

        return "redirect:/requests/" + requestId;
    }
}
