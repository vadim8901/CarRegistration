package ru.project.repository;

import java.sql.SQLException;

public class AddData {
    private Repository repository;
    private SearchData searchData;

    public AddData(Repository repository) {
        this.repository = repository;
        searchData = new SearchData(repository);
    }

    private void addPeople(String namePeople) throws SQLException {
        String query = "INSERT INTO people(name)" + " VALUES ('" + namePeople + "')";
        repository.getStmt().executeUpdate(query);
    }

    private void addCountry(String country) throws SQLException {
        String query = "INSERT INTO country(country)" + " VALUES ('" + country + "')";
        repository.getStmt().executeUpdate(query);
    }

    private void addBrand(String brand) throws SQLException {
        String query = "INSERT INTO brand(brand)" + " VALUES ('" + brand + "')";
        repository.getStmt().executeUpdate(query);
    }

    private void addModel(String model, String brand) throws SQLException {
        int idBrand = searchData.searchBrand(brand);
        String query = "INSERT INTO model(id_brand,model)"
                + " VALUES (" + idBrand + ",'" + model + "'" +");";
        repository.getStmt().executeUpdate(query);
    }

    private void addCar(String model, String VIN, String year) throws SQLException {
        int idModel = searchData.searchModel(model);
        String query = "INSERT INTO car(model_id,vin,year)"
                + " VALUES (" + idModel + ",'" + VIN + "','" + year + "');";
        repository.getStmt().executeUpdate(query);
    }

    private void addOwnerCar(String namePeople, String number, String country, String VIN) throws SQLException {
        int idCar = searchData.searchCar(VIN);
        int idPeople = searchData.searchPeople(namePeople);
        int idCountry = searchData.searchCountry(country);
        String query = "INSERT INTO owner_car(car_id,people_id,number,country_id)"
                + " VALUES (" + idCar + "," + idPeople + ",'" + number + "'," + idCountry + ");";
        repository.getStmt().executeUpdate(query);
    }

    public void addCarData(String name, String brand, String VIN,
                           String number, String model, String country, String year) throws SQLException {
        addPeople(name);
        addCountry(country);
        addBrand(brand);
        addModel(model, brand);
        addCar(model, VIN, year);
        addOwnerCar(name, number, country, VIN);
    }
}
