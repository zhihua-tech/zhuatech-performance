/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance.controller;

import cn.zhuatech.performance.common.ApiResponse;
import cn.zhuatech.performance.service.PerformanceCalibrationReleaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enterprise/performance")
public class PerformanceCalibrationReleaseController {
    private final PerformanceCalibrationReleaseService service;
    public PerformanceCalibrationReleaseController(PerformanceCalibrationReleaseService service) { this.service = service; }

    @PostMapping("/calibration-release")
    public ApiResponse<?> assess(@RequestBody PerformanceCalibrationReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
