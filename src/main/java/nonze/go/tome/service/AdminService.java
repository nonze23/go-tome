package nonze.go.tome.service;

import lombok.RequiredArgsConstructor;
import nonze.go.tome.domain.Admin;
import nonze.go.tome.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;

    @Transactional
    public Long register(Admin admin) {
        adminRepository.save(admin);
        return admin.getId();
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findOne(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
}