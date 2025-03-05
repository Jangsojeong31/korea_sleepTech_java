package chapter010.practice02.entity;

public class Furniture extends Item{
	private String material; //재질
	private String size;
	

	public Furniture(String id, String name, int price, int quantity, String material, String size) {
		super(id, name, price, quantity);
		this.material = material;
		this.size = size;
		// TODO Auto-generated constructor stub
	}
	
	public String getMaterial() { return material; }
	public String getSize() { return size; }
	
	

	@Override
	public String getCategory() { return "Furniture"; }
	
	@Override
	public String toString() {
		return super.toString() + " // Material: " + material + ", Size: " + size;
	}

}
