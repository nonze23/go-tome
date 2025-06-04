package nonze.go.tome.repository;

import nonze.go.tome.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByMatchId(Long matchId); // 매칭별 메시지 조회
}