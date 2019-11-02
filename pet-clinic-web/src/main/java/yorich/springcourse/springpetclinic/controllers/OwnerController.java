package yorich.springcourse.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yorich.springcourse.springpetclinic.services.OwnerService;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getAllOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }


    @RequestMapping("/find")
    public String findOwners(){
        return "notimplemented";
    }
}
