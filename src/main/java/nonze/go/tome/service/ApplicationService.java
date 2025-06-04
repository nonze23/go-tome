package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Application;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.domain.MentoringRequest;
import nonze.go.tome.repository.ApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Transactional
    public Long apply(Mentor mentor, MentoringRequest request) {
        Application application = new Application();
        application.setMentor(mentor);
        application.setRequest(request);
        application.setAppliedAt(LocalDateTime.now());
        applicationRepository.save(application);
        return application.getId();
    }

    public List<Application> findByRequest(Long requestId) {
        return applicationRepository.findByRequestId(requestId);
    }

    public List<Application> findByMentor(Long mentorId) {
        return applicationRepository.findByMentorId(mentorId);
    }
}