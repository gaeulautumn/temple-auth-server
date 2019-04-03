package com.temple.authserver.users;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "test_user")
@Deprecated
public class TestUser {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

}
