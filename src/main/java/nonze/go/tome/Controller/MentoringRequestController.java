package nonze.go.tome.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Mentee;
import nonze.go.tome.domain.MentoringRequest;
import nonze.go.tome.domain.Comment;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.domain.Application;
import nonze.go.tome.service.MentoringRequestService;
import nonze.go.tome.service.MenteeService;
import nonze.go.tome.service.CommentService;
import nonze.go.tome.service.MentorService;
import nonze.go.tome.service.ApplicationService;
import nonze.go.tome.web.form.MentoringRequestForm;
import nonze.go.tome.web.form.CommentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/requests")
public class MentoringRequestController {

    private final MentoringRequestService requestService;
    private final MenteeService menteeService;
    private final CommentService commentService;
    private final MentorService mentorService;
    private final ApplicationService applicationService;

    @GetMapping("/new")
    public String createForm(Model model, HttpSession session) {
        Object user = session.getAttribute("loginUser");
        if (!(user instanceof Mentee)) {
            return "redirect:/login";
        }
        model.addAttribute("mentoringRequestForm", new MentoringRequestForm());
        return "requests/createRequestForm";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("mentoringRequestForm") MentoringRequestForm form, HttpSession session) {
        Object user = session.getAttribute("loginUser");
        if (!(user instanceof Mentee)) {
            return "redirect:/login";
        }
        Mentee mentee = (Mentee) user;
        MentoringRequest request = new MentoringRequest();
        request.setTitle(form.getTitle());
        request.setContent(form.getContent());
        request.setSubject(form.getSubject());
        requestService.createRequest(request, mentee);
        return "redirect:/";
    }

    @GetMapping
    public String list(Model model) {
        List<MentoringRequest> requests = requestService.findAll();
        model.addAttribute("requests", requests);
        return "requests/requestList";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        MentoringRequest request = requestService.findOne(id);
        List<Comment> comments = commentService.findByRequest(id);
        List<Application> applications = applicationService.findByRequest(id);

        model.addAttribute("request", request);
        model.addAttribute("comments", comments);
        model.addAttribute("applications", applications);
        model.addAttribute("commentForm", new CommentForm());
        return "requests/requestDetail";
    }

    @PostMapping("/{id}/comments")
    public String addComment(@PathVariable("id") Long id,
                             @ModelAttribute("commentForm") CommentForm form,
                             HttpSession session) {
        Object user = session.getAttribute("loginUser");
        if (!(user instanceof Mentor)) {
            return "redirect:/login";
        }
        Mentor writer = (Mentor) user;
        MentoringRequest request = requestService.findOne(id);

        Comment comment = new Comment();
        comment.setMentoringRequest(request);
        comment.setWriter(writer);
        comment.setContent(form.getContent());
        comment.setCreatedAt(java.time.LocalDateTime.now());

        commentService.writeComment(comment);
        return "redirect:/requests/" + id;
    }
}