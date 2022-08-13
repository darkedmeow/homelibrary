package ru.smallgroup.homelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BOOKS")
public class Book {

    public enum Status {
        IN_PROCESS, COMPLETED
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(max = 30, message = "Author")
    private String author;

    @NotEmpty
    @Size(max = 30, message = "Title")
    private String title;

    @NotNull
    @Size(max = 200, message = "Author")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JsonIgnore
    private Collection collection;

    @ManyToOne
    @JsonIgnore
    private Store store;

}
