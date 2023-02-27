package ovh.major.udemytestyzadanie;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinatesTest {

    @ParameterizedTest
    @CsvSource({
            "10, 40",
            "20, 15",
            "99, 2",
            "2, 80"
    })
    void newCoordinatesShouldBeCorrectAndHaveXYWhenTheyAreCorrect(int x, int y) {

        //given
        //when
        Coordinates coordinates = new Coordinates(x, y);

        //then
        assertAll(
                () -> assertNotNull(coordinates),
                () -> assertThat(coordinates.getX(), equalTo(x)),
                () -> assertThat(coordinates.getY(), equalTo(y))

        );
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 0",
            "0, -1",
            "-1, 101",
            "104, -5",
            "-40, -50",
            "500, 240"
    })
    void newCoordinatesShouldThrowAnExceptionWhenXOrYOrBothAreIncorrect(int x, int y) {
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(x, y));

    }


    @ParameterizedTest
    @CsvSource({
            "10, 10, 5 , 5",
            "100, 100 , -5 , -60",
            "50, 50, -30, 40",
            "50, 50, -50, 50"
    })
    void copyTest(int sourceX, int sourceY, int x, int y) {

        //given
        Coordinates coordinates = new Coordinates(sourceX, sourceY);

        //when
        Coordinates copyCoordinates = Coordinates.copy(coordinates, x, y);

        //then
        assertAll(
                () -> assertNotNull(copyCoordinates),
                () -> assertThat(copyCoordinates.getX(), equalTo(coordinates.getX() + x)),
                () -> assertThat(copyCoordinates.getY(), equalTo(coordinates.getY() + y))
        );
    }

}
