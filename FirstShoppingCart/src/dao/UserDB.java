package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.Shoppinguser;


public class UserDB {
	public static void insert(Shoppinguser user) {
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

	public static void update(Shoppinguser user) {
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

	public static void delete(Shoppinguser user) {
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
	
	public static Shoppinguser checkLogin(String username, String password){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Shoppinguser i where i.username = '" + username + "' and i.password = '" + password + "'";
		TypedQuery<Shoppinguser> q = em.createQuery(qString, Shoppinguser.class);
		List<Shoppinguser> users;
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
	
	public static List<Shoppinguser> getAllProduct(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Product i";
		TypedQuery<Shoppinguser> q = em.createQuery(qString, Shoppinguser.class);
		List<Shoppinguser> users;
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
	
	
	public static List<Shoppinguser> getPeopleByCompanyName(String company){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Customerspractice i where i.company like '%" + company + "%'";
		TypedQuery<Shoppinguser> q = em.createQuery(qString, Shoppinguser.class);
		List<Shoppinguser> users;
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
	
	public static Shoppinguser getProductByID(int pid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Product i where i.pid = " + pid;
		TypedQuery<Shoppinguser> q = em.createQuery(qString, Shoppinguser.class);
		List<Shoppinguser> users;
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
