package com.example.WAALab1.Controller;

import com.example.WAALab1.DTO.PostDTO;
import com.example.WAALab1.Domain.Post;
import com.example.WAALab1.Service.PostService;
import com.example.WAALab1.Service.PostServiceImpl;
import jakarta.websocket.server.PathParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final ModelMapper modelMapper;

    @Autowired
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @PostMapping

    public void save(@RequestBody PostDTO postDTO) {
        postService.save(postDTO);
    }

    @GetMapping
    public ResponseEntity< List<PostDTO>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);

    }
    @DeleteMapping ("/{id1}")
    public void  deletePost(@PathVariable(value = "id1") long id) {
         postService.remove(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity< PostDTO> getById(@PathVariable long id) {
        return new ResponseEntity<>(postService.getById(id), HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public PostDTO update(@PathVariable long id, @RequestBody PostDTO postDTO){
        return  postService.update(id,postDTO);

    }
  @GetMapping(value = {
          "/endpoint",
          "/endpoint/author"

  })

  public ResponseEntity<?> getAuthorPost(@PathParam(value = "author") String author){
        if(author==null)
            return new ResponseEntity<>("please give author", HttpStatusCode.valueOf(200));
        List<PostDTO> list =postService.getAuthor(author);
      System.out.println(list);
        return new ResponseEntity<>(  postService.getAuthorY(author),HttpStatus.OK);

  }
}

