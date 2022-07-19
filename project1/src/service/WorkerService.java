package service;

import pojo.Page;
import pojo.Worker;

import java.util.List;

public interface WorkerService {

    public void add(Worker worker);

    public void deleteById(Integer id);

    public void Update(Worker worker);

    public Worker queryById(Integer id);

    public List<Worker> queryAll();

    /**
     * 实现分页的数据传输
     * @param pageNo 当前页码
     * @param pageSize 总页码
     * @return
     */
    Page<Worker> page(Integer pageNo, Integer pageSize);

}
