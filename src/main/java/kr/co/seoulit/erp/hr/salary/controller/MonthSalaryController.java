package kr.co.seoulit.erp.hr.salary.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.hr.salary.servicefacade.SalaryServiceFacade;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.MonthSalaryTO;

@CrossOrigin("*")
@RestController
@Tag(name = "월급관리", description = "월급관리 API")
@RequestMapping(value = "/hr/salary/*", produces = "application/json")
public class MonthSalaryController {
	
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;

	
	HashMap<String, Object> map = new HashMap<>();
	@Operation(summary = "직원 월급 리스트 조회", description = "월급 리스트를 출력합니다.")

	@GetMapping("/searchSalaryInit")
	public HashMap<String, Object> initSalaryList(@RequestParam String applyYearMonth,@RequestParam String empCode){
		System.out.println(applyYearMonth);
		try {
			ArrayList<MonthSalaryTO> initSalaryList = salaryServiceFacade.initSalaryList(applyYearMonth,empCode);
			map.clear();
			map.put("initSalaryList", initSalaryList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		System.out.println(map);
		return map;
	}

	@Operation(summary = "직원 월급 등록을 위한 프로시저 실행", description = "월급 등록하기 위해 세부 내용을 프로시저 실행 후 출력합니다.")
	@GetMapping("/salaryProcess")
	public HashMap<String, Object> findSalaryList(@RequestParam String applyYearMonth,
			@RequestParam String empCode, @RequestParam String deptCode){
		try {
			HashMap<String, Object> resultMap = salaryServiceFacade.findSalaryList(applyYearMonth, empCode, deptCode);
			@SuppressWarnings("unchecked")
			ArrayList<MonthSalaryTO> salaryList = (ArrayList<MonthSalaryTO>)resultMap.get("RESULT");
			map.clear();
			map.put("salaryList", salaryList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		System.out.println("map 확인");
		System.out.println(map);
		return map;
	}

	@Operation(summary = "직원 월급 수정", description = "월급 수정합니다.")
	@PutMapping("/updateMonthSal")
	public HashMap<String, Object> modifyMonthSal(@RequestBody MonthSalaryTO monthSalaryTo){
		System.out.println(monthSalaryTo);
		try {
			salaryServiceFacade.modifyMonthSalary(monthSalaryTo);
			map.clear();
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
	@Operation(summary = "직원 월급 삭제", description = "해당 직원의 월급을 삭제합니다.")
	@DeleteMapping("/removeMonthSalary")
	public HashMap<String, Object> removeMonthSalary(@RequestParam String empCode, @RequestParam String applyYearMonth){
		try {
			salaryServiceFacade.removeMonthSalary(empCode, applyYearMonth);
			map.clear();
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}

	@Operation(summary = "직원 월급 조회", description = "선택한 직원 월급을 조회합니다.")
	@GetMapping("/findSalary")
	public HashMap<String, Object> findSalary(@RequestParam String applyYearMonth,@RequestParam String empCode){
		System.out.println(applyYearMonth);
		System.out.println(empCode);
		try {
			ArrayList<MonthSalaryTO> salaryList = salaryServiceFacade.findSalary(applyYearMonth,empCode);
			map.clear();
			map.put("salaryList", salaryList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		System.out.println(map);
		return map;
	}
	
//	private ModelMap modelMap = null;

//	@SuppressWarnings("unchecked")
//	@RequestMapping("/findMonthSalary") // 월 급여조회  사용안함
//	public ModelMap findMonthSalary(HttpServletRequest request, HttpServletResponse response) {
//		String applyYearMonth = request.getParameter("applyYearMonth");
//		String empCode = request.getParameter("empCode");
//		HashMap<String, Object> monthSalary = null;
//		modelMap = new ModelMap();
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("application/json; charset=UTF-8");
//			monthSalary = salaryServiceFacade.findMonthSalary(applyYearMonth, empCode);
//			ArrayList<MonthSalaryTO> list = (ArrayList<MonthSalaryTO>) monthSalary.get("result");
//			if (list.size() != 1) {
//				modelMap.put("errorCode", "-1");
//				modelMap.put("errorMsg", monthSalary.get("errorMsg"));
//			} else {
//				modelMap.put("monthSalary", monthSalary);
//				modelMap.put("errorMsg", "success");
//				modelMap.put("errorCode", 0);
//			}
//		} catch (Exception ioe) {
//			ioe.printStackTrace();
//			modelMap.clear();
//			modelMap.put("errorCode", "-1");
//			modelMap.put("errorMsg", ioe.getMessage());
//		}
//		return modelMap;
//	}
//
//	@RequestMapping(value = "/findYearSalary") //사용안함
//	public ModelMap findYearSalary(HttpServletRequest request, HttpServletResponse response) {
//		String applyYear = request.getParameter("applyYear");
//		String empCode = request.getParameter("empCode");
//		modelMap = new ModelMap();
//		try {
//
//			ArrayList<MonthSalaryTO> yearSalary = salaryServiceFacade.findYearSalary(applyYear, empCode);
//			modelMap.put("yearSalary", yearSalary);
//			modelMap.put("errorMsg", "success");
//			modelMap.put("errorCode", 0);
//		} catch (Exception ioe) {
//			modelMap.clear();
//			modelMap.put("errorMsg", ioe.getMessage());
//		}
//		return modelMap;
//	}
//
//	@PostMapping("/modifyMonthSalary") // 월급여 마감    ===> 커서가 닫혀있다고 나온다. 
//	public ModelMap modifyMonthSalary(@RequestBody Map<String, ArrayList<MonthSalaryTO>> empcode1) {
////**************************2020-08-20 63기 손유찬 수정********************************* 
////			@RequestBody ArrayList<SlipBean> slipData , @RequestBody ArrayList<MonthSalaryTO> monthSalary
//		modelMap = new ModelMap();
//		System.out.println("뷰단에서 가져온 empcode : " + empcode1.get("empcode1"));
//
//		try {
//			for (MonthSalaryTO empCodeList : empcode1.get("empcode1")) {
//
//				empCodeList.setFinalizeStatus("Y");
//				salaryServiceFacade.closeMonthSalary(empCodeList);
//				salaryServiceFacade.modifyMonthSalary(empCodeList);
//			}
//
////**************************2020-08-20 63기 손유찬 수정********************************* 
//			modelMap.put("errorMsg", "success");
//			modelMap.put("errorCode", 0);
//		} catch (Exception ioe) {
//			modelMap.put("errorMsg", ioe.getMessage());
//		}
//		return modelMap;
//	}
//
////**************************2020-08-20 63기 손유찬 수정********************************* 	
//	@RequestMapping("/findCloseSalary") // 월급여 조회
//	@GetMapping
//	public ModelMap findCloseSalary(HttpServletRequest request, HttpServletResponse response) {
//		String applyYearMonth = request.getParameter("applyYearMonth");
//		String deptCode = request.getParameter("deptCode");
//		HashMap<String, Object> monthSalary = null;
//		modelMap = new ModelMap();
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("application/json; charset=UTF-8");
//			monthSalary = salaryServiceFacade.CloseSalary(applyYearMonth, deptCode);
//			System.out.println("가져온값 " + monthSalary);
//			modelMap.put("monthSalary", monthSalary);
//			modelMap.put("errorMsg", "success");
//			modelMap.put("errorCode", 0);
//		} catch (Exception ioe) {
//			modelMap.clear();
//			modelMap.put("errorMsg", ioe.getMessage());
//		}
//		return modelMap;
//	}

}