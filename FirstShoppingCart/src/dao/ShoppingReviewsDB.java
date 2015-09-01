package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.Shoppingreview;


public class ShoppingReviewsDB {
	public static void insert(Shoppingreview user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	} 

	public static void update(Shoppingreview user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Shoppingreview user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
/*	public static void deleteByUsername(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "delete i from Shoppinguser i where i.username = '" + username + "'";
		TypedQuery<Usershoppingcart> q = em.createQuery(qString, Usershoppingcart.class);
		List<Usershoppingcart> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				return null;
			}
		}finally{
			em.close();
		}
		return users.get(0);
	}*/
	
	
	
	public static Shoppingreview checkLogin(String username, String password){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Shoppinguser i where i.username = '" + username + "' and i.password = '" + password + "'";
		TypedQuery<Shoppingreview> q = em.createQuery(qString, Shoppingreview.class);
		List<Shoppingreview> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				return null;
			}
		}finally{
			em.close();
		}
		return users.get(0);
	}
	
	public static List<Shoppingreview> getAllReviewByID(int pid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Shoppingreview i where i.pid = " + pid;
		TypedQuery<Shoppingreview> q = em.createQuery(qString, Shoppingreview.class);
		List<Shoppingreview> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				users = null;
			}
		}finally{
			em.close();
		}
		return users;
	}
	
	
	public static List<Shoppingreview> getProductsByUsername(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Usershoppingcart i where i.username = '" + username + "'";
		TypedQuery<Shoppingreview> q = em.createQuery(qString, Shoppingreview.class);
		List<Shoppingreview> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				users = null;
			}
		}finally{
			em.close();
		}
		return users;
	}
	
	public static Shoppingreview getProductByID(int pid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Product i where i.pid = " + pid;
		TypedQuery<Shoppingreview> q = em.createQuery(qString, Shoppingreview.class);
		List<Shoppingreview> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				users = null;
			}
		}finally{
			em.close();
		}
		return users.get(0);
	}
}
