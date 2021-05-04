package Member;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import BookManagerUtil.BookManagementUtil;

public class MemberUtil implements MemberInterface {
	Scanner sc = new Scanner(System.in);

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
	String InputID;
	int isAdmin = 0;
	boolean IsID = true;
	public static String SessionID;
	public static String SessionPW;
	public static int SessionAd;
	FileReader fr;

	@Override
	public void SignUp() {
		// 회원가입
		System.out.println("*****************1. 회원가입을 선택하셨습니다.*******************");
		IsAdmin("관리자로 가입하시겠습니까?");
		MemberVO mv = new MemberVO();
		
		
		try {
			while (true) {
				fr = new FileReader("C:\\Users\\HP\\git\\JAVAProject\\BookManagerSystem\\iodata\\memberList.txt");
				br = new BufferedReader(fr);
				System.out.println("아이디를 입력하세요 : ");
				String line = "";
				IsID = true;
				InputID = sc.nextLine();
				while ((line = br.readLine()) != null) {
					String[] temp = line.split("/");
					if (InputID.equalsIgnoreCase(temp[0])) {
						System.out.println("중복체크 완료");
						System.out.println("이미 등록된 아이디 입니다. 다른아이디를 입력해주세요");
						IsID = false;
						break;
					}
				}
				if (IsID) {
					mv.setMemberID(InputID);
					System.out.println("패스워드를 입력하세요 : ");
					mv.setMemberPW(sc.nextLine());
					System.out.println("이름을 입력하세요 : ");
					mv.setMemberName(sc.nextLine());
					System.out.println("휴대폰 번호를 입력하세요 ex)01012345678 : ");
					mv.setMemberPhone(sc.nextLine());
					mv.setMemberISAdmin(isAdmin);
					memberList.add(mv);
					writeFile();
					System.out.println("회원가입이 완료 되었습니다. 로그인 해주세요");
					break;
				}
				br.close();
				fr.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void SignIn() {
		// 로그인
		System.out.println("*****************2. 로그인을 선택하셨습니다.*******************");
		while(true) {
			System.out.println("아이디를 입력하세요 : ");
			InputID = sc.nextLine();
			System.out.println("비밀번호를 입력하세요 : ");
			String InputPW = sc.nextLine();
			String line = "";

			try {
				fr = new FileReader("C:\\Users\\HP\\git\\JAVAProject\\BookManagerSystem\\iodata\\memberList.txt");
				br = new BufferedReader(fr);
				
				while ((line = br.readLine()) != null) {
					String[] temp = line.split("/");
					if (InputID.equals(temp[0]) && InputPW.equals(temp[1]) ) {
						System.out.println("로그인 성공!");
						if(Integer.parseInt(temp[4])==1) {
								System.out.println("관리자 계정입니다!");
						}
						System.out.println(temp[2] + "님 환영합니다. 로그인 성공!");
						SessionID = temp[0];
						SessionPW = temp[1];
						SessionAd = Integer.parseInt(temp[4]);
						IsID = false;
						break;
					}
				}
				if (IsID) {
					System.out.println("등록된 아이디나 비밀번호가 아닙니다.");
				}else {
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	@Override
	public void SignOut() {
		// 로그아웃

	}

	public void writeFile() {
		FileWriter fw;

		try {
			fw = new FileWriter("C:\\Users\\HP\\git\\JAVAProject\\BookManagerSystem\\iodata\\memberList.txt", true);

			for (int i = 0; i < memberList.size(); i++) {
				fw.write(memberList.get(i).getMemberID() + "/" + memberList.get(i).getMemberPW() + "/"
						+ memberList.get(i).getMemberName() + "/" + memberList.get(i).getMemberPhone() + "/"
						+ memberList.get(i).getMemberISAdmin() + "\r\n");
			}
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("저장완료");

	}

	public void IsAdmin(String str) {
		System.out.println(str);

		boolean loop =true;
		
		while(loop){
			System.out.println("1 : 관리자  2 : 일반 사용자");
			int inputad = sc.nextInt();
			sc.nextLine();
			switch (inputad) {
			case 1:
				isAdmin = 1;
				loop = false;
				break;
			case 2:
				isAdmin = 0;
				loop = false;
				break;

			default:
				System.out.println("1과 2사이의 숫자를 입력하세요!");
				break;
			}
		}
		
	}

}
