package com.example.WAALab1.Repository;

import com.example.WAALab1.DTO.PostDTO;
import com.example.WAALab1.Domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepo {

    private static List<Post> postList;
    private static int id=1;

    static {
        postList = new ArrayList<>();
        Post post1 = new Post(id++, "Head First Java", "Java", "Kathy Sierra");
        Post post2 = new Post(id++, "Head First JavaScript", "Java", "Kathy Sierra");
        Post post3 = new Post(id++, "Head First PHP", "Java", "Kbert Bates");
        Post post4 = new Post(id++, "Head First SpringBoot", "Java", "Kathy Sierra");

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);

    }
    public void save(Post post){
        post.setId(id++);
        postList.add(post);
    }
    public List<Post> getAllPost(){

        List<Post> postList1 = postList.stream().collect(Collectors.toList());
        return postList1;
    }
    public void remove(long id){
       Post post1 = postList.stream().filter(post -> post.getId()==id).findFirst().orElse(null);
        postList.remove(post1);
    }
    public Post getById(long id){
        Post post1 = postList.stream().filter(post -> post.getId()==id).findFirst().orElse(null);
        return post1;
    }
    public Post update(long id,Post post){
        Post post1 = postList.stream().filter(post2 -> post2.getId()==id).findFirst().orElse(null);
        postList.remove(post1);
        post.setId(id);
        postList.add(post);
        Post post3 = postList.stream().filter(post2 -> post2.getId()==id).findFirst().orElse(null);
        return post3;
    }
    public List<Post> getAuthor(String author){
     List<Post> postList1= postList.stream().filter(post -> post.getAuthor().equals(author)).collect(Collectors.toList());
     return postList1;
    }
    public List<Post> getAuthorY(String  str1){
        List<Post> list =new ArrayList<>();
        for(Post p:postList){
            if(p.getAuthor().startsWith(str1)){
                list.add(p);
            }
        }
        return list;
    }
}

