package com.smile.admin.service.system.impl;

import com.smile.admin.bean.domain.SmileDictionary;
import com.smile.admin.bean.domain.SmileDictionaryExample;
import com.smile.admin.mapper.system.SmileDictionaryMapper;
import com.smile.admin.service.system.SmileDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaowenjin
 * @date 2021/4/9
 * @description:
 */
@Service
public class SmileDictionaryServiceImpl implements SmileDictionaryService {

    @Autowired
    private SmileDictionaryMapper smileDictionaryMapper;

    // 缓存字典
    private Map<Integer, List<SmileDictionary>> dictionaryMap = new HashMap<>();

    @Override
    public List<SmileDictionary> getDictionaryByGroup(int groupId) {

        if (dictionaryMap.containsKey(groupId)) {
            return dictionaryMap.get(groupId);
        }

        SmileDictionaryExample example = new SmileDictionaryExample();
        example.createCriteria().andGroupIdEqualTo(groupId);
        List<SmileDictionary> dictionaries = smileDictionaryMapper.selectByExample(example);

        dictionaryMap.put(groupId, dictionaries);
        return dictionaries;
    }
}
