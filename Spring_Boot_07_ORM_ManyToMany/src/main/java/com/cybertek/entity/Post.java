package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String descript;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "posts_tag_rel",
    joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tags> tags = new HashSet<>();   // if we use list, hibernate makes something twice which is not good for performance


    public Post(String title, String descript) {
        this.title = title;
        this.descript = descript;
    }
}
