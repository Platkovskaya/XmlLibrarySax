package by.htp.bean;

public class Edition {
	private int id;
	private String type;
	private String name;
	private String author;
	private int year;
	private int count;
	private int countOfReadingDays;
	private String readAtHome;
	
	
	public String getReadAtHome() {
		return readAtHome;
	}
	public void setReadAtHome(String readAtHome) {
		this.readAtHome = readAtHome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCountOfReadingDays() {
		return countOfReadingDays;
	}
	public void setCountOfReadingDays(int countOfReadingDays) {
		this.countOfReadingDays = countOfReadingDays;
	}
	
	
	

}
