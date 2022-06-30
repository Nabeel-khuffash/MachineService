package com.example.MachineService.controllers;

import com.example.MachineService.entities.Machine;
import com.example.MachineService.services.MachineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RequestMapping("/tenant")
@Controller
public class MachineController {

    private MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping("/{userId}/machine/device/{deviceId}")
    String addMachineRequest()
    {
        return ""; //add machine form
    }

    @PostMapping("/{userId}/machine/device/{deviceId}")
    String addMachine(@RequestBody Machine machine, @PathVariable Long userId, @PathVariable Long deviceId)
    {
        Integer response=machineService.addMachine(machine,userId,deviceId);
        if(response==2)
        {

        }
        else if (response ==0){

        }
        else {

        }
        return ""; //redirect to a valid location
    }

    @DeleteMapping("/tenant/{userId}/machine/device/")
    String deleteMachine(@PathVariable Long userId){

        boolean isFound =machineService.deleteMachines(userId);
        if(isFound)
        {

        }
        else {

        }

        return "";
    }

    @PutMapping("/tenant/{userId}/machine/device/{deviceId}")
    String updateMachine(@PathVariable Long userId, @PathVariable Long deviceId, @RequestBody Machine machine)
    {
        Integer response=machineService.updateMachine(machine,userId,deviceId);
        if(response==2)
        {

        }
        else if (response ==0){

        }
        else {

        }
        return ""; //redirect to a valid location
    }


}
