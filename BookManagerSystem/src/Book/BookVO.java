package Book;

public class BookVO {
	private String BookNO;
	private String BookCategory;
	private String BookName;
	private String BookAuthor;
	private String BookPublisher;
	private String BookPubYear;
	
	
	public BookVO() {
		
	}
	/**
	 * @param bookNO
	 * @param bookCategory
	 * @param bookName
	 * @param bookAuthor
	 * @param bookPublisher
	 * @param bookPubYear
	 */
	public BookVO(String bookNO, String bookCategory, String bookName, String bookAuthor, String bookPublisher,
			String bookPubYear) {
		super();
		BookNO = bookNO;
		BookCategory = bookCategory;
		BookName = bookName;
		BookAuthor = bookAuthor;
		BookPublisher = bookPublisher;
		BookPubYear = bookPubYear;
	}
	public String getBookNO() {
		return BookNO;
	}
	public void setBookNO(String bookNO) {
		BookNO = bookNO;
	}
	public String getBookCategory() {
		return BookCategory;
	}
	public void setBookCategory(String bookCategory) {
		BookCategory = bookCategory;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public String getBookPublisher() {
		return BookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		BookPublisher = bookPublisher;
	}
	public String getBookPubYear() {
		return BookPubYear;
	}
	public void setBookPubYear(String bookPubYear) {
		BookPubYear = bookPubYear;
	}
	

}
