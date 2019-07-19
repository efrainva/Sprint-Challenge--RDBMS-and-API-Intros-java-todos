package com.sprint.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userroles")
public class UserRoles extends Auditable implements Serializable {
    @Id @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"userROles",hibernate})
}
