package cn.pen.pojo;

public class Pen {
	private int penId;
	private String penName;
	private String penImg;
	private String penInfo;
	
	@Override
	public String toString() {
		return "Pen [penId=" + penId + ", penName=" + penName + ", penImg=" + penImg + ", penInfo=" + penInfo + "]";
	}
	
	public Pen() {
		super();
	}
	public Pen(int penId, String penName, String penImg, String penInfo) {
		super();
		this.penId = penId;
		this.penName = penName;
		this.penImg = penImg;
		this.penInfo = penInfo;
	}

	public int getPenId() {
		return penId;
	}

	public void setPenId(int penId) {
		this.penId = penId;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getPenImg() {
		return penImg;
	}

	public void setPenImg(String penImg) {
		this.penImg = penImg;
	}

	public String getPenInfo() {
		return penInfo;
	}

	public void setPenInfo(String penInfo) {
		this.penInfo = penInfo;
	}
}
