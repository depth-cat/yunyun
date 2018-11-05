package domain;

import java.io.Serializable;
//用户的ID以及联系方式
public class contact implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uId;
	private String ucon;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getUcon() {
		return ucon;
	}
	public void setUcon(String ucon) {
		this.ucon = ucon;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
