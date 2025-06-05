package nonze.go.tome.web.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class MentorForm {
    private String name;
    private String email;
    private String password;
    private String university;         // 대학교명
    private String department;         // 전공/학과
    private MultipartFile proofFile;   // 재학증명서 파일 업로드
}