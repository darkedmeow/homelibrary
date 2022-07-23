package ru.smallgroup.homelibrary.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "COLLECTIONS")
public class Collection {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 40)
    private String name;

    @ManyToOne
    @NotNull
    private User owner;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

}
