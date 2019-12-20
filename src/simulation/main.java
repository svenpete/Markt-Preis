package simulation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class main extends Application
{
    public static void main(String [] args)
    {
        launch(args);

    }


    @Override
    public void start(Stage stage)
    {
        try
        {
            stage.setTitle("Marktkonkurrenz");
            //defining the axes
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();

            Simulation simulation = new Simulation();
            simulation.simulate(800,1);

            xAxis.setLabel("Zeit");
            yAxis.setLabel("Marketprice");

            //creating the chart
            final LineChart<Number,Number> lineChart =
                    new LineChart<Number,Number>(xAxis,yAxis);



            lineChart.setTitle("Preis");

            //defining a series
            XYChart.Series seriesMar= new XYChart.Series();
            XYChart.Series seriesPro = new XYChart.Series();
            XYChart.Series seriesTotalProduction = new XYChart.Series();
            XYChart.Series seriesAProduc = new XYChart.Series();
            XYChart.Series seriesBProduc = new XYChart.Series();

            seriesMar.setName("Marketprice");
            seriesTotalProduction.setName("Total Production");
            seriesPro.setName("ProductionCapacity");

            //populating the series with data
            double time = 0.00;
            for (int i = 0; i < simulation.getMarketPrice().length ; i++) {
                double y = simulation.getMarketPrice(i);
                double y2 = simulation.getTotalProduction(i);
                double y3 = simulation.getProduktionsKapazitätA(i);
                double y4 = simulation.getProduktionsKapazitätB(i);


                //seriesMar.getData().add(new XYChart.Data(time, y));
                //seriesTotalProduction.getData().add(new XYChart.Data(time,y2));
                seriesAProduc.getData().add(new XYChart.Data(time,y3));
                //seriesPro.getData().add(new XYChart.Data(i,yProduc));
                time+= 0.0625;
            }
            lineChart.getData().addAll(seriesAProduc);
            Group root = new Group(lineChart);
            Scene scene  = new Scene(root,800,600);

            //scene scene2 = new Scene(lineChart2, 800,600);

            //lineChart2.getData().add(seriesProfit);

            //Creating a Group object


            lineChart.setCreateSymbols(false);


            //lineChart.getData().add(seriesProfit);

            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
