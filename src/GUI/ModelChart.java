package GUI;

import JDBC.Dataset;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.SQLException;

public class ModelChart
{

    /**
     * getting data from database
     * @param company differences data in database
     * @return data
     * @throws SQLException
     */
    public static ObservableList<Dataset> getCompanyData(String company) throws SQLException
    {
        Dataset capitalCost    = new Dataset("capitalcost","cost",company);
        Dataset materialCost   = new Dataset("materialcost","cost",company);
        Dataset labourCost     = new Dataset("labourcost","cost",company);
        Dataset unitCost       = new Dataset("unitcost","cost",company);
        Dataset productionCost = new Dataset("productioncost","cost",company);
        Dataset employee       = new Dataset("employee","employee",company);
        Dataset production     = new Dataset("production","production_capacity",company);

        ObservableList<Dataset> items = FXCollections.observableArrayList(capitalCost,materialCost,labourCost,unitCost,
                                productionCost,employee,production);

        return items;
    }


    /**
     * getting data from database
     * @param company differences data in database
     * @return data for market price
     * @throws SQLException
     */
    public static ObservableList<Dataset> getMarketPriceData(String company) throws SQLException
    {
        Dataset marketPrice = new Dataset("marketprice","market_price",company);
        ObservableList<Dataset> itemM = FXCollections.observableArrayList(marketPrice);

        return itemM;
    }

}
