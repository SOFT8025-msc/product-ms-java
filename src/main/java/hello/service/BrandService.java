package hello.service;

import hello.dto.Brand;
import hello.model.BrandEntity;

import java.util.List;

public interface BrandService {
    List<BrandEntity> list();
}
