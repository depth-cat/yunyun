package domain;

import java.io.Serializable;

public class admin implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aId;//管理员ID
    private String aname;
	private String asex;
	private String acon;
	private String apwd;
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public String getAcon() {
		return acon;
	}
	public void setAcon(String acon) {
		this.acon = acon;
	}
	
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
}
