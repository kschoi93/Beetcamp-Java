
class Access1 {
	String userid="choi";
	String userpwd="choi1234";
	static String test = "Access1.static";
	private String pitest = "Access1.pi";
	Access1() {
		System.out.println("private test"+pitest);
	}
	
	void printData() {
		System.out.println("id="+ userid);
		System.out.println("pwd="+ userpwd);
	}

}
