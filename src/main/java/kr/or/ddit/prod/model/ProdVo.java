package kr.or.ddit.prod.model;

public class ProdVo {

	private String prod_id;
	private String prod_name;
	private String lprod_nm;
	private String prod_outline;
	private int prod_price;
	private int rnum;
	public ProdVo() {
	}
	
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
	public String getProd_outline() {
		return prod_outline;
	}
	public void setProd_outline(String prod_outline) {
		this.prod_outline = prod_outline;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	@Override
	public String toString() {
		return "ProdVo [prod_id=" + prod_id + ", prod_name=" + prod_name + ", lprod_nm=" + lprod_nm + ", prod_outline="
				+ prod_outline + ", prod_price=" + prod_price + "]";
	}
	
	
	
	
	
	
	
}
