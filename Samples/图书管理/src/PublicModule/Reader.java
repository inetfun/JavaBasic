// Reader.java
package PublicModule;

public class Reader {
	private String id;
	private String readername;
	private String readertype;
	private String sex;
	private int max_num;
	private int days_num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReadername() {
		return readername;
	}

	public void setReadername(String name) {
		this.readername = name;
	}

	public String getReadertype() {
		return readertype;
	}

	public void setReadertype(String type) {
		this.readertype = type;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getMax_num() {
		return max_num;
	}

	public void setMax_num(int max_num) {
		this.max_num = max_num;
	}

	public int getDays_num() {
		return days_num;
	}

	public void setDays_num(int days_num) {
		this.days_num = days_num;
	}
}
