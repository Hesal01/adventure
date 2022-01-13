package com.pulsars.adventure.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

}
