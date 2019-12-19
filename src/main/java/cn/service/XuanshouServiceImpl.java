package cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.XuanshouMapper;
import cn.pojo.Xuanshou;

@Service("xuanshouService")
@Transactional(propagation = Propagation.REQUIRED, timeout = -1)
public class XuanshouServiceImpl implements XuanshouService {
	@Resource
	private XuanshouMapper mapper;

	@Override
	public List<Xuanshou> getXuanshouList() {
		// TODO Auto-generated method stub
		return mapper.getXuanshouList();
	}

	@Override
	public int updateCount(Xuanshou xuanshou) {
		// TODO Auto-generated method stub
		return mapper.updateCount(xuanshou);
	}

	@Override
	public Integer getCount(Xuanshou xuanshou) {
		// TODO Auto-generated method stub
		return mapper.getCount(xuanshou);
	}

}
