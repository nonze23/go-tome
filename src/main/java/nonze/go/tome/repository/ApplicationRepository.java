package nonze.go.tome.repository;

import nonze.go.tome.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByMentorId(Long mentorId);
    List<Application> findByRequestId(Long requestId);
}