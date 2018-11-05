package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import domain.Users;



public class UserDAO {
		private static String driverName;
		private static String url;
		private static String pwd;
		private static String user;
		static{
			driverName ="com.mysql.jdbc.Driver";
			url = "jdbc:mysql://localhost:3306/yunyun1?characterEncoding=utf8&useSSL=true";
			user= "root";
			pwd = "123456";
			try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		public static Connection getConnection(){
			try {
				Connection connection =DriverManager.getConnection(url,user,pwd);
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		
		//////////////////判断连接是否成功
		public static void check(Connection connection) {
			try {
				
				if(connection!=null){
					System.out.println("连接成功!");
				}else{
					System.out.println("连接失败!");
				}
			} catch (Exception e) {
			}
		}
		
		////////////////////关闭连接对象
		public static void close(Connection connection,Statement statement,ResultSet rs){
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		///////////////////////用户注册登录
public static boolean doRegiser(Users user) {
	Connection  connection  = null;
	connection = UserDAO.getConnection();
	PreparedStatement prstatement = null;
	PreparedStatement prstatement2 = null;
	PreparedStatement prstatement3 = null;
	PreparedStatement prstatement4 = null;
	ResultSet  resultSet = null;
	try {
		prstatement = connection.prepareStatement("SELECT * FROM users where uId=?");
		prstatement.setString(1, user.getuId());
		resultSet = prstatement.executeQuery();
		if(resultSet.next()){
			System.out.println("输入ID已经存在,请重新输入!");
			System.out.println(user.getuId());
			return false;
		}else{
			prstatement2 = connection.prepareStatement("INSERT INTO users(uId,uname,usex,upwd) VALUES(?,?,?,?)");
			prstatement2.setString(1,user.getuId() );
			prstatement2.setString(2, user.getUname());
			prstatement2.setString(3, user.getUsex());
			prstatement2.setString(4,user.getUpwd());
			prstatement2.executeUpdate();
			prstatement3 = connection.prepareStatement("INSERT INTO address(uaddr,uId) VALUES(?,?)");
			prstatement3.setString(1, user.getUaddr());
			prstatement3.setString(2, user.getuId());
			prstatement3.executeUpdate();
			prstatement4 = connection.prepareStatement("INSERT INTO contact(ucon,uId) VALUES(?,?)");
			prstatement4.setString(1, user.getUcon());
			prstatement4.setString(2, user.getuId());
			prstatement4.executeUpdate();
			return true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		UserDAO.close(connection, prstatement, resultSet);
		UserDAO.close(connection, prstatement2, resultSet);
		UserDAO.close(connection, prstatement3, resultSet);
		UserDAO.close(connection, prstatement4, resultSet);
		
		
	}
	return false;
  }





///////////////////////用户登录检验
		public static boolean doLogin(Users user) {
			Connection  connection  = null;
			connection = DBUtils.getConnection();
			PreparedStatement prstatement = null;
			
			ResultSet  resultSet = null;
			try {
				prstatement = connection.prepareStatement("SELECT upwd FROM users where uId=?");
				prstatement.setString(1,user.getuId());
				resultSet = prstatement.executeQuery();
				if(resultSet.next()){
					if(resultSet.getString("upwd").equals(user.getUpwd())){
					System.out.println(user.getUpwd());
					System.out.println(resultSet.getString("upwd"));
					System.out.println("账号与密码相匹配!");
					return true;
					}
				}else{
					
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUtils.close(connection, prstatement, resultSet);
				
			}
			return false;
		}
		
		
               
		/////////////////////用户的所有信息
				public static Users doQP(String uId) {
					Connection  connection  = null;
					connection = DBUtils.getConnection();
					PreparedStatement prstatement = null;
					System.out.println(uId);
					ResultSet  resultSet = null;
					try {
						prstatement = connection.prepareStatement("select users.uId,users.uname,users.upwd,users.usex,address.uaddr,contact.ucon from users,address,contact WHERE users.uId=? and contact.uId=? and address.uId=? ");
						prstatement.setString(1, uId);
						prstatement.setString(2, uId);
						prstatement.setString(3, uId);
						resultSet = prstatement.executeQuery();
						if(resultSet!=null){
							while(resultSet.next()){
								Users users = new Users();
								users.setUname(resultSet.getString("uname"));
								users.setuId(resultSet.getString("uId"));
								users.setUsex(resultSet.getString("usex"));
								users.setUpwd(resultSet.getString("upwd"));
								users.setUaddr(resultSet.getString("uaddr"));
								users.setUcon(resultSet.getString("ucon"));
								
								return users;
							}
						}else{
							return null;
							}	
					} catch (Exception e) {
						
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, prstatement, resultSet);
					}
					return null;
				
				}


}