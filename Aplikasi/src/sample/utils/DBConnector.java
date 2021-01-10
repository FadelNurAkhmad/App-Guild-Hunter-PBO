package sample.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class DBConnector {
    //objek untuk menyimpan data
    private TableView tableView;
    private ObservableList<ObservableList> queryData;

    // menginisialisasi objek
    public DBConnector() {
        queryData = null;
        tableView = null;
    }

    //dapatkan status hasilnya
    public boolean getStatus() { return queryData.size() > 0; }

    //dapatkan isi tabel
    public TableView getTable() { return tableView; }

    // dapatkan isi datanya
    public ObservableList<ObservableList> getData() { return queryData; }

    //mulai koneksi database
    public void start(String dbCommand) {
        // try to connect to the database
        try (Connection dbConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_oop?serverTimezone=UTC",
                "root", "");
             Statement statement = dbConnection.createStatement();) {

            //jalankan perintah untuk mendapatkan data kueri
            ResultSet queryResult = statement.executeQuery(dbCommand);

            // initialize the objects
            queryData = FXCollections.observableArrayList();
            tableView = new TableView();

            //baca semua kolom dan buat kolom persis dalam tampilan tabel
            for (int i = 0; i < queryResult.getMetaData().getColumnCount(); i++) {
                TableColumn<ObservableList, String> col = new TableColumn<>(queryResult.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new PropertyValueFactory<>(queryResult.getMetaData().getColumnName(i + 1)));
                tableView.getColumns().addAll(col);
            }

            //baca semua baris dan isi objek dengan data dari database
            while (queryResult.next()) {
                ObservableList<String> queryRow = FXCollections.observableArrayList();
                for (int i = 1; i <= queryResult.getMetaData().getColumnCount(); i++) {
                    queryRow.add(queryResult.getString(i));
                }
                queryData.add(queryRow);
            }

            //isi tampilan tabel dengan data
            tableView.setItems(queryData);
            queryResult.close();
        }
        //jika ada yang salah, itu akan ditemukan di sini
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insert(String dbCommand) {
        // try to connect to the database
        try (Connection dbConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_oop?serverTimezone=UTC",
                "root", "");
             Statement statement = dbConnection.createStatement();) {

            // execute the command to update the table
            statement.executeUpdate(dbCommand);
        }
        // if something is wrong, it will be found here
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(String dbCommand) {
        // try to connect to the database
        try (Connection dbConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_oop?serverTimezone=UTC",
                "root", "");
             Statement statement = dbConnection.createStatement();) {

            // execute the command to update the table
            statement.executeUpdate(dbCommand);
        }
        // if something is wrong, it will be found here
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String dbCommand) {
        // try to connect to the database
        try (Connection dbConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_oop?serverTimezone=UTC",
                "root", "");
             Statement statement = dbConnection.createStatement();) {

            // execute the command to update the table
            statement.executeUpdate(dbCommand);
        }
        // if something is wrong, it will be found here
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
