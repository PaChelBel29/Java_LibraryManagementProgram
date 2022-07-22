# Java_LibraryManagementProgram

### 개요
방학동안 진행하는 프로젝트 두번째, 도서관을 관리하는 프로그램을 Java로 구현한다

2022.07.11 - 

### 목표
도서관 관리 프로그램을 Java로 구현한다.

*******
교수님이 주신 기본 코드를 베이스로 한다.


******
```Java
public class Manager extends Person {
// (A)
// 상위 클래스 생성자 호출
}
```

### (A)

웃기게도 이걸 구현하는 것을 찾기 귀찮아서 미루고 있었다...
하지만 언제까지 미루고 있을 수 는 없어서 미루다 미루다 다시 붙잡았는데 너무 쉬워서 어이가 없다.

```Java
public class Manager extends Person {

	public Manager(String ID, String name, String passward) {
		super(ID, name, passward);
		// TODO Auto-generated constructor stub
	}
}
```
#

```Java
import java.util.*;

public class Member extends Person {

	HashMap<String, Book> bookHash; //대여 중인 도서를 저장하는 hash

	public Member(String ID, String name, String passward) {
// (B)
// 생성자(구현 필요)
}

 HashMap<String, Book> getbookHash(){ return bookHash; }

 void PrintRentalList() {
 // (C)
 // 대출 중인 도서를 출력
 }
}
```


### (B)
해쉬맵을 잘 몰라서 다양한 함수를 알 수 있었다. 
```Java
public Member(String ID, String name, String passward) {
	super(ID, name, passward);
}
```

#

### (C)

```Java
 HashMap<String, Book> getbookHash(){ return bookHash; }

 void PrintRentalList() {
 	system.out.println(bookHash.values());
 }
}
```
### (C-2)
(C)를 잘못 구현했다. 
Set이라고 하는 자료구조를 사용했고, for 문에서 사용하기 위해서 사용했다.
수정 코드

```Java
HashMap<String, Book> getbookHash(){ return bookHash; }
 void PrintRentalList() {
Set<String> keys = bookHash.keySet();
	 for(String i : keys) {
		 System.out.println("도서 번호: "+bookHash.get(i).getBookNumber()+", 도서 명: "+bookHash.get(i).getName()+"도서 장르: "+bookHash.get(i).getGenre());
	 }
 }
```

#

```Java
public class TotalLibraryManage {
MemberManage memberManage;
 BookManage bookManage;

 private Scanner scanner;

 public TotalLibraryManage() {
memberManage = new MemberManage();
 bookManage = new BookManage();
 scanner = new Scanner(System.in);
 }

 public MemberManage getmemberManage() { return memberManage;
}

 public BookManage getbookManage() { return bookManage; }

 public void ManagerRun(Person person) { // 관리자
 // (D)
 //루프를 돌면서 관리자 기능 수행
 // 1. 전체 도서 목록 출력
 // 2. 도서 등록
 // 3. 도서 재고 추가
 // 4. 회원 목록 보기
 // 5. 돌아가기(루프 탈출)
 }

 public void MemberRun(Person person) { // 회원
 // (E)
 //루프를 돌면서 회원 기능 수행
 // 1. 전체 도서 목록 출력
 // 2. 도서 대여
 // 3. 도서 반납
 // 4. 대여 도서 목록
 // 5. 돌아가기(루프 탈출)
 }
}

```

#

### (D)
나중에 사용할 기본탑재 소스를 사용한다.
```Java
 public void ManagerRun(Person person) { // 관리자
	 while(true) {
		 System.out.println("-----------------------------------------------------------------------------------");
		 System.out.println( "1. 전체 도서 목록 출력 | 2. 도서 등록 | 3. 도서 재고 추가 | 4. 회원 목록 보기 | 5. 돌아가기");
		 System.out.println("-----------------------------------------------------------------------------------");
		 System.out.print(">>");
		 int op=scanner.nextInt();
		 switch(op) {
		 case(1): bookManage.printBookList();
		 case(2): bookManage.AddBook();
		 case(3): bookManage.UpdateBookStock();
		 case(4): memberManage.PrintMemberList();
		 case(5):break;
	 }
	 
	 }
 }
```
#

### (E)
나중에 사용할 기본탑재 소스를 사용한다.
```Java
 public void MemberRun(Person person) { // 회원
	 Member m = new Member(person.getID(), person.getName(), person.getPassward());
		 while(true) {
		 System.out.println("-----------------------------------------------------------------------------------");
		 System.out.println( "1. 전체 도서 목록 출력 | 2. 도서 대여 | 3. 도서 반납 | 4. 대여 도서 목록 | 5. 돌아가기");
		 System.out.println("-----------------------------------------------------------------------------------");
		 System.out.print(">>");
		 int op=scanner.nextInt();
		 switch(op) {
		 case(1): bookManage.printBookList();
		 case(2): bookManage.RentalBook(m);
		 case(3): bookManage.ReturnBook(m);
		 case(4): m.PrintRentalList();
		 case(5):break;
	 }
	 }
 }
```

#

```Java
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
 }

 boolean AddBook() {
 // (G)
 // scanner 객체를 통해 도서 정보를 입력 받아 bookHash에 저장
 // 현재 보유중인 도서가 아닌 도서만 추가 가능하도록 제약 필요
 // 원하는 재고 수량이 0보다 작으면 추가 불가능 제약 필요
 }

 boolean UpdateBookStock() {
 // (H)
 // scanner를 통해 도서 번호로 bookHash에 접근하여 재고업데이트
 // 현재 보유중인 도서만 가능하도록 제약 필요
 // 추가하고자 하는 재고 수량이 0보다 작으면 갱신 불가능 제약필요
 }

 boolean ReturnBook(Member member) {
 // (I)
 // 도서 번호를 입력 받아 현재 회원이 대여중인 도서 반납
 // 현재 회원이 대여중인 도서만 반납 가능하도록 제약 필요
 // 재고는 다시 올려줌
 }

 boolean RentalBook(Member member) {
 // (J)
 // 도서 번호를 입력 받아 현재 도서 대여
 // 도서가 존재하지 않거나 재고가 0개 이면 대여 불가능
 // 대여하는 책의 수량은 1개만 가능
 }
}


```

#
### (F)
저번에 사용했던 (C-2)코드와 비슷하다.
```Java
void printBookList() {
	 Set<String> keys = bookHash.keySet();
	 for(String i : keys) {
		 System.out.println("도서 번호: "+bookHash.get(i).getBookNumber()+", 도서 명: "+bookHash.get(i).getName()+"도서 장르: "+bookHash.get(i).getGenre());
	 }
 } 
```

#
### (G)
```Java
 boolean AddBook() {
	 System.out.print("책 번호 입력 >>");
	 String book_number=scanner.next();
	 if(bookHash.get(book_number)!=null) {
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
 }
```
#
### (H)

```Java
 boolean UpdateBookStock() {
	 System.out.print("책 번호 입력 >>");
	 String book_number=scanner.next();
	 if(bookHash.get(book_number)!=null) {
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
 }
```
#
### (I)
```Java
boolean ReturnBook(Member member) {
	 System.out.print("반납할 도서 번호 입력 >>");
	 String book_number=scanner.next();
	 if(member.getbookHash().get(book_number)!=null) {
		 bookHash.get(book_number).updateStock(1);
		 member.getbookHash().remove(book_number);
		 return true;
	 }
	 else {
		 System.out.println("도서 번호가 일치하지 않거나 대여하지 않았습니다.");
		 return false;
	 }

 }
```

#
### (J)
조건문이 까다로웠다
```Java
boolean RentalBook(Member member) {
	 System.out.print("대출할 도서 번호 입력 >>");
	 String book_number=scanner.next();
	 if(member.getbookHash().get(book_number)!=null) {
		 System.out.println("이미 대여한 도서입니다.");
		 return false;
	 }
	 else {
		 if(bookHash.get(book_number)!=null) {
			 if(bookHash.get(book_number).getStock()>=0) {
			 member.bookHash.put(book_number, bookHash.get(book_number));
			 bookHash.get(book_number).updateStock(-1);
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
 }
}
```
#

```Java
import java.util.*;

public class MemberManage {
 private Scanner scanner;
 private HashMap<String, Member> memberHash;

 public MemberManage() {
 this.scanner = new Scanner(System.in);
 this.memberHash = new HashMap<String, Member>();
 }

 public void signup() {
 // (K)
 // 회원 ID, 이름, 비밀번호를 입력받아 memberHash에 추가
 // 루프를 돌면서 ID가 이미 존재하면 “이미 존재하는 ID입니다” 출력 후
 // 재입력. 재입력된 ID가 중복되지 않으면 루프 탈출
 }
 public Member Login() {
 Member member = null;
 // (L)
 // ID가 존재하지 않거나 비밀번호가 틀릴 경우 메시지 출력 후 null 반환
 // 로그인 성공 시 해당 멤버 객체 반환
 }

 public void PrintMemberList() {
 // (M)
 // memberHash로부터 회원 리스트 출력
 }
 }
```

#
### (K)

#
### (L)

#
### (M)

#

```Java
import java.util.*;

public class LibraryManagementProgram {
private static Scanner scanner = new Scanner(System.in);
 private static final String managerID = "0000";
 private static final String managerName = "홍길동";
 private static final String managerPWD = "1234";

 private static TotalLibraryManage libManager = new
TotalLibraryManage();
 static Person currentPerson = null;

 public static void main(String[] args) {
 // (N)
 //
 while (true) {
 printMenu();
 System.out.print("입력 >> ");
 int selectNum = scanner.nextInt();

 if (selectNum == 1) { // 관리자 모드
 // 로그인 후 이용 가능. 정보가 일치하지 않으면 초기메뉴로...
 while {
 // 1. 도서 관리
 // 2. Logout (currentPerson = null; 후 break;)
 }
 } else if (selectNum == 2) { // 회원 메뉴
 while {
 //
 // 1. 회원 가입
 // 2. 로그인
 // 3. 도서 대출(로그인 후 이용 가능 제약)
 // 4. Logout (currentPerson = null; 후 break;)
 }
 } else if (selectNum == 3) { // 종료
 System.out.println("프로그램을 종료합니다.");
 break;
 }
 }
 }

 public static void printMainMenu() {
 // (O)
 // 메인 메뉴 작성
 }

 public static void printManagerMenu() {
 // (P)
 // 관리자 메뉴 작성
}

public static void printMemberMenu() {
 // (Q)
 // 회원 메뉴 작성
 }
}

```

#
### (N)

#
### (O)

#
### (P)

#
### (Q)
