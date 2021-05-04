package BookManagerUtil;

import java.util.Scanner;

import Member.MemberUtil;

public class BookManagementUtil {
	Scanner sc = new Scanner(System.in);
	
	public void startView() {
		
		System.out.println("도서관리 프로그램에 오신것을 환영합니다.");
		System.out.println("로그인 또는 회원가입을 진행해주세요!");
		System.out.println("1. 회원가입  2. 로그인 3. 종료");
		MemberUtil mu = null;
		switch(sc.nextInt()) {
		case 1:
			mu.SignUp();
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
	}
	public void addMember() {
		System.out.println();
	}
	
	
}
