package com.example.MachineService.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
public class Machine {

    @Id
    private Long id;

    private String name;

    private String ipAddress;

    private String location;

    @ManyToOne
    private User user;
}
