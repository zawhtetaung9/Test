package com.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.user.dto.MyConnection;
import com.user.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Repository
public class UserReposity  {
	public static Connection con=null;
	static {
		con = MyConnection.getConnection();
	}
	
	public int addUser(User user) {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("japtestmy");
		EntityManager em=factory.createEntityManager();
		em.getTransaction().begin();
		
		int i=0;
		String sql="INSERT INTO user(name,email,password,role,create_date) values(?,?,?,?,CURRENT_TIMESTAMP)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getRole());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
}
