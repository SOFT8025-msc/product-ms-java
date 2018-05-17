package org.soft.assignment.controller;

import org.soft.assignment.model.Brand;
import org.soft.assignment.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Brand> getList() {
        return brandService.list();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Brand create(@RequestBody Brand object) {
        return brandService.create(object);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Brand update(@RequestParam String id, @RequestBody Brand object) {
        return brandService.update(object);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestParam String id) {
        brandService.delete(id);
    }
}
