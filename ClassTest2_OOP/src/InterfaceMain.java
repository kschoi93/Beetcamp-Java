import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

//implements : �겢�옒�뒪�뿉�꽌 interface瑜� �긽�냽諛쏆쓣�븣
// 				�씤�꽣�럹�씠�뒪�뒗 �뿬�윭媛쒕�� �긽�냽諛쏆쓣 �닔 �엲�떎
//				�긽�냽諛쏆� 紐⑤뱺 異붿긽 硫붿냼�뱶瑜� �삤踰꾨씪�씠�뵫 �빐�빞�븳�떎
public class InterfaceMain implements InterfaceTest, ActionListener {

	public InterfaceMain() {
		// TODO Auto-generated constructor stub
	}
	//異붿긽硫붿냼�뱶 �삤踰꾨씪�씠�뵫
	public void print() {
		System.out.println(global+"-->"+MAX);
	}
	public int[] recordAll(int num) {
		Random r= new Random();
		int ran[] = new int[num];
		
		for(int i=0; i<ran.length; i++) {
			ran[i] = r.nextInt(100);
		}
		return ran;
	}
	public String total(int max) {
		return "total";
	}
	public double getData(int data) {
		return (double)data;
	}
	public void actionPerformed(ActionEvent ae) {}
	
	public static void main(String[] args) {
		InterfaceMain im = new InterfaceMain();
		im.print();
		int n[] = im.recordAll(10);
		System.out.println(Arrays.toString(n));
		System.out.println(im.total(50));
		System.out.println(im.getData(100));
		
	}
}
