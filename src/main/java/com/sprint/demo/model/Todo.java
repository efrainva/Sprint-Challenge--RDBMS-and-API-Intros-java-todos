package com.sprint.demo.model;


import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;


    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }
}
