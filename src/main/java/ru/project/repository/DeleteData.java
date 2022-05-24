package ru.project.repository;

import java.sql.SQLException;

public class DeleteData {

    private Repository repository;
    private SearchData searchData;

    public DeleteData(Repository repository) {
        this.repository = repository;
        this.searchData = new SearchData(repository);
    }

    public void deleteData(String VIN){
        int carId = searchData.searchCar(VIN);

        String queryOwnerCar = "DELETE FROM owner_car WHERE car_id="+carId+";";
        String queryCar = "DELETE FROM car WHERE id="+carId+";";

        try {
            repository.setAutoCommit(false);
            repository.getStmt().executeUpdate(queryOwnerCar);
            repository.getStmt().executeUpdate(queryCar);
            repository.commit();
        } catch (SQLException throwables) {
            repository.rollback();
            System.out.println("Incorrect query");
        } finally {
            repository.disconnect();
        }
    }
}
