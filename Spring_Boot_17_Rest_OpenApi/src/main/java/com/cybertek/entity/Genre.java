package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernate_Lazy_Initializer"}, ignoreUnknown = true) // because fetch type lazy
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genreList")  // genreList name comes from Movie Class..List<Genre> genreList...
    @JsonIgnore  // because this one is mapped by... There is no need @JsonManagedReference
    private List<Movie> movieList = new ArrayList<>();


    public Genre(String name) {
        this.name = name;
    }
}
