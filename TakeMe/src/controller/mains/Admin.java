package controller.mains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Admin extends Application {

    @Override
    public void start(Stage primaryStage) {

        Double[] data = {0.1, 0.4, 0.5, 0.7, 0.9, 1.0};

        LineChart<Number, Number> lc = createLineChart(data);
        LineChart<Number, Number> lc1 = createLineChart(data);
        LineChart<Number, Number> lc2 = createLineChart(data);
        LineChart<Number, Number> lc3= createLineChart(data);

        StackPane root = new StackPane();
        HBox a= new HBox();
        VBox b1= new VBox();
        VBox b2= new VBox();
        root.getChildren().addAll(a);
        a.setMaxSize(1000,1000);
        a.getChildren().addAll(b1,b2);
        b1.getChildren().addAll(lc,lc1);
        b2.getChildren().addAll(lc2,lc3);


        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Take Me");
        primaryStage.getIcons().add(new Image("ressources/img/img/logo.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private LineChart<Number, Number> createLineChart(Double[] axisValues) {
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        //creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Axis' values");
        //defining a series
        XYChart.Series<Number, Number> series = new LineChart.Series<>();
        series.setName("X Axis");
        //populating the series with data
        for (int i = 0; i < axisValues.length; i++) {
            XYChart.Data<Number, Number> data = new LineChart.Data<>(i, axisValues[i]);
            series.getData().add(data);
        }
        lineChart.getData().add(series);
        return lineChart;
    }
}