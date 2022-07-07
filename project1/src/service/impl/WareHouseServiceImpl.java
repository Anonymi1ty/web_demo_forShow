package service.impl;

import dao.impl.WareHouseDaoImpl;
import pojo.WareHouse;
import service.WareHService;

import java.util.List;

public class WareHouseServiceImpl implements WareHService {
    //通过Dao写的基本方法，实现service
    private WareHouseDaoImpl wareHouseDao=new WareHouseDaoImpl();
    @Override
    public List<WareHouse> queryAll() {
        return wareHouseDao.queryWareHouses();
    }

    @Override
    public void add(WareHouse wareHouse) {
        wareHouseDao.addWareHouse(wareHouse);
    }
}
