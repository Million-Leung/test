package com.haicheng.test;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Leung
 * @create 2020-03-08 3:09
 */
public class RequirementOneTest {

    /*
    编写单元测试代码遵守 BCDE 原则，以保证被测试模块的交付质量
    B：Border，边界值测试，包括循环边界、特殊取值、特殊时间点、数据顺序等。
    C：Correct，正确的输入，并得到预期的结果。
    D：Design，与设计文档相结合，来编写单元测试。
    E：Error，强制错误信息输入（如：非法数据、异常流程、非业务允许输入等），并得
    到预期的结果。(参考阿里巴巴java开发手册)
     */

    private RequirementOne requirementOne=new RequirementOne();

    /**
     * 边界值 10
     * 正确输入 0-9
     * 错误信息 非数字入 aa
     */
    @Test
    public void showLetters(){
        requirementOne.showLetters();
    }


    @Test
    public void testGetDigits(){
        String digits = requirementOne.getDigits(1);
        assertNotNull(digits);
    }

}
