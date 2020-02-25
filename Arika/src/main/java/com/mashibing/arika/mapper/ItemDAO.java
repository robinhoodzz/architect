package com.mashibing.arika.mapper;

import com.mashibing.arika.entity.Item;
import com.mashibing.arika.entity.ItemExample;
import org.springframework.stereotype.Repository;

/**
 * ItemDAO继承基类
 */
@Repository
public interface ItemDAO extends MyBatisBaseDao<Item, Integer, ItemExample> {
}