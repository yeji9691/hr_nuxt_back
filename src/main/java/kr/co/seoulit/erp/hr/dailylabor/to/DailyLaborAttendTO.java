package kr.co.seoulit.erp.hr.dailylabor.to;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Schema(description = "일용근로 사원 정보 관련 DTO")
@EqualsAndHashCode(callSuper = false)
public class DailyLaborAttendTO extends BaseTO {

   @Schema(description = "사원번호")
   private String employeeId;

   @Schema(description = "성명")
   private String employeeName;

   @Schema(description = "프로젝트")
   private String project;

   @Schema(description = "근무시작일")
   private String workDate;

   @Schema(description = "근무시작시간")
   private String workStartTime;

   @Schema(description = "근무종료시간")
   private String workEndTime;

   @Schema(description = "총근무시간")
   private String totalWorkTime;

   @Schema(description = "근무시간")
   private String workTime;

   @Schema(description = "연장근무시간")
   private String workOverTime;

   @Schema(description = "야간근무시간")
   private String workNightTime;

   @Schema(description = "근무유형")
   private String workType;

   @Schema(description = "마감요청")
   private String deadlineRequest;
}