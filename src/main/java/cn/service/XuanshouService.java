package cn.service;

import java.util.List;

import cn.pojo.Xuanshou;

public interface XuanshouService {
	List<Xuanshou> getXuanshouList();

	int updateCount(Xuanshou xuanshou);

	Integer getCount(Xuanshou xuanshou);
}
