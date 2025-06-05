package nonze.go.tome.web.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MentoringRequestForm {
    private String title;
    private String content;
    private String subject; // 예: 진로, 학습법 등
}