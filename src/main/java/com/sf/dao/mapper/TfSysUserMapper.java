package com.sf.dao.mapper;

import com.sf.core.mapper.MyMapper;
import com.sf.dao.model.TfSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TfSysUserMapper extends MyMapper<TfSysUser> {
    void insertBatch(@Param(value = "users") List<TfSysUser> users);
}