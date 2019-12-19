package cn.pojo;

import org.springframework.stereotype.Component;

@Component("xuanshou")
public class Xuanshou {
	private Integer id;
	private String code;
	private String name;
	private String jiemu;
	private Integer count;
	private String pic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJiemu() {
		return jiemu;
	}

	public void setJiemu(String jiemu) {
		this.jiemu = jiemu;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "Xuanshou [id=" + id + ", code=" + code + ", name=" + name + ", jiemu=" + jiemu + ", count=" + count
				+ ", pic=" + pic + "]";
	}

}
