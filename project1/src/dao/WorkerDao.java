package dao;

import pojo.Worker;

import java.util.List;

public interface WorkerDao {

    /**
     * 添加员工
     * @param worker
     * @return
     */
    public int addWorker(Worker worker);

    /**
     * 根据Id删除员工
     * @param id
     * @return
     */
    public int deleteWorkerById(Integer id);

    /**
     * 修改员工信息
     * @param worker
     * @return
     */
    public int updateWorker(Worker worker);

    /**
     * 通过Id查询员工
     * @param id
     * @return
     */
    public Worker queryWorkerById(Integer id);

    /**
     * 查询全部工人信息
     * @return
     */
    public List<Worker> queryWorkers();
}
