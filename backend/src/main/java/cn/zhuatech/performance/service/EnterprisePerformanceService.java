/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance.service;
import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.http.*; import org.springframework.stereotype.Service; import org.springframework.web.server.ResponseStatusException; import java.math.*; import java.util.*;
@Service public class EnterprisePerformanceService {
 public ScoreResult calculate(@Valid ScoreRequest r){
  int totalWeight=r.goals().stream().mapToInt(Goal::weight).sum(); if(totalWeight!=100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"目标权重合计必须为100");
  if(Math.abs(r.calibrationAdjustment())>10) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"校准调整不得超过10分");
  BigDecimal weighted=r.goals().stream().map(g->BigDecimal.valueOf(g.score()).multiply(BigDecimal.valueOf(g.weight())).divide(BigDecimal.valueOf(100),2,RoundingMode.HALF_UP)).reduce(BigDecimal.ZERO,BigDecimal::add);
  BigDecimal finalScore=weighted.add(BigDecimal.valueOf(r.calibrationAdjustment())).max(BigDecimal.ZERO).min(BigDecimal.valueOf(100)).setScale(2,RoundingMode.HALF_UP);
  String grade=finalScore.compareTo(BigDecimal.valueOf(90))>=0?"A":finalScore.compareTo(BigDecimal.valueOf(80))>=0?"B":finalScore.compareTo(BigDecimal.valueOf(70))>=0?"C":finalScore.compareTo(BigDecimal.valueOf(60))>=0?"D":"E";
  return new ScoreResult(r.employeeNo(),weighted,finalScore,grade,totalWeight,r.calibrationAdjustment()!=0?"CALIBRATED":"ORIGINAL");
 }
 public record ScoreRequest(@NotBlank String employeeNo,@NotEmpty List<@Valid Goal> goals,@Min(-10) @Max(10) int calibrationAdjustment){}
 public record Goal(@NotBlank String goalNo,@Min(1) @Max(100) int weight,@Min(0) @Max(100) int score){}
 public record ScoreResult(String employeeNo,BigDecimal weightedScore,BigDecimal finalScore,String grade,int totalWeight,String scoreType){public ScoreResult(String e,BigDecimal w,BigDecimal f,String g,int t,boolean c){this(e,w,f,g,t,c?"CALIBRATED":"ORIGINAL");}}
}

