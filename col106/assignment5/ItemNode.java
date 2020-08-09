package col106.assignment5;

public class ItemNode implements ItemInterface{

	int itemId;
	String itemName;
	int stock;

	public ItemNode(int itemId, String itemName, int stock){
		this.itemId = itemId;
		this.itemName = itemName;
		this.stock = stock;
	}

	public int getItemId(){
		//Enter your code here
		return 0;
	}

	public  String getItemName(){
		//Enter your code here
		return null;
	}

	public int getStockLeft(){
		//Enter your code here
		return 0;
	}

	public void addTransaction(PurchaseNode purchaseT){
		//Enter your code here
	}

	public Node<PurchaseNode> getPurchaseHead(){
		//Enter your code here
		return null;
	}

}
