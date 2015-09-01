package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.Usershoppingcart;


public class UserShoppingCartDB {
	public static void insert(Usershoppingcart user) {
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

	public static void update(Usershoppingcart user) {
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

	public static void delete(Usershoppingcart user) {
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
	
	
	
	public static Usershoppingcart checkLogin(String username, String password){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Shoppinguser i where i.username = '" + username + "' and i.password = '" + password + "'";
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
	}
	
	public static List<Usershoppingcart> getAllProduct(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Product i";
		TypedQuery<Usershoppingcart> q = em.createQuery(qString, Usershoppingcart.class);
		List<Usershoppingcart> users;
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
	
	
	public static List<Usershoppingcart> getProductsByUsername(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Usershoppingcart i where i.username = '" + username + "'";
		TypedQuery<Usershoppingcart> q = em.createQuery(qString, Usershoppingcart.class);
		List<Usershoppingcart> users;
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
	
	public static Usershoppingcart getProductByID(int pid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Product i where i.pid = " + pid;
		TypedQuery<Usershoppingcart> q = em.createQuery(qString, Usershoppingcart.class);
		List<Usershoppingcart> users;
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
