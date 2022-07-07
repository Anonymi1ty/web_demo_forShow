package test;

import dao.impl.WorkerDaoImpl;
import org.junit.Test;
import pojo.Worker;

import java.util.List;

import static org.junit.Assert.*;

public class WorkerDaoTest {
    WorkerDaoImpl workerDao=new WorkerDaoImpl();

    @Test
    public void addWorker() {
        int result = workerDao.addWorker(new Worker(null, "Zy", "1234567890"));
        System.out.println(result);
    }

    @Test
    public void deleteBookById() {
        int result = workerDao.deleteWorkerById(3);
        System.out.println(result);
    }

    @Test
    public void updateWorker() {
        int result = workerDao.updateWorker(new Worker(1, "WYZ", "296027154"));
        System.out.println(result);
    }

    @Test
    public void queryWorkerById() {
        Worker result = workerDao.queryWorkerById(1);
        System.out.println(result);
    }

    @Test
    public void queryWorkers() {
        List<Worker> result = workerDao.queryWorkers();
        System.out.println(result);
    }
}