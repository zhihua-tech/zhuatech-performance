/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceCalibrationReleaseService {
    public Result assess(Request request) {
        var blockers = new ArrayList<String>();
        var actions = new ArrayList<String>();
        if (request.cycleId() == null || request.cycleId().isBlank()) blockers.add("绩效周期不能为空");
        if (!request.goalsLocked()) blockers.add("绩效目标尚未锁定");
        if (!request.biasChecked()) blockers.add("公平性与偏差检查未完成");
        if (!request.compensationSeparated()) blockers.add("绩效校准与薪酬决策未职责分离");
        if (!request.hrApproved()) blockers.add("HR 最终审批缺失");
        if (!request.auditReady()) blockers.add("绩效发布审计证据不完整");
        if (!request.managerReviewsComplete()) actions.add("补齐经理评价");
        if (!request.employeeAcknowledgementsCollected()) actions.add("收集员工确认");
        if (!request.calibrationComplete()) actions.add("完成组织校准会议");
        if (!request.ratingDistributionExplained()) actions.add("补充等级分布说明");
        if (!request.appealWindowConfigured()) actions.add("配置申诉窗口");
        var decision = !blockers.isEmpty() ? Decision.BLOCKED : actions.isEmpty() ? Decision.RELEASE : Decision.CALIBRATION;
        return new Result(decision, List.copyOf(blockers), List.copyOf(actions));
    }

    public enum Decision { RELEASE, CALIBRATION, BLOCKED }
    public record Request(String cycleId, boolean goalsLocked, boolean managerReviewsComplete,
                          boolean employeeAcknowledgementsCollected, boolean calibrationComplete,
                          boolean biasChecked, boolean ratingDistributionExplained,
                          boolean compensationSeparated, boolean appealWindowConfigured,
                          boolean hrApproved, boolean auditReady) {}
    public record Result(Decision decision, List<String> blockers, List<String> actions) {}
}
