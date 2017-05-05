package org.launchcode.controllers;

import org.launchcode.models.data.TenantDao;
import org.launchcode.models.forms.Tenant;
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
@RequestMapping("tenant")
public class TenantController {

    @Autowired
    private TenantDao tenantDao;

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
        return "tenant/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTenantForm(@ModelAttribute @Valid Tenant newTenant, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Tenant");
            return "tenant/add";
        }

        tenantDao.save(newTenant);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTenantForm(Model model) {
        model.addAttribute("title", "Remove Tenant");
        model.addAttribute("tenants", tenantDao.findAll());
        return "tenant/remove";
    }



}
