package service;

import pojo.Worker;

import java.util.List;

public interface WorkerService {

    public void add(Worker worker);

    public void deleteById(Integer id);

    public void Update(Worker worker);

    public Worker queryById(Integer id);

    public List<Worker> queryAll();
}
