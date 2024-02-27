package kr.co.seoulit.erp.hr.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.hr.base.servicefacade.HrBaseServiceFacade;
import kr.co.seoulit.erp.hr.base.to.HolidayTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/base/*")
public class HolidayListController {
	@Autowired
	private HrBaseServiceFacade baseServiceFacade;
	HashMap<String, Object> map = new HashMap<String, Object>();

	@GetMapping("/holidayList")
	public HashMap<String, Object> findHolidayList(@RequestParam String applyDay) {
		System.out.println(applyDay);
		try {
			ArrayList<HolidayTO> holidayList = baseServiceFacade.findHolidayList(applyDay);
			map.clear();
			map.put("holidayList", holidayList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
	
	@PostMapping("/addHoliday")
	public HashMap<String, Object> addHoliday(@RequestBody HolidayTO holiday){
		System.out.println(holiday);
		baseServiceFacade.addHoliday(holiday);
		try {
			map.clear();
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
	
	@PutMapping("/modifyHoliday")
	public HashMap<String, Object> modifyHoliday(@RequestBody HolidayTO holiday){
		System.out.println(holiday);
		baseServiceFacade.modifyHoliday(holiday);
		try {
			map.clear();
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
	
	@DeleteMapping("/removeHoliday")
	public HashMap<String, Object> removeHoliday(@RequestParam String applyDay){
		System.out.println(applyDay);
		try {
			baseServiceFacade.removeHoliday(applyDay);
			map.clear();
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
	

	
	@PostMapping("/addPublicHoliday")
	public HashMap<String, Object> addPublicHoliday(@RequestBody ArrayList<HolidayTO> holidayList){
		System.out.println(holidayList);
		try {
			for(HolidayTO holiday: holidayList) {
				baseServiceFacade.addPublicHoliday(holiday);
			}
			map.clear();
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
	
//	@PostMapping("/addPublicHoliday")
//	public ArrayList<HashMap<String, Object>> addPublicHoliday(@RequestBody ArrayList<HolidayTO> holidayList){
//		System.out.println(holidayList);
//		return null;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value="/holidayList", method=RequestMethod.GET)
//	public Map<String, Object> findHolidayList(HttpServletRequest request, HttpServletResponse response, Model model) {
//		ArrayList<HolidayTO> holidayList = baseServiceFacade.findHolidayList();
//			HolidayTO holito = new HolidayTO();
//			 map.put("holidayList", holidayList);
//			 map.put("emptyHoilday", holito);
//			 map.put("errorMsg", "success");
//			 map.put("errorCode", 0);
//	return map;
//	}
//	
//	public Model findWeekDayCount(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Model model) {
//		// TODO Auto-generated method stub
//		try {
//			String weekdayCount = baseServiceFacade.findWeekDayCount(startDate, endDate);
//			model.addAttribute("weekdayCount", weekdayCount);
//			model.addAttribute("errorMsg", "success");
//			model.addAttribute("errorCode", 0);
//
//			} catch (Exception e) {
//			
//			model.addAttribute("errorMsg", e.getMessage());
//			
//			}
//		
//		return model;
//	}
//	//***************2020-11-18 64 정준혁
//	@RequestMapping(value="/holidayList",method=RequestMethod.POST)
//	   public ModelMap batchListProcess(@RequestBody HashMap<String,ArrayList<HolidayTO>> sendData) {
//		 ModelMap modelMap = new ModelMap();
//	      try {	    	
//			baseServiceFacade.registCodeList(sendData.get("sendData"));
//
//	         modelMap.put("errorCode", 1);
//	         modelMap.put("errorMsg", "성공");
//
//	      } catch (Exception e2) {
//	         e2.printStackTrace();
//	         modelMap.put("errorCode", -2);
//	         modelMap.put("errorMsg", e2.getMessage());
//
//	      }
//	      return modelMap;
//	   }

}
