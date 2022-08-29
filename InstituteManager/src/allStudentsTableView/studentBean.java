package allStudentsTableView;

public class studentBean {
	String tid;
	String name;
	String mobile;
	String college;
	String sem;
	String branch;
	String tech;
	String date;
	String time;
	int totalFee;
	int advFee;
	int bal;
	String admn;
	String picpath;
	public studentBean(String tid, String name, String mobile, String college, String sem, String branch, String tech,
			String date, String time, int totalFee, int advFee, int bal, String admn,String picpath) {
		super();
		this.tid = tid;
		this.name = name;
		this.mobile = mobile;
		this.college = college;
		this.sem = sem;
		this.branch = branch;
		this.tech = tech;
		this.date = date;
		this.time = time;
		this.totalFee = totalFee;
		this.advFee = advFee;
		this.bal = bal;
		this.admn = admn;
		this.picpath = picpath;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}
	public int getAdvFee() {
		return advFee;
	}
	public void setAdvFee(int advFee) {
		this.advFee = advFee;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public String getAdmn() {
		return admn;
	}
	public void setAdmn(String admn) {
		this.admn = admn;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	
}
