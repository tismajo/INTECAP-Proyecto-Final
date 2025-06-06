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
        try {
            List<VehicleModel> activeVehicles = vehicleRepo.findByExitTimeIsNull();
            model.addAttribute("vehicles", activeVehicles);
        } catch(Exception e) {
            System.err.println("Error al intentar mostrar los vehículos: " + e.getMessage());
            model.addAttribute("error", "no se pudieron cargar los vehículos");
        }
        return "showVehicles";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        try {
            model.addAttribute("vehicle", new VehicleModel());
            model.addAttribute("colors", colorRepo.findAll());
            model.addAttribute("types", typeRepo.findAll());
        } catch (Exception e) {
            System.err.println("Error loading form data: " + e.getMessage());
            model.addAttribute("error", "Could not load form data.");
        }
        return "addVehicles";
    }

    @PostMapping("/new-vehicle-form")
    public String addVehicle(@ModelAttribute VehicleModel vehicle, Model model) {
        try {
            LocalDateTime now = LocalDateTime.now();
            int hour = now.getHour();

            if (hour < 7 || hour >= 21) {
                model.addAttribute("error", "No se permite el ingreso de vehículos fuera del horario de 7:00 a.m. a 9:00 p.m.");
                model.addAttribute("vehicle", vehicle);
                model.addAttribute("colors", colorRepo.findAll());
                model.addAttribute("types", typeRepo.findAll());
                return "addVehicles";
            }

            vehicle.setEntranceTime(LocalDateTime.now());
            vehicleRepo.save(vehicle);
        } catch (Exception e) {
            System.err.println("Error saving new vehicle: " + e.getMessage());
            return "redirect:/park-station/add?error=true";
        }
        return "redirect:/park-station/display";
    }

    @PostMapping("/mark-exit/{id}")
    public String markExit(@PathVariable("id") Integer id) {
        try {
            Optional<VehicleModel> optionalVehicle = vehicleRepo.findById(id);
            if (optionalVehicle.isPresent()) {
                VehicleModel vehicle = optionalVehicle.get();
                if (vehicle.getExitTime() == null) {
                    vehicle.setExitTime(LocalDateTime.now());
                    vehicleRepo.save(vehicle);
                }
            }
        } catch (Exception e) {
            System.err.println("Error marking vehicle exit: " + e.getMessage());
        }
        return "redirect:/park-station/display";
    }
}
