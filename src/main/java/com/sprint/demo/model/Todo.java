package com.sprint.demo.model;


import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false,
            unique =true)
    private String username;

}
