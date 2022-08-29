package allBatchesTableView;

public class batchBean {
	String batch;
	String date;
	String time;
	int seats;
	int book;
	int fee;
	public batchBean(String batch, String date, String time, int seats, int book, int fee) {
		super();
		this.batch = batch;
		this.date = date;
		this.time = time;
		this.seats = seats;
		this.book = book;
		this.fee = fee;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
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
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getBook() {
		return book;
	}
	public void setBook(int book) {
		this.book = book;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
}
