import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.List;

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
    
    private String cellSequence;
    private String beneficialSeq;
    private boolean introd;
    private int cycles = 0;
    private int speed = 1;
    private int max = 0;
    
    //mid, preEF populations
    private int midSurPop = 0;
    private int midNonPop = 0;
    private int midPop = 0;
    private int midPopAfter = 0;
    
    //final populations
    private int finSurPop = 0;
    private int finNonPop = 0;
    private int finPop = 0;

    private void init(Stage primaryStage) {
    	//obtain needed parameters..............................
    	List<String>stats = this.getParameters().getUnnamed();
    	cellSequence = stats.get(0);
    	double timeFrame = Double.parseDouble(stats.get(1));
    	double timeInterval = Double.parseDouble(stats.get(2));
    	double aMutation = Double.parseDouble(stats.get(3));
    	double tMutation= Double.parseDouble(stats.get(4));
    	double gMutation = Double.parseDouble(stats.get(5));
    	double cMutation = Double.parseDouble(stats.get(6));
    	double textField = Double.parseDouble(stats.get(7));
    	double textField_1= Double.parseDouble(stats.get(8));
    	double textField_2 = Double.parseDouble(stats.get(9));
    	double textField_3 = Double.parseDouble(stats.get(10));
    	double textField_4 = Double.parseDouble(stats.get(11));
    	double textField_5 = Double.parseDouble(stats.get(12));
    	double textField_6 = Double.parseDouble(stats.get(13));
    	double textField_7 = Double.parseDouble(stats.get(14));
    	double textField_8 = Double.parseDouble(stats.get(15));
    	double textField_9 = Double.parseDouble(stats.get(16));
    	double textField_10 = Double.parseDouble(stats.get(17));
    	double textField_11 = Double.parseDouble(stats.get(18));
    	beneficialSeq = (stats.get(19));
    	double bsDeath = Double.parseDouble(stats.get(20));
    	double bsReproduction = Double.parseDouble(stats.get(21));
    	double introTime = Double.parseDouble(stats.get(22));
    	double deathChance = Double.parseDouble(stats.get(23));
    	double reproductionChance = Double.parseDouble(stats.get(24));

    	EnvironmentalFactor ef = new EnvironmentalFactor();
    	//initialize first cell, assign delivered survival sequence
    	ef.getPop().add(cellSequence);
    	ef.setbeneficialSeq(beneficialSeq);
    	//check if starting sequence has beneficial sequence
    	if(cellSequence.contains(beneficialSeq)) ef.surcellinc();
    	cycles = 0;
    	introd = false;
    	
    	Label lbl = new Label("Cell Population:\n1");
    	lbl.setTranslateY(76);
    	lbl.setTranslateX(5);
    	
    	Label lbl2 = new Label("Current Time:\n0 s");
    	lbl2.setTranslateY(286);
    	lbl2.setTranslateX(5);
    	
    	Label lbl3 = new Label("Is EF TRUE?: OFF");
    	lbl3.setTranslateY(336);
    	lbl3.setTranslateX(5);
    	
    	Label lbl4 = new Label("Max Population:\n1");
    	lbl4.setTranslateY(236);
    	lbl4.setTranslateX(5);
    	
    	Label lbl5 = new Label("Survivor Cell\nPopulation:\n???");
    	lbl5.setTranslateY(116);
    	lbl5.setTranslateX(5);
    	
    	Label lbl6 = new Label("Non-Survivor Cell\nPopulation:\n???");
    	lbl6.setTranslateY(176);
    	lbl6.setTranslateX(5);
    	
    	//add in all elements into stage
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        root.getChildren().add(createChart(cellSequence.contains(beneficialSeq), false));
        root.getChildren().add(createStartButton());
        root.getChildren().add(createStopButton());
        root.getChildren().add(createSpeedButton());
//        root.getChildren().add(createResetButton());
        root.getChildren().add(lbl);
        root.getChildren().add(lbl2);
        root.getChildren().add(lbl3);
        root.getChildren().add(lbl4);
        root.getChildren().add(lbl5);
        root.getChildren().add(lbl6);
        //SET TIMELINE
        // KeyFrame = interval
        animation = new Timeline();
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(timeInterval*1000), new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                // 6 minutes data per frame
/*                for(int count=0; count < 6; count++) {
                    nextTime();
                    plotTime();
                }*/
            	if(!ef.getPop().isEmpty()) {
                	//update cell population
            		int statikksize = ef.getPop().size();
            		if(timeInterval*cycles > introTime) {
            			if(!introd) {
            				introd = true;
            				midSurPop = ef.getSurcell();
            				midNonPop = ef.getPop().size()-midSurPop;
            				midPop = ef.getPop().size();
            			}
            			
            			for(int i=0; i < statikksize; i++) {
            				//after intro time, ef rates
            				if(!ef.isSurvival(ef.getPop().get(i), true, i, bsDeath, bsReproduction, aMutation, tMutation, gMutation, cMutation, deathChance, reproductionChance,
            						textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6,
            						textField_7, textField_8, textField_9, textField_10, textField_11))
            					i--;
            					statikksize--;
            			}
            		} else {
            			//before intro time, 100% repro rate, 0% death rate
            			for(int i=0; i < statikksize; i++) {
            				ef.isSurvival(ef.getPop().get(i), false, i, 0, 0, aMutation, tMutation, gMutation, cMutation, 0, 1,
            						textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6,
            						textField_7, textField_8, textField_9, textField_10, textField_11);
            			}
            		}
            		plotTime((double)ef.getPop().size(), (double)ef.getSurcell());
            		//Input population here
            		lbl.setText("Cell Population:\n" + ef.getPop().size());
            		lbl2.setText("Current Time:\n" + Math.round(timeInterval*cycles+1) + " s");            		
            		if(introTime < timeInterval*cycles+2) lbl3.setText("Is EF TRUE?: " + "ON");            		
            		if(ef.getPop().size() > max) max = ef.getPop().size();
            		lbl4.setText("Max Population:\n" + max); 
            		lbl5.setText("Survivor Cell\nPopulation:\n" + ef.getSurcell()); 
            		lbl6.setText("Non-Survivor Cell\nPopulation:\n" + (ef.getPop().size() - ef.getSurcell()) ); 
            		cycles++;
            		if(cycles == (int)Math.floor(timeFrame/timeInterval)) {
            			finSurPop = ef.getSurcell();
            			finNonPop = ef.getPop().size()-finSurPop;
            			finPop = ef.getPop().size();
            			Button bn = new Button("Stats");
            			bn.setPrefSize(45, 25);
            			bn.setTranslateX(58);
            			bn.setTranslateY(38);
            			bn.setOnAction(event -> {
            				scene2(primaryStage);
            			});
            			root.getChildren().add(bn);
            		}	
            	} else {
            		plotTime(0,0);
            		lbl.setText("Cell Population:\n" + "0");
            		max = 1;
            		cycles++;
            		if(cycles == (int)Math.floor(timeFrame/timeInterval)) {
            			finSurPop = 0;
            			finNonPop = 0;
            			finPop = 0;
            			Button bn = new Button("Stats");
            			bn.setPrefSize(45, 25);
            			bn.setTranslateX(58);
            			bn.setTranslateY(38);
            			bn.setOnAction(event -> {
            				scene2(primaryStage);
            			});
            			root.getChildren().add(bn);
            		}	
            	}
            }
        }));
        
        //Lifetime/interval = cycles
        animation.setCycleCount((int)Math.floor(timeFrame/timeInterval));
    }
    
    void scene2(Stage primaryStage) {
        Group root2 = new Group();
        Scene sn = new Scene(root2);
        lblset(root2);
        primaryStage.setScene(sn);
    }
    
    protected void lblset(Group root2) {
    	Label startseq = new Label("Start Sequence: " + cellSequence);
    	startseq.setWrapText(true);
    	startseq.setPrefWidth(200);
    	startseq.setTranslateX(5);
    	Label surseq = new Label("Survival Sequence: " + beneficialSeq);
    	surseq.setWrapText(true);
    	surseq.setPrefWidth(200);
    	surseq.setTranslateX(5);
    	surseq.setTranslateY(300);
    	Label midpop = new Label("Pre-EF Cell Population:\n" + midPop);
    	midpop.setTranslateX(405);
    	midpop.setWrapText(true);
    	midpop.setPrefWidth(200);
    	Label midsurpop = new Label("Pre-EF Survival Cell Population:\n" + midSurPop);
    	midsurpop.setTranslateX(405);
    	midsurpop.setWrapText(true);
    	midsurpop.setPrefWidth(200);
    	midsurpop.setTranslateY(35);
    	Label midnonpop = new Label("Pre-EF Non-Survival Cell Population:\n" + midNonPop);
    	midnonpop.setTranslateX(405);
    	midnonpop.setWrapText(true);
    	midnonpop.setPrefWidth(200);
    	midnonpop.setTranslateY(70);
    	Label finalpop = new Label("Final Cell Population:\n" + finPop);
    	finalpop.setTranslateX(205);
    	finalpop.setWrapText(true);
    	finalpop.setPrefWidth(200);
    	Label finsurpop = new Label("Final Survival Cell Population:\n" + finSurPop);
    	finsurpop.setTranslateX(205);
    	finsurpop.setWrapText(true);
    	finsurpop.setPrefWidth(200);
    	finsurpop.setTranslateY(35);
    	Label finnonpop = new Label("Final Non-Survival Cell Population:\n" + finNonPop);
    	finnonpop.setTranslateX(205);
    	finnonpop.setWrapText(true);
    	finnonpop.setPrefWidth(200);
    	finnonpop.setTranslateY(70);
    	Label maxpop = new Label("Cell Population Max:\n" + max);
    	maxpop.setTranslateX(205);
    	maxpop.setTranslateY(105);
    	maxpop.setWrapText(true);
    	maxpop.setPrefWidth(200);
//    	Label efdeathtoll = new Label("EF Initial Death Toll\n" + midpop-);
//    	efdeathtoll.setTranslateX(205);
//    	efdeathtoll.setTranslateY(140);
//    	efdeathtoll.setWrapText(true);
//    	efdeathtoll.setPrefWidth(200);
    	
    	root2.getChildren().add(startseq);
    	root2.getChildren().add(finalpop);
    	root2.getChildren().add(maxpop);
    	root2.getChildren().add(finsurpop);
    	root2.getChildren().add(finnonpop);
    	root2.getChildren().add(midpop);
    	root2.getChildren().add(midsurpop);
    	root2.getChildren().add(midnonpop);
    	root2.getChildren().add(surseq);
//    	root2.getChildren().add(efdeathtoll);
    }
/////TODO RESET?
/*    protected Button createResetButton() {
    	Button bn = new Button("Reset");
    	bn.setPrefSize(45, 25);
    	bn.setOnAction(actionEvent -> {
    		animation.play();
    	});
    	bn.setTranslateX(58);
    	bn.setTranslateY(38);
    	return bn;
    }*/
    
    protected Button createStartButton() {
    	Button bn = new Button("Start");
    	bn.setPrefSize(45, 25);
    	bn.setOnAction(actionEvent -> {
    		animation.play();
    	});
    	bn.setTranslateX(5);
    	return bn;
    }
    
    protected Button createStopButton() {
    	Button bn = new Button("Stop");
    	bn.setPrefSize(45, 25);
    	bn.setOnAction(actionEvent -> {
    		animation.pause();
    	});
    	bn.setTranslateX(58);
    	return bn;
    }
    
    protected Button createSpeedButton() {
    	Button bn = new Button("1x");
    	bn.setPrefSize(45, 25);
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
    
    protected BarChart<String, Number> createChart(boolean isSur, boolean mid) {
    	//setup axes
    	final CategoryAxis xAxis = new CategoryAxis(FXCollections.observableArrayList("Survival Cells", "Non-Survival Cells"));
    	final NumberAxis yAxis = new NumberAxis(0,100,10);
    	
    	//setup initial barss
    	mainSeries = new XYChart.Series<String, Number>();
        int n;
        //check if initial cell was survival cell
        if(isSur) {
        	n = 100;
        } else {
        	n = 0;
        }
    	
        mainSeries.getData().add(new XYChart.Data<String,Number>("Survival Cells", n));
        mainSeries.getData().add(new XYChart.Data<String,Number>("Non-Survival Cells", 100-n));
        
        //setup barchart
    	final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
    	bc.setAnimated(false);
    	bc.setLegendVisible(false);
    	bc.setTitle("Single Nucleotide Polymorphism Simulator");
    	yAxis.setLabel("Distribution of cells");
    	yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, "%"));
    	bc.setTranslateX(76);
    	
    	//bring data into chart
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

    private void plotTime(double popSize, double surSize) {
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
        mainSeries.getData().add(new XYChart.Data<String,Number>("Survival Cells", surSize/popSize*100.0));
        mainSeries.getData().add(new XYChart.Data<String,Number>("Non-Survival Cells", 100.0-(surSize/popSize*100.0)));
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
//        init2(primaryStage);
//        primaryStage.show();
//        play();
    }
    public static void main(String[] args) { launch(args); }
}
