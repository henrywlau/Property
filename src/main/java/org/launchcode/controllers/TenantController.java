package org.launchcode.controllers;

import org.launchcode.models.data.BuildingDao;
import org.launchcode.models.data.TenantDao;
import org.launchcode.models.forms.Building;
import org.launchcode.models.forms.Tenant;
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
@RequestMapping("tenant")
public class TenantController {

    @Autowired
    private TenantDao tenantDao;

    @Autowired
    private BuildingDao buildingDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Tenants");
        model.addAttribute("tenants", tenantDao.findAll());
        return "tenant/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTenantForm(Model model) {
        model.addAttribute("title", "Add Tenant");
        model.addAttribute(new Tenant());
        model.addAttribute("buildings", buildingDao.findAll());
        return "tenant/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTenantForm(@ModelAttribute @Valid Tenant newTenant, Errors errors, @RequestParam int buildingId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Tenant");
            return "tenant/add";
        }

        Building building = buildingDao.findOne(buildingId);
        newTenant.setBuilding(building);
        tenantDao.save(newTenant);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTenantForm(Model model) {
        model.addAttribute("title", "Remove Tenant");
        model.addAttribute("tenants", tenantDao.findAll());
        return "tenant/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveTenantForm(@RequestParam int[] tenantIds) {

        for (int tenantId : tenantIds) {
            tenantDao.delete(tenantId);
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{tenantId}", method = RequestMethod.GET)
    public String displayEditTenantForm(Model model, @PathVariable int tenantId) {
        Tenant tenant = tenantDao.findOne(tenantId);
        model.addAttribute("title", "Edit Tenant");
        model.addAttribute("tenant", tenant);
        model.addAttribute("buildings", buildingDao.findAll());
        return "tenant/edit";
    }

    @RequestMapping(value = "edit/{tenantId}", method = RequestMethod.POST)
    public String processEditTenantForm(@ModelAttribute @Valid Tenant tenant, Errors errors, Model model, @PathVariable("tenantId") int tenantId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Tenant");
            model.addAttribute("buildings", buildingDao.findAll());
            model.addAttribute("tenant", tenant);

            return "tenant/edit";
        }

        Tenant editTenant = tenantDao.findOne(tenantId);
        editTenant.setBuilding(tenant.getBuilding());
        editTenant.setUnit(tenant.getUnit());
        editTenant.setName(tenant.getName());
        editTenant.setPhoneNumber(tenant.getPhoneNumber());
        editTenant.setAltNumber(tenant.getAltNumber());
        editTenant.setRent(tenant.getRent());
        editTenant.setMoveInDate(tenant.getMoveInDate());

        tenantDao.save(editTenant);

        model.addAttribute("title", "Edit Tenant");
        model.addAttribute("buildings", buildingDao.findAll());
        model.addAttribute("successMessage", "Tenant has been modified!");
        return "tenant/edit";

    }


}
