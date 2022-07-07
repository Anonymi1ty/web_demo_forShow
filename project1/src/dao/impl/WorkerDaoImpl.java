package dao.impl;

import dao.WorkerDao;
import pojo.Worker;

import java.util.List;

public class WorkerDaoImpl extends BaseDao implements WorkerDao {

    @Override
    public int addWorker(Worker worker) {
        String sql="INSERT INTO workers(workername,phonenumber) VALUES(?,?)";
        return update(sql,worker.getWorkerName(),worker.getPhoneNumber());
    }

    @Override
    public int deleteWorkerById(Integer id) {
        String sql="DELETE FROM workers WHERE id=?;";
        return update(sql,id);
    }

    @Override
    public int updateWorker(Worker worker) {
        String sql="UPDATE workers SET workername=?,phonenumber=? WHERE id=?;";
        return update(sql,worker.getWorkerName(),worker.getPhoneNumber(),worker.getId());
    }

    @Override
    public Worker queryWorkerById(Integer id) {
        String sql="SELECT * FROM workers WHERE id=?;";
        return queryForOne(Worker.class,sql,id);
    }

    @Override
    public List<Worker> queryWorkers() {
        String sql="SELECT * FROM workers";
        return queryForList(Worker.class,sql);
    }

}
