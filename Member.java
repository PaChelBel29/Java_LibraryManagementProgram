import java.util.*;

public class Member extends Person {

	HashMap<String, Book> bookHash; //대여 중인 도서를 저장하는 hash

	public Member(String ID, String name, String passward) {
		super(ID,name, passward);
		this.bookHash=new HashMap<String, Book>();
		// (B)
		// 생성자(구현 필요)
}

 HashMap<String, Book> getbookHash(){ return bookHash; }

 void PrintRentalList() {
// (C)
// 대출 중인 도서를 출력
	 if(bookHash.isEmpty()) {
		 System.out.println("대출한 도서가 없습니다.");
	 }
	 else {
Set<String> keys = bookHash.keySet();
	 for(String i : keys) {
		 System.out.println("도서 번호: "+bookHash.get(i).getBookNumber()+", 도서 명: "+bookHash.get(i).getName()+", 도서 장르: "+bookHash.get(i).getGenre());
	 }
	 }
 }
}
