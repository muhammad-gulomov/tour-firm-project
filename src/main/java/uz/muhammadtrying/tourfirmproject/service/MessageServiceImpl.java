package uz.muhammadtrying.tourfirmproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.muhammadtrying.tourfirmproject.entity.Client;
import uz.muhammadtrying.tourfirmproject.entity.Message;
import uz.muhammadtrying.tourfirmproject.entity.TourPackage;
import uz.muhammadtrying.tourfirmproject.repo.ClientRepo;
import uz.muhammadtrying.tourfirmproject.repo.MessageRepo;
import uz.muhammadtrying.tourfirmproject.repo.TourPackageRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepo messageRepo;
    private final TourPackageRepo tourPackageRepo;
    private final TourPackageService tourPackageService;
    private final ClientRepo clientRepo;


    @Override
    public void save(Client savedClient, String comment) {
        Message message = Message.builder()
                .client(savedClient)
                .content(comment)
                .build();
        messageRepo.save(message);
    }

    @Override
    public void alterReadStatus(Integer messageId) {
        Message message = messageRepo.findById(messageId).get();
        message.setRead(true);
        messageRepo.save(message);
    }

    @Override
    public List<Message> findAllOrderedByRead() {
        return messageRepo.findAllByOrderByRead();
    }

    @Override
    @Transactional
    public void deleteReadMessages() {
        messageRepo.deleteAllByRead(true);
    }

    @Override
    public void addInterest(Integer packageId, String name, String phone) {
        Client client = Client.builder()
                .phone(phone)
                .name(name)
                .build();
        clientRepo.save(client);
        TourPackage tourPackage = tourPackageService.findById(packageId);
        String messageContent = tourPackage.getDescription() + " tur paketiga qiziqib qoldim. Iltimos menga telefon qiling!";
        Message message = Message.builder()
                .client(client)
                .content(messageContent)
                .build();
        messageRepo.save(message);
    }

    @Override
    public Integer unreadMessagesCount() {
        return messageRepo.countUnreadMessages();
    }
}
