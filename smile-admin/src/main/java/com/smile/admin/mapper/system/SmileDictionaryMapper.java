package com.smile.admin.mapper.system;

import com.smile.admin.bean.domain.SmileDictionary;
import com.smile.admin.bean.domain.SmileDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SmileDictionaryMapper {
    long countByExample(SmileDictionaryExample example);

    int deleteByExample(SmileDictionaryExample example);

    int insert(SmileDictionary record);

    int insertSelective(SmileDictionary record);

    List<SmileDictionary> selectByExampleWithRowbounds(SmileDictionaryExample example, RowBounds rowBounds);

    List<SmileDictionary> selectByExample(SmileDictionaryExample example);

    int updateByExampleSelective(@Param("record") SmileDictionary record, @Param("example") SmileDictionaryExample example);

    int updateByExample(@Param("record") SmileDictionary record, @Param("example") SmileDictionaryExample example);
}