import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.collections.FXCollections;

/**
 * A simulated stock line chart.
 *
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.LineChart
 * @see javafx.scene.chart.NumberAxis
 * @see javafx.scene.chart.XYChart
 */
public class TestGraph extends Application {

    private XYChart.Series<String, Number> mainSeries;
    private Timeline animation;

/*    private double hours = 0;
    private double minutes = 0;
    private double timeInHours = 0;
    private double prevY = 10;
    private double y = 10;*/
    
    private double x;
    private int speed = 1;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        root.getChildren().add(createChart());
        root.getChildren().add(createStartButton());
        root.getChildren().add(createStopButton());
        root.getChildren().add(createSpeedButton());
        // create timeline to add new data every 60th of second
        animation = new Timeline();
        //Can set rate of animation, 2 = 2x speed
        //animation.setRate(2);
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                // 6 minutes data per frame
/*                for(int count=0; count < 6; count++) {
                    nextTime();
                    plotTime();
                }*/
            	plotTime();
            }
        }));
        animation.setCycleCount(Animation.INDEFINITE);
    }
    
    protected Button createStartButton() {
    	Button bn = new Button("Start");
    	bn.setOnAction(actionEvent -> {
    		animation.play();
    	});
    	bn.setTranslateX(5);
    	return bn;
    }
    
    protected Button createStopButton() {
    	Button bn = new Button("Stop");
    	bn.setOnAction(actionEvent -> {
    		animation.pause();
    	});
    	bn.setTranslateX(58);
    	return bn;
    }
    
    protected Button createSpeedButton() {
    	Button bn = new Button("1x");
    	bn.setOnAction(actionEvent -> {
    		speed++;
    		if(speed > 3) speed = 1;
    		bn.setText(speed + "x");
    		animation.setRate(speed);
    	});
    	bn.setTranslateY(38);
    	bn.setTranslateX(5);
    	return bn;
    }
    
    protected BarChart<String, Number> createChart() {
    	//setup axes
    	final CategoryAxis xAxis = new CategoryAxis(FXCollections.observableArrayList("Survival Cells", "Non-survival Cells"));
    	final NumberAxis yAxis = new NumberAxis(0,100,10);
    	
    	//setup initial barss
    	mainSeries = new XYChart.Series<String, Number>();
        x = Math.random()*100;
        mainSeries.getData().add(new XYChart.Data<String,Number>("Survival Cells", x));
        mainSeries.getData().add(new XYChart.Data<String,Number>("Non-Survival Cells", 100-x));
        
        //setup barchart
    	final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
    	bc.setAnimated(false);
    	bc.setLegendVisible(false);
    	bc.setTitle("Single Nucleotide Polymorphism Simulator");
    	yAxis.setLabel("Distribution of cells");
    	yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, "%"));
    	bc.setTranslateX(76);
    	bc.getData().add(mainSeries);
    	return bc;
    }

/*    protected LineChart<Number, Number> createChart() {
        xAxis = new NumberAxis(0,24,3);
        final NumberAxis yAxis = new NumberAxis(0,100,10);
        final LineChart<Number,Number> lc = new LineChart<Number,Number>(xAxis,yAxis);
        // setup chart
        lc.setId("lineStockDemo");
        lc.setCreateSymbols(false);
        lc.setAnimated(false);
        lc.setLegendVisible(false);
        lc.setTitle("Single Nucleotide Polymorphism Simulator");
        xAxis.setLabel("Time");
        xAxis.setForceZeroInRange(false);
        yAxis.setLabel("Survival Rate");
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,null,"%"));
        // add starting data
        hourDataSeries = new XYChart.Series<Number,Number>();
        hourDataSeries.setName("Hourly Data");
        minuteDataSeries = new XYChart.Series<Number,Number>();
        minuteDataSeries.setName("Minute Data");
        // create some starting data
        hourDataSeries.getData().add(new XYChart.Data<Number,Number>(timeInHours,prevY));
        minuteDataSeries.getData().add(new XYChart.Data<Number,Number>(timeInHours,prevY));
        for (double m=0; m<(60); m++) {
            nextTime();
            plotTime();
        }
        lc.getData().add(minuteDataSeries);
        lc.getData().add(hourDataSeries);
        lc.setTranslateX(76);
        return lc;
    }*/

/*    private void nextTime() {
        if (minutes == 59) {
            hours ++;
            minutes = 0;
        } else {
            minutes ++;
        }
        timeInHours = hours + ((1d/60d)*minutes);
    }*/

    private void plotTime() {
/*        if ((timeInHours % 1) == 0) {
            // change of hour
            double oldY = y;
            y = prevY - 10 + (Math.random()*20);
            prevY = oldY;
            while (y < 10 || y > 90) y = y - 10 + (Math.random()*20);
            hourDataSeries.getData().add(new XYChart.Data<Number, Number>(timeInHours, prevY));
            // after 25hours delete old data
            if (timeInHours > 25) hourDataSeries.getData().remove(0);
            // every hour after 24 move range 1 hour
            if (timeInHours > 24) {
                xAxis.setLowerBound(xAxis.getLowerBound()+1);
                xAxis.setUpperBound(xAxis.getUpperBound()+1);
            }
        }
        double min = (timeInHours % 1);
        double randomPickVariance = Math.random();
        if (randomPickVariance < 0.3) {
            double minY = prevY + ((y-prevY) * min) - 4 + (Math.random()*8);
            minuteDataSeries.getData().add(new XYChart.Data<Number,Number>(timeInHours,minY));
        } else if (randomPickVariance < 0.7) {
            double minY = prevY + ((y-prevY) * min) - 6 + (Math.random()*12);
            minuteDataSeries.getData().add(new XYChart.Data<Number,Number>(timeInHours,minY));
        } else if (randomPickVariance < 0.95) {
            double minY = prevY + ((y-prevY) * min) - 10 + (Math.random()*20);
            minuteDataSeries.getData().add(new XYChart.Data<Number,Number>(timeInHours,minY));
        } else {
            double minY = prevY + ((y-prevY) * min) - 15 + (Math.random()*30);
            minuteDataSeries.getData().add(new XYChart.Data<Number,Number>(timeInHours,minY));
        }
        // after 25hours delete old data
        if (timeInHours > 25) minuteDataSeries.getData().remove(0);*/
        x = Math.random()*100;
        mainSeries.getData().add(new XYChart.Data<String,Number>("Survival Cells", x));
        mainSeries.getData().add(new XYChart.Data<String,Number>("Non-survival Cells", 100-x));
    }

   public void play() {
        animation.play();
    }

    @Override public void stop() {
        animation.pause();
    }    

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
        play();
    }
    public static void main(String[] args) { launch(args); }
}
