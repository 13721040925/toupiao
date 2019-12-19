package cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.DingweiMapper;
import cn.pojo.Dingwei;

@Service("dingweiService")
@Transactional(propagation = Propagation.REQUIRED, timeout = -1)
public class DingweiServiceImpl implements DingweiService {
	@Resource
	private DingweiMapper mapper;

	@Override
	public int addDingWei(Dingwei dingwei) {
		// TODO Auto-generated method stub
		return mapper.addDingWei(dingwei);
	}

	@Override
	public Dingwei getDingwei() {
		// TODO Auto-generated method stub
		return mapper.getDingwei();
	}

	@Override
	public List<Dingwei> getDingweiList() {
		// TODO Auto-generated method stub
		return mapper.getDingweiList();
	}

}
