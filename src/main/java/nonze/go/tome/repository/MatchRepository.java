package nonze.go.tome.repository;

import nonze.go.tome.domain.Match;
import nonze.go.tome.domain.Mentee;
import nonze.go.tome.domain.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    // 멘티 기준 매칭 내역 (요청 객체의 mentee를 따라감)
    List<Match> findByRequest_Mentee(Mentee mentee);

    // 멘토 기준 매칭 내역
    List<Match> findByMentor(Mentor mentor);
}
