package BookManagerUtil;

import java.util.Scanner;

import Book.BookUtil;
import Member.MemberUtil;

public class BookManagementUtil {
	Scanner sc = new Scanner(System.in);
	private boolean loop = true;
	BookUtil bu = new BookUtil();
	MemberUtil mu = new MemberUtil();
	public void startView() {
		System.out.println("도서관리 프로그램에 오신것을 환영합니다.");
		System.out.println("로그인 또는 회원가입을 진행해주세요!");
		System.out.println("1. 회원가입 /// 2. 로그인  /// 3. 종료");
		

		while (loop) {
			switch (sc.nextInt()) {
			case 1:
				mu.SignUp();
			case 2:
				mu.SignIn();
				successLoginView();
				break;
			case 3:
				loop = false;
				System.out.println("프로그램을 종료합니다!");
				break;
			default:
				System.out.println("1~3의 숫자만 입력해주세요!");
				break;
			}
		}

	}

	public void successLoginView() {

		loop = true;
		
		int isAdmin = MemberUtil.SessionAd;
		
		while (loop) {
			System.out.println("==========================메뉴를 선택하세요 ==========================");
			System.out.println("1. 도서 검색 \t 2. 도서 목록 \t 3. 도서 대출 \t 4.도서 반납 \t 5.마이 페이지 \t 6. 관리자 페이지\t 7. 종료");			
			int inputMu = sc.nextInt();
			sc.nextLine();
			switch (inputMu) {
			case 1:
				System.out.println("========================1. 도서 검색===========================");
				bu.BookSearch();
				break;
			case 2:
				System.out.println("========================2. 도서 목록===========================");
				bu.BookList();
				break;
			case 3:
				System.out.println("========================3. 도서 대출===========================");
				break;
			case 4:
				
				System.out.println("========================4. 도서 반납===========================");
				break;
			case 5:
				System.out.println("========================5. 마이 페이지===========================");
				break;
			case 6:
				if(isAdmin == 0) {
					System.out.println("관리자만 사용 가능한 페이지 입니다.");
					break;
				}
				System.out.println("========================6. 관리자 페이지===========================");
				managerPage();
				break;	
			case 7:
				System.out.println("========================7. 종  료===========================");
				loop = false;
				break;
			default:
				System.out.println("=================1~5사이 숫자만 입력해주세요 =====================");
				break;
			}
			

		}

	}
	public void managerPage() {
		System.out.println("관리자 페이지에 오신 것을 환영합니다.");
		System.out.println("이용 할 기능을 선택하세요 !");
		System.out.println("1. 도서 목록\t2. 도서 추가\t3. 도서 삭제\t4. 뒤로 가기");
		int inputMu = sc.nextInt();
		sc.nextLine();

		
			switch (inputMu) {
			case 1:
				System.out.println("========================1. 도서 목록 ===========================");
				bu.BookList();
				break;
			case 2:
				System.out.println("========================2. 도서 추가===========================");
				bu.BookAdd();;
				break;
			case 3:
				System.out.println("========================3. 도서 삭제===========================");
				bu.BookDelete();;
				break;
			case 4:
				System.out.println("===========메인 페이지로 돌아갑니다.=============");
				break;
			default:
				System.out.println("=================1~3사이 숫자만 입력해주세요 =====================");
				break;
		
		}
		
	}
	
	public void personalPage() {
		System.out.println("마이 페이지에 입니다.");
		System.out.println("이용 할 기능을 선택하세요 !");
		System.out.println("1. 내 정보 출력\t2. 내 정보 수정\t3.비밀 번호 변경");
		int inputMu = sc.nextInt();
		sc.nextLine();
		switch (inputMu) {
		case 1:
			System.out.println("========================1. 내 정보 출력 ===========================");
			bu.BookList();;
			break;
		case 2:
			System.out.println("========================2. 내 정보 수정===========================");
			bu.BookAdd();;
			break;
		case 3:
			System.out.println("========================3. 비밀 번호 변경===========================");
			bu.BookDelete();;
			break;
		default:
			System.out.println("=================1~3사이 숫자만 입력해주세요 =====================");
			break;
		}
	}

}
