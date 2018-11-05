package domain;

import java.io.Serializable;


//��Ʒ�ĸ�������
public class commodity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cId;//商品ID
	private String cname;//商品名称
	private String cate;//商品类别
	private float price;//商品价格
	private String 	writer;//商品出处
	private String 	image;//商品图片
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
