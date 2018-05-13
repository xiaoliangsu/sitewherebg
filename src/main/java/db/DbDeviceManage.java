package db;
import model.DeviceInfoBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDeviceManage {
    private static DbDeviceManage dbDeviceManage;

    private Connection conn = null;
    //siteware 是数据库名，根据需要修改
    private String url = "jdbc:mysql://localhost:3306/siteware?useUnicode=true&characterEncoding=utf-8";
    public static DbDeviceManage getInstance(){
        if(dbDeviceManage==null){
            synchronized (DbDeviceManage.class){
                if(dbDeviceManage==null){
                    dbDeviceManage=new DbDeviceManage();
                }
            }
        }
        return dbDeviceManage;
    }

    public void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url,"root","1234");
            createTable();
            System.out.println("连接数据库成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //创建数据表的操作
    public void createTable(){
        PreparedStatement pstmt;

        String sql = "create table IF NOT EXISTS deviceInfo(id integer primary key not null auto_increment,name varchar(20),siteToken varchar(30),specToken varchar(100),sitewhereToken varchar(30),specName varchar(30)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //增加
    public void insert(String name,String siteToken,String specToken,String sitewhereToken,String specName){
        String sql = "insert into deviceInfo(name,siteToken,specToken,sitewhereToken,specName) values(?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt=conn.prepareStatement(sql);
            //1,2对应sql语句里面的问号顺序
            pstmt.setString(1,name);
            pstmt.setString(2,siteToken);
            pstmt.setString(3,specToken);
            pstmt.setString(4,sitewhereToken);
            pstmt.setString(5,specName);

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //修改
    public void update(String name,String siteToken,String specToken,String sitewhereToken,String specName,int id){
        String sql = "UPDATE deviceInfo set name=?,siteToken=?,specToken=?,sitewhereToken=? ,specName = ? WHERE  id=?";
        PreparedStatement pstmt;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,siteToken);
            pstmt.setString(3,specToken);
            pstmt.setString(4,sitewhereToken);
            pstmt.setString(5,specName);
            pstmt.setInt(6,id);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除
    public void delete(String name){
        String sql = "DELETE FROM deviceInfo where name=?";
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
    public List<DeviceInfoBean> select(String name){
        List<DeviceInfoBean> deviceInfoBeans = new ArrayList<DeviceInfoBean>();
        String sql = "SELECT * FROM deviceInfo WHERE name=?";    //要执行的SQL
        PreparedStatement pstmt;
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();//创建数据对象
            while (rs.next()){
                DeviceInfoBean deviceInfoBean=new DeviceInfoBean();
                deviceInfoBean.setName(rs.getString(2));
                deviceInfoBean.setSiteToken(rs.getString(3));
                deviceInfoBean.setSpecificationToken(rs.getString(4));
                deviceInfoBean.setSitewhereToken(rs.getString(5));
                deviceInfoBean.setSpecName(rs.getString(6));

                deviceInfoBeans.add(deviceInfoBean);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deviceInfoBeans;
    }



    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
