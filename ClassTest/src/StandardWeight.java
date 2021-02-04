import java.util.Scanner;

public class StandardWeight {

	/*public StandardWeight() {

	}*/
	
	// 이름, 스펙 작성
	public int getInput(String information) {
		Scanner scan = new Scanner(System.in);
		System.out.print(information + " = ");
		return scan.nextInt();
	}
	
	// 표준체중
	public double avgWeight(int ag, int se, int hei) {
		double avgWeight = 0;
		//표준체중 기준 = 35세 이하, 36세 이상
		if(ag <= 35 && se == 1) avgWeight = (hei-100)*(0.90);
		else if(ag >= 36 && se == 1) avgWeight = (hei-100)*(0.95);
			
		if(ag <= 35 && se == 2) avgWeight = (hei-100)*(0.85);
		else if(ag >= 36 && se == 2) avgWeight = (hei-100)*(0.90);
		
		return avgWeight;
	}
	
	// 입력 기준 표준체중 지수 계산
	public double avgWeightIndex(int now, int avg) {
		
		double sum = ((double)now/(double)avg)*100;
		
		return sum;
	}
	
	// 표준체중지수 평가기준
	public String CalcuratorStandard(double d) {
		String str = "";
		if(d<=85) str = "마른형";
		else if(d >= 86 && d <= 95) str = "조금마른형";
		else if(d >= 96 && d <= 115) str = "표준형";
		else if(d >= 116 && d <= 125) str = "조금비만형";
		else if(d >= 126) str = "비만형";
		
		return str;
	}
	
	
	// 표준체중 기준 작성
	public void start() {
		int age = getInput("나이");
		int sex = getInput("성별(1:남성,2:여성)");
		int height = getInput("키");
		int nowWeight = getInput("현재체중");
		int avg = (int)avgWeight(age,sex,height); System.out.println("표준체중 = " + avg);
		System.out.printf("당신은 표중체중지수는 %17.14f으로 %s입니다",avgWeightIndex(nowWeight,avg),CalcuratorStandard(avgWeightIndex(nowWeight,avg)));
		
	}
	

}
