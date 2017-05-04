package org.launchcode.controllers;

import org.launchcode.models.data.BuildingDao;
import org.launchcode.models.forms.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by henry on 5/3/17.
 */
@Controller
@RequestMapping("building")
public class BuildingController {

    @Autowired
    private BuildingDao buildingDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Buildings");
        model.addAttribute("buildings", buildingDao.findAll());
        return "building/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddBuildingForm(Model model) {
        model.addAttribute("title", "Add Building");
        model.addAttribute(new Building());
        return "building/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddBuildingForm(@ModelAttribute @Valid Building newBuilding, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Building");
            return "building/add";
        }

        buildingDao.save(newBuilding);
        return "redirect:";
    }
}
