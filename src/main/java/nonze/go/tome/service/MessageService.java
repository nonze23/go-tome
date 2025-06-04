package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Match;
import nonze.go.tome.domain.Message;
import nonze.go.tome.domain.MessageType;
import nonze.go.tome.domain.User;
import nonze.go.tome.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public Long sendMessage(Match match, User sender, String content, MessageType type) {
        Message message = new Message();
        message.setMatch(match);
        message.setSender(sender);
        message.setContent(content);
        message.setMessageType(type);
        message.setCreatedAt(LocalDateTime.now());
        messageRepository.save(message);
        return message.getId();
    }

    public List<Message> findByMatch(Long matchId) {
        return messageRepository.findByMatchId(matchId);
    }
}