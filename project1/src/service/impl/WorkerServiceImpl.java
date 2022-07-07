package service.impl;

import dao.impl.WorkerDaoImpl;
import pojo.Worker;
import service.WorkerService;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    //通过Dao写的基本方法，实现service
    private WorkerDaoImpl workerDao=new WorkerDaoImpl();
    @Override
    public void add(Worker worker) {
        workerDao.addWorker(worker);
    }

    @Override
    public void deleteById(Integer id) {
        workerDao.deleteWorkerById(id);
    }

    @Override
    public void Update(Worker worker) {
        workerDao.updateWorker(worker);
    }

    @Override
    public Worker queryById(Integer id) {
        return workerDao.queryWorkerById(id);
    }

    @Override
    public List<Worker> queryAll() {
        return workerDao.queryWorkers();
    }
}
