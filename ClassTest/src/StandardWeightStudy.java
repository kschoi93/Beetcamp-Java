
public class StandardWeightStudy {
	// 멤버 변수
	int age;
	int gender;
	
	// 생성자 메소드
	public StandardWeightStudy() {// 매개변수가 없는 생성자 메소드는 컴파일시 javac.exe가 추가해준다
		// 실행부
	}
	public StandardWeightStudy(int a) {
		
	}
	// 메소드
	public void start() {
		age = CalendarObject.getInput("나이");//나이 
		gender = CalendarObject.getInput("성별(1:남성, 2:여성)");
		int height = CalendarObject.getInput("키");
		int weight = CalendarObject.getInput("현재체중");
		double standard = getStandardWeight(height);
		double standardIndex = (weight/standard)*100;//표준체중 지수
		String standardStr = standardStr(standardIndex);
		System.out.println("표준체중="+standard);
		System.out.println("당신은 표준체중지수는 "+standardIndex+"으로 "+standardStr+"입니다.");
	}
	
	// 표준체중 메소드 : 나이, 키
	// 표준체중을 리턴한다
	public double getStandardWeight(int height) {
		double idx = 0.90;
		if(age<=35 && gender == 2) idx = 0.85;
		if(age>=36 && gender == 1) idx = 0.95;
		double standard = (height-100)*idx;
		return standard;
	}
	//표준체중지수를 이용한 체형구하기
	public String standardStr(double idx) {
		String result = "";
		if(idx < 86) result = "마른형";
		else if (idx<96) result = "조금마른형";
		else if (idx<116) result = "표준형";
		else if (idx<126) result = "조금비만형";
		else result = "비만형";
		
		return result;
	}
	
	
	public static void main(String[] args) {
		StandardWeight sw = new StandardWeight();
		sw.start();
	}

}
