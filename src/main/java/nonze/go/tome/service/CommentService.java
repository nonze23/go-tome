package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Comment;
import nonze.go.tome.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;

    public void writeComment(Comment comment) {
        commentRepository.save(comment);
    }
    public List<Comment> findByRequest(Long requestId) {
        return commentRepository.findByMentoringRequestId(requestId);
    }
}