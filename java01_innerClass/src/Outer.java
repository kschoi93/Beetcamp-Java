public class Outer{
	int data = 10;
	public Outer(){start();}
	public void start() {
		class Inner{
			Inner(){}
			public void msg(){
				System.out.println("data ="+data);
		    }
		}
		Inner in = new Inner();
		in.msg();
	}
	
  public static void main(String[] args){
    Outer out = new Outer();
    
  }
}
