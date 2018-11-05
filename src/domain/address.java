package domain;

import java.io.Serializable;
//用户ID和addr
public class address implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uId;
	private String addr;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
