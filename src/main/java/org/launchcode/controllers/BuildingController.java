package org.launchcode.controllers;

import org.launchcode.models.data.BuildingDao;
import org.launchcode.models.forms.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
    public String processAddBuildingForm(@ModelAttribute @Valid Building building, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Building");
            return "building/add";
        }

        buildingDao.save(building);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveBuildingForm(Model model) {
        model.addAttribute("title", "Remove Building");
        model.addAttribute("buildings", buildingDao.findAll());
        return "building/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveBuildingForm(@RequestParam int[] buildingIds) {

        for (int buildingId : buildingIds) {
            buildingDao.delete(buildingId);
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{buildingId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int buildingId) {
        Building findBuilding = buildingDao.findOne(buildingId);
        model.addAttribute("title", "Edit Building");
        model.addAttribute("building", findBuilding);
        return "building/edit";
    }

    @RequestMapping(value = "edit/{buildingId}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Building building, Errors errors, Model model, @PathVariable("buildingId") int buildingId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Building");
            model.addAttribute("building", building);
            return "building/edit";
        }

        Building myBuilding = buildingDao.findOne(buildingId);
        myBuilding.setId(building.getId());
        myBuilding.setAddress(building.getAddress());
        myBuilding.setUnits(building.getUnits());
        myBuilding.setCity(building.getCity());
        myBuilding.setState(building.getState());
        myBuilding.setZipCode(building.getZipCode());

        buildingDao.save(myBuilding);
        model.addAttribute("title", "Edit Building");
        model.addAttribute("successMessage", "Building has been modified!");
        return "building/edit";
    }

//    @RequestMapping(value = "edit/{buildingId}", method = RequestMethod.POST)
//    public String processEditForm(@ModelAttribute @Valid Building building, Errors errors, Model model, @PathVariable int buildingId, @RequestParam("address") String address, @RequestParam("units") Integer units, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("zipCode") Integer zipCode) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Edit Building");
//            model.addAttribute("building", building);
//            return "building/edit";
//        }
//
//        building.setAddress(address);
//        building.setUnits(units);
//        building.setCity(city);
//        building.setState(state);
//        building.setZipCode(zipCode);
//        building.setId(buildingId);
//        buildingDao.save(building);
//        model.addAttribute("title", "Edit Building");
//        model.addAttribute("successMessage", "Building has been modified!");
//        return "building/edit";
//    }
}
