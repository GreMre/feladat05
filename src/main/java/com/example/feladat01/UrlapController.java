package com.example.feladat01;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;


@Controller
public class UrlapController {
    private final  ÜzenetRepository üzenetRepository;
    @Autowired
    public  UrlapController( ÜzenetRepository üzenetRepository){
        this.üzenetRepository = üzenetRepository;
    }
    @GetMapping("/feladat")
    public String urlapForm(Model model) {
        model.addAttribute("uzenetOsztaly", new UzenetOsztaly());
        return "urlap";
    }
    @PostMapping("/feladat2")
    public String urlapSubmit(@Valid @ModelAttribute UzenetOsztaly uzenetOsztaly, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "urlap";
        }

        try {
            LocalDateTime now = LocalDateTime.now();
            uzenetOsztaly.setElkuldve(now);
            üzenetRepository.save(uzenetOsztaly);
            model.addAttribute("attr2", uzenetOsztaly);
            return "eredmeny";
        } catch (Exception e) {
            // Kezeljük az adatbázis mentés során fellépő hibákat
            return "urlap"; // Vagy visszatérhetsz az urlap oldalra hibaüzenettel
        }
    }
}
