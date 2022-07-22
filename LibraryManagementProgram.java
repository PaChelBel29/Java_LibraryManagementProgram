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
//(N)
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
 }

 public static void printMainMenu() {
	 System.out.println("--------전북대학교 컴퓨터 공학부 도서관 관리 프로그램입니다.------------");
	 System.out.println( "1. 관리자 메뉴 | 2. 회원 메뉴 | 3. 종료");
	 System.out.println("-----------------------------------------------------------");
	 //(O)
 }

 public static void printManagerMenu() {
 // (P)
 // 관리자 메뉴 작성
	 libManager.ManagerRun(currentPerson);
}

public static void printMemberMenu() {
 // (Q)
 // 회원 메뉴 작성
	libManager.MemberRun(currentPerson);
 }
}