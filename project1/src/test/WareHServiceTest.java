package test;

import org.junit.Test;
import pojo.WareHouse;
import service.WareHService;
import service.impl.WareHouseServiceImpl;

import java.util.List;

import static org.junit.Assert.*;

public class WareHServiceTest {
    WareHService wareHService=new WareHouseServiceImpl();
    @Test
    public void queryAll() {
        List<WareHouse> res = wareHService.queryAll();
        System.out.println(res);
    }

    @Test
    public void add() {
        wareHService.add(new WareHouse(null,16,"woods","ChangSha"));
    }
}