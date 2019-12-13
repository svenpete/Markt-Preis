package simulation;

import javafx.application.Application;
import javafx.scene.Scene;
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
            stage.setTitle("Line Chart Sample");
            //defining the axes
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();

            Simulation simulation = new Simulation();
            simulation.simulate(1,320,1);

            xAxis.setLabel("Preis und Markt");

            //creating the chart
            final LineChart<Number,Number> lineChart =
                    new LineChart<Number,Number>(xAxis,yAxis);

            lineChart.setTitle("Preis");

            //defining a series
            XYChart.Series seriesMar= new XYChart.Series();
            XYChart.Series seriesPro = new XYChart.Series();
            XYChart.Series seriesProfit = new XYChart.Series();

            seriesMar.setName("Marketprice");
            seriesProfit.setName("Profit");
            seriesPro.setName("ProductionCapacity");

            //populating the series with data
            for (int i = 1; i < 320; i++) {
                double y = simulation.getMarketPrice(i);
                double y2 = simulation.getProfit(i);
                double y3 = simulation.getProduktionsKapazität(i);
                //seriesMar.getData().add(new XYChart.Data(i, y));
                //seriesProfit.getData().add(new XYChart.Data(i,y2));
                seriesPro.getData().add(new XYChart.Data(i,y3));
            }

            lineChart.getData().addAll(seriesMar,seriesPro);
            Scene scene  = new Scene(lineChart,800,600);



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
