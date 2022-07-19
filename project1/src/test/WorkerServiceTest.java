package test;

import org.junit.Test;
import pojo.Page;
import pojo.Worker;
import service.WorkerService;
import service.impl.WorkerServiceImpl;

import java.util.List;

import static org.junit.Assert.*;

public class WorkerServiceTest {
    WorkerService workerService=new WorkerServiceImpl();
    @Test
    public void add() {
        workerService.add(new Worker(null,"WJX","13698456323"));
    }

    @Test
    public void deleteById() {
        workerService.deleteById(2);
    }

    @Test
    public void update() {
        workerService.Update(new Worker(1,"WZY","1265493257"));
    }

    @Test
    public void queryById() {
        Worker res = workerService.queryById(6);
        System.out.println(res);
    }

    @Test
    public void queryAll() {
        List<Worker> res = workerService.queryAll();
        System.out.println(res);
    }

    @Test
    public void page() {
        Page<Worker> res = workerService.page(1, 3);
        System.out.println(res);
    }
}