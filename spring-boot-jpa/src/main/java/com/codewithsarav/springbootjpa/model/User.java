package com.codewithsarav.springbootjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String userName;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Todo> todos;
}
