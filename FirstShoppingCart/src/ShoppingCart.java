import java.util.ArrayList;

public class ShoppingCart {
	ArrayList<Integer> list;
	public ShoppingCart(){
		list = new ArrayList<Integer>();
	}
	public ArrayList<Integer> getList() {
		return list;
	}
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
}
