package GUI;

import JDBC.Dataset;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelChart
{
    //ObservableList<String>


    public static ObservableList<Dataset> getCompanyData(String company) throws SQLException
    {
        Dataset capitalCost = new Dataset("capitalcost","cost",company);
        Dataset materialCost = new Dataset("materialcost","cost",company);
        Dataset labourCost = new Dataset("labourcost","cost",company);
        Dataset unitCost = new Dataset("unitcost","cost",company);
        Dataset productionCost = new Dataset("productioncost","cost",company);
        Dataset employee = new Dataset("employee","employee",company);
        Dataset production = new Dataset("production","production_capacity",company);

        ObservableList<Dataset> items = FXCollections.observableArrayList(capitalCost,materialCost,labourCost,unitCost,
                                productionCost,employee,production);
        return items;
    }


    public static ObservableList<Dataset> getMarketPriceData(String company) throws SQLException
    {
        Dataset marketPrice = new Dataset("marketprice","market_price",company);
        ObservableList<Dataset> itemM = FXCollections.observableArrayList(marketPrice);
        return itemM;
    }


}
