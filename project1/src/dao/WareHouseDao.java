package dao;

import pojo.WareHouse;
import pojo.Worker;

import java.util.List;

public interface WareHouseDao {

    /**
     * 通过id查询仓库
     * @param id
     * @return
     */
    public WareHouse queryWareHouseById(Integer id);

    /**
     * 查询全部的仓库信息
     * @return
     */
    public List<WareHouse> queryWareHouses();

    public int addWareHouse(WareHouse wareHouse);
}
