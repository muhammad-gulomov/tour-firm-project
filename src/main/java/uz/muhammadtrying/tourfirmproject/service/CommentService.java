package uz.muhammadtrying.tourfirmproject.service;

import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.Client;

@Service
public interface CommentService {

    void save(Client savedClient, String comment);
}
