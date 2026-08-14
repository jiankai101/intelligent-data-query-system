package io.github.qifan777.server.agentconfig;

import java.util.ArrayList;
import java.util.List;

/** 智能助手配置：开场白、提示词设计(人设/系统提示词)、预设问题。 */
public class AgentConfig {
    private String openingMessage = "你好呀😊 我是标准化智能助手小鑫，如果你有电商经营数据相关的问题，都可以随时告诉我哦！";
    private String personaPrompt = "你是标准化智能助手「小鑫」，负责帮助用户查询和分析电商经营数据。请用自然、友好、简洁的语气回复用户，不要编造数据。";
    private List<String> presets = new ArrayList<>(List.of(
        "查询本季度销售额最高的三个店铺",
        "买家ID为xxx的历史订单和消费汇总",
        "统计6月各商品类别的销售件数与GMV"));

    public String getOpeningMessage() { return openingMessage; }
    public void setOpeningMessage(String v) { this.openingMessage = v == null ? "" : v; }
    public String getPersonaPrompt() { return personaPrompt; }
    public void setPersonaPrompt(String v) { this.personaPrompt = v == null ? "" : v; }
    public List<String> getPresets() { return presets; }
    public void setPresets(List<String> v) { this.presets = v == null ? new ArrayList<>() : v; }
}
