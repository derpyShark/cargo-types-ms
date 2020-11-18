package kpi.trspo.cargotypesms.controller;


import javassist.NotFoundException;
import kpi.trspo.cargotypesms.model.CargoType;
import kpi.trspo.cargotypesms.service.ICargoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/cargoTypes")
public class CargoTypeController {
    private final ICargoTypeService cargoTypeService;

    @Autowired
    public CargoTypeController(ICargoTypeService cargoTypeService){
        this.cargoTypeService = cargoTypeService;
    }

    @GetMapping
    public List<CargoType> getCargoType(){ return  cargoTypeService.getAll();}

    @GetMapping(path = "{id}")
    public CargoType getCargoTypeById(@PathVariable("id") UUID id) throws NotFoundException
    {
        return cargoTypeService.getById(id);
    }

    @PostMapping
    public CargoType addCargoType(@RequestBody CargoType addedCargoType)
    {
        return cargoTypeService.create(addedCargoType);
    }

    @PutMapping(path = "{id}")
    public void changeCargoType(@PathVariable("id") UUID id, @RequestBody CargoType cargoTypeDetails)
            throws NotFoundException
    {
        cargoTypeService.update(id, cargoTypeDetails);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCargoTypeById(@PathVariable("id") UUID id) throws NotFoundException
    {
        cargoTypeService.delete(id);
    }
}
