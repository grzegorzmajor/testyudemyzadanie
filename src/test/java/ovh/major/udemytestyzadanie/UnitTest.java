package ovh.major.udemytestyzadanie;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UnitTest {

    @Test
    void unitLoadWeightShouldBeEqualToCargoWeightWhenLoaded() {

        //given
        Coordinates coordinates = new Coordinates(2,2);
        Unit unit = new Unit(coordinates,100,100);
        Cargo cargo = new Cargo("Rower",30);

        //when
        unit.loadCargo(cargo);

        //then
        assertThat(unit.getLoad(),is(equalTo(cargo.getWeight())));
    }

    @Test
    void unitLoadShouldBeReducedWhenIsUnloaded() {

        //given
        Coordinates coordinates = new Coordinates(2,2);
        Unit unit = new Unit(coordinates,100,100);
        Cargo cargo = new Cargo("Rower",30);
        unit.loadCargo(cargo);
        unit.loadCargo(cargo);

        //when
        unit.unloadCargo(cargo);

        //then
        assertThat(unit.getLoad(),is(equalTo(cargo.getWeight())));
    }

    @Test
    void unitLoadShouldBeReducedToZeroWhenAllCargoUnloaded() {

        //given
        Coordinates coordinates = new Coordinates(2,2);
        Unit unit = new Unit(coordinates,100,100);
        Cargo cargo = new Cargo("Rower",30);
        unit.loadCargo(cargo);
        unit.loadCargo(cargo);

        //when
        unit.unloadAllCargo();

        //then
        assertThat(unit.getLoad(),is(equalTo(0)));
    }

    @Test
    void unitFuelLevelShouldBeUpdatedWhenTankedUpAfterMove() {

        //given
        Coordinates coordinates = new Coordinates(2,2);
        Unit unit = new Unit(coordinates,100,100);
        unit.move(5,5);

        //when
        int fuelBeforeMove = unit.getFuel();
        unit.tankUp();

        //then
        assertThat(unit.getFuel(),is(greaterThanOrEqualTo(fuelBeforeMove)));

    }

    @Test
    void unitCoordinatesShouldBeUpdatedWhenMoved() {

        //given
        Coordinates coordinatesBeforeMove = new Coordinates(2,2);
        Unit unit = new Unit(coordinatesBeforeMove,100,100);
        Coordinates coordinatesAfterMoveShouldBe = new Coordinates(7,7);


        //when
        Coordinates coordinatesAfterMove = unit.move(5,5);

        //then
        assertThat(coordinatesAfterMove,is(equalTo(coordinatesAfterMoveShouldBe)));

    }


}
