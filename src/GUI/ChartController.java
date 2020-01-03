package GUI;

import JDBC.Dataset;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChartController implements Initializable
{
    ObservableList<Dataset> dataset = null;

    ObservableList<String> itemA = FXCollections.observableArrayList("Capitalcost","Materialcost","Labourcost",
                                "Unitcost","Productioncost","Employee","Productioncapacity");

    ObservableList<String> itemB = FXCollections.observableArrayList("Marketprice" );

    @FXML
    private LineChart<String, Number> companyA;

    @FXML
    private CategoryAxis xAxisCompanyA;

    @FXML
    private NumberAxis yAxisCompanyA;

    @FXML
    private LineChart<String, Number> companyB;

    @FXML
    private CategoryAxis xAxisCompanyB;

    @FXML
    private NumberAxis yAxisCompanyB;

    @FXML
    private LineChart<String, Number> marketPrice;

    @FXML
    private CategoryAxis xAxisMarketPrice;

    @FXML
    private NumberAxis yAxisMarketPrice;


    @FXML
    private ChoiceBox<String> choiceBoxA;

    @FXML
    private Button SubmitA;

    @FXML
    private ChoiceBox<String> choiceBoxB;

    @FXML
    private Button SubmitB;

    @FXML
    private ChoiceBox<String> choiceBoxC;

    @FXML
    private Button submitM;

    @FXML
    private Button goBack;

    @FXML
    private Button exit;


    /**
     * exit programm properly
     */
    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    /**
     * submits the choosen diagram for companyA
     */
    @FXML
    void submitA(ActionEvent event) throws SQLException
    {

        String s = choiceBoxA.getValue();


        ObservableList<XYChart.Series<String, Number>> chartData = getChartDataCompany(checkSelectedItem(s),"A");


        companyA.getData().addAll(chartData);
        companyA.setCreateSymbols(false);



    }

    /**
     * submits the choosen diagram for companyB
     */
    @FXML
    void submitB(ActionEvent event) throws SQLException {
        String s = choiceBoxB.getValue();
        ObservableList<XYChart.Series<String, Number>> chartData = getChartDataCompany(checkSelectedItem(s),"B");

        companyB.getData().addAll(chartData);
        companyB.setCreateSymbols(false);



    }

    /**
     * submits the choosen diagram for marketprice
     */
    @FXML
    void submitC(ActionEvent event) throws SQLException {

        String s = choiceBoxC.getValue();


        ObservableList<XYChart.Series<String, Number>> chartData = getMarketPriceData(0);
        marketPrice.getData().addAll(chartData);
        marketPrice.setCreateSymbols(false);


    }

    /**
     * @param input to check selected item in choicebox
     * @return the position of the item in the list
     */
    private int checkSelectedItem(String input)
    {

        String[] toCheck = {"Capitalcost","Materialcost","Labourcost",
                "Unitcost","Productioncost","Employee","Productioncapacity"};

        for (int i = 0; i < toCheck.length; i++)
        {
            if (input.equals(toCheck[i]))
                return i;
        }

        return 99;
    }

    private ObservableList<XYChart.Series<String, Number>> getChartDataCompany(Integer position, String company) throws SQLException
    {
        ObservableList<Dataset> dataCompany = ModelChart.getCompanyData(company);

        Double[] aValue = dataCompany.get(position).getData();


        //return list with series of x and y values
        ObservableList<XYChart.Series<String, Number>> answer = FXCollections.observableArrayList();

        XYChart.Series<String, Number> aSeries = new XYChart.Series<>();

        aSeries.setName(dataCompany.get(position).getTableName() +": "+ dataCompany.get(position).getColumnName());


        for (int i = 0; i < 800; i++)
        {
            Double d = aValue[i];
            aSeries.getData().add(new XYChart.Data(Integer.toString(i), d));



        }
        answer.addAll(aSeries);
        return answer;
    }


    private ObservableList<XYChart.Series<String, Number>> getMarketPriceData(Integer position) throws SQLException {
        // zero because  no company exits
        ObservableList<Dataset> dataCompany = ModelChart.getMarketPriceData("0");

        Double[] aValue = dataCompany.get(position).getData();


        //return list with series of x and y values
        ObservableList<XYChart.Series<String, Number>> answer = FXCollections.observableArrayList();

        XYChart.Series<String, Number> aSeries = new XYChart.Series<>();

        // set name of series
        aSeries.setName(dataCompany.get(position).getTableName() +": "+ dataCompany.get(position).getColumnName());


        for (int i = 0; i < 800; i++)
        {
            Double d = aValue[i];
            aSeries.getData().add(new XYChart.Data(Integer.toString(i), d));



        }
        answer.addAll(aSeries);
        return answer;
    }



    // goes back to setter.fxml
    @FXML
    void switchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("setter.fxml")); // create and load() view
        Stage stage = (Stage) goBack.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

    // set items in choicebox

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {


        choiceBoxA.setItems(itemA);
        choiceBoxB.setItems(itemA);
        choiceBoxC.setItems(itemB);


    }


}
















