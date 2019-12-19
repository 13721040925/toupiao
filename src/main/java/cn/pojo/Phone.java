package cn.pojo;

import org.springframework.stereotype.Component;

@Component("phone")
public class Phone {
	private Integer id;
	private String tel;
	private Integer status;
	private String beizhu;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", tel=" + tel + ", status=" + status + ", beizhu=" + beizhu + "]";
	}
	

}
