
public class CallPreprocessedTfidfClass {
	public static void main(String args[]){
		
		String arg[] = {};
		
		GUIMain.main(arg);
		
		String input = GUIMain.inputWord;
		DocumentCluster pre = new DocumentCluster();
	//Main.runFromTerminal("Rscript plotValues.r all_keywords 1");
		pre.fuzzyCMeansWithoutPSO(input);
	//	pre.FuzzyCMeansWithPSO();
		
		

		Main.runFromTerminal("Rscript plotBar.r barTime names");
	    Main.runFromTerminal("Rscript plotiter.r iter names");
	}
}
