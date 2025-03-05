package chapter010.practice;

public class Book extends Item { // item을 상속받아 book이 가져야할 속성 추가
	// id, name 
	private String isbn; // 책 고유 번호(전 세계 통용)
	private String author;
	private String publisher;
	private int publishYear;
	private int price;
	private int stock;
	private String category;
	
	// 생성자
	public Book (String id, String name, String isbn, String author, String publisher,
			int publishYear, int price, int stock, String category ) {
		
		super(id, name);
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}
	
	// getter
	public String getIsbn() { return isbn; }
	public String getAuthor() { return author; }
	public String getPublisher() { return publisher; }
	public int getPublishYear() { return publishYear; }
	public int getPrice() { return price; }
	public int getStock() { return stock; }
	public String getCategory() { return category; }
	
	// 메서드 : 재고 현황 
	public void updateStock(int quantity) {
		this.stock += quantity;
	}
	
	// 추상 메서드 재정의 
	@Override
	public void display() {
		System.out.println("ID : " + getId() + ", Name : " + getName() + ", ISBN : " + getIsbn());
	}

}
