package ru.smallgroup.homelibrary.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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


}
