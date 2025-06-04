package nonze.go.tome.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class MentoringRequest {

    @Id @GeneratedValue
    @Column(name = "request_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentee_id")
    private Mentee mentee;

    private String title;

    private String content;

    private String subject; // ex: 진로, 공부법 등

    @Enumerated(EnumType.STRING)
    private RequestStatus status; // REQUESTED, MATCHED, COMPLETED

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();
}