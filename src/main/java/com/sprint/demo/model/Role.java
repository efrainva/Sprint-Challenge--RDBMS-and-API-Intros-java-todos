package com.sprint.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;


    @Column(nullable = false,
            unique = true)
    String name;

    @OneToMany(mappedBy = "role",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("roles")
    private List<UserRoles> users = new ArrayList<>();

    public Role(){}

    public Role(String name){
        this.name = name;
    }

    public long getRoleid(){
        return roleid;
    }
    public void setRoleid(long roleid){
     this.roleid = roleid  ;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<UserRoles> getUserRoles(){
        return UserRoles;
    }
    public void setUserRoles(List<UserRoles> userRoles){
        this.userRoles = userRoles;

    }


}