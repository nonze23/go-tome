package nonze.go.tome.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Mentee extends User {

    private String school;
    private String grade;

    @OneToMany(mappedBy = "mentee", cascade = CascadeType.ALL)
    private List<MentoringRequest> requests = new ArrayList<>();
}