import java.util.Random;
import java.util.ArrayList;

public class EnvironmentalFactor{
	private String beneficialSeq;
	private String bsDeath;
	private String bsReproduction;
	private String bsLocation;
	private String introTime;
	private String deathChance;
	private String reproductionChance;

	private ArrayList<String> population = new ArrayList<>();

	public EnvironmentalFactor(String beneficialSeq, String bsDeath, String bsReproduction, String bsLocation, String introTime, String deathChance, String reproductionChance){
		this.beneficialSeq = beneficialSeq;
		this.bsDeath = bsDeath;
		this.bsLocation = bsLocation;
		this.introTime = introTime;
		this.bsReproduction = bsReproduction;
		this.deathChance = deathChance;
		this.reproductionChance = reproductionChance;
	}
	
	public EnvironmentalFactor() {
	}
	
	public ArrayList<String> getPop() {return population;}

	public boolean isSurvival(String cellSequence, boolean introd, int index, double bsDeath, double bsReproduction, 
			double aMutation, double tMutation, double gMutation, double cMutation, double deathChance, double reproductionChance){

		Random rng = new Random();
		int cellsLength = cellSequence.length();
		String newSequence = "";
		double n;
		double mutationTo;

		if(cellSequence.contains(this.beneficialSeq) && introd == true){ //contains beneficial
			n = (double)(rng.nextInt(101))/100;
			if(n <= bsDeath){
				population.remove(index);
				return false;
			}
			n = (double)(rng.nextInt(101))/100;
			if(n <= bsReproduction){
				for(int i = 0; i < cellsLength; i++){
					if (cellSequence.charAt(i) == 'A'){
						if ((double)(rng.nextInt(101))/100 < aMutation){
							mutationTo = (double)(rng.nextInt(101))/100;
							if(mutationTo < 0.33){
								newSequence+="T";
							}
							else if(mutationTo < 0.66){
								newSequence+="G";
							}
							else{
								newSequence+="C";
							}
						}else {
							newSequence+="A";
						}
					}
					if (cellSequence.charAt(i) == 'T'){
						if ((double)(rng.nextInt(101))/100 < tMutation){
							mutationTo = (double)(rng.nextInt(101))/100;
							if(mutationTo < 0.33){
								newSequence+="A";
							}
							else if(mutationTo < 0.66){
								newSequence+="G";
							}
							else{
								newSequence+="C";
							}
						}else {
							newSequence+="T";
						}
					}
					if (cellSequence.charAt(i) == 'G'){
						if ((double)(rng.nextInt(101))/100 < gMutation){
							mutationTo = (double)(rng.nextInt(101))/100;
							if(mutationTo < 0.33){
								newSequence+="T";
							}
							else if(mutationTo < 0.66){
								newSequence+="A";
							}
							else{
								newSequence+="C";
							}
						}else{
							newSequence+="G";
						}
					}
					if (cellSequence.charAt(i) == 'C'){
						if ((double)(rng.nextInt(101))/100 < cMutation){
							mutationTo = (double)(rng.nextInt(101))/100;
							if(mutationTo < 0.33){
								newSequence+="T";
							}
							else if(mutationTo < 0.66){
								newSequence+="G";
							}
							else{
								newSequence+="A";
							}
						}else {
							newSequence+="C";
						}
					}
				}
				
			}
			else{ //doesnt contain beneficial
				n = (double)(rng.nextInt(101))/100;
				if(n <= deathChance){
					population.remove(index);
					return false;
				}
				n = (double)(rng.nextInt(101))/100;
				if(n <= reproductionChance){
					for(int i = 0; i < cellsLength; i++){
						if (cellSequence.charAt(i) == 'A'){
							if ((double)(rng.nextInt(101))/100 < aMutation){
								mutationTo = (double)(rng.nextInt(101))/100;
								if(mutationTo < 0.33){
									newSequence+="T";
								}
								else if(mutationTo < 0.66){
									newSequence+="G";
								}
								else{
									newSequence+="C";
								}
							}else {
								newSequence+="A";
							}
						}
						if (cellSequence.charAt(i) == 'T'){
							if ((double)(rng.nextInt(101))/100 < tMutation){
								mutationTo = (double)(rng.nextInt(101))/100;
								if(mutationTo < 0.33){
									newSequence+="A";
								}
								else if(mutationTo < 0.66){
									newSequence+="G";
								}
								else{
									newSequence+="C";
								}
							}else {
								newSequence+="T";
							}
						}
						if (cellSequence.charAt(i) == 'G'){
							if ((double)(rng.nextInt(101))/100 < gMutation){
								mutationTo = (double)(rng.nextInt(101))/100;
								if(mutationTo < 0.33){
									newSequence+="T";
								}
								else if(mutationTo < 0.66){
									newSequence+="A";
								}
								else{
									newSequence+="C";
								}
							}else{
								newSequence+="G";
							}
						}
						if (cellSequence.charAt(i) == 'C'){
							if ((double)(rng.nextInt(101))/100 < cMutation){
								mutationTo = (double)(rng.nextInt(101))/100;
								if(mutationTo < 0.33){
									newSequence+="T";
								}
								else if(mutationTo < 0.66){
									newSequence+="G";
								}
								else{
									newSequence+="A";
								}
							}else {
								newSequence+="C";
							}
						}
					}
				}
			}
		}
		population.add(newSequence);
		return true;
	}
	public String[] getArray() {
		String[] arr = new String[7];
		arr[0] = this.beneficialSeq;
		arr[1] = this.bsDeath;
		arr[2] = this.bsReproduction;
		arr[3] = this.bsLocation;
		arr[4] = this.introTime;
		arr[5] = this.deathChance;
		arr[6] = this.reproductionChance;
		
		return arr;
	}
}