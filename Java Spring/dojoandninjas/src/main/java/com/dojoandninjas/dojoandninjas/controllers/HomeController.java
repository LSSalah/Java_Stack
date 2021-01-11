package com.dojoandninjas.dojoandninjas.controllers;

import com.dojoandninjas.dojoandninjas.models.Dojo;
import com.dojoandninjas.dojoandninjas.models.Ninja;
import com.dojoandninjas.dojoandninjas.services.DojoNinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    private final DojoNinjaService dojoNinjaService;

    public HomeController(DojoNinjaService dojoNinjaService) {
        this.dojoNinjaService = dojoNinjaService;
    }

    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("dojos",dojoNinjaService.allDojo());
        return "root.jsp";
    }

    @RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "dojo.jsp";
    }

    @RequestMapping(value = "/dojo", method = RequestMethod.POST)
    public String createdojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "dojo.jsp";
        } else {
            Dojo dojo1=dojoNinjaService.createDojo(dojo);
            return "redirect:/";
        }
    }

    @RequestMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos",dojoNinjaService.allDojo());
        return "ninja.jsp";
    }
    @RequestMapping(value = "/ninja",method = RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, @RequestParam("dojo")Long id,Model model) {
        Dojo dojo1 = dojoNinjaService.findDojo(id);
        if (result.hasErrors()) {
            model.addAttribute("dojos",dojoNinjaService.allDojo());
            return "ninja.jsp";
        } else {
            Ninja ninja1=dojoNinjaService.createNinja(ninja);
            Ninja ninjaWithDojo = dojoNinjaService.createNinjaForDojo(ninja1,dojo1);
            return "redirect:/";
        }
    }

    @RequestMapping("/dojos/{id}")
    public String show(@PathVariable("id")Long id, Model model){
        model.addAttribute("dojo",dojoNinjaService.findDojo(id));
        return "show.jsp";
    }

}
