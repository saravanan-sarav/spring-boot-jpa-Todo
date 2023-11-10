package com.codewithsarav.springbootjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo_table")
public class Todo {
    @Id
    @GeneratedValue
    private int id;

    private String todo;
    @ManyToOne
    @JoinColumn(name = "userId"       , referencedColumnName = "id")
    private User user;
}
