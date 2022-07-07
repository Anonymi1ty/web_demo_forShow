package test;

import dao.impl.WareHouseDaoImpl;
import org.junit.Test;
import pojo.WareHouse;

import java.util.List;

import static org.junit.Assert.*;

public class WareHouseDaoTest {
    WareHouseDaoImpl wareHouseDao=new WareHouseDaoImpl();
    @Test
    public void queryWareHouseById() {
        WareHouse result = wareHouseDao.queryWareHouseById(1);
        System.out.println(result);
    }

    @Test
    public void queryWareHouses() {
        List<WareHouse> result = wareHouseDao.queryWareHouses();
        System.out.println(result);
    }
    @Test
    public void addWareHouse() {
        int result = wareHouseDao.addWareHouse(new WareHouse(null, 19, "胶水", "长沙"));
        System.out.println(result);
    }
}