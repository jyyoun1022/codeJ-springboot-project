package com.codeJ.book.springboot.web;

import com.codeJ.book.springboot.service.posts.PostsService;
import com.codeJ.book.springboot.web.dto.PostsResponseDTO;
import com.codeJ.book.springboot.web.dto.PostsSaveRequestDTO;
import com.codeJ.book.springboot.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDTO requestDTO){

        return postsService.save(requestDTO);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDTO requestDTO
                       ){

        return postsService.update(id,requestDTO);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDTO findById(@PathVariable Long id){

        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){

        postsService.delete(id);

        return id;
    }





}
