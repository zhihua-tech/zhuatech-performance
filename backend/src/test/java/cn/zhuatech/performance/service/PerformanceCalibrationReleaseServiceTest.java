/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PerformanceCalibrationReleaseServiceTest {
    private final PerformanceCalibrationReleaseService service = new PerformanceCalibrationReleaseService();

    @Test void releasesFairAndGovernedResults() {
        var result = service.assess(new PerformanceCalibrationReleaseService.Request("FY26-H2", true, true,
                true, true, true, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(PerformanceCalibrationReleaseService.Decision.RELEASE);
    }

    @Test void routesIncompleteCycleToCalibration() {
        var result = service.assess(new PerformanceCalibrationReleaseService.Request("FY26-H2", true, false,
                false, false, true, false, true, false, true, true));
        assertThat(result.actions()).hasSize(5);
        assertThat(result.decision()).isEqualTo(PerformanceCalibrationReleaseService.Decision.CALIBRATION);
    }

    @Test void blocksUnfairOrUncontrolledRelease() {
        var result = service.assess(new PerformanceCalibrationReleaseService.Request("", false, false,
                false, false, false, false, false, false, false, false));
        assertThat(result.blockers()).hasSize(6);
        assertThat(result.decision()).isEqualTo(PerformanceCalibrationReleaseService.Decision.BLOCKED);
    }
}
