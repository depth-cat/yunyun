package repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import domain.Users;
import domain.admin;
import domain.commodity;
import domain.scart;

//////////////////////建立连接
public class DBUtils {
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
	
		
		//////////////判断连接是否成功
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
		
		
		///////////////关闭连接对象
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
					e.printStackTrace();
				}
			}
		}
		
		

    ///////////管理员登录(从数据库中获取Id和密码是否与输入的对应)
		public static boolean adLogin(admin admin) {
			Connection  connection  = null;
			connection = DBUtils.getConnection();
			PreparedStatement prstatement = null;
			System.out.println(admin.getApwd());
			System.out.println(admin.getaId());
			ResultSet  resultSet = null;
			try {
				prstatement = connection.prepareStatement("SELECT apwd FROM admin where aId=?");
				prstatement.setString(1,admin.getaId());
				resultSet = prstatement.executeQuery();
				if(resultSet.next()){
					if(resultSet.getString("apwd").equals(admin.getApwd())){
					System.out.println(admin.getApwd());
					System.out.println(resultSet.getString("apwd"));
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




	
		
                ////////管理员所看到的所有用户的基本信息
				public static List<Users> doUQuery() {
					Connection  connection  = null;
					PreparedStatement statement = null;
					ResultSet  resultSet = null;
					List<Users> list = new ArrayList<>();
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("select * from users");
						resultSet = statement.executeQuery();
						if(resultSet!=null){
							while(resultSet.next()){
								Users user = new Users();
								user.setUname(resultSet.getString("uname"));
								user.setuId(resultSet.getString("uId"));
								user.setUsex(resultSet.getString("usex"));
								user.setUpwd(resultSet.getString("upwd"));
								list.add(user);
							}
							return list;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return null;
				
				}
				
				
				
				
		/////////////////////////管理员将用户信息删除
				public static boolean doUDelete(String uId) {
					Connection  connection  = null;
					PreparedStatement statement = null;
					PreparedStatement statement2 = null;
					PreparedStatement statement3 = null;
					PreparedStatement statement4 = null;
					ResultSet  resultSet = null;
					
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("delete from users WHERE uId = ?");
						statement.setString(1, uId);
						statement.executeUpdate();
						statement2 = connection.prepareStatement("delete from address WHERE uId = ?");
						statement2.setString(1, uId);
						statement2.executeUpdate();
						statement3 = connection.prepareStatement("delete from orders WHERE uId = ?");
						statement3.setString(1, uId);
						statement3.executeUpdate();
						statement4 = connection.prepareStatement("delete from contact WHERE uId = ?");
						statement4.setString(1, uId);
						statement4.executeUpdate();
						return true;
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return false;
				}

				
				
              /////////////////////////商品基本信息
				public static List<commodity> doCQuery() {
					Connection  connection  = null;
					PreparedStatement statement = null;
					ResultSet  resultSet = null;
					List<commodity> list = new ArrayList<>();
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("select * from commodity");
						resultSet = statement.executeQuery();
						if(resultSet!=null){
							while(resultSet.next()){
								commodity comm = new  commodity();
								comm.setcId(resultSet.getString("cId"));
								comm.setCname(resultSet.getString("cname"));
								comm.setCate(resultSet.getString("cate"));
								comm.setPrice(resultSet.getFloat("price"));
								comm.setWriter(resultSet.getString("writer"));
								comm.setImage(resultSet.getString("image"));
								list.add(comm);
							}
							return list;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return null;
				
				}
				
				
				
				
                   //////////////////////新增商品信息
				public static boolean doAddcomm(String cId,String cname,String cate,float price,String writer,String image) {
					Connection  connection  = null;
					PreparedStatement statement = null;
					ResultSet  resultSet = null;
					
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("INSERT into commodity(cId,cname,cate,price,writer,image) VALUES(?,?,?,?,?,?)");
						statement.setString(1, cId);
						statement.setString(2, cname);
						statement.setString(3, cate);
						statement.setFloat(4, price);
						statement.setString(5,writer);
						statement.setString(6,image);
						statement.executeUpdate();
							return true;	
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return false;
				
				}
				
				
				
		
				
                ///////////////////商品信息删除
				public static boolean doCDelete(String cId) {
					Connection  connection  = null;
					PreparedStatement statement = null;
					ResultSet  resultSet = null;
					
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("delete from commodity WHERE cId = ?");
						statement.setString(1, cId);
						statement.executeUpdate();
						return true;
						
					} catch (Exception e) {
						
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return false;
				
				}
				
				
				
				
               //////////////////用户基本信息
				public static Users doUQ(String uId) {
					Connection  connection  = null;
					PreparedStatement statement= null;
					ResultSet  resultSet = null;
					System.out.println(uId);
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("select users.uId,users.uname,users.upwd,users.usex,address.uaddr,contact.ucon from users,address,contact WHERE users.uId=? and contact.uId=? and address.uId=? ");
						statement.setString(1, uId);
						statement.setString(2, uId);
						statement.setString(3, uId);
						resultSet = statement.executeQuery();
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
						DBUtils.close(connection, statement, resultSet);
					}
					return null;
				
				}
				
                  ///////////////////用户信息更新
				public static boolean doUupdate(String uId,String uname,String uaddr,String ucon,String usex,String upwd) {
					Connection  connection  = null;
					PreparedStatement statement= null;
					ResultSet  resultSet = null;
					System.out.println(uId);
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("UPDATE users,address,contact SET users.uname=?,users.upwd=?,users.usex=?,address.uaddr=?,contact.ucon=? WHERE users.uId=? AND address.uId=? AND contact.uId=?");
						statement.setString(1, uname);
						statement.setString(2, upwd);
						statement.setString(3, usex);
						statement.setString(4, uaddr);
						statement.setString(5, ucon);
						statement.setString(6, uId);
						statement.setString(7, uId);
						statement.setString(8, uId);
						statement.executeUpdate();
						return true;	
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return false;
				
				}

				
				
				
				
				
              ////////////////商品信息更新
				public static boolean doCupdate(String cId,String cname,String cate,float price,String writer) {
					Connection  connection  = null;
					PreparedStatement statement= null;
					ResultSet  resultSet = null;
					System.out.println(cId);
					System.out.println("cId:::::::::::"+cId);
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("UPDATE commodity SET cname=?,cate=? ,price=?,writer=? WHERE cId=?");
						statement.setString(1, cname);
						statement.setString(2, cate);
						statement.setFloat(3, price);
						statement.setString(4,writer);
						statement.setString(5, cId);
						statement.executeUpdate();
						return true;	
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return false;
				
				}

				
				
				
               //////////// /订单具体信息
				public static List<Users> doQO(String uId) {
					Connection  connection  = null;
					PreparedStatement prstatement= null;
					ResultSet  resultSet = null;
					PreparedStatement prstatement2= null;
					ResultSet  resultSet2 = null;
					
					System.out.println(uId);
					try {
						connection = DBUtils.getConnection();
						List<Users> userlist = new ArrayList<>();
						prstatement = connection.prepareStatement("SELECT *,count(*) AS 'num' FROM orders WHERE uId=? GROUP BY cId");
						prstatement.setString(1,uId);
						resultSet = prstatement.executeQuery();
						prstatement2 = connection.prepareStatement("SELECT * FROM commodity WHERE cId in(SELECT cId FROM orders WHERE uId=?) ");
						prstatement2.setString(1,uId);
						resultSet2 = prstatement2.executeQuery();
						if(resultSet!=null){
							while(resultSet.next()&&resultSet2.next()){
								Users users = new Users();
								users.setuId(uId);
								users.setcId(resultSet.getString("cId"));
								users.setNum(resultSet.getInt("num"));
								int num = resultSet.getInt("num");
								System.out.println(num);
								users.setCname(resultSet2.getString("cname"));
								users.setCate(resultSet2.getString("cate"));
								users.setWriter(resultSet2.getString("writer"));
								users.setPrice(resultSet2.getFloat("price"));
								userlist.add(users);
								
							}
							return userlist;
						}else{
							return null;
							}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, prstatement, resultSet);
						DBUtils.close(connection, prstatement2, resultSet2);
						
					}
					return null;
				
				}
				
				
				
                   ///////////订单信息删除
				public static boolean doODelete(String uId,String cId) {
					Connection  connection  = null;
					PreparedStatement statement = null;
					ResultSet  resultSet = null;
					System.out.println(uId);
					System.out.println(cId);
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("delete from orders WHERE cId = ? AND uId=?");
						statement.setString(1, cId);
						statement.setString(2, uId);
						statement.executeUpdate();
						return true;
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return false;
				
				}
				
				
				
              //////////////添加到购物车			
				public static boolean Addtocart(String uId,String cId) {
					Connection  connection  = null;
					connection = DBUtils.getConnection();
					PreparedStatement prstatement = null;
					ResultSet  resultSet = null;
					System.out.println("添加到购物车的uId:::"+uId);
					System.out.println("添加到购物车的cId：：：："+cId);
					
					try {
							prstatement = connection.prepareStatement("INSERT INTO cart(uId,cId) VALUES(?,?)");
							prstatement.setString(1,uId);
							prstatement.setString(2,cId);
							prstatement.executeUpdate();
				     		return true;	
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, prstatement, resultSet);
						
					}
					return false;
				}
				
				
				
                 //查看购物车	
				public static List<scart> doQcart(String uId) {
					Connection  connection  = null;
					connection = DBUtils.getConnection();
					PreparedStatement prstatement = null;
					PreparedStatement prstatement2 = null;
					List<scart> scartlist = new ArrayList<>();
					ResultSet  resultSet = null;
					ResultSet  resultSet2 = null;
					try {
							prstatement = connection.prepareStatement("SELECT *,count(*) AS 'num' FROM cart WHERE uId=? GROUP BY cId");
							prstatement.setString(1,uId);
							resultSet = prstatement.executeQuery();
							prstatement2 = connection.prepareStatement("SELECT * FROM commodity WHERE cId in(SELECT cId FROM cart WHERE uId=?) ");
							prstatement2.setString(1,uId);
							resultSet2 = prstatement2.executeQuery();
							if(resultSet!=null)
								while(resultSet.next()&&resultSet2.next()){
									scart scart = new scart();
									scart.setNum(resultSet.getInt("num"));
									scart.setcId(resultSet.getString("cId"));
									scart.setCate(resultSet2.getString("cate"));
									scart.setCname(resultSet2.getString("cname"));
									scart.setPrice(resultSet2.getFloat("price"));
									scart.setWriter(resultSet2.getString("writer"));
									
									scartlist.add(scart);
								}
							return scartlist;
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, prstatement, resultSet);
						
					}
					return null;
				}
				
				
				
				
               //购物车中删除商品
				public static boolean doDelCart(String uId,String cId) {
					Connection  connection  = null;
					PreparedStatement statement = null;
					ResultSet  resultSet = null;
					
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("DELETE FROM cart WHERE uId=? AND cId = ? LIMIT 1");
						statement.setString(2, cId);
						statement.setString(1, uId);
						statement.executeUpdate();
						return true;
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return false;
				
				}

				
   //购物车添加到订单
public static boolean doMoveCart(String uId,String cId) {
		Connection  connection  = null;
		PreparedStatement statement = null;
		ResultSet  resultSet = null;
		PreparedStatement prstatement = null;
		PreparedStatement prstatement2 = null;
		System.out.println(uId);
		System.out.println(cId);
			try {
				connection = DBUtils.getConnection();
				statement = connection.prepareStatement("SELECT *,count(*) AS 'num' FROM cart WHERE uId=? and cId=?  GROUP BY cId");
				statement.setString(2, cId);
				statement.setString(1, uId);
						
				resultSet = statement.executeQuery();
					if(resultSet!=null)
						while(resultSet.next()){
							int num = resultSet.getInt("num");
							for(int i=0; i<num;i++)
							{
								System.out.println(num);
								prstatement = connection.prepareStatement("INSERT INTO orders(uId,cId) VALUES(?,?)");
								prstatement.setString(1,uId);
								prstatement.setString(2,cId);
								prstatement.executeUpdate();
							}
							
						}
					return true;
						
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					DBUtils.close(connection, statement, resultSet);
					DBUtils.close(connection, prstatement, resultSet);
					DBUtils.close(connection, prstatement2, resultSet);
				}
				return false;
				
			}
				
				
				
                 //购物车添加到订单后移出购物车
				public static boolean doCart(String uId,String cId) {
					Connection  connection  = null;
					PreparedStatement statement = null;
					ResultSet  resultSet = null;
					System.out.println(uId);
					try {
						connection = DBUtils.getConnection();
						statement = connection.prepareStatement("DELETE FROM cart WHERE uId=? AND cId = ?");
						statement.setString(2, cId);
						statement.setString(1, uId);
						statement.executeUpdate();
						return true;		
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						DBUtils.close(connection, statement, resultSet);
					}
					return false;
				
				}
}

