
public class BubbleSort {

	public static void main(String[] args) {
		int [] num = { 7, 5, 4, 6, 2, 1 , 10, 100, 20, 30, 21, 52, 33, 9, 5, 11, 8, 55, 44, 88, 99, 77, 66};
		int tmp ;
		for(int j=num.length-1; j>0; j--) {
			for(int i=0; i<j; i++) {
				if(num[i] > num[i+1]) {
					tmp = num[i];
					num[i] = num[i+1];
					num[i+1] = tmp;
				}
			}
		}
		
		for(int i=0; i<num.length;i++) {
			if(i==(num.length-1)) {
				System.out.print(num[i]);
				break;
			}
			System.out.print(num[i]+" , ");
		}
	}

}
