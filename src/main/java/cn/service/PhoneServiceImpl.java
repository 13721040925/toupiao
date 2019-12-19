package cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.PhoneMapper;
import cn.pojo.Phone;

@Service("phoneService")
@Transactional(propagation = Propagation.REQUIRED, timeout = -1)
public class PhoneServiceImpl implements PhoneService {
	@Resource
	private PhoneMapper mapper;

	@Override
	public int addPhone(Phone phone) {
		// TODO Auto-generated method stub
		return mapper.addPhone(phone);
	}

	@Override
	public Phone checkPhone(Phone phone) {
		// TODO Auto-generated method stub
		return mapper.checkPhone(phone);
	}

	@Override
	public Integer getStatus(Phone phone) {
		// TODO Auto-generated method stub
		return mapper.getStatus(phone);
	}

	@Override
	public List<Phone> getPhoneList() {
		// TODO Auto-generated method stub
		return mapper.getPhoneList();
	}

}
