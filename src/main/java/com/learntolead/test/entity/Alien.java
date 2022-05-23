package com.learntolead.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALIEN_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Alien {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String gender;

}
