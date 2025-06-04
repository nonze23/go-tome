package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Match;
import nonze.go.tome.domain.Mentor;
import nonze.go.tome.domain.MentoringRequest;
import nonze.go.tome.repository.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MatchService {

    private final MatchRepository matchRepository;

    @Transactional
    public Long match(MentoringRequest request, Mentor mentor) {
        Match match = new Match();
        match.setRequest(request);
        match.setMentor(mentor);
        match.setMatchedAt(LocalDateTime.now());

        matchRepository.save(match);
        return match.getId();
    }

    public Match findOne(Long id) {
        return matchRepository.findById(id).orElse(null);
    }
}