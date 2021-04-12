package com.smile.admin.service;

import com.smile.admin.bean.domain.SmileDictionary;
import com.smile.admin.mock.MockApplication;
import com.smile.admin.service.system.SmileDictionaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/4/9
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class SmileDictionaryServiceTest {

    @Autowired
    private SmileDictionaryService smileDictionaryService;

    @Test
    public void testGetDictionaryByGroup() {

        List<SmileDictionary> dictionaryByGroup = smileDictionaryService.getDictionaryByGroup(1);

        System.out.println(dictionaryByGroup.size());

    }

}
