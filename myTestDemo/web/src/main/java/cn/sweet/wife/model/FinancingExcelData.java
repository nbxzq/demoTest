package cn.sweet.wife.model;


import lombok.Data;

/**
 * 融资融券情况分析Excel对应的实体对象
 *
 * @author ziqiang.xia
 */
@Data
public class FinancingExcelData {

    /**
     * 日期
     */
    private String tradeDate;

    /**
     * 买入额(元)
     */
    private String finpurch;

    /**
     * 偿还额(元)
     */
    private String finpmt;

    /**
     * 净买入额(元)
     */
    private String buy;

    /**
     * 融资余额(元)
     */
    private String finbalance;

    /**
     * 融资余额/流通市值(%)
     */
    private String finbalancetoliqmu;

    /**
     * 卖出量(股）
     */
    private String secsold;

    /**
     * 偿还量(股）
     */
    private String secpmt;

    /**
     * 净卖出量(股）
     */
    private String sales;

    /**
     * 融券余量(股）
     */
    private String secbalancevol;

    /**
     * 融券余额（元）
     */
    private String secbalance;

    /**
     * 融资余额/流通市值（%）
     */
    private String secbalancetoliqmu;
}
