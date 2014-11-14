package com.jygj.admin.dao;

import java.util.List;

import com.jygj.admin.dao.entity.ResumeEntity;

public interface ResumeDao {

	ResumeEntity get(Integer id);

	/**
	 * 新增 or 修改简历实体对象信息
	 * 
	 * @param resume
	 *            传入需要操作的简历实体对象信息
	 */
	void save(ResumeEntity resumeEntity);

	/**
	 * 查询简历信息实体对象列表
	 * 
	 * @return 返回简历实体对象列表
	 */
	List<ResumeEntity> queryAll();

	/**
	 * 删除简历实体对象信息
	 * 
	 * @param id
	 *            传入简历id
	 */
	void delete(Integer id);

	/**
	 * 删除简历实体对象信息
	 * 
	 * @param idList
	 *            传入简历id列表
	 */
	void deleteByIds(List<Integer> idList);

	/**
	 * 查询简历实体对象信息列表
	 * 
	 * @param name
	 *            传入姓名, 姓名模糊匹配
	 * @param jobYear
	 *            传入工作年限, 工作年限在指定年限以内
	 * @return 返回符合条件的简历实体对象列表
	 */
	List<ResumeEntity> find(String name, Integer jobYear);

}
