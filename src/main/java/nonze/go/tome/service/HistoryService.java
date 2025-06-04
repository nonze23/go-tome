package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.History;
import nonze.go.tome.domain.Match;
import nonze.go.tome.repository.HistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HistoryService {

    private final HistoryRepository historyRepository;

    @Transactional
    public Long recordHistory(Match match, String summary) {
        History history = new History();
        history.setMatch(match);
        history.setSummary(summary);
        history.setCompletedAt(LocalDateTime.now());
        historyRepository.save(history);
        return history.getId();
    }

    public History findOne(Long id) {
        return historyRepository.findById(id).orElse(null);
    }
}