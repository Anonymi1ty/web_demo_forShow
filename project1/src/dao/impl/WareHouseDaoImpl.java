package dao.impl;

import dao.WareHouseDao;
import pojo.WareHouse;

import java.util.List;

public class WareHouseDaoImpl extends BaseDao implements WareHouseDao {

    @Override
    public WareHouse queryWareHouseById(Integer id) {
        String sql="SELECT * FROM warehouse WHERE id=?";
        return queryForOne(WareHouse.class,sql,id);
    }

    @Override
    public List<WareHouse> queryWareHouses() {
        String sql="SELECT * FROM warehouse";
        return queryForList(WareHouse.class,sql);
    }

    @Override
    public int addWareHouse(WareHouse wareHouse) {
        String sql="INSERT INTO warehouse(goodType,goodNumber,goodPosition) VALUES(?,?,?)";
        return update(sql,wareHouse.getGoodType(),wareHouse.getGoodNumber(),wareHouse.getGoodPosition());
    }

}
