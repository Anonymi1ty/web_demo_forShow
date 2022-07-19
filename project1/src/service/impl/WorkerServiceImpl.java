package service.impl;

import dao.WorkerDao;
import dao.impl.WorkerDaoImpl;
import pojo.Page;
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

    @Override
    public Page<Worker> page(Integer pageNo, Integer pageSize) {
        Page<Worker> page = new Page<Worker>();
        //设置当前页
        page.setPageNo(pageNo);
        //设置每页显示数量
        page.setPageSize(pageSize);
        //设置总记录数
        Integer pageTotalCount= workerDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;//总记录÷每页显示
        if (pageTotalCount % pageSize>0)//如果有余数，加一页
            pageTotal++;
        page.setPageTotal(pageTotal);

        //当前页数据
        int begin=(page.getPageNo()-1)*pageSize;//开始的sql查询行数
        List<Worker> items=workerDao.queryForPageItems(begin,pageSize);//求当前页数据
        page.setItems(items);//保存当前页数据
        return page;
    }
}
