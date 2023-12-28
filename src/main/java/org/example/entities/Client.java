package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name", length =  200)
    private String name;

}
