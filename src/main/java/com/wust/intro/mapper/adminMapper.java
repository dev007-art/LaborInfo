package com.wust.intro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wust.intro.pojo.NotifyPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface adminMapper extends BaseMapper<NotifyPojo> {
}
