/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance.controller;
import cn.zhuatech.performance.common.ApiResponse; import cn.zhuatech.performance.service.EnterprisePerformanceService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/enterprise/performance") public class EnterprisePerformanceController {
 private final EnterprisePerformanceService service; public EnterprisePerformanceController(EnterprisePerformanceService service){this.service=service;}
 @PostMapping("/calculate-score") ApiResponse<?> execute(@Valid @RequestBody EnterprisePerformanceService.ScoreRequest request){return ApiResponse.ok(service.calculate(request));}
}

