/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance.controller;

import cn.zhuatech.performance.common.ApiResponse;
import cn.zhuatech.performance.service.PerformanceCalibrationReleaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/performance")
public class PerformanceCalibrationReleaseController {
    private final PerformanceCalibrationReleaseService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public PerformanceCalibrationReleaseController(PerformanceCalibrationReleaseService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/calibration-release")
    public ApiResponse<?> assess(@RequestBody PerformanceCalibrationReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
