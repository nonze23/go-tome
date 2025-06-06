package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.User;
import nonze.go.tome.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public User login(String email, String password) {
        // 단순 예시, 실제로는 암호화된 비밀번호 비교 추천
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
}