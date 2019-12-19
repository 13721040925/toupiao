package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.pojo.Xuanshou;

public interface XuanshouMapper {
	@Select(" select * from xuanshou ")
	List<Xuanshou> getXuanshouList();

	@Update(" update  xuanshou set count=#{count} where code=#{code} ")
	int updateCount(Xuanshou xuanshou);

	@Select(" select count from xuanshou where code=#{code} ")
	Integer getCount(Xuanshou xuanshou);
}
