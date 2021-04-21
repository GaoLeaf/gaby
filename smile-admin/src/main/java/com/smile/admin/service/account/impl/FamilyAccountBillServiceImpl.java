package com.smile.admin.service.account.impl;

import com.smile.admin.bean.domain.FamilyAccountBill;
import com.smile.admin.bean.domain.FamilyAccountBillExample;
import com.smile.admin.bean.dto.FamilyBillPage;
import com.smile.admin.common.PrincipalUtils;
import com.smile.admin.mapper.account.FamilyAccountBillMapper;
import com.smile.admin.service.account.FamilyAccountBillService;
import com.smile.tool.bean.dto.PageDataInfo;
import com.smile.tool.common.GenerationIds;
import com.smile.tool.lang.Strings;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/4/8
 * @description:
 */
@Service
public class FamilyAccountBillServiceImpl implements FamilyAccountBillService {

    @Autowired
    private FamilyAccountBillMapper familyAccountBillMapper;

    @Override
    public int saveOrUpdate(FamilyAccountBill familyAccountBill) {

        if (Strings.isEmpty(familyAccountBill.getBillId())) {
            familyAccountBill.setBillId(GenerationIds.getAccountBillGenerationIdByDateTime(familyAccountBill.getBillDate(),
                    PrincipalUtils.id()));
            familyAccountBill.setFamilyId(PrincipalUtils.familyId());
            familyAccountBill.setCreateUserId(PrincipalUtils.id());
            familyAccountBill.setCreateUserName(PrincipalUtils.name());
            familyAccountBill.setCreateDate(new Date());
            familyAccountBill.setModifyUserId(PrincipalUtils.id());
            familyAccountBill.setModifyUserName(PrincipalUtils.name());
            familyAccountBill.setModifyTime(new Date());
            return familyAccountBillMapper.insert(familyAccountBill);
        } else {
            familyAccountBill.setModifyUserId(PrincipalUtils.id());
            familyAccountBill.setModifyUserName(PrincipalUtils.name());
            familyAccountBill.setModifyTime(new Date());

            FamilyAccountBillExample example = new FamilyAccountBillExample();
            example.createCriteria().andBillIdEqualTo(familyAccountBill.getBillId());
            return familyAccountBillMapper.updateByExampleSelective(familyAccountBill, example);
        }

    }

    @Override
    public PageDataInfo<FamilyAccountBill> getFamilyBills(FamilyBillPage page) {

        FamilyAccountBillExample example = new FamilyAccountBillExample();
        example.createCriteria()
                .andFamilyIdEqualTo(page.getFamilyId());

        List<FamilyAccountBill> familyAccountBills = familyAccountBillMapper.selectByExampleWithRowbounds(example,
                new RowBounds(page.getPageNumber(), page.getPageSize()));

        PageDataInfo<FamilyAccountBill> pageDataInfo = new PageDataInfo<>();
        pageDataInfo.setRows(familyAccountBills);

        // 如果查询集合为空，或第一页数据长度不足显示数目，不再查询总条数，减少数据库交互
        if (familyAccountBills.isEmpty() ||
                (page.getPageNumber() == 1 && familyAccountBills.size() < page.getPageSize())) {
            pageDataInfo.setTotal(familyAccountBills.size());
        } else {
            pageDataInfo.setTotal(familyAccountBillMapper.countByExample(example));
        }

        return pageDataInfo;

    }

}
