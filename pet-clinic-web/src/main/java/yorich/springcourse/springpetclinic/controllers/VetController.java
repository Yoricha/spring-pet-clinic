package yorich.springcourse.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yorich.springcourse.springpetclinic.services.VetService;

@Controller
public class VetController {

    private VetService vetService;

    public VetController(VetService petService) {
        this.vetService = petService;
    }

    @RequestMapping({"vets","/vets/index","/vets/index.html","/vets.html"})
    public String listOfVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
