import java.util.Random;
import java.util.ArrayList;

public class EnvironmentalFactor{
	private String beneficialSeq;
	private float bsReproduction;
	private float bsDeath;
	private String cellSequence;
	private float reproductionChance;
	private float deathChance;
	private float aMutation;
	private float gMutation;
	private float tMutation;
	private float cMutation;

	private ArrayList<String> population = new ArrayList<>();

	public EnvironmentalFactor(String beneficialSeq, float bsReproduction, float bsDeath, String cellSequence, float reproductionChance, float deathChance,float aMutation, float gMutation, float tMutation, float cMutation){
		this.beneficialSeq = beneficialSeq;
		this.bsReproduction = bsReproduction;
		this.bsDeath = bsDeath;
		this.cellSequence = cellSequence;
		this.reproductionChance = reproductionChance;
		this.deathChance = deathChance;
		this.aMutation = aMutation;
		this.gMutation = gMutation;
		this.tMutation = tMutation;
		this.cMutation = cMutation;
	}

	public void isSurvival(){
		population.add(this.cellSequence);
		Random rng = new Random();
		int cellsLength = cellSequence.length();
		String newSequence = "";
		float n;
		float mutationTo;

		if(this.cellSequence.contains(this.beneficialSeq)){ //contains beneficial
			n = (float)(rng.nextInt(101))/100;
			if(n <= this.bsDeath){
				population.remove(population.size());
			}
			n = (float)(rng.nextInt(101))/100;
			if(n <= this.bsReproduction){
				for(int i = 0; i < cellsLength; i++){
					if (cellSequence.charAt(i) == 'A'){
						if ((float)(rng.nextInt(101))/100 < aMutation){
							mutationTo = (float)(rng.nextInt(101))/100;
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
						if ((float)(rng.nextInt(101))/100 < tMutation){
							mutationTo = (float)(rng.nextInt(101))/100;
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
						if ((float)(rng.nextInt(101))/100 < gMutation){
							mutationTo = (float)(rng.nextInt(101))/100;
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
						if ((float)(rng.nextInt(101))/100 < cMutation){
							mutationTo = (float)(rng.nextInt(101))/100;
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
				n = (float)(rng.nextInt(101))/100;
				if(n <= this.deathChance){
					population.remove(population.size());
				}
				n = (float)(rng.nextInt(101))/100;
				if(n <= this.reproductionChance){
					for(int i = 0; i < cellsLength; i++){
						if (cellSequence.charAt(i) == 'A'){
							if ((float)(rng.nextInt(101))/100 < aMutation){
								mutationTo = (float)(rng.nextInt(101))/100;
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
							if ((float)(rng.nextInt(101))/100 < tMutation){
								mutationTo = (float)(rng.nextInt(101))/100;
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
							if ((float)(rng.nextInt(101))/100 < gMutation){
								mutationTo = (float)(rng.nextInt(101))/100;
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
							if ((float)(rng.nextInt(101))/100 < cMutation){
								mutationTo = (float)(rng.nextInt(101))/100;
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
	}
}