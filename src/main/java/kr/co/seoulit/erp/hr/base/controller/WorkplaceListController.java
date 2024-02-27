package kr.co.seoulit.erp.hr.base.controller;

import java.util.*;

import kr.co.seoulit.erp.hr.company.to.WorkplaceTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.hr.base.servicefacade.HrBaseServiceFacade;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/base/*")
public class WorkplaceListController{
    @Autowired
    private HrBaseServiceFacade hrBaseServiceFacade;

    @GetMapping("/workplaceList")
    public Map<String, Object> selectWorkplaceList() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<WorkplaceTO> list = hrBaseServiceFacade.selectWorkplaceList();
        map.put("workplaceList", list);
        map.put("errorMsg","success");
        map.put("errorCode", 0);
        System.out.println(map);
        return map;
    }

}
