package src.classes;
import java.util.Date;

public class Status {
	private Date date;
	private long money;
	
	public Status(Date date, long money) {
		super();
		this.date = date;
		this.money = money;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	
	
	
}
