package domain;

import java.io.Serializable;
//订单详情，显示用户id和商品ID
public class order implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uId;
	private String cId;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
