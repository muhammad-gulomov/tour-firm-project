package uz.muhammadtrying.tourfirmproject.service;

import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.User;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

    void deleteById(Integer userId);

    void saveUser(String firstName, String lastName, String email, String password);
}
