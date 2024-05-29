package uz.muhammadtrying.tourfirmproject.runnable;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.muhammadtrying.tourfirmproject.entity.Role;
import uz.muhammadtrying.tourfirmproject.entity.RoleName;
import uz.muhammadtrying.tourfirmproject.entity.User;
import uz.muhammadtrying.tourfirmproject.repo.RoleRepo;
import uz.muhammadtrying.tourfirmproject.repo.UserRepo;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Runnable implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Value("${init.data}")
    private Boolean initData;

    @Override
    public void run(String... args) throws Exception {
        if (initData) {
            initializeData();
        }
    }

    private void initializeData() {
        Role role1 = Role.builder()
                .roleName(RoleName.ROLE_ADMIN)
                .build();
        Role role2 = Role.builder()
                .roleName(RoleName.ROLE_USER)
                .build();
        roleRepo.save(role1);
        roleRepo.save(role2);

        User user = User.builder()
                .firstName("Muhammad")
                .lastName("G'ulmov")
                .email("muhammadtrying@gmail.com")
                .password(passwordEncoder.encode("123"))
                .roles(List.of(role1, role2))
                .build();
        userRepo.save(user);
    }
}
