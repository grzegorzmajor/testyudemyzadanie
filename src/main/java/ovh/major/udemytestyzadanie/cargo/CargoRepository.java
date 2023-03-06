package ovh.major.udemytestyzadanie.cargo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CargoRepository {

    private List<Cargo> cargoList;

    public CargoRepository() {
        this.cargoList = new ArrayList<>();
    }

    void addCargo(Cargo cargo) {
        cargoList.add(cargo);
    }

    void removeCargo(Cargo cargo) {
        cargoList.remove(cargo);
    }

    public Optional<Cargo> findCargoByName(String name) {
        return cargoList.stream().filter(cargo -> cargo.getName().equals(name)).findFirst();
    }

}
