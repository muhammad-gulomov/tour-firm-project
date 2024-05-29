package uz.muhammadtrying.tourfirmproject.service;

import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.Client;
import uz.muhammadtrying.tourfirmproject.entity.Message;

import java.util.List;

@Service
public interface MessageService {

    void save(Client savedClient, String comment);

    void alterReadStatus(Integer messageId);

    List<Message> findAllOrderedByRead();

    void deleteReadMessages();

    void addInterest(Integer packageId, String name, String phone);
}
