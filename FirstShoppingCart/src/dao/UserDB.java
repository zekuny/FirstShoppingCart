package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.Shoppinguser;
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
	
	public static List<Shoppinguser> getAllUser(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Shoppinguser i";
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
	
	public static Shoppinguser getUserByID(int uid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Shoppinguser i where i.userid = " + uid;
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
	
	public static Shoppinguser getUserByName(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Shoppinguser i where i.username = '" + uname + "'";
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
	
	public static boolean isAvailable(Shoppinguser user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT count(d.username) FROM Shoppinguser d WHERE UPPER(d.username) = :userName OR UPPER(d.email) = :email";
		try
		{
			long l = (long) em.createQuery(query)
					.setParameter("username", user.getUsername().toUpperCase())
					.setParameter("email", user.getEmail().toUpperCase())
					.getSingleResult();
			if (l>0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			em.close();
		}
	}
}
