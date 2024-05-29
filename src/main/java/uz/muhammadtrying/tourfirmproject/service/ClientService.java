package uz.muhammadtrying.tourfirmproject.service;

import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.Client;

@Service
public interface ClientService {
    Client save(String clientName, String clientPhone);
}
