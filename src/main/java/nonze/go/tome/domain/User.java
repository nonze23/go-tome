package nonze.go.tome.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@Table(name = "users")
public abstract class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Embedded
    private Address address;
}