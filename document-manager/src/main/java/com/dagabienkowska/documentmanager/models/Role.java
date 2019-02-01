package com.dagabienkowska.documentmanager.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
