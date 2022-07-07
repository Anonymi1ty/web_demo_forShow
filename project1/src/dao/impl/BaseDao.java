package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用Dbutils操作数据库

    private QueryRunner queryRunner=new  QueryRunner();
    /**
     * update()方法来执行：Insert/Update/Delete
     * 如果返回-1说明失败
     */
    public int update(String sql,Object ...args){
        //需要传入sql语句和占位符
        Connection connection = JdbcUtils.getConnect();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection);
        }

    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return
     * @param <T>   返回的泛型
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection connection = JdbcUtils.getConnect();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection);
        }
    }

    /**
     * 查询返回多个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return
     * @param <T>   返回的泛型
     */
    public <T> List<T> queryForList(Class<T> type,String sql,Object ...args){
        Connection connection = JdbcUtils.getConnect();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object ...args){
        Connection connection = JdbcUtils.getConnect();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection);
        }
    }
}
