package uz.muhammadtrying.tourfirmproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.Client;
import uz.muhammadtrying.tourfirmproject.entity.Comment;
import uz.muhammadtrying.tourfirmproject.repo.CommentRepo;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;

    @Override
    public void save(Client savedClient, String commentContent) {
        Comment comment = Comment.builder()
                .client(savedClient)
                .content(commentContent)
                .build();
        commentRepo.save(comment);
    }
}
