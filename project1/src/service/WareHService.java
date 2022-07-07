package service;

import pojo.WareHouse;

import java.util.List;

public interface WareHService {

    /**
     * 查询全部数据用于图标展示
     * @return 返回结果为List返回值
     */
    public List<WareHouse> queryAll();

    public void add(WareHouse wareHouse);
}
