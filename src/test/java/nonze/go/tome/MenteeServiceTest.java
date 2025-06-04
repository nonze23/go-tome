package nonze.go.tome;

import nonze.go.tome.domain.Address;
import nonze.go.tome.domain.Mentee;
import nonze.go.tome.service.MenteeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = GoTomeApplication.class)
@Transactional
public class MenteeServiceTest {

    @Autowired
    MenteeService menteeService;

    @Test
    void 회원가입_성공() {
        // Given
        Mentee mentee = new Mentee();
        mentee.setName("홍길동");
        mentee.setEmail("hong@gotome.com");
        mentee.setPassword("1234");
        mentee.setAddress(new Address("대구", "중구", "12345"));

        // When
        Long savedId = menteeService.register(mentee);

        // Then
        Mentee found = menteeService.findOne(savedId);
        assertEquals("홍길동", found.getName());
    }

    @Test
    void 중복_이메일_예외() {
        // Given
        Mentee mentee1 = new Mentee();
        mentee1.setEmail("dup@gotome.com");
        mentee1.setName("A");

        Mentee mentee2 = new Mentee();
        mentee2.setEmail("dup@gotome.com");
        mentee2.setName("B");

        // When
        menteeService.register(mentee1);
        assertThrows(IllegalStateException.class, () -> menteeService.register(mentee2));
    }
}