package feeStatusTableView;

public class feeBean {
	String tid;
	String tech;
	String time;
	int total;
	int recieved;
	public feeBean(String tid, String tech, String time, int total, int recieved) {
		super();
		this.tid = tid;
		this.tech = tech;
		this.time = time;
		this.total = total;
		this.recieved = recieved;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRecieved() {
		return recieved;
	}
	public void setRecieved(int recieved) {
		this.recieved = recieved;
	}
	
}
