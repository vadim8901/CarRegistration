package ru.project.repository;

import java.sql.SQLException;

public class UpdateData {
    private Repository repository;
    private SearchData searchData;

    public UpdateData(Repository repository) {
        this.repository = repository;
        this.searchData = new SearchData(repository);
    }

    public void updateData(String vin, String year, String name){
        try {
            repository.setAutoCommit(false);
            car(vin, year);
            people(vin, name);
            repository.commit();
        } catch (Exception e){
            repository.rollback();
            throw new RuntimeException("Incorrect data", e);
        } finally {
            repository.disconnect();
        }
    }

    private int getIDCar(String vin){
        return searchData.searchCar(vin);
    }

    private void car(String vin, String year) throws SQLException {
        String query = "UPDATE car SET year='" + year + "' WHERE id=" + getIDCar(vin) + ";";
        repository.getStmt().executeUpdate(query);
    }

    private void people(String vin, String name) throws SQLException {
        int idPeople = searchData.searchPeopleFromOwnerCar(vin);
        String query = "UPDATE people SET name='" + name + "' WHERE id=" + idPeople + ";";
        repository.getStmt().executeUpdate(query);
    }

}
