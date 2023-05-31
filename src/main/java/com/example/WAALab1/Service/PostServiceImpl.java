package com.example.WAALab1.Service;

import com.example.WAALab1.DTO.PostDTO;
import com.example.WAALab1.Domain.Post;
import com.example.WAALab1.Repository.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private ModelMapper modelMapper;

    private final PostRepo postRepo;


    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }


    @Override
    public void save(PostDTO postDTO) {
        Post post =modelMapper.map(postDTO, Post.class);
        postRepo.save(post);
    }

    @Override
    public List<PostDTO>   getAllPosts() {

     List<Post> postList =postRepo.getAllPost();

     List<PostDTO> postDTOList =new ArrayList<>();
      for(Post post:postList){
          PostDTO postDTO =modelMapper.map(post, PostDTO.class);
          postDTOList.add(postDTO);
      }

        return  postDTOList;
    }
    public void remove(long id){
        postRepo.remove(id);
    }
    public PostDTO getById(long id){
        Post post =postRepo.getById(id);
        return modelMapper.map(post, PostDTO.class);

    }

    @Override
    public PostDTO update(long id, PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        Post post1 =postRepo.update(id,post);
        return modelMapper.map(post1, PostDTO.class);
    }

    @Override
    public List<PostDTO> getAuthor(String author) {
        List<Post> postList =  postRepo.getAuthor(author);
        System.out.println(postList);
        return postList.stream().map(x->modelMapper.map(x, PostDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getAuthorY(String str1) {
        List<Post> postList =  postRepo.getAuthorY(str1);
        return postList.stream().map(x->modelMapper.map(x, PostDTO.class)).collect(Collectors.toList());
    }
}
