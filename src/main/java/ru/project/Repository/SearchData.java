package ru.project.Repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.project.entities.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchData {
    private Repository repository;

    public SearchData(Repository repository) {
        this.repository = repository;
    }

    public ObservableList<Car> searchFullData() throws SQLException {
        ResultSet rs;
        String search =
                "SELECT car.vin," +
                        "brand.brand,\n " +
                        "(SELECT country FROM country WHERE owner_car.country_id = country.id) AS country,\n " +
                        "model.model,\n " +
                        "(SELECT name FROM people WHERE owner_car.people_id = people.id) AS name,\n " +
                        "owner_car.number,\n " +
                        "car.year " +
                        "FROM owner_car LEFT JOIN car ON owner_car.car_id = car.id " +
                        "LEFT JOIN model ON car.model_id = model.id " +
                        "LEFT JOIN brand ON model.id_brand = brand.id;";
        rs = repository.getStmt().executeQuery(search);
        ObservableList<Car> list = FXCollections.observableArrayList();;
        while (rs.next()){
            list.add(new Car(rs.getString(1), rs.getString(2),
                    rs.getString(4), rs.getString(3),
                    rs.getString(6), rs.getString(7),
                    rs.getString(5)));
        }
        repository.disconnect();
        return list;
    }

    private int getIdData(String query){
        try {
            ResultSet rs = repository.getStmt().executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e){
            throw new RuntimeException("Incorrect query");
        }
        return -1;
    }

    int searchPeople(String namePeople){
        String query = "SELECT id FROM people WHERE name = '" + namePeople + "';";
        return getIdData(query);
    }

    int searchCountry(String country) {
        String query = "SELECT id FROM country WHERE country = '" + country + "';";
        return getIdData(query);
    }

    int searchBrand(String brand) throws SQLException {
        String query = "SELECT id FROM brand WHERE brand = '" + brand + "';";
        return getIdData(query);
    }

    int searchModel(String model) throws SQLException {
        String query = "SELECT id FROM model WHERE model = '" + model + "';";
        return getIdData(query);
    }

    int searchCar(String VIN) throws SQLException {
        String query = "SELECT id FROM car WHERE vin = '" + VIN + "';";
        return getIdData(query);
    }

}
