package iva.com.beispiele;

public class ReadExperiment {
	//static String[] argss;
	public ReadExperiment(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//argss = args;
		ReadExperiment re = new ReadExperiment();
		re.test(args);
		
	}
	public void test(String[] args){
		Experiment e = new Experiment(100, args);
		ExperimentInterface[] arr = new ExperimentInterface[2];
		arr[0] =  new Experiment(20, args);
		arr[1] =  new Experiment1();
		arr[0].zeige();
		arr[1].zeige();
	}

}
