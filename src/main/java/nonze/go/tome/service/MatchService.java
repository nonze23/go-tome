package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Match;
import nonze.go.tome.domain.Mentee;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.domain.MentoringRequest;
import nonze.go.tome.repository.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MatchService {

    private final MatchRepository matchRepository;

    @Transactional
    public void match(MentoringRequest request, Mentor mentor) {
        Match match = new Match();
        match.setRequest(request);
        match.setMentor(mentor);
        match.setMatchedAt(LocalDateTime.now());
        matchRepository.save(match);
    }

    public Match findOne(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    //멘티 기준 매칭 내역
    public List<Match> findByMentee(Mentee mentee) {
        return matchRepository.findByRequest_Mentee(mentee);
    }

    // 멘토 기준 매칭 내역
    public List<Match> findByMentor(Mentor mentor) {
        return matchRepository.findByMentor(mentor);
    }
}