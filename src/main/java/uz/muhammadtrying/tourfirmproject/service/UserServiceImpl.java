package uz.muhammadtrying.tourfirmproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.Role;
import uz.muhammadtrying.tourfirmproject.entity.RoleName;
import uz.muhammadtrying.tourfirmproject.entity.User;
import uz.muhammadtrying.tourfirmproject.repo.RoleRepo;
import uz.muhammadtrying.tourfirmproject.repo.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteById(Integer userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public void saveUser(String firstName, String lastName, String email, String password) {
        Role userRole = roleRepo.findByRoleNameEquals(RoleName.ROLE_USER);
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .roles(List.of(userRole))
                .build();
        userRepo.save(user);
    }
}
