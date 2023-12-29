package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @OneToMany
    @JoinColumn(name = "client_id")
    private Set<Ticket> tickets;
}


