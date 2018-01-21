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
	private int surcell;

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
		surcell = 0;
	}
	//surcell is counter for cells in population with survival sequences "survival cells"
	public void surcellinc() {
		surcell++;
	}
	
	public int getSurcell() {
		return surcell;
	}
	//for assigning value from TestGraph
	public void setbeneficialSeq(String ben) {
		this.beneficialSeq = ben;
	}
	
	public ArrayList<String> getPop() {return population;}
	
	public boolean isSurvival(String cellSequence, boolean introd, int index, double bsDeath, double bsReproduction, 
			double aMutation, double tMutation, double gMutation, double cMutation, double deathChance, double reproductionChance,
			double atot, double atog, double atoc, double ttoa, double ttog, double ttoc, double gtoa, 
			double gtot, double gtoc, double ctoa, double ctot, double ctog, String bsLocation){
		
		Random rng = new Random();
		int cellsLength = cellSequence.length();
		String newSequence = "";
		double n;
		double mutationTo;
		
		if(!bsLocation.equals("")) {
			int start = Integer.parseInt(bsLocation);
			String ssSequence = cellSequence.substring(start, start + beneficialSeq.length());
			if(beneficialSeq.equals(ssSequence)) {
				n = (double)(rng.nextInt(101))/100;
				if(n <= bsDeath){
					population.remove(index);
					surcell--;
					//return false to trigger decrement of indices
					return false;
				}
				n = (double)(rng.nextInt(101))/100;
				if(n <= bsReproduction){
					for(int i = 0; i < cellsLength; i++){
						if (cellSequence.charAt(i) == 'A'){
							if ((double)(rng.nextInt(101))/100 < aMutation){
								mutationTo = (double)(rng.nextInt(101))/100;
								if(mutationTo < atot){
									newSequence+="T";
								}
								else if(mutationTo <= (atog+atot)){
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
								if(mutationTo < ttoa){
									newSequence+="A";
								}
								else if(mutationTo <= (ttog+ttoa)){
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
								if(mutationTo < gtot){
									newSequence+="T";
								}
								else if(mutationTo <= (gtot+gtoa)){
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
								if(mutationTo < ctot){
									newSequence+="T";
								}
								else if(mutationTo < (ctot+ctog)){
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
		else {
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
							if(mutationTo < atot){
								newSequence+="T";
							}
							else if(mutationTo <= (atot+atog)){
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
							if(mutationTo < ttoa){
								newSequence+="A";
							}
							else if(mutationTo <= (ttoa+ttog)){
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
							if(mutationTo < gtot){
								newSequence+="T";
							}
							else if(mutationTo <= (gtoa+gtot)){
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
							if(mutationTo < ctot){
								newSequence+="T";
							}
							else if(mutationTo <= (ctot+ctog)){
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
		if(cellSequence.contains(this.beneficialSeq) && introd == true){ //contains beneficial
			n = (double)(rng.nextInt(101))/100;
			if(n <= bsDeath){
				population.remove(index);
				surcell--;
				//return false to trigger decrement of indices
				return false;
			}
			n = (double)(rng.nextInt(101))/100;
			if(n <= bsReproduction){
				for(int i = 0; i < cellsLength; i++){
					if (cellSequence.charAt(i) == 'A'){
						if ((double)(rng.nextInt(101))/100 < aMutation){
							mutationTo = (double)(rng.nextInt(101))/100;
							if(mutationTo < atot){
								newSequence+="T";
							}
							else if(mutationTo <= (atog+atot)){
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
							if(mutationTo < ttoa){
								newSequence+="A";
							}
							else if(mutationTo <= (ttog+ttoa)){
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
							if(mutationTo < gtot){
								newSequence+="T";
							}
							else if(mutationTo <= (gtot+gtoa)){
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
							if(mutationTo < ctot){
								newSequence+="T";
							}
							else if(mutationTo < (ctot+ctog)){
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
		else { //doesnt contain beneficial
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
							if(mutationTo < atot){
								newSequence+="T";
							}
							else if(mutationTo <= (atot+atog)){
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
							if(mutationTo < ttoa){
								newSequence+="A";
							}
							else if(mutationTo <= (ttoa+ttog)){
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
							if(mutationTo < gtot){
								newSequence+="T";
							}
							else if(mutationTo <= (gtoa+gtot)){
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
							if(mutationTo < ctot){
								newSequence+="T";
							}
							else if(mutationTo <= (ctot+ctog)){
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
		population.add(newSequence);
		if(newSequence.contains(this.beneficialSeq)) surcell++;
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