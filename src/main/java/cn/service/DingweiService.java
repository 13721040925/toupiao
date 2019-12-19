package cn.service;

import java.util.List;

import cn.pojo.Dingwei;

public interface DingweiService {
	int addDingWei(Dingwei dingwei);

	Dingwei getDingwei();

	List<Dingwei> getDingweiList();
}
