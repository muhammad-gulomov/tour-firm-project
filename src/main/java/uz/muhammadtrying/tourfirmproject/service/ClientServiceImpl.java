package uz.muhammadtrying.tourfirmproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.Client;
import uz.muhammadtrying.tourfirmproject.repo.ClientRepo;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    @Override
    public Client save(String clientName, String clientPhone) {
        Client client = Client.builder()
                .name(clientName)
                .phone(clientPhone)
                .build();
        return clientRepo.save(client);
    }
}
