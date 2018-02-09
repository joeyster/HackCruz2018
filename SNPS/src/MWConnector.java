public class MWConnector{
	private String cellSequence;
	private String timeFrame;
	private String timeInterval;
	private String aMutation;
	private String tMutation;
	private String gMutation;
	private String cMutation;
	private String textField;
	private String textField_1;
	private String textField_2;
	private String textField_3;
	private String textField_4;
	private String textField_5;
	private String textField_6;
	private String textField_7;
	private String textField_8;
	private String textField_9;
	private String textField_10;
	private String textField_11;

	//uses the constructor to pass variables to next window
	public MWConnector(String cellSequence, String aMutation, String tMutation, String gMutation, String cMutation, String textField, String textField_1, String textField_2, String textField_3, String textField_4, String textField_5, String textField_6, String textField_7, String textField_8, String textField_9, String textField_10, String textField_11, String timeFrame, String timeInterval){
		this.cellSequence = cellSequence;
		this.aMutation = aMutation;
		this.tMutation = tMutation;
		this.gMutation = gMutation;
		this.cMutation = cMutation;
		this.textField = textField;
		this.textField_1 = textField_1;
		this.textField_2 = textField_2;
		this.textField_3 = textField_3;
		this.textField_4 = textField_4;
		this.textField_5 = textField_5;
		this.textField_6 = textField_6;
		this.textField_7 = textField_7;
		this.textField_8 = textField_8;
		this.textField_9 = textField_9;
		this.textField_10 = textField_10;
		this.textField_11 = textField_11;
		this.timeFrame = timeFrame;
		this.timeInterval = timeInterval;
	}
	

	//used to eventually return a String array needed by TestGraph
	public String[] getArray() {
		String[] arr = new String[19];
		arr[0] = this.cellSequence;
		arr[1] = this.timeFrame;
		arr[2] = this.timeInterval;
		arr[3] = this.aMutation;
		arr[4] = this.tMutation;
		arr[5] = this.gMutation;
		arr[6] = this.cMutation;
		arr[7] = this.textField;
		arr[8] = this.textField_1;
		arr[9] = this.textField_2;
		arr[10] = this.textField_3;
		arr[11] = this.textField_4;
		arr[12] = this.textField_5;
		arr[13] = this.textField_6;
		arr[14] = this.textField_7;
		arr[15] = this.textField_8;
		arr[16] = this.textField_9;
		arr[17] = this.textField_10;
		arr[18] = this.textField_11;
		
		return arr;
	}
}