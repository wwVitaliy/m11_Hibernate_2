package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Planet")
public class Planet {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 500)
    private String name;
}
