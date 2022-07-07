package utils;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    //创建
     private static DruidAbstractDataSource dataSource;
     static {

         try {
             Properties properties = new Properties();
             //通过反射来获取配置文件流
             InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
             //并且加载
             properties.load(inputStream);
             //创建数据库连接池
             dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     }

    public static void main(String[] args) {

    }

    /**
     * 获取数据库连接池中的连接
     * 如果返回null，则说明连接失败
     */
    public static Connection getConnect(){
        Connection con=null;
        try {
            //这一步如果失败则返回null值
            con=dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    /**
     * 关闭连接，放回数据库连接池
     * @param con
     */
    public static void close(Connection con){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
