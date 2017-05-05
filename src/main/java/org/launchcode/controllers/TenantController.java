package org.launchcode.controllers;

import org.launchcode.models.data.TenantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
