package yorich.springcourse.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import yorich.springcourse.springpetclinic.models.Owner;
import yorich.springcourse.springpetclinic.services.OwnerService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    private static final String FIND_OWNERS_VIEW = "owners/findOwners";
    private static final String OWNERS_DETAILS_VIEW = "owners/ownerDetails";
    private static final String OWNERS_UPDATE_CRATE_VIEW = "owners/createOrUpdateOwnerForm";
    private static final String OWNERS_LIST = "owners/ownersList";

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());

        return FIND_OWNERS_VIEW;
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult bindingResult, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }
        //find owners by last name
        List<Owner> results = this.ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        if (results.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return FIND_OWNERS_VIEW;
        } else if (results.size() == 1) {
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return OWNERS_LIST;
        }
    }

    @GetMapping("/{id}")
    public ModelAndView showOwner(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(OWNERS_DETAILS_VIEW);
        modelAndView.addObject(ownerService.findById(id));
        return modelAndView;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);
        return OWNERS_UPDATE_CRATE_VIEW;
    }


    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return OWNERS_UPDATE_CRATE_VIEW;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{id}/edit")
    public String initUpdateOwnerForm(@PathVariable("id") Long id, Model model) {
        Owner owner = ownerService.findById(id);
        model.addAttribute("owner", owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{id}/edit")
    public String processUpdateForm(@Valid Owner owner, BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return OWNERS_UPDATE_CRATE_VIEW;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }
}
