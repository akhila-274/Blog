package com.BlogSpringboot.Springboot.Controller;
import com.BlogSpringboot.Springboot.Entity.Blog;
import com.BlogSpringboot.Springboot.Repository.BlogRepo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/blogs")
public class BlogController {
		private final BlogRepo repo;

	    public BlogController(BlogRepo repo) {
	        this.repo = repo;
	    }

	    @GetMapping
	    public List<Blog> getAllPosts() {
	        return repo.findAll();
	    }

	    @GetMapping("/{id}")
	    public Blog getById(@PathVariable Long id) {
	        return repo.findById(id).orElse(null);
	    }

	    @PostMapping
	    public Blog create(@RequestBody Blog post) {
	        post.setDate(LocalDateTime.now());
	        return repo.save(post);
	    }

	    @PutMapping("/{id}")
	    public Blog update(@PathVariable Long id, @RequestBody Blog post) {
	        post.setId(id);
	        post.setDate(LocalDateTime.now());
	        return repo.save(post);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        repo.deleteById(id);
	    }
	
}
