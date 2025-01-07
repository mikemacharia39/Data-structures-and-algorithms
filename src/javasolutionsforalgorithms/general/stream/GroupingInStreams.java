package javasolutionsforalgorithms.general.stream;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GroupingInStreams {

    private static final Logger log = Logger.getLogger(GroupingInStreams.class.getName());

    public static Map<String, Long> populationByCountry(List<Country> countries) {
        return countries.stream()
                .collect(
                        Collectors.groupingBy(
                                Country::name,
                                Collectors.summingLong(c -> c.city().population())
                        )
                );
    }

    private record Country(String name, City city) {
    }
    private record City(String name, Long population) {
    }


    public static void main(String[] args) {
        List<Country> countries = List.of(
                new Country("USA", new City("New York", 8_336_817L)),
                new Country("USA", new City("Los Angeles", 3_967_746L)),
                new Country("USA", new City("Chicago", 2_695_598L)),
                new Country("India", new City("Mumbai", 12_478_447L)),
                new Country("India", new City("Delhi", 11_034_555L)),
                new Country("Kenya", new City("Nairobi", 4_397_073L)),
                new Country("Kenya", new City("Mombasa", 1_208_333L)));

        Map<String, Long> populationByCountry = populationByCountry(countries);

        log.log(Level.INFO, "Population by country: {0}", populationByCountry);
    }
}
