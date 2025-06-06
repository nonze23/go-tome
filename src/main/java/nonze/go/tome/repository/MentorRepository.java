package nonze.go.tome.repository;

import nonze.go.tome.domain.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Optional<Mentor> findByEmail(String email);
}