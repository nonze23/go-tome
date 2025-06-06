package nonze.go.tome.repository;

import nonze.go.tome.domain.Mentee;
import nonze.go.tome.domain.MentoringRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentoringRequestRepository extends JpaRepository<MentoringRequest, Long> {
    // 멘티가 쓴 요청 목록 조회
    List<MentoringRequest> findByMentee(Mentee mentee);
}