package com.jygj.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jygj.admin.dao.ResumeDao;
import com.jygj.admin.dao.entity.ResumeEntity;
import com.jygj.admin.pojo.Resume;
import com.jygj.admin.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;

	@Override
	public List<Resume> queryAll() {
		// 从数据库查询简历列表
		List<ResumeEntity> resumeEntityList = resumeDao.queryAll();
		// 将数据库实体对象的列表转换成POJO对象的列表
		List<Resume> resumeList = new ArrayList<Resume>();
		for (ResumeEntity entity : resumeEntityList) {
			resumeList.add(new Resume(entity));
		}
		return resumeList;
	}

	@Override
	public Resume get(Integer id) {
		return new Resume(resumeDao.get(id));
	}

	@Override
	public void save(Resume resume) {
		resumeDao.save(resume.toEntity());
	}

	@Override
	public void delete(Integer id) {
		resumeDao.delete(id);
	}
	
	@Override
	public List<Resume> query(String name, Integer jobYear) {
		List<Resume> resumeList = new ArrayList<Resume>();
		for(ResumeEntity entity: resumeDao.find(name, jobYear)) {
			resumeList.add(new Resume(entity));
		}
		return resumeList;
	}
	

}
