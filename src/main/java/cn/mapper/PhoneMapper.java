package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.pojo.Phone;

public interface PhoneMapper {
	@Insert(" insert into phone (tel,status) values (#{tel},#{status}) ")
	int addPhone(Phone phone);

	@Select(" select * from phone where tel=#{tel} ")
	Phone checkPhone(Phone phone);

	@Select(" select status from phone where tel=#{tel} ")
	Integer getStatus(Phone phone);

	@Select(" select * from phone ")
	List<Phone> getPhoneList();
}
