package com.BlogSpringboot.Springboot.Service;
import org.springframework.stereotype.Service;

import com.BlogSpringboot.Springboot.Entity.Blog;
import com.BlogSpringboot.Springboot.Repository.BlogRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class BlogService {

	    private final BlogRepo repo;

	    public BlogService(BlogRepo repo) {
	        this.repo = repo;
	    }

	    public List<Blog> getAllPosts() {
	        return repo.findAll();
	    }

	    public Optional<Blog> getPostById(Long id) {
	        return repo.findById(id);
	    }

	    public Blog createPost(Blog post) {
	        post.setDate(LocalDateTime.now());
	        return repo.save(post);
	    }

	    public Blog updatePost(Long id, Blog post) {
	        post.setId(id);
	        post.setDate(LocalDateTime.now());
	        return repo.save(post);
	    }

	    public void deletePost(Long id) {
	        repo.deleteById(id);
	    }
	}


