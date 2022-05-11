package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.springboot.blog.entity.Post;

/*No need to annotate this with @Repository because JpaRepository interface
 * has an implementation called SimpleJpaRepository which is already annotated with
 * @Repository annotation
 */
public interface PostRepository extends JpaRepository<Post, Long>{

}
