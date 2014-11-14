package com.jygj.admin.service;

import java.util.List;

import com.jygj.admin.pojo.Resume;

public interface ResumeService {

	/**
	 * 查询所有简历信息
	 * 
	 * @return 返回简历列表
	 */
	List<Resume> queryAll();

	/**
	 * 查询简历信息
	 * 
	 * @param id
	 *            传入简历信息的id
	 * @return 返回简历信息
	 */
	Resume get(Integer id);

	/**
	 * 保存简历信息
	 * 
	 * @param resume
	 *            传入简历信息
	 */
	void save(Resume resume);

	/**
	 * 删除简历信息
	 * 
	 * @param id
	 *            传入简历id
	 */
	void delete(Integer valueOf);

	/**
	 * 查询简历信息
	 * 
	 * @param name
	 * @param jobYear
	 * @return
	 */
	List<Resume> query(String name, Integer jobYear);

}
