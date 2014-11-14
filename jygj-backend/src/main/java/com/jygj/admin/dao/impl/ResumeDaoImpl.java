package com.jygj.admin.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.jygj.admin.common.HibernateSessionFactory;
import com.jygj.admin.dao.ResumeDao;
import com.jygj.admin.dao.entity.ResumeEntity;

@Repository
public class ResumeDaoImpl implements ResumeDao {

	@Override
	public ResumeEntity get(Integer id) {
		return (ResumeEntity) HibernateSessionFactory.get(ResumeEntity.class, id);
	}

	@Override
	public void save(ResumeEntity resumeEntity) {
		HibernateSessionFactory.save(resumeEntity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ResumeEntity> queryAll() {
		String hql = "from ResumeEntity order by id";
		return (List<ResumeEntity>) HibernateSessionFactory.list(hql);
	}

	@Override
	public void delete(Integer id) {
		HibernateSessionFactory.delete(ResumeEntity.class, id);
	}

	@Override
	public void deleteByIds(List<Integer> idList) {
		HibernateSessionFactory.batchDelete(ResumeEntity.class, idList);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ResumeEntity> find(String name, Integer jobYear) {
		String hql = "from ResumeEntity";
		Object[] params = null;
		if (StringUtils.isNotBlank(name) && jobYear != null && jobYear.intValue() > 0) {
			hql += " where name like ? and jobYear <= ?";
			params = new Object[]{"%" + name + "%", jobYear};
		} else if (StringUtils.isNotBlank(name)) {
			hql += " where name like ?";
			params = new Object[]{"%" + name + "%"};
		} else if (jobYear != null && jobYear.intValue() > 0) {
			hql += " where jobYear <= ?";
			params = new Object[]{jobYear};
		} 
		return (List<ResumeEntity>) HibernateSessionFactory.find(params, hql);
	}

}
