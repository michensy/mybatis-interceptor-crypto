package com.sf.core.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * 继承自己的MyMapper
 */
public interface MyMapper<T> extends Mapper<T>, ConditionMapper<T>,RowBoundsMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}