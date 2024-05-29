package uz.muhammadtrying.tourfirmproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.muhammadtrying.tourfirmproject.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
