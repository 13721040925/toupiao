package cn.service;

import java.util.List;

import cn.pojo.Phone;

public interface PhoneService {
	int addPhone(Phone phone);

	Phone checkPhone(Phone phone);

	Integer getStatus(Phone phone);

	List<Phone> getPhoneList();
}
