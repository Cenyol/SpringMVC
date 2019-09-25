package com.cenyol.mybatisplus.common.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 * @date 2019-09-23 11:21
 *
 * provide the basic curd method
 * include list/insert/view/update/delete
 */
@Slf4j
public class CurdController<T> {

    @Autowired
    private BaseMapper<T> mapper;

    /**
     * 在搜索的时候，去除这几个 map 参数
     */
    private String[] pageParams = {"size", "current", "orders"};

    /**
     * example:
     * {
     *     "size": 15,            默认：10
     *     "current": 1,          当前页码
     *     "id": 1162,            SQL查询条件
     *     "orders": ["id desc"]  排序条件，可以设置多个
     * }
     * @param map
     * @return
     */
    @PostMapping( value = {"/listByPage", "/index", "/list"})
    @ResponseBody
    public String listByPage(@RequestBody Map<String, Object> map) {
        return JSON.toJSONString(
                mapper.selectPage(
                        extractPageFromRequestMap(map),
                        extractWrapperFromRequestMap(map)
                )
        );
    }

    @PostMapping( value = {"/save", "/insert"} )
    @ResponseBody
    public int save(@RequestBody T map) {
        return mapper.insert(map);
    }

    @PostMapping( value = {"/getById", "/get"} )
    @ResponseBody
    public String getById(@RequestBody Long id) {
        return JSON.toJSONString(mapper.selectById(id));
    }

    @PostMapping( value = {"/updateById", "/update"} )
    @ResponseBody
    public int updateById(@RequestBody T map) {
        return mapper.updateById(map);
    }

    @PostMapping( value = {"/deleteById", "/delete"} )
    @ResponseBody
    public int deleteById(@RequestBody Long id) {
        return mapper.deleteById(id);
    }


    /**
     * 从请求体中提取查询参数
     * @param map
     * @return
     */
    private QueryWrapper<T> extractWrapperFromRequestMap(Map<String, Object> map) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        for (String pageParam : pageParams) {
            map.remove(pageParam);
        }
        queryWrapper.allEq(map, false);
        return queryWrapper;
    }

    /**
     * 从请求体中提取分页参数
     * @param map
     * @return
     */
    private Page<T> extractPageFromRequestMap(Map<String, Object> map) {

        Page<T> page = new Page<>();

        String key = pageParams[0];
        if (map.containsKey(key) && map.get(key) instanceof Integer) {
            page.setSize((Integer)map.get(key));
        }

        key = pageParams[1];
        if (map.containsKey(key) && map.get(key) instanceof Integer) {
            page.setCurrent((Integer)map.get(key));
        }

        // 排序
        key = pageParams[2];
        if (map.containsKey(key) && map.get(key) instanceof List) {
            List<OrderItem> orderItemList = new ArrayList<>();
            for (String orderArrStr : (List<String>)map.get(key)) {
                if (StringUtils.isBlank(orderArrStr) || !orderArrStr.contains(" ")) {
                    continue;
                }
                String[] orderArr = orderArrStr.split(" ");
                if ("desc".equals(orderArr[1])) {
                    orderItemList.add(OrderItem.desc(orderArr[0]));
                } else {
                    orderItemList.add(OrderItem.asc(orderArr[0]));
                }
            }
            page.setOrders(orderItemList);
        }

        return page;
    }
}
