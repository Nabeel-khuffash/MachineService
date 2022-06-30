package com.example.MachineService.services;

import com.example.MachineService.entities.Machine;
import com.example.MachineService.entities.User;
import com.example.MachineService.repositories.MachineRepository;
import com.example.MachineService.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class MachineService {

    private MachineRepository machineRepository;
    private UserRepository userRepository;

    public MachineService(MachineRepository machineRepository, UserRepository userRepository) {
        this.machineRepository = machineRepository;
        this.userRepository = userRepository;
    }

    public Integer addMachine(Machine machine, Long userId, Long deviceId)
    {
        if(deviceId!= machine.getId())       //if the id given by url isn't the same as one given by form it will return 2 as response
            return 2;
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())                 //if everything is correct it will return 1 as response, and it will save the machine
        {
            user.get().getMachines().add(machine);
            machine.setId(deviceId);
            machine.setUser(user.get());
            machineRepository.save(machine);
            return 1;
        }                                    //if the user not found in the database it will return 0 as a response
        else return 0;
    }

    public boolean deleteMachines(Long userId)
    {
        Optional<User> user= userRepository.findById(userId);
        if(user.isPresent())
        {
            machineRepository.deleteAllByUserId(userId);
            return true;
        }
        return false;
    }

    public Integer updateMachine(Machine machine, Long userId, Long deviceId)
    {
        return addMachine(machine, userId, deviceId);
    }
}
