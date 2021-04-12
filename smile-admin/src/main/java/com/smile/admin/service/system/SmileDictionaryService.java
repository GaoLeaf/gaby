package com.smile.admin.service.system;

import com.smile.admin.bean.domain.SmileDictionary;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/4/9
 * @description:
 */
public interface SmileDictionaryService {

    /**
     * 根据groupId查找字典
     * @param groupId
     * @return
     */
    List<SmileDictionary> getDictionaryByGroup(int groupId);

}
