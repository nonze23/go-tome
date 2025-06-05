package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Mentee;
import nonze.go.tome.domain.MentoringRequest;
import nonze.go.tome.repository.MentoringRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentoringRequestService {

    private final MentoringRequestRepository requestRepository;

    @Transactional
    public Long createRequest(MentoringRequest request, Mentee mentee) {
        request.setMentee(mentee);
        request.setCreatedAt(LocalDateTime.now());
        request.setStatus(nonze.go.tome.domain.RequestStatus.REQUESTED);
        requestRepository.save(request);
        return request.getId();
    }

    public List<MentoringRequest> findAll() {
        return requestRepository.findAll();
    }

    public MentoringRequest findOne(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(MentoringRequest request) {
        requestRepository.save(request);
    }
}