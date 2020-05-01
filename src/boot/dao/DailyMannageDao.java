package boot.dao;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import boot.pojo.JiTiJiaTiaoBean;
import boot.pojo.JiaTiaoBean;
import boot.pojo.JiangLiInFoBean;
import boot.pojo.NoticeBean;

@Repository
public interface DailyMannageDao {
		//查看个人请假信息
		public List<JiaTiaoBean> selectPersonalQingjia(Map<String,Object> param);
		//查看个人假条总数
		public Integer selectPersonalJiaTiaoCount(Map<String,Object> param);
		//修改个人假条状态
		public Integer updateJiaTiaoStatus(@Param("id")Integer id,@Param("status") String status);
		//删除假条操作
		public int deletePersonJiaTiaoById(@Param("id")Integer id);
		//集体请假信息
		public List<JiTiJiaTiaoBean> selectJiTiJiaTiao(Map<String, Object> param);
		//集体假条总数
		public Integer selectJiTiJiaTiaoCount(Map<String,Object> param);
		//更新集体假条状态
		public Integer updateJiTiJiaTiaoStatus(@Param("id") Integer id,@Param("status") String status);
		//删除集体假条
		public int deletejitiJiaTiao(@Param("id") Integer id);
		//向加班表中存储数据
		public void addIntoJiaBanCount(Map<String,Object> param);
		//查询所受奖励员工的信息
		public List<JiangLiInFoBean> selectJiangLiInFo(Map<String,Object> param);
		//查询所受奖励员工的总数
		public Integer jiangLiTotalCount();
		//查询员工基础工资
		public String selectEmpBaseSalary(Integer id);
		//更新奖励状态信息
		public int updateJiangLiInFo(@Param("id")Integer id,@Param("status")String status,@Param("yingdejiangli")String yingdejiangli);
		//更新公共消息库
		public int addPublicNotice(NoticeBean noticeBean);
		//更新私人消息库
		public int addPrivateNotice(NoticeBean noticeBean);
		
}
