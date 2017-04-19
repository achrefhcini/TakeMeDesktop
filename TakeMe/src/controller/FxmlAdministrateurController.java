package controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import controller.mains.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.crud.CrudMembre;
import model.crud.CrudOffre;
import model.crud.CrudSession;


public  class FxmlAdministrateurController implements Initializable   {


    @FXML
    private BorderPane tochange;

    @FXML
    void LoadGestUser(MouseEvent event) throws IOException {
        BorderPane borderp= (BorderPane) FXMLLoader.load(getClass().getResource("/view/FxmlUserView.fxml"));
        tochange.setCenter(borderp);

    }
    @FXML
    void loadStats(MouseEvent event) throws IOException {
        BorderPane borderp= (BorderPane) FXMLLoader.load(getClass().getResource("/view/FxmlStats.fxml"));
        tochange.setCenter(borderp);
    }
    @FXML
    void signOut(MouseEvent event) throws Exception {
        System.out.println("Load login Gui");
        Login login =new Login();
        login.start(new Stage());
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void versionPieChart(MouseEvent event) throws IOException {

            BorderPane borderp= (BorderPane) FXMLLoader.load(getClass().getResource("/view/FxmlStatsPie.fxml"));
            tochange.setCenter(borderp);

    }



    public void initialize(URL location, ResourceBundle resources) {

        CrudSession crudSession=null;
        try {
            crudSession = new CrudSession();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        CrudMembre crudMembre=null;
        try {
            crudMembre = new CrudMembre();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        CrudOffre crudOffre = null;
        try {
            crudOffre = new CrudOffre();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("DATA DESKTOP*******************************");



        Integer[] dataDesktop = new Integer[10];
        for (int i=0; i<7;i++){
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDatefrom=d.plusMonths(i).withDayOfMonth(1);
            LocalDate ParcoursDateto=d.plusMonths(i+1).withDayOfMonth(1).minusDays(1);

            int nombreUserDesktop= crudSession.afficheNbrSession(ParcoursDatefrom,ParcoursDateto,"desktop");
            System.out.println(ParcoursDatefrom+" "+ParcoursDateto);
            System.out.println(nombreUserDesktop);
            dataDesktop[i]=nombreUserDesktop;
        }
        System.out.println(" DATA WEB*******************************");


        Integer[] dataWeb = new Integer[10];
        for (int i=0; i<7;i++){
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDatefrom=d.plusMonths(i).withDayOfMonth(1);
            LocalDate ParcoursDateto=d.plusMonths(i+1).withDayOfMonth(1).minusDays(1);

            int nombreUserWeb= crudSession.afficheNbrSession(ParcoursDatefrom,ParcoursDateto,"web");
            System.out.println(ParcoursDatefrom+" "+ParcoursDateto);
            System.out.println(nombreUserWeb);
            dataWeb[i]=nombreUserWeb;
        }
        System.out.println("DATA MOBILE*******************************");


        Integer[] dataMobile = new Integer[10];
        for (int i=0; i<7;i++){
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDatefrom=d.plusMonths(i).withDayOfMonth(1);
            LocalDate ParcoursDateto=d.plusMonths(i+1).withDayOfMonth(1).minusDays(1);

            int nombreUserMobile= crudSession.afficheNbrSession(ParcoursDatefrom,ParcoursDateto,"mobile");
            //System.out.println(ParcoursDatefrom+" "+ParcoursDateto);
            //System.out.println(nombreUserMobile);
            dataMobile[i]=nombreUserMobile;

        }


        System.out.println(" DATA HOMME*******************************");



        int dataHomme =crudMembre.nombreMembresHommes();
        System.out.println(dataHomme);
        System.out.println("DATA FEMME*******************************");

        int dataFemme =crudMembre.nombreMembresFemmes();
        System.out.println(dataFemme);

        System.out.println("DATA AGEMAX*******************************");

        int ageMax =crudMembre.ageMaxMembre();
        System.out.println(ageMax);

        System.out.println("DATA COUTMAX*******************************");


        int coutMax =crudOffre.coutMaxOffre();
        System.out.println(coutMax);

        System.out.println("DATA AGE*******************************");

        Integer[] dataAge = new Integer[100];
        for (int i=18; i<ageMax+3 ;i=i+3){

            //System.out.println(ageMax);
            int ages= crudMembre.afficherMembreAges(i,(i+2)).size();
            dataAge[i]=ages;
            System.out.println(dataAge[i]);

        }

        System.out.println("DATA PRIX*******************************");

        Integer[] dataPrix = new Integer[100];
        for (int i=1; i<coutMax+3 ;i=i+5){

            int prix= crudOffre.afficherOffreCouts(i,(i+4));
            dataPrix[i]=prix;

            System.out.println(dataPrix[i]);
        }
        System.out.println("DIRAAAAAABEK");








        Integer[] data = new Integer[7];
        for (int i=0; i<7;i++){
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDatefrom=d.plusMonths(i).withDayOfMonth(1);
            LocalDate ParcoursDateto=d.plusMonths(i+1).withDayOfMonth(1).minusDays(1);
            int nombreUser= crudSession.afficheNbrSession(ParcoursDatefrom,ParcoursDateto,"desktop");
            System.out.println(ParcoursDatefrom+" "+ParcoursDateto);
            System.out.println(nombreUser);
            data[i]=nombreUser;
        }

        Integer[] data1 = new Integer[7];
        for (int i=0; i<7;i++){
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDatefrom=d.plusMonths(i).withDayOfMonth(1);
            LocalDate ParcoursDateto=d.plusMonths(i+1).withDayOfMonth(1).minusDays(1);
            int nombreUser= crudSession.afficheNbrSession(ParcoursDatefrom,ParcoursDateto,"web");
            System.out.println(ParcoursDatefrom+" "+ParcoursDateto);
            System.out.println(nombreUser);
            data1[i]=nombreUser;
        }


        Integer[] data2 = new Integer[7];
        for (int i=0; i<7;i++){
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDatefrom=d.plusMonths(i).withDayOfMonth(1);
            LocalDate ParcoursDateto=d.plusMonths(i+1).withDayOfMonth(1).minusDays(1);
            int nombreUser= crudSession.afficheNbrSession(ParcoursDatefrom,ParcoursDateto,"mobile");
            System.out.println(ParcoursDatefrom+" "+ParcoursDateto);
            System.out.println(nombreUser);
            data2[i]=nombreUser;
        }


        LineChart<String, Number> lc = createLineChart1(data,data1,data2);
        LineChart<String, Number> lc2 = createLineChart2(dataHomme,dataFemme);
        LineChart<String, Number> lc3 = createLineChart3(ageMax,dataAge);


        StackPane root = new StackPane();
        HBox a= new HBox();
        VBox b1= new VBox();
        VBox b2= new VBox();
        root.getChildren().addAll(a);
        a.setMaxSize(1000,1000);
        a.getChildren().addAll(b1,b2);
        b1.getChildren().addAll(lc,lc2);


        tochange.setCenter(root);

    }
    private LineChart<String, Number> createLineChart1(Integer[] axisValuesDesktop,Integer[] axisValuesWeb,Integer[] axisValuesMobile) {
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        //creating the chart
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Axis' values");
        //defining a series
        XYChart.Series<String, Number> series = new LineChart.Series<>();
        series.setName("Desktop");

        XYChart.Series<String, Number> series1 = new LineChart.Series<>();
        series1.setName("Web");

        XYChart.Series<String, Number> series2 = new LineChart.Series<>();
        series2.setName("Mobile");
        //populating the series with data


        for (int i = 0; i < axisValuesDesktop.length; i++) {
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDate=d.plusMonths(i);

            int ParcoursDateMonth=ParcoursDate.getMonthValue();
            int ParcoursDateYear=ParcoursDate.getYear();

            String mois=""+ParcoursDateYear+"-"+ParcoursDateMonth;
            XYChart.Data<String, Number> data = new LineChart.Data<>(mois, axisValuesDesktop[i]);

            series.getData().add(data);
        }

        for (int i = 0; i < axisValuesDesktop.length; i++) {
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDate=d.plusMonths(i);

            int ParcoursDateMonth=ParcoursDate.getMonthValue();
            int ParcoursDateYear=ParcoursDate.getYear();

            String mois=""+ParcoursDateYear+"-"+ParcoursDateMonth;
            XYChart.Data<String, Number> data1 = new LineChart.Data<>(mois, axisValuesMobile[i]);

            series1.getData().add(data1);
        }

        for (int i = 0; i < axisValuesDesktop.length; i++) {
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDate=d.plusMonths(i);

            int ParcoursDateMonth=ParcoursDate.getMonthValue();
            int ParcoursDateYear=ParcoursDate.getYear();

            String mois=""+ParcoursDateYear+"-"+ParcoursDateMonth;
            XYChart.Data<String, Number> data2 = new LineChart.Data<>(mois, axisValuesWeb[i]);

            series2.getData().add(data2);
        }
        lineChart.getData().addAll(series,series1,series2);
        return lineChart;
    }


    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************


    private LineChart<String, Number> createLineChart2(int hommeValues,int femmeValues) {
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number");

        //creating the chart
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Hommes/Femmes");

        //defining a series
        XYChart.Series<String, Number> seriesHomme = new LineChart.Series<>();
        seriesHomme.setName("Homme");

        //defining a series
        XYChart.Series<String, Number> seriesFemme = new LineChart.Series<>();
        seriesFemme.setName("Femme");



        //populating the series with data
        for (int i = 0; i < 2; i++) {
            LocalDate d= (LocalDate.now()).minusMonths(6);
            LocalDate ParcoursDate=d.plusMonths(i);
            int ParcoursDateMonth=ParcoursDate.getMonthValue();
            int ParcoursDateYear=ParcoursDate.getYear();


            XYChart.Data<String, Number> data1 = new LineChart.Data<>("Hommes", hommeValues);
            seriesHomme.getData().add(data1);

            XYChart.Data<String, Number> data2 = new LineChart.Data<>("Femmes", femmeValues);
            seriesFemme.getData().add(data2);


        }
        lineChart.getData().addAll(seriesHomme,seriesFemme);
        System.out.println("FUNCTION 222222222222222222222222222222222");

        return lineChart;
    }


    private LineChart<String, Number> createLineChart3(int ageMax ,Integer[] DataAge) {
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("age");

        //creating the chart
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Nombre d'utilisateurs/Age");

        //defining a series
        XYChart.Series<String, Number> seriesAge = new LineChart.Series<>();
        seriesAge.setName("nombre d'utilisateurs par age");

        //populating the series with data




        for (int i = 18; i < ageMax+3 ; i=i+3 ) {
            String age=""+i+"-"+(i+2);
            XYChart.Data<String, Number> data1 = new LineChart.Data<>(age ,DataAge[i]  );
            seriesAge.getData().add(data1);

            System.out.println(age+" "+DataAge[i]);
        }
        lineChart.getData().add(seriesAge);

        System.out.println("FUNCTION 333333333333333333333333333333333333333333333");
        return lineChart;
    }

    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************




    }
