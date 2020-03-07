package com.haicheng.test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Leung
 * @create 2020-03-08 0:38
 */
public class RequirementOne {

    /**
     * @description 此方法用于初始化数字映射
     */
    public Map<String, List<String>> initDigitsMap(){
        Map<String, List<String>> digitsMap = new HashMap<>();
        digitsMap.put("0", Arrays.asList(""));
        digitsMap.put("1",Arrays.asList(""));
        digitsMap.put("2",Arrays.asList("A","B","C"));
        digitsMap.put("3",Arrays.asList("D","E","F"));
        digitsMap.put("4",Arrays.asList("G","H","I"));
        digitsMap.put("5",Arrays.asList("J","K","L"));
        digitsMap.put("6",Arrays.asList("M","N","O"));
        digitsMap.put("7",Arrays.asList("P","Q","R","S"));
        digitsMap.put("8",Arrays.asList("T","U","V"));
        digitsMap.put("9",Arrays.asList("W","X","Y","Z"));
        return digitsMap;
    }

    /**
     * @description 此方法用于数字转化成字母
     */
    public void showLetters(){

        //初始化map
        Map<String, List<String>> digitsMap = initDigitsMap();

        String digits=getDigits(1);

        //获取数字对应的字母集合
        List<String> lettersList = digitsMap.get(digits);

        String arrInput=new String("Input:arr[] ={"+digits+"}");

        //打印输入内容
        System.out.println(arrInput.toString());
        System.out.print("Output:");
        //打印输出排列组合结果
        for (String s : lettersList) {
            System.out.print(" "+s);
        }

    }

    /**
     * @description 此方法用于返回用户输入的数字，参数是多少位数字，目前支持1-2位数字
     * @param count
     * @return
     */
    public String getDigits(Integer count) {
        String tip;
        String error;
        String pattern;
        if (count==1){
            tip = "请输入0-9的数字 :";
            error = "输入不合法！只能输入0-9的数字,请重新输入：";
            pattern = "[0-9]";
        }else {
            tip = "请输入0-99的数字 :";
            error = "输入不合法！只能输入0-99的数字,请重新输入：";
            pattern = "[0-9]{1,2}";
        }
        System.out.println(tip);

        String digits="";
        while(true){
            Scanner input = new Scanner(System.in);
            digits=input.next();

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(digits);

            if(!m.matches()){
                System.out.println(error);
            }else{
                break;
            }
        }
        return digits;
    }

}
