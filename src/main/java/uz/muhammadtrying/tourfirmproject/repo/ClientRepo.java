package uz.muhammadtrying.tourfirmproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.muhammadtrying.tourfirmproject.entity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
}
