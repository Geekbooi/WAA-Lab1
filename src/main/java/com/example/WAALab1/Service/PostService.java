package com.example.WAALab1.Service;

import com.example.WAALab1.DTO.PostDTO;
import com.example.WAALab1.Domain.Post;

import java.util.List;
public interface PostService {
    public void save(PostDTO postDTO);

    public List<PostDTO> getAllPosts();

    public void remove(long id);

    public PostDTO getById(long id);

    public PostDTO update(long id, PostDTO postDTO);

    public List<PostDTO> getAuthor(String author);
    public List<PostDTO> getAuthorY(String str1);

}
