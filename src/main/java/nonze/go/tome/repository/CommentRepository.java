package nonze.go.tome.repository;

import nonze.go.tome.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByMentoringRequestId(Long requestId);
}