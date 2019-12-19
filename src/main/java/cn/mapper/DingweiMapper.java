package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.pojo.Dingwei;

public interface DingweiMapper {

	@Insert(" insert into dingwei (longitude,latitude,name,detail,city,beizhu) values (#{longitude},#{latitude},#{name},#{detail},#{city},#{beizhu}) ")
	int addDingWei(Dingwei dingwei);

	@Select(" select * from dingwei where beizhu=1 limit 0,1 ")
	Dingwei getDingwei();

	@Select(" select * from dingwei ")
	List<Dingwei> getDingweiList();
}
