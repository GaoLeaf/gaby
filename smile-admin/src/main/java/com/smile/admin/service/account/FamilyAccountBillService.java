package com.smile.admin.service.account;

import com.smile.admin.bean.domain.FamilyAccountBill;
import com.smile.admin.bean.dto.FamilyBillPage;
import com.smile.tool.bean.dto.PageDataInfo;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/4/8
 * @description:
 */
public interface FamilyAccountBillService {

    int saveOrUpdate(FamilyAccountBill familyAccountBill);

    PageDataInfo<FamilyAccountBill> getFamilyBills(FamilyBillPage page);

}
