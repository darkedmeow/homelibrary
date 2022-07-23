package ru.smallgroup.homelibrary.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "STORES")
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 40)
    private String name;

    @ManyToOne
    private Room room;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();


}
