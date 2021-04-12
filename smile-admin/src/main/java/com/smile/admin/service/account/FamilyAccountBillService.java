package com.smile.admin.service.account;

import com.smile.admin.bean.domain.FamilyAccountBill;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/4/8
 * @description:
 */
public interface FamilyAccountBillService {

    int saveOrUpdate(FamilyAccountBill familyAccountBill);

    List<FamilyAccountBill> getFamilyBills(FamilyAccountBill familyAccountBill);

}
