package kr.co.seoulit.erp.hr.salary.to;

import lombok.Data;

@Data
public class SeveranceTO {
	private String
				empCode,
				empName,
				hireDate,
				retireDate,
				applyDate,
				severanceType,
				workDays,
				severancePay,
				severanceDeduction,
				realSeverancePay,
				firstDay,
				today;
}
