package com.INTECAP.finalProject.Controller;

import com.INTECAP.finalProject.Model.VehicleModel;
import com.INTECAP.finalProject.Repository.ColorRepository;
import com.INTECAP.finalProject.Repository.VehicleRepository;
import com.INTECAP.finalProject.Repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/park-station")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepo;

    @Autowired
    private ColorRepository colorRepo;

    @Autowired
    private VehicleTypeRepository typeRepo;

    private List<VehicleModel> parkedVehicles;

    @GetMapping("/menu")
    public String mainMenu(){
        return "menu";
    }

    @GetMapping("/display")
    public String displayVehicles(Model model) {
        model.addAttribute("vehicles", vehicleRepo.findAll());
        return "showVehicles";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("vehicle", new VehicleModel());
        model.addAttribute("colors", colorRepo.findAll());
        model.addAttribute("types", typeRepo.findAll());
        return "addVehicles";
    }

    @PostMapping("/new-vehicle-form")
    public String addVehicle(@ModelAttribute VehicleModel vehicle) {
        vehicle.setEntranceTime(LocalDateTime.now());
        vehicleRepo.save(vehicle);
        return "redirect:/park-station/display";
    }

    @PostMapping("/mark-exit/{id}")
    public String markExit(@PathVariable("id") Integer id) {
        Optional<VehicleModel> optionalVehicle = vehicleRepo.findById(id);
        if (optionalVehicle.isPresent()) {
            VehicleModel vehicle = optionalVehicle.get();
            if (vehicle.getExitTime() == null) {
                vehicle.setExitTime(LocalDateTime.now());
                vehicleRepo.save(vehicle);
            }
        }
        return "redirect:/park-station/display";
    }
}
