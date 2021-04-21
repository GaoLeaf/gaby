package com.smile.admin.bean.dto;

import com.smile.tool.bean.dto.PageInfo;

/**
 * @author gaowenjin
 * @date 2021/4/21
 * @description:
 */
public class FamilyBillPage extends PageInfo {

    private String familyId;

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }
}
