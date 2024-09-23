package Main;

public class Product {
	private String Name1;
	private String type1;
	private String place;
	private int warrenty1;
	
	@Override
	public String toString() {
		return "Product [Name1=" + Name1 + ", type1=" + type1 + ", place=" + place + ", warrenty1=" + warrenty1 + "]";
	}
	public Product() {
		super();
	}
	public Product(String name1, String type1, String place, int warrenty1) {
		super();
		Name1 = name1;
		this.type1 = type1;
		this.place = place;
		this.warrenty1 = warrenty1;
	}
	public String getName1() {
		return Name1;
	}
	public void setName1(String name1) {
		Name1 = name1;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getWarrenty1() {
		return warrenty1;
	}
	public void setWarrenty1(int warrenty1) {
		this.warrenty1 = warrenty1;
	}
	

}
