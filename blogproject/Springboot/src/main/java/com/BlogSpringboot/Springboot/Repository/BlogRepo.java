package com.BlogSpringboot.Springboot.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogSpringboot.Springboot.Entity.Blog;
public interface BlogRepo  extends JpaRepository<Blog, Long>{

	
}
