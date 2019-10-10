package com.splitApp.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.splitApp.appProperty.AppConstants;
import com.splitApp.utils.HibernateUtil;

public class UniversalDaoImpl implements UniversalDao {

	@Override
	public void addObject(Object object) {
		// TODO Auto-generated method stub
		
		Session sess = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		
		try{
			tx = sess.beginTransaction();
			sess.save(object);
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null ){
				tx.rollback();
			}
		}finally{
			sess.close();
		}		
	}
	
	@SuppressWarnings("all")
	public synchronized Object lookup(Class classObject, String propertyName, String propertyValue){
		List list = null;
		
		list = retrieveValueByField(classObject,propertyName,propertyValue);
			
		Object obj = null;
		
		if(list.size()==0){
			return null;
			
		}else{
			obj = list.get(0);
			return obj;
		}
		
		
		
	}
	
	@SuppressWarnings("all")
	public static List retrieveValueByField(Class classObject, String propertyName, String propertyValue){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List list = null;
		
		try{
			Criteria criteria = session.createCriteria(classObject);
			criteria.add(Restrictions.eq(propertyName, propertyValue));
			list = criteria.list();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List getFreindList(Class classObject,String selfPhNo, String friendPhNo)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
//		SQLQuery query= session.createSQLQuery("select * from " + AppConstants.SCHEMA_NAME+ ".friends_details where selfPhNo =:selfPhNo and friendPhNo =:friendPhNo ");
//		query.setParameter("selfPhNo", selfPhNo);
//		query.setParameter("friendPhNo", friendPhNo);
//		List list = query.list();
		
		
		List list = null;
		
		try{
			Criteria criteria = session.createCriteria(classObject);
			criteria.add(Restrictions.eq("selfPhNo", selfPhNo) );
			criteria.add(Restrictions.eq("friendPhNo", friendPhNo) );
			
			list = criteria.list();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		session.close();
		
		return list;
	}
	
	
	
	@Override
	public void updateObject(Object object) {
		// TODO Auto-generated method stub
		
		Session sess = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		
		try{
			tx = sess.beginTransaction();
			sess.update(object);
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null ){
				tx.rollback();
			}
		}finally{
			sess.close();
		}		
	}
	

}
