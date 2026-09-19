/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance.controller;
import cn.zhuatech.performance.common.ApiResponse; import cn.zhuatech.performance.service.EnterprisePerformanceService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/enterprise/performance") public class EnterprisePerformanceController {
 private final EnterprisePerformanceService service; /**
                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                      */
public EnterprisePerformanceController(EnterprisePerformanceService service){this.service=service;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @PostMapping("/calculate-score") ApiResponse<?> execute(@Valid @RequestBody EnterprisePerformanceService.ScoreRequest request){return ApiResponse.ok(service.calculate(request));}
}

