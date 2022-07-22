import java.util.*;

public class MemberManage {
 private Scanner scanner;
 private HashMap<String, Member> memberHash;

 public MemberManage() {
 this.scanner = new Scanner(System.in);
 this.memberHash = new HashMap<String, Member>();
 }

 public void signup() {
	 System.out.print("ID를 입력>>");
	 String ID=scanner.next();
	 System.out.print("이름을 입력>>");
	 String name=scanner.next();
	 System.out.print("비밀번호를 입력>>");
	 String pw=scanner.next();
	 while(true) {
		 if(memberHash.get(ID)==null) {
			 memberHash.put(ID, new Member(ID,name,pw));
			 System.out.println("계정이 생성되었습니다.");
			 break;
	 	}
		 else {
			 
			 System.out.println("이미 존재하는 ID입니다. 다른 ID를 입력해주세요.");
			 System.out.print("ID를 입력>>");
			 ID=scanner.next();
		 }
	 }
 // (K)
 // 회원 ID, 이름, 비밀번호를 입력받아 memberHash에 추가
 // 루프를 돌면서 ID가 이미 존재하면 “이미 존재하는 ID입니다” 출력 후
 // 재입력. 재입력된 ID가 중복되지 않으면 루프 탈출
 }
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
			 System.out.println("비밀번호가 일치하지 않습니다.");
			 return null;
		 }
	 }
 // (L)
 // ID가 존재하지 않거나 비밀번호가 틀릴 경우 메시지 출력 후 null 반환
 // 로그인 성공 시 해당 멤버 객체 반환
 }


 public void PrintMemberList() {
 // (M)
 // memberHash로부터 회원 리스트 출력
	 Set<String> keys = memberHash.keySet();
	 for(String i : keys) {
		 System.out.println("이름: "+memberHash.get(i).getName()+", ID: "+memberHash.get(i).getID());
	 }
 }
 }
 
