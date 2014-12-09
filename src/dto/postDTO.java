package dto;

public class postDTO {
	private String addr;
	private String zipcode;
	private String type;
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		String z = String.valueOf(zipcode);
		String z1 = z.substring(0, 3);
		String z2 = z.substring(3, 6);
		
		this.zipcode = z1 + "-" + z2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
