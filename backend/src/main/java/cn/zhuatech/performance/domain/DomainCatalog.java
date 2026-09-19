/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance.domain;

import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Component
public class DomainCatalog {
    private final Map<String, WorkflowAction> actions = new LinkedHashMap<>();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DomainCatalog() {
        actions.put("SUBMIT", new WorkflowAction("SUBMIT", "提交评估", List.of("草稿"), "待评估", "OPERATOR"));
        actions.put("REVIEW", new WorkflowAction("REVIEW", "完成评估", List.of("待评估"), "待校准", "OPERATOR"));
        actions.put("CALIBRATE", new WorkflowAction("CALIBRATE", "完成校准", List.of("待校准"), "待确认", "ADMIN"));
        actions.put("CONFIRM", new WorkflowAction("CONFIRM", "确认结果", List.of("待确认"), "已生效", "OPERATOR"));
        actions.put("APPEAL", new WorkflowAction("APPEAL", "发起申诉", List.of("已生效"), "申诉中", "OPERATOR"));
        actions.put("RESOLVE", new WorkflowAction("RESOLVE", "处理申诉", List.of("申诉中"), "已生效", "ADMIN"));
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String systemName() { return "知华科技绩效与人才发展系统"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String scene() { return "目标设定、持续反馈、绩效评估、校准、申诉、人才盘点与继任发展"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String initialStatus() { return "草稿"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String partyLabel() { return "员工/组织"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String amountLabel() { return "绩效奖金基数"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String quantityLabel() { return "目标数量"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String dueLabel() { return "周期截止日"; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public List<ModuleDefinition> modules() {
        return List.of(
            new ModuleDefinition("CYCLE", "绩效周期", "配置周期、适用组织、评分规则和里程碑"),
            new ModuleDefinition("GOAL", "目标管理", "分解战略目标并管理权重与进展"),
            new ModuleDefinition("CHECKIN", "持续反馈", "记录一对一沟通、辅导与关键事件"),
            new ModuleDefinition("REVIEW", "绩效评估", "执行自评、上级评估和多维反馈"),
            new ModuleDefinition("CALIBRATION", "绩效校准", "控制校准会议、分布和调整依据"),
            new ModuleDefinition("APPEAL", "绩效申诉", "受理申诉、复核证据并闭环处理"),
            new ModuleDefinition("TALENT_REVIEW", "人才盘点", "通过九宫格识别高潜、关键人才与风险"),
            new ModuleDefinition("SUCCESSION", "继任计划", "管理关键岗位继任梯队和准备度"),
            new ModuleDefinition("DEVELOPMENT", "发展计划", "制定能力差距、学习任务和岗位历练"),
            new ModuleDefinition("REWARD", "结果应用", "向调薪、奖金、晋升和培训输出结果")
        );
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Map<String, WorkflowAction> actions() { return Collections.unmodifiableMap(actions); }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ModuleDefinition(String code, String name, String description) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record WorkflowAction(String code, String label, List<String> from, String to, String requiredRole) {}
}
