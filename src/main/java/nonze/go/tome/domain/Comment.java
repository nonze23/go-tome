package nonze.go.tome.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Comment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id")
    private MentoringRequest mentoringRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private User writer; // 멘토/멘티 모두 댓글 작성자 가능

    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();
}