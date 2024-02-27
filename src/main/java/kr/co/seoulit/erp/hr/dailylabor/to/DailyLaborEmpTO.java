package kr.co.seoulit.erp.hr.dailylabor.to;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.seoulit.common.to.BaseTO;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@Schema(description = "일용근로 사원 정보 관련 DTO")
@EqualsAndHashCode(callSuper = false)
public class DailyLaborEmpTO extends BaseTO {
   @Schema(description = "사원번호")
   private String employeeId;
   @Schema(description = "성명")
   private String employeeName;
   @Schema(description = "주민등록번호")
   private String residentialNumber;
   @Schema(description = "내/외국인 여부")
   private String nationality;
   @Schema(description = "부서")
   private String department;
   @Schema(description = "프로젝트")
   private String project;
   @Schema(description = "근무시작일")
   private String workStartDate;
   @Schema(description = "근무종료일")
   private String workEndDate;
   @Schema(description = "고용보험대상여부")
   private String employmentInsuranceEligibility;
   @Schema(description = "정상급여유형")
   private String normalPayType;
   @Schema(description = "정상급여")
   private double normalPay;
   @Schema(description = "연장급여(시급)")
   private double overtimePayRate;
   @Schema(description = "야간급여(시급)")
   private double nightPayRate;
   @Schema(description = "은행")
   private String bankName;
   @Schema(description = "계좌번호")
   private String accountNumber;
   @Schema(description = "예금주")
   private String accountHolder;
   @Schema(description = "핸드폰")
   private String phoneNumber;
   @Schema(description = "이메일")
   private String email;
   @Schema(description = "상태")
   private String status;
}