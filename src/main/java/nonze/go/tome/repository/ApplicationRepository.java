package nonze.go.tome.repository;

import nonze.go.tome.domain.Application;
import nonze.go.tome.domain.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // 멘토가 지원한 내역
    List<Application> findByMentor(Mentor mentor);

    // 요청 기준 지원 내역
    List<Application> findByRequestId(Long requestId);
}
