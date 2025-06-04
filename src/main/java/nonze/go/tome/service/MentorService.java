package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.repository.MentorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentorService {

    private final MentorRepository mentorRepository;

    @Transactional
    public Long register(Mentor mentor) {
        validateDuplicateEmail(mentor.getEmail());
        mentorRepository.save(mentor);
        return mentor.getId();
    }

    private void validateDuplicateEmail(String email) {
        mentorRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }

    public List<Mentor> findAll() {
        return mentorRepository.findAll();
    }

    public Mentor findOne(Long id) {
        return mentorRepository.findById(id).orElse(null);
    }
}