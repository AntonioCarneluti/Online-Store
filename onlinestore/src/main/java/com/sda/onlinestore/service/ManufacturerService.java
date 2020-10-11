package com.sda.onlinestore.service;


import com.sda.onlinestore.dto.ManufacturerDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.model.ManufacturerModel;
import com.sda.onlinestore.model.ProductModel;
import com.sda.onlinestore.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<ManufacturerDto> getManufacturers() {
        List<ManufacturerModel> manufacturerModelList = manufacturerRepository.findAll();
        List<ManufacturerDto> manufacturerDtoList = new ArrayList<>();

        for (ManufacturerModel manufacturerModel : manufacturerModelList) {
            ManufacturerDto manufacturerDto = new ManufacturerDto();
            manufacturerDto.setName(manufacturerModel.getName());


            manufacturerDtoList.add(manufacturerDto);

        }
        return manufacturerDtoList;
    }

    public ManufacturerDto findManufacturerById(Long id) {
        Optional<ManufacturerModel> optionalManufacturerModel = manufacturerRepository.findById(id);
        if (optionalManufacturerModel.isPresent()) {
            ManufacturerModel manufacturerModel = optionalManufacturerModel.get();
            ManufacturerDto manufacturerDto = new ManufacturerDto();
            manufacturerDto.setName(manufacturerModel.getName());


            return manufacturerDto;
        }
        return null;
    }

    public void addManufacturer(ManufacturerDto manufacturerDto) {
        ManufacturerModel manufacturerModel = new ManufacturerModel();
        manufacturerModel.setName(manufacturerDto.getName());
        manufacturerRepository.save(manufacturerModel);
    }

    public void deleteProduct(Long id) {
        manufacturerRepository.deleteById(id);
    }

    public void updateManufacturer(ManufacturerDto manufacturerDto) {
        Optional<ManufacturerModel> optionalManufacturerModel = manufacturerRepository.findById(manufacturerDto.getId());
        if (optionalManufacturerModel.isPresent()) {
            ManufacturerModel manufacturerModel = optionalManufacturerModel.get();
            manufacturerModel.setName(manufacturerDto.getName());
            manufacturerRepository.save(manufacturerModel);

        }
    }


}
