package com.INTECAP.finalProject.Controller;

import com.INTECAP.finalProject.Model.VehicleModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/park-station")
public class VehicleController {
    private List<VehicleModel> parkedVehicles;

    @GetMapping("/menu")
    public String mainMenu(){
        return "menu";
    }

    @GetMapping("/display")
    public String displayVehicles(Model model) {
        model.addAttribute("vehicle", parkedVehicles);
        return "showVehicles";
    }

    @PostMapping("/new-vehicle-form")
    public String addVehicle(@ModelAttribute VehicleModel vehicle) {

        return "addVehicles";
    }
}
