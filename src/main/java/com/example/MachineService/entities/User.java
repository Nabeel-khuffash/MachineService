package com.example.MachineService.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    private Long id;

    private String username;

    @OneToMany
    private List<Machine> machines=new ArrayList<>();
}
