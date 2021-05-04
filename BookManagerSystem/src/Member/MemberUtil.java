package Member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberUtil implements MemberInterface {
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
	String InputID;
	@Override
	public void SignUp() {
		// 회원가입
		System.out.println("*****************1. 회원가입을 선택하셨습니다.*******************");
		
		FileReader fr;
		
		MemberVO mv = new MemberVO();
		
		try {
			fr = new FileReader("C:\\Users\\Hwany\\git\\Javaproject\\BookManagementSystem\\iodata\\memberlist.txt");
			br = new BufferedReader(fr);
			
			System.out.println("아이디를 입력하세요 : ");
			
			
			String line = "";
			boolean IsID = true;
			
			while((line = br.readLine()) != null) {
				InputID = sc.nextLine();
				String[] temp = line.split("/");
				System.out.println(temp[0]);
				if(InputID.equalsIgnoreCase(temp[0])) {
					System.out.println("이미 등록된 아이디 입니다. 다른아이디를 입력해주세요");
					IsID = false;
					break;
				}
			}
			if(IsID) {
				mv.setMemberID(InputID);
				System.out.println("패스워드를 입력하세요 : ");
				mv.setMemberPhone(sc.nextLine());
				System.out.println("이름을 입력하세요 : ");
				mv.setMemberName(sc.nextLine());
				System.out.println("휴대폰 번호를 입력하세요 ex)01012345678 : ");
				mv.setMemberPhone(sc.nextLine());
				writeFile();
				System.out.println("회원가입이 완료 되었습니다. 로그인 해주세요");
			}
			
			br.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void SignIn() {
		// 로그인
		
	}

	@Override
	public void SignOut() {
		// 로그아웃
		
	}
	
	public void writeFile() {
		FileWriter fw;
		
		try {
			fw = new FileWriter("C:\\\\Users\\\\Hwany\\\\git\\\\Javaproject\\\\BookManagementSystem\\\\iodata\\\\memberlist.txt", true);
			
			for(int i = 0; i < memberList.size(); i++) {
				fw.write(memberList.get(i).getMemberID() + "/" + memberList.get(i).getMemberPW() + "/" +memberList.get(i).getMemberPhone() + "\r\n");
			}
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("저장완료");
		
	}
	
	

}
