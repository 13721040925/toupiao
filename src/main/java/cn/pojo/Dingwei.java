package cn.pojo;

import org.springframework.stereotype.Component;

@Component("dingwei")
public class Dingwei {
	private Integer id;
	private String longitude;
	private String latitude;
	private String name;
	private String detail;
	private String city;
	private Integer beizhu;

	public Dingwei() {
	}

	public Dingwei(String longitude, String latitude, String name, String detail, String city, Integer beizhu) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.detail = detail;
		this.city = city;
		this.beizhu = beizhu;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(Integer beizhu) {
		this.beizhu = beizhu;
	}

	@Override
	public String toString() {
		return "Dingwei [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", name=" + name
				+ ", detail=" + detail + ", city=" + city + ", beizhu=" + beizhu + "]";
	}


}
