package kpi.trspo.cargotypesms.service;

import javassist.NotFoundException;
import kpi.trspo.cargotypesms.model.CargoType;

import java.util.List;
import java.util.UUID;

public interface ICargoTypeService {
    List<CargoType> getAll();
    CargoType getById(UUID cargoTypeId) throws NotFoundException;
    CargoType create(CargoType cargoTypeObject);
    CargoType update(UUID cargoTypeId, CargoType cargoTypeDetails) throws NotFoundException;
    void delete(UUID cargoTypeId) throws NotFoundException;
}
