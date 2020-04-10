package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.JiTiJiaTiaoBean;
import boot.pojo.JiaTiaoBean;

@Repository
public interface DailyMannageDao {
		//查看个人请假信息
		public List<JiaTiaoBean> selectPersonalQingjia(Map<String,Object> param);
		//查看个人假条总数
		public Integer selectPersonalJiaTiaoCount();
		//修改个人假条状态
		public Integer updateJiaTiaoStatus(@Param("id")Integer id,@Param("status") String status);
		//集体请假信息
		public List<JiTiJiaTiaoBean> selectJiTiJiaTiao(Map<String, Object> param);
		//集体假条总数
		public Integer selectJiTiJiaTiaoCount();
		//更新集体假条状态
		public Integer updateJiTiJiaTiaoStatus(@Param("id") Integer id,@Param("status") String status);
}
