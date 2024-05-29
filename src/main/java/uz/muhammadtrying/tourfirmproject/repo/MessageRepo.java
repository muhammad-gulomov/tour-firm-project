package uz.muhammadtrying.tourfirmproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.muhammadtrying.tourfirmproject.entity.Message;

import java.util.List;

@Repository
@Transactional
public interface MessageRepo extends JpaRepository<Message, Integer> {
    List<Message> findAllByOrderByRead();

    void deleteAllByRead(boolean read);
}
