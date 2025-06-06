package nonze.go.tome.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.domain.Mentee;
import nonze.go.tome.domain.MentoringRequest;
import nonze.go.tome.domain.Application;
import nonze.go.tome.domain.Match;
import nonze.go.tome.service.MentoringRequestService;
import nonze.go.tome.service.ApplicationService;
import nonze.go.tome.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    private final MentoringRequestService requestService;
    private final ApplicationService applicationService;
    private final MatchService matchService;

    @GetMapping
    public String myPage(HttpSession session, Model model) {
        Object user = session.getAttribute("loginUser");

        if (user == null) {
            // 미로그인 시 로그인 페이지로
            return "redirect:/login";
        }

        // 멘티일 경우
        if (user instanceof Mentee mentee) {
            model.addAttribute("mentee", mentee);

            // [1] 내가 쓴 요청 목록
            List<MentoringRequest> myRequests = requestService.findByMentee(mentee);
            model.addAttribute("myRequests", myRequests);

            // [2] 내가 매칭된 멘토 내역
            List<Match> myMatches = matchService.findByMentee(mentee);
            model.addAttribute("myMatches", myMatches);

            return "mypage/menteeMypage";
        }

        // 멘토일 경우
        if (user instanceof Mentor mentor) {
            model.addAttribute("mentor", mentor);

            // [1] 내가 신청한 멘토링 요청 (지원 내역)
            List<Application> myApplications = applicationService.findByMentor(mentor);
            model.addAttribute("myApplications", myApplications);

            // [2] 내가 매칭된 내역
            List<Match> myMatches = matchService.findByMentor(mentor);
            model.addAttribute("myMatches", myMatches);

            return "mypage/mentorMypage";
        }

        // 혹시 모를 예외 (관리자 등)
        return "redirect:/";
    }
}