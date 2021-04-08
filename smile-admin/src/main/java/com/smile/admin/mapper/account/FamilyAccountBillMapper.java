package com.smile.admin.mapper.account;

import com.smile.admin.bean.domain.FamilyAccountBill;
import com.smile.admin.bean.domain.FamilyAccountBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FamilyAccountBillMapper {
    long countByExample(FamilyAccountBillExample example);

    int deleteByExample(FamilyAccountBillExample example);

    int insert(FamilyAccountBill record);

    int insertSelective(FamilyAccountBill record);

    List<FamilyAccountBill> selectByExampleWithRowbounds(FamilyAccountBillExample example, RowBounds rowBounds);

    List<FamilyAccountBill> selectByExample(FamilyAccountBillExample example);

    int updateByExampleSelective(@Param("record") FamilyAccountBill record, @Param("example") FamilyAccountBillExample example);

    int updateByExample(@Param("record") FamilyAccountBill record, @Param("example") FamilyAccountBillExample example);
}