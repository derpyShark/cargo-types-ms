package kpi.trspo.cargotypesms.service;

import javassist.NotFoundException;
import kpi.trspo.cargotypesms.model.CargoType;
import kpi.trspo.cargotypesms.repository.CargoTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CargoTypeService implements ICargoTypeService{
    private CargoTypeRepository cargoTypeRepository;

    @Override
    public List<CargoType> getAll() {
        return cargoTypeRepository.findAll();
    }

    @Override
    public CargoType getById(UUID cargoTypeId) throws NotFoundException {
        Optional<CargoType> cargoTypeMaybe = cargoTypeRepository.findById(cargoTypeId);
        if(cargoTypeMaybe.isPresent()){
            return cargoTypeMaybe.get();
        }
        else
            throw new NotFoundException("No cargoType with such an Id: " + cargoTypeId);
    }

    @Override
    public CargoType create(CargoType cargoTypeObject) {
        return cargoTypeRepository.save(cargoTypeObject);
    }

    @Override
    public CargoType update(UUID cargoTypeId, CargoType cargoTypeDetails) throws NotFoundException {
        CargoType oldCargoType = getById(cargoTypeId);
        oldCargoType.setCargoTypeName(cargoTypeDetails.getCargoTypeName());
        return cargoTypeRepository.save(oldCargoType);
    }

    @Override
    public void delete(UUID cargoTypeId) throws NotFoundException{
        cargoTypeRepository.delete(getById(cargoTypeId));
    }
}
