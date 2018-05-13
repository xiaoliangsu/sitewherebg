package db;

import model.UserBean;
import model.UserInfoBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static DbManager dbManager;

    private Connection conn = null;
    //siteware 是数据库名，根据需要修改
    private String url = "jdbc:mysql://localhost:3306/siteware?useUnicode=true&characterEncoding=utf-8";
    public static DbManager getInstance(){
        if(dbManager==null){
            synchronized (DbManager.class){
                if(dbManager==null){
                    dbManager=new DbManager();
                }
            }
        }
        return dbManager;
    }

    public void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url,"root","1234");
            System.out.println("连接数据库成功");
            createTable();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //创建数据表的操作
    public void createTable(){
        PreparedStatement pstmt;

        String sql = "create table IF NOT EXISTS stu(id integer primary key not null auto_increment,name varchar(20),pwd integer,unitName varchar(20),unitId varchar(20)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //增加
    public void insert(String name,int pwd,String unitName,String unitId){
        String sql = "insert into stu(name,pwd,unitName,unitId) values(?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt=conn.prepareStatement(sql);
            //1,2对应sql语句里面的问号顺序
            pstmt.setString(1,name);
            pstmt.setInt(2,pwd);
            pstmt.setString(3,unitName);
            pstmt.setString(4,unitId);

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //修改
    public void update(String name,int pwd,String unitName,String unitId,int id){
        String sql = "UPDATE stu set name=?,pwd=?,unitName=?,unitId=? WHERE  id=?";
        PreparedStatement pstmt;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,pwd);
            pstmt.setString(3,unitName);
            pstmt.setString(4,unitId);
            pstmt.setInt(5,id);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除
    public void delete(String name){
        String sql = "DELETE FROM stu where name=?";
        PreparedStatement pstmt;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询
    public List<UserInfoBean> select(String name){
        List<UserInfoBean> userInfoBeans=new ArrayList<UserInfoBean>();
        String sql = "SELECT * FROM stu WHERE name=?";    //要执行的SQL
        PreparedStatement pstmt;
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();//创建数据对象
            while (rs.next()){
                UserInfoBean userInfoBean=new UserInfoBean();
                userInfoBean.setName(rs.getString(2));
                userInfoBean.setPwd(rs.getInt(3));
                userInfoBean.setUnitName(rs.getString(4));
                userInfoBean.setUnitId(rs.getString(5));
                userInfoBeans.add(userInfoBean);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfoBeans;
    }



    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
