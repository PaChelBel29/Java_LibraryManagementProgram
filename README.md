# Java_LibraryManagementProgram

### 개요
방학동안 진행하는 프로젝트 두번째, 도서관을 관리하는 프로그램을 Java로 구현한다

2022.07.11 - 2022.07.23

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
이클립스가 나보다 코딩 잘하는 것 같다. 자바 공부 열심히 해야겠다고 느꼈다.

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
해쉬맵을 처음으로 마주했던 코드다. 나는 해쉬맵을 이 때 인스턴스 선언하는 것을 까먹고 뒤늦게 고생하게 되었다.
```Java
public Member(String ID, String name, String passward) {
	super(ID, name, passward);
}
```
###(B-2)
해쉬맵도 인스턴스 선언 하는 것을 잊어서 한참을 해매고 고생했다. 무려 이 문제를 찾는데 2시간을 소비했다...
```Java
public Member(String ID, String name, String passward) {
		super(ID,name, passward);
		this.bookHash=new HashMap<String, Book>();
}
```
#

### (C)
이것 또한 pdf를 볼 생각 안하고 생각없이 만들어서 규격에 맞지도 않고 그냥 value만 출력하는 함수였다.
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

(마지막 까지 수정하는 것에 실패 한 코드)

이 코드는 끝까지 해결하지 못해 교수님께 답변을 받고 싶은 코드다.

먼저 문제점은 Person 데이터 타입을 받았는데 Member의 private타입으로 보호받는 bookHash를 받아오는 방법이 없다.

그래서 그냥 인스턴스로 받아오는 아무것도 들어있지 않은 HashMap인 bookHash만 사용했다.
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
null을 사용하는 것 보단 containkey를 사용하는 것이 좋다고 뒤늦게 느꼈다. 하지만 이미 쓴 코드를 수정하기엔 귀찮았다.

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

그나마 쉬웠던 코드다 book클래스의 함수를 사용하기만 하면 문제 없었기 때문이다.

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
NPE 문제가 발생해서 null 비교문이 문제인줄 알아서 개선하려고 I-2 를 만들었으나 문제가 아니었다!!
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
###(I-2)
containKey라는 함수를 사용했다 null을 그냥 사용하기엔 적절하지 않은 것 같다.

그리고 B-2를 수정하기 전이라서 NPE가 나왔다...
```Java
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
###(J-2)
(I-2)와 같은 이유로 NPE가 많이 발생했다 생각했다.
```Java
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
ID루프를 생각하는 것이 조금 고민이었다.

```Java
public void signup() {
	 System.out.print("ID를 입력>>");
	 String ID=scanner.next();
	 System.out.print("이름을 입력>>");
	 String name=scanner.next();
	 System.out.print("비밀번호를 입력>>");
	 String pw=scanner.next();
	 while(true) {
		 if(memberHash.get(ID).getID()!=null) {
			 System.out.println("이미 존재하는 ID입니다. 다른 ID를 입력해주세요.");
			 System.out.print("ID를 입력>>");
			 ID=scanner.next();
	 	}
		 else {
			 memberHash.put(ID, new Member(ID,name,pw));
			 System.out.println("계정이 생성되었습니다.");
			 break;
		 }
	 }

 }
```
#
### (L)

```Java
public Member Login() {
	 System.out.print("ID를 입력>>");
	 String ID=scanner.next();
	 if(memberHash.get(ID)==null) {
		 System.out.println("존재하지 않는 계정입니다.");
		 return null;
	 }
	 else {
		 System.out.print("비밀번호를 입력>>");
		 String pw=scanner.next();
		 if(memberHash.get(ID).getPassward().equals(pw)) {
			 System.out.println("로그인 성공");
			 return memberHash.get(ID);
		 }
		 else {
			 System.out.print("비밀번호가 일치하지 않습니다.");
			 return null;
		 }
	 }
 }
```
#
### (M)
Set과 for문은 출력이 참 편한 것 같아서 좋은 것 같다.
```Java
public void PrintMemberList() {
	 Set<String> keys = memberHash.keySet();
	 for(String i : keys) {
		 System.out.println("이름: "+memberHash.get(i).getName()+", ID: "+memberHash.get(i).getID());
	 }
 }
```
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
Main함수는 항상 귀찮은 것 같다.
```Java
while (true) {
 printMainMenu();
 System.out.print("입력 >> ");
 int selectNum = scanner.nextInt();
 if (selectNum == 1) { // 관리자 모드
	 System.out.println("----------------관리자 모드. 로그인 하십시오.----------------");
	 System.out.print("ID: ");
	 String ID=scanner.next();
	 System.out.print("비밀번호: ");
	 String PW=scanner.next();
	 if(managerID.equals(ID)&&managerPWD.equals(PW)) {
		 currentPerson=new Member(managerID,managerName,managerPWD);
		 printManagerMenu();
	 }
	 else {
		 System.out.println("ID 또는 비밀번호 불일치. 로그인 실패.");
		 continue;
	 }
 // 로그인 후 이용 가능. 정보가 일치하지 않으면 초기메뉴로...
 while(true) {
	 System.out.println("----------------관리자 모드.----------------");
	 System.out.println( "1. 도서관리 | 2. 로그아웃");
	 System.out.println("-----------------------------------------");
	 System.out.print("입력 >> ");
	 selectNum = scanner.nextInt();
	 if (selectNum == 1) {
		 libManager.ManagerRun(currentPerson);
	 }
	 else if(selectNum==2){
		 currentPerson = null;
		 break;
	 }
 }
 // 1. 도서 관리
 // 2. Logout (currentPerson = null; 후 break;)
 } else if (selectNum == 2) { // 회원 메뉴
	 while(true) {
		 System.out.println("----------------회원 모드.----------------");
		 System.out.println( "1. 회원가입 | 2. 로그인 | 3. 도서 대출 | 4. 로그아웃");
		 System.out.println("-----------------------------------------");
		 System.out.print("입력 >> ");
		 selectNum = scanner.nextInt();
		 if (selectNum == 1) {
			 libManager.memberManage.signup();
		 }
		 else if(selectNum==2){
			 currentPerson=libManager.memberManage.Login();
		 }
		 else if (selectNum==3) {
			 if(currentPerson==null) {
				 System.out.println("로그인 후 이용해주세요.");
			 }
			 else {
				 printMemberMenu();
			 }
		 }
		 else if (selectNum==4) {
			 System.out.println("로그아웃");
			 currentPerson = null;
			 break;
		 }
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

```
#
### (O)
```Java
public static void printMainMenu() {
	 System.out.println("-----------------전북대학교 컴퓨터 공학부 도서관 관리 프로그램입니다.---------------------------");
	 System.out.println( "1. 전체 도서 목록 출력 | 2. 도서 대여 | 3. 도서 반납 | 4. 대여 도서 목록 | 5. 돌아가기");
	 System.out.println("-----------------------------------------------------------------------------------");
	 //(O)
 }
```
#
### (P)
```Java
 public static void printManagerMenu() {
 // (P)
 // 관리자 메뉴 작성
	 libManager.ManagerRun(currentPerson);
}
```
#
### (Q)
진짜 MemberRun함수 완벽한 구현이 너무 아쉽다 추가 함수를 사용해야하나 고민까지 했다.
```Java
public static void printMemberMenu() {
 // (Q)
 // 회원 메뉴 작성
	libManager.MemberRun(currentPerson);
 }
}
```
## 마무리

교수님의 4개의 과제중 두번째 과제가 끝났다. 시간계획에 맞춰보면 상당히 무난하게 흘러가는 것 같다고 생각한다.

### 아쉬운점
가장 아쉬운 점은 지금 로그인 했던 회원이 로그아웃하면 다시 그 회원의 bookHash를 가져오지 못했다는 것이 아쉽다.

MemberRun이 지금 person을 인자로 받기 때문에 member의 bookHash를 가져올 수 없다.

상속으로 만든다고 해도 새로운 HashMap이 생성되기 때문이다.

이걸 보완하는 방법을 찾아야 할 것 같다.

### 배운점
HashMap에 대해서 아주 진하게 배운 것 같다. 

NPE에 대해서도 아주 호되게 당한 것 같다.

HashMap의 함수들과 Set에 범용이 편했고 for문도 같이 사용 할 수 있어서 아주 좋았다.

### 소감

학기중에 배운 것 보다 지금 과제로 고생하면서 공부하는게 더 많이 도움 되는 것 같다. 

나중에는 또 어떤 고행이 기다리고 있을 지 기대된다.
