package org.launchcode.controllers;

import org.launchcode.models.data.BuildingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String displayAddBuildingForm(Model model) {
//        return null;
//    }

}
