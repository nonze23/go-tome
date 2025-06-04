package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Mentee;
import nonze.go.tome.repository.MenteeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenteeService {

    private final MenteeRepository menteeRepository;

    // 회원가입
    @Transactional
    public Long register(Mentee mentee) {
        validateDuplicateEmail(mentee.getEmail());
        menteeRepository.save(mentee);
        return mentee.getId();
    }

    private void validateDuplicateEmail(String email) {
        menteeRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }

    // 전체 멘티 조회
    public List<Mentee> findAll() {
        return menteeRepository.findAll();
    }

    // ID로 멘티 조회
    public Mentee findOne(Long id) {
        return menteeRepository.findById(id).orElse(null);
    }
}