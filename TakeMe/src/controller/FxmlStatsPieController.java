package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.crud.CrudMembre;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by SAW on 17/02/2017.
 */
public class FxmlStatsPieController implements Initializable {
  @FXML
          private BorderPane tochange;



    public void initialize(URL location, ResourceBundle resources) {

        CrudMembre crudMembre= null;
        try {
            crudMembre = new CrudMembre();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PieChart pieChart = new PieChart();
        ObservableList data = crudMembre.buildDataSexe();
        System.out.println(data);

        pieChart.getData().addAll(data);
        tochange.setCenter(pieChart);



    }

}
