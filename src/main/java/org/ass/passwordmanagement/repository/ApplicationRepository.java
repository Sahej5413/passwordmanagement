package org.ass.passwordmanagement.repository;

import java.util.List;

import org.ass.passwordmanagement.entity.ApplicationEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ApplicationRepository {
	@Autowired
	private SessionFactory sessionFactory;

	public ApplicationEntity save(ApplicationEntity applicationEntity) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ApplicationEntity savedObject=(ApplicationEntity) session.merge(applicationEntity);
		transaction.commit();
		return savedObject;
	}

	public List<ApplicationEntity> findAll() {
		Session session = sessionFactory.openSession();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("from ApplicationEntity");
		Query query = session.createQuery(stringBuilder.toString());
		return query.getResultList();
	}

	public ApplicationEntity findById(long id) {
		Session session = sessionFactory.openSession();
		ApplicationEntity applicationEntity = session.get(ApplicationEntity.class, id);
		return applicationEntity;
	}

	public List<ApplicationEntity> findByAppType(String appType) {
		Session session = sessionFactory.openSession();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("from ApplicationEntity where appType=:e");
		Query query = session.createQuery(stringBuilder.toString());
		query.setParameter("e", appType);
		return query.getResultList();
	}
}
