package com.temple.authlib.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long no;

}
