package nonze.go.tome.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Mentor extends User {

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();
}