package Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class BookUtil implements BookInterface {
	Scanner sc = new Scanner(System.in);

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<BookVO> bookList = new ArrayList<BookVO>();
	FileReader fr;
	boolean isBook = true;
	boolean inputBook = true;
	int bookCnt = 0;

	@Override
	public void BookSearch() {

		System.out.println("검색할 방법을 입력 하세요!");
		System.out.println("1. 도서번호\t2. 카테 고리\t3. 도서 제목\t4.도서 저자\t5.출판사\t6.출판년도");
		int inputM = sc.nextInt();
		sc.nextLine();
		inputM -= 1;

		try {
			fr = new FileReader("C:\\Users\\HP\\git\\JAVAProject\\BookManagerSystem\\iodata\\bookList.txt");
			br = new BufferedReader(fr);

			String line = "";
			System.out.println("검색 내용을 입력하세요 : ");
			String inputIdx = sc.nextLine();
			boolean isbook = false;
			bookCnt = 0;
			while ((line = br.readLine()) != null) {
				String[] temp = line.split("/");

				if (temp[inputM].contains(inputIdx)) {
					System.out.println("====================== 책 이름 : " + temp[2] + "==========================\n");
					System.out.println("도서 번호 : " + temp[0]);
					System.out.println("카테 고리 : " + temp[1]);
					System.out.println("도서 제목 : " + temp[2]);
					System.out.println("도서 저자 : " + temp[3]);
					System.out.println("도서 출판 : " + temp[4]);
					System.out.println("출판년도 : " + temp[5]);
					System.out
							.println("============================================================================\n");
					bookCnt++;
				}
			}
			if (bookCnt > 0) {
				System.out.println(bookCnt + "건  검색 되었습니다!");
			} else {
				System.out.println("검색하신 책은 없습니다. ");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	//도서 대출
	public void BookLend() {
		
	}

	@Override
	public void BookList() {
		//도서 List출력
		try {
			fr = new FileReader("C:\\Users\\HP\\git\\JAVAProject\\BookManagerSystem\\iodata\\bookList.txt");
			br = new BufferedReader(fr);
			System.out.println("============================도서 목록==============================");
			String line = "";
			while ((line = br.readLine()) != null) {
				String temp[] = line.split("/");
				System.out.println("====================== 책 이름 : " + temp[2] + "==========================\n");
				System.out.println("도서 번호 : " + temp[0]);
				System.out.println("카테 고리 : " + temp[1]);
				System.out.println("도서 제목 : " + temp[2]);
				System.out.println("도서 저자 : " + temp[3]);
				System.out.println("도서 출판 : " + temp[4]);
				System.out.println("출판 년도 : " + temp[5]);
				System.out.println("============================================================================\n");
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void BookAdd() {
		//도서 추가
		BookVO bv = new BookVO();
		System.out.println("도서를 등록하기 전에 유사한 책이 있는지 먼저 확인해 주세요!");
		BookSearch();
		if (bookCnt != 0) {
			System.out.println("등록 하시려는 책이 " + bookCnt + " 건 검색되었습니다. 추가 등록 하시겠습니까?");
		}
		System.out.println("책 등록을 시작합니다!");
		System.out.println("등록하실 책 정보를 입력해 주세요!");
		try {
			fr = new FileReader("C:\\Users\\HP\\git\\JAVAProject\\BookManagerSystem\\iodata\\bookList.txt");
			br = new BufferedReader(fr);

			System.out.println("도서 카테고리를 선택하세요(1~4숫자입력) : ");
			System.out.println("1.문학\t2.사회과학\t3.인문과학\t4.자연과학");
			boolean isNull = true;
			while (isNull)
				switch (sc.nextInt()) {

				case 1:
					bv.setBookCategory("문학");
					isNull = false;
					break;
				case 2:
					bv.setBookCategory("사회문학");
					isNull = false;
					break;
				case 3:
					bv.setBookCategory("인문과학");
					isNull = false;
					break;
				case 4:
					bv.setBookCategory("자연과학");
					isNull = false;
					break;
				default:
					System.out.println("1~4숫자만 입력하세요!");
					break;
				}
			sc.nextLine();
			System.out.println("도서 제목을 입력하세요 : ");
			bv.setBookName(sc.nextLine());
			System.out.println("도서 저자를 입력하세요 : ");
			bv.setBookAuthor(sc.nextLine());
			System.out.println("출판사를 입력하세요 : ");
			bv.setBookPublisher(sc.nextLine());
			System.out.println("출판 년도를 입력하세요 : ");
			bv.setBookPubYear(sc.nextLine());
			bv.setBookNO(bv.getBookPubYear().substring(0, 2) + "-" + bv.getBookCategory().substring(0, 2) + "-"
					+ bv.getBookName().substring(0, 1) + "-"
					+ bv.getBookPubYear().substring(bv.getBookPubYear().length() - 2, bv.getBookPubYear().length()));
			bookList.add(bv);
			writeFile(true);

			System.out.println("도서 동록이 완료 되었습니다.");

			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void BookDelete() {
		//도서 삭제
		readBookList();
		System.out.println("삭제 하려고 하는 책 제목을 입력해주세요!");
		String inputBookName = sc.nextLine();
		loop : for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookName().equals(inputBookName)) {
				System.out.println(bookList.get(i).getBookName() + "을 삭제 하시겠습니까?");
				System.out.println("1. Yes 2. No");
				int input = sc.nextInt();
				sc.nextLine();
				switch (input) {
				case 1:
					bookList.remove(i);
					System.out.println("삭제가 완료 되었습니다!");
					break loop;
				case 2:
				default:
					System.out.println("다시 검색을 시작합니다.");
					continue;
				}
			}else {
				System.out.println("검색하는 책은 존재 하지 않습니다.");
			}
		}
		writeFile(false);
	}

	public void writeFile(boolean IsCover) {
		//도서 쓰기
		FileWriter fw;
		try {
			fw = new FileWriter("C:\\Users\\HP\\git\\JAVAProject\\BookManagerSystem\\iodata\\BookList.txt", IsCover);

			for (int i = 0; i < bookList.size(); i++) {
				fw.write(bookList.get(i).getBookNO() + "/" + bookList.get(i).getBookCategory() + "/"
						+ bookList.get(i).getBookName() + "/" + bookList.get(i).getBookAuthor() + "/"
						+ bookList.get(i).getBookPublisher() + "/" + bookList.get(i).getBookPubYear() + "\r\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("저장완료");
	}
	public void readBookList() {
		// 도서 List로 불러오기
		try {
			fr = new FileReader("C:\\Users\\HP\\git\\JAVAProject\\BookManagerSystem\\iodata\\bookList.txt");
			br = new BufferedReader(fr);
			String line = "";

			while ((line = br.readLine()) != null) {
				String[] temp = line.split("/");
				bookList.add(new BookVO(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

//// 도서 목록 출력
