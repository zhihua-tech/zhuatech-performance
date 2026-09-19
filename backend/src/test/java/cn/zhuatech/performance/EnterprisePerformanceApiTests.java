/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.performance;
import org.junit.jupiter.api.Test; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.boot.test.context.SpringBootTest; import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc; import org.springframework.http.MediaType; import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic; import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@SpringBootTest @AutoConfigureMockMvc class EnterprisePerformanceApiTests { @Autowired MockMvc mvc;

 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void weightedScoreAndCalibrationAreCalculated() throws Exception {mvc.perform(post("/api/enterprise/performance/calculate-score").with(httpBasic("operator","operator123")).contentType(MediaType.APPLICATION_JSON).content("""
 {"employeeNo":"E-001","goals":[{"goalNo":"G1","weight":60,"score":90},{"goalNo":"G2","weight":40,"score":80}],"calibrationAdjustment":2}
 """)).andExpect(status().isOk()).andExpect(jsonPath("$.data.weightedScore").value(86.00)).andExpect(jsonPath("$.data.finalScore").value(88.00)).andExpect(jsonPath("$.data.grade").value("B"));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void invalidWeightTotalIsRejected() throws Exception {mvc.perform(post("/api/enterprise/performance/calculate-score").with(httpBasic("operator","operator123")).contentType(MediaType.APPLICATION_JSON).content("""
 {"employeeNo":"E-002","goals":[{"goalNo":"G1","weight":50,"score":90}],"calibrationAdjustment":0}
 """)).andExpect(status().isBadRequest());}
}

