package Member;

public class MemberVO {
	private String MemberID;
	private String MemberPW;
	private String MemberName;
	private String MemberPhone;
	private Boolean MemberISAdmin;
	private Boolean MemberISOverDue;
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public String getMemberPW() {
		return MemberPW;
	}
	public void setMemberPW(String memberPW) {
		MemberPW = memberPW;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public Boolean getMemberISAdmin() {
		return MemberISAdmin;
	}
	public void setMemberISAdmin(Boolean memberISAdmin) {
		MemberISAdmin = memberISAdmin;
	}
	public Boolean getMemberISOverDue() {
		return MemberISOverDue;
	}
	public void setMemberISOverDue(Boolean memberISOverDue) {
		MemberISOverDue = memberISOverDue;
	}
	public String getMemberPhone() {
		return MemberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		MemberPhone = memberPhone;
	}
	
}
