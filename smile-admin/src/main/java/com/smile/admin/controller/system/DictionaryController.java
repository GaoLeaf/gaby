package com.smile.admin.controller.system;

import com.smile.admin.bean.domain.SmileDictionary;
import com.smile.admin.service.system.SmileDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaowenjin
 * @date 2021/4/12
 * @description:
 */
@Controller
@RequestMapping("system/dictionary")
public class DictionaryController {

    @Autowired
    private SmileDictionaryService smileDictionaryService;

    @PostMapping("get")
    @ResponseBody
    public List<SmileDictionary> get(SmileDictionary dictionary) {

        List<SmileDictionary> dictionaryMap = smileDictionaryService.getDictionaryByGroup(dictionary.getGroupId());

        if (dictionaryMap == null || dictionaryMap.isEmpty()) {
            return Collections.emptyList();
        }

        // 提取
        return dictionaryMap.stream()
                .filter(d -> d.getParentId() != null && d.getParentId().equals(dictionary.getParentId()))
                .collect(Collectors.toList());
    }

}
