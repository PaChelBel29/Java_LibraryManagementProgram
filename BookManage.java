import java.util.*;

public class BookManage {

 private Scanner scanner;
 private HashMap<String, Book> bookHash;

 public BookManage() {
 this.scanner = new Scanner(System.in);
 this.bookHash = new HashMap<String, Book>();
 }

 void printBookList() {
 // (F)
 // bookHash에 저장된 모든 도서 정보 출력
	 Set<String> keys = bookHash.keySet();
	 for(String i : keys) {
		 System.out.println("도서 번호: "+bookHash.get(i).getBookNumber()+", 도서 명: "+bookHash.get(i).getName()+", 도서 장르: "+bookHash.get(i).getGenre()+", 재고: "+bookHash.get(i).getStock());
	 }
 } 

 boolean AddBook() {
	 System.out.print("책 번호 입력 >>");
	 String book_number=scanner.next();
	 if(bookHash.get(book_number)==null) {
		 System.out.print("책 제목 입력 >>");
		 String book_name=scanner.next();
		 System.out.print("책 장르 입력 >>");
		 String book_genre=scanner.next();
		 System.out.print("책 수량 입력 >>");
		 int count=scanner.nextInt();
		 if(count<0) {
			 System.out.println("도서는 1개 이상일 때 추가됩니다.");
			 return false;
		 }
		 bookHash.put(book_number, new Book(book_number,book_name,book_genre,count));
		 return true;
	 }
	 else {
		 System.out.println("이미 존재하는 도서번호입니다.");
		 return false;
	 }
 // (G)
 // scanner 객체를 통해 도서 정보를 입력 받아 bookHash에 저장
 // 현재 보유중인 도서가 아닌 도서만 추가 가능하도록 제약 필요
 // 원하는 재고 수량이 0보다 작으면 추가 불가능 제약 필요
	 
 }

 boolean UpdateBookStock() {
	 System.out.print("책 번호 입력 >>");
	 String book_number=scanner.next();
	 if(bookHash.containsKey(book_number)) {
		 System.out.print("책 수량 입력 >>");
		 int count=scanner.nextInt();
		 if(count<0) {
			 System.out.println("입력값이 1개 이상일 때 추가됩니다.");
			 return false;
		 }
		 bookHash.get(book_number).updateStock(count);
		 return true;
	 }
	 else {
		 System.out.println("존재하지 않는 도서번호입니다.");
		 return false;
	 }
 // (H)
 // scanner를 통해 도서 번호로 bookHash에 접근하여 재고업데이트
 // 현재 보유중인 도서만 가능하도록 제약 필요
 // 추가하고자 하는 재고 수량이 0보다 작으면 갱신 불가능 제약필요
 }

 boolean ReturnBook(Member member) {
	 System.out.print("반납할 도서 번호 입력 >>");
	 String book_number=scanner.next();
	 if(member.getbookHash().containsKey(book_number)) {
		 bookHash.get(book_number).updateStock(1);
		 member.getbookHash().remove(book_number);
		 System.out.println("[도서번호 :"+ bookHash.get(book_number).getBookNumber()
				 +"+"+bookHash.get(book_number).getName()+"]이 정상적으로 반납되었습니다.");
		 return true;
	 }
	 else {
		 System.out.println("도서 번호가 일치하지 않거나 대여하지 않았습니다.");
		 return false;
	 }
 // (I)
 // 도서 번호를 입력 받아 현재 회원이 대여중인 도서 반납
 // 현재 회원이 대여중인 도서만 반납 가능하도록 제약 필요
 // 재고는 다시 올려줌
 }

 boolean RentalBook(Member member) {
	 System.out.print("대출할 도서 번호 입력 >>");
	 String book_number=scanner.next();
	 if(member.getbookHash().containsKey(book_number)) {
		 System.out.println("이미 대여한 도서입니다.");
		 return false;
	 }
	 else {
		 if(member.getbookHash().get(book_number)==null) {
			 if(bookHash.get(book_number).getStock()>=0) {
				 member.getbookHash().put(book_number, bookHash.get(book_number));
			 bookHash.get(book_number).updateStock(-1);
			 System.out.println("[도서번호 :"+ bookHash.get(book_number).getBookNumber()
					 +", 도서 제목 :"+bookHash.get(book_number).getName()+"]이 정상적으로 대여되었습니다.");
			 return true;
			 }
			 else {
				 System.out.println("도서가 현재 전부 대여중입니다. \n나중에 이용해주세요.");
				 return false;
			 }
		 }
		 else {
			 System.out.println("도서 번호가 일치하지 않거나 존재하지 않습니다.");
			 return false;
		 }
	 }
 // (J)
 // 도서 번호를 입력 받아 현재 도서 대여
 // 도서가 존재하지 않거나 재고가 0개 이면 대여 불가능
 // 대여하는 책의 수량은 1개만 가능
 }
}
