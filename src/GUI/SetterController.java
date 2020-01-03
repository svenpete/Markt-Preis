package GUI;

import JDBC.JDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import simulation.Simulation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SetterController
{

    private    List<String> datenliste;

    @FXML
    private GridPane companyA;

    @FXML
    private TextField productionA;

    @FXML
    private TextField employeeA0;

    @FXML
    private TextField employeeA1;

    @FXML
    private TextField labourCostA0;

    @FXML
    private TextField labourCostA1;

    @FXML
    private TextField capitalCostA0;

    @FXML
    private TextField capitalCostA1;

    @FXML
    private TextField materialCostA;

    @FXML
    private TextField unitCostA;

    @FXML
    private GridPane companyB;

    @FXML
    private TextField productionB;

    @FXML
    private TextField employeeB0;

    @FXML
    private TextField employeeB1;

    @FXML
    private TextField labourCostB0;

    @FXML
    private TextField labourCostB1;

    @FXML
    private TextField capitalCostB0;

    @FXML
    private TextField capitalCostB1;

    @FXML
    private TextField materialCostB;

    @FXML
    private TextField unitCostB;

    @FXML
    private GridPane marketPriceParam;

    @FXML
    private TextField marketPrice0;

    @FXML
    private TextField marketPrice1;

    @FXML
    private TextField marketPrice2;

    @FXML
    private Button showDiagrams;

    @FXML
    private Button simulate;

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row)
    {
        for (Node node : gridPane.getChildren() )
        {
            if (GridPane.getColumnIndex(node) == col
                    && GridPane.getRowIndex(node) == row)
            {
                return node;
            }
        }
        return null;
    }



    @FXML
    void simulate(ActionEvent event) throws SQLException {

        Simulation simulation = new Simulation();
        List<Double> param = getParam();
        System.out.println(param.size());
        simulation.simulate(800,1,param);
        JDBC.createDatabase(JDBC.getConnection(),simulation);
        System.out.println("ok");
    }

    private List<Double> getParam()
    {
        List<Double> datenliste = new ArrayList<>();

        datenliste.add( Double.parseDouble(productionA.getText()));
        datenliste.add( Double.parseDouble(employeeA0.getText()));
        datenliste.add( Double.parseDouble(employeeA1.getText()));
        datenliste.add( Double.parseDouble(labourCostA0.getText()));
        datenliste.add( Double.parseDouble(labourCostA1.getText()));
        datenliste.add( Double.parseDouble(capitalCostA0.getText()));
        datenliste.add( Double.parseDouble(capitalCostA1.getText()));
        datenliste.add( Double.parseDouble(materialCostA.getText()));
        datenliste.add( Double.parseDouble(unitCostA.getText()));

        datenliste.add( Double.parseDouble(productionB.getText()));
        datenliste.add( Double.parseDouble(employeeB0.getText()));
        datenliste.add( Double.parseDouble(employeeB1.getText()));
        datenliste.add( Double.parseDouble(labourCostB0.getText()));
        datenliste.add( Double.parseDouble(labourCostB1.getText()));
        datenliste.add( Double.parseDouble(capitalCostB0.getText()));
        datenliste.add( Double.parseDouble(capitalCostB1.getText()));
        datenliste.add( Double.parseDouble(materialCostB.getText()));
        datenliste.add( Double.parseDouble(unitCostB.getText()));

        datenliste.add( Double.parseDouble(marketPrice0.getText()));
        datenliste.add( Double.parseDouble(marketPrice1.getText()));
        datenliste.add( Double.parseDouble(marketPrice2.getText()));
        return datenliste;
    }

    private

    /**
     * this function switches the scenes
     * for diagram presentation
     * input is from scene before
     * @param event
     * @throws IOException
     */
    @FXML
    void showDiagrams(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("chart.fxml")); // create and load() view
        Stage stage = (Stage) showDiagrams.getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);

    }



    @FXML
    void update(KeyEvent event)
    {

    }




}






