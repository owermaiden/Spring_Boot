package com.cybertek.bootstrap;

import com.cybertek.entity.Post;
import com.cybertek.entity.Tags;
import com.cybertek.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner{


    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        Post post1 = new Post("ORM", "ManyToMany");
        Post post2 = new Post("MVC", "Controller");

        Tags tag1 = new Tags("Spring");
        Tags tag2 = new Tags("Jpa");

        // var p1 = post1.getTags();   // burada Set in  içerisine data yüklüyoruz....

        post1.getTags().add(tag1);
        post1.getTags().add(tag2);

        tag1.getPosts().add(post1);
        tag2.getPosts().add(post1);

        tag1.getPosts().add(post2);
        post2.getTags().add(tag1);

        postRepository.save(post1);
        postRepository.save(post2);





    }
}
