package nonze.go.tome.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Admin extends User {
    // 현재는 추가 필드 없음. 필요 시 관리자 전용 기능/속성 여기에 추가
}