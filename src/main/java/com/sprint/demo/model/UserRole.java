package com.sprint.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="userrole")
public class UserRole  extends Auditable implements Serializable {
    @Id @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"userRoles","hibernateLazyImitializer"})
    @JoinColumn(name = "userid")
    private User user;

//    @Id @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnoreProperties({"roleid","hibernateLazyImitializer"})
//    @JoinColumn(name = "roleid")
//    private Role role;
//
    public UserRole(){}

    public UserRole(User user){
        this.user = user;
//        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
