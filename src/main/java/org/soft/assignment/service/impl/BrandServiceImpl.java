package org.soft.assignment.service.impl;

import org.soft.assignment.model.Brand;
import org.soft.assignment.repositories.BrandRepository;
import org.soft.assignment.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repo;

    @Override
    public List<Brand> list() {
        return repo.findAll();
    }

    @Override
    public Brand create(Brand brand) {
        return repo.save(brand);
    }

    @Override
    public Brand update(Brand brand) {
        Brand existingBrand = repo.getOne(brand.getId());
        existingBrand.setOwner(brand.getOwner());
        existingBrand.setName(brand.getName());

        return repo.save(existingBrand);
    }

    @Override
    public void delete(Brand brand) {
        repo.delete(brand);
    }

    @Override
    public void delete(String id) {
        Optional<Brand> toBeDeleted = repo.findById(id);
        if (!Objects.isNull(toBeDeleted)) {
            delete(toBeDeleted.orElse(null));
        }
    }
}
