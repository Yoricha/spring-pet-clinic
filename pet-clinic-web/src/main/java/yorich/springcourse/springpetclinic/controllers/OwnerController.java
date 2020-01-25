package yorich.springcourse.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yorich.springcourse.springpetclinic.services.OwnerService;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getAllOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }


    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }

    @GetMapping("/{id}")
    public ModelAndView showOwner(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(id));
        return modelAndView;
    }
}
