package com.codeJ.book.springboot.service.posts;

import com.codeJ.book.springboot.domain.posts.Posts;
import com.codeJ.book.springboot.domain.posts.PostsRepository;
import com.codeJ.book.springboot.web.dto.PostsListResponseDTO;
import com.codeJ.book.springboot.web.dto.PostsResponseDTO;
import com.codeJ.book.springboot.web.dto.PostsSaveRequestDTO;
import com.codeJ.book.springboot.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO){

        return postsRepository.save(requestDTO.dtoToEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDTO requestDTO){

        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id + "다시 확인해보세요."));

        posts.update(requestDTO.getTitle(), requestDTO.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDTO findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> findAllDesc(){

        return postsRepository.findAllDesc().stream()
                .map(posts -> new PostsListResponseDTO(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){

        Optional<Posts> result = postsRepository.findById(id);
        if(result.isPresent()){
            Posts posts = result.get();

            postsRepository.delete(posts);
        }
    }


}
