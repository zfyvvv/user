package com.zfy.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zfy.dao.LoginDao;
import com.zfy.pojo.User;

public class LoginDaoImpl implements LoginDao{

	//验证登录！
	@Override
	public User checkLoginDao(String uname, String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;		
		User u=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="select * from t_user where uname=? and pwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("uid"));
				u.setName(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}

	@Override
	public User checkUidDao(String uid) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;		
		User u=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="select * from t_user where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("uid"));
				u.setName(rs.getString("uname"));
				u.setPwd(rs.getString("upassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}

	//更新
	@Override
	public int updUser(String uid,String uname,String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;		
		int index=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="update t_user set uname=?,pwd=? where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.setString(3, uid);
			index=ps.executeUpdate();
			//返回结果集；
			//rs=ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}

	//删除；
	@Override
	public int delUser(String uid) {
		Connection conn=null;
		PreparedStatement ps=null;
		int index=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="delete from t_user where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			index=ps.executeUpdate();
			System.out.println(index);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}

	//add
	@Override
	public int addUser(String uid, String uname, String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;		
		int index=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="insert into t_user (uid,uname,pwd) values (?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, uname);
			ps.setString(3, pwd);
			index=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}

	@Override
	public List<User> selAll() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> list=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="select * from t_user";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			list=new ArrayList<>();
			while(rs.next()){
				User u=new User();
				u.setId(rs.getInt("uid"));
				u.setName(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public User selUser(String uname) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;		
		User u=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "123456");
			String sql="select * from t_user where uname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("uid"));
				u.setName(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}


}
