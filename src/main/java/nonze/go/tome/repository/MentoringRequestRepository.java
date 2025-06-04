package nonze.go.tome.repository;

import nonze.go.tome.domain.MentoringRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentoringRequestRepository extends JpaRepository<MentoringRequest, Long> {
}