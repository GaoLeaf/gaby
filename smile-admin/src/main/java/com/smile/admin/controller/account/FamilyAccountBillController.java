package com.smile.admin.controller.account;

import com.smile.admin.bean.domain.FamilyAccountBill;
import com.smile.admin.bean.domain.SmileDictionary;
import com.smile.admin.service.account.FamilyAccountBillService;
import com.smile.admin.service.system.SmileDictionaryService;
import com.smile.tool.bean.dto.BackWarnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账户账单
 *
 * @author gaowenjin
 * @date 2021/4/9
 * @description:
 */
@Controller
@RequestMapping("/account/bill")
public class FamilyAccountBillController {

    @Autowired
    private FamilyAccountBillService familyAccountBillService;

    @Autowired
    private SmileDictionaryService smileDictionaryService;

    @GetMapping("list")
    public String list() {
        return "account/bill-list";
    }

    @PostMapping("data")
    @ResponseBody
    public List<FamilyAccountBill> data() {
        FamilyAccountBill familyAccountBill = new FamilyAccountBill();
        familyAccountBill.setFamilyId("1");
        return familyAccountBillService.getFamilyBills(familyAccountBill);
    }

    @GetMapping("add")
    public String add(Model model) {
        List<SmileDictionary> billCategarys = smileDictionaryService.getDictionaryByGroup(1);

        // 获取一级分类
        List<SmileDictionary> categorys = new ArrayList<>();
        // 获取二级分类
        Map<Integer, List<SmileDictionary>> subcategorys = new HashMap<>();

        billCategarys.forEach(billCategary -> {

            if (billCategary.getParentId() == null) {
                categorys.add(billCategary);
                return;
            }

            if (subcategorys.containsKey(billCategary.getParentId())) {
                List<SmileDictionary> dictionaries = subcategorys.get(billCategary.getParentId());
                dictionaries.add(billCategary);
            } else {
                List<SmileDictionary> dictionaries = new ArrayList<>();
                dictionaries.add(billCategary);
                subcategorys.put(billCategary.getParentId(), dictionaries);
            }

        });

        model.addAttribute("categorys", categorys);
        model.addAttribute("subcategorys", subcategorys);
        model.addAttribute("familyAccountBill", new FamilyAccountBill());
        return "account/bill-edit";
    }

    @PostMapping({"add", "edit"})
    @ResponseBody
    public BackWarnEntity saveOrUpdate(FamilyAccountBill familyAccountBill) {

        int result = familyAccountBillService.saveOrUpdate(familyAccountBill);

        if (result > 0) {
            return new BackWarnEntity(true, "成功");
        } else {
            return new BackWarnEntity(false, "失败");
        }
    }

}
