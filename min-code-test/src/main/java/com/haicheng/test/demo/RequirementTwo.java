package com.haicheng.test.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Leung
 * @create 2020-03-08 1:06
 */
public class RequirementTwo extends RequirementOne {

    /**
     * @description 此方法用于数字转化成字母
     */
    public void showLetters(){

        //初始化map
        Map<String, List<String>> digitsMap = initDigitsMap();

        //获取用户输入的数字

        String digits = getDigits(2);

        //把用户输入的数字分割成数组
        String[] digitsArr=digits.split("");

        //创建每位数字对应字母的集合
        List<String[]> letterList=new ArrayList<String[]>();

        //拼接输入内容
        StringBuffer inputStr=new StringBuffer("Input:arr[] ={");

        for(int i=0;i<digitsArr.length;i++){

            //将匹配到的字母集合添加到letters中
            List<String> letters=digitsMap.get(digitsArr[i]);
            if(letters.size()>0){
                //转化为数组
                String[] letterArr= (String[]) letters.toArray();
                letterList.add(letterArr);
            }

            //拼接输入内容
            inputStr.append(digitsArr[i]);
            if(i<digitsArr.length-1){
                inputStr.append(",");
            }
        }
        inputStr.append("}");
        //递归，返回最终的组合结果
        List<String[]> resultList= makeLetters(letterList,0,null);
        //打印输入内容
        System.out.println(inputStr.toString());

        //打印输出排列组合结果
        System.out.print("Output:");
        for(int i=0;i<resultList.size();i++){
            String[] letterArr=resultList.get(i);
            System.out.print(" ");
            for(String letter: letterArr){
                System.out.print(letter);
            }
        }
    }

    /**
     * @description 此方法做了递归，返回最终的组合结果
     * @param letterList
     * @param index
     * @param resultList
     * @return
     */
    private List<String[]> makeLetters(List<String[]> letterList, int index, List<String[]> resultList){
        //递归出口
        if(index==letterList.size()){
            return resultList;
        }

        //用于最后的结果返回
        List<String[]> tempList=new ArrayList<String[]>();
        if(index==0){
            String[] dataArr=letterList.get(0);
            for (int i = 0; i < dataArr.length; i++) {
                tempList.add(new String[]{dataArr[i]});
            }
        }else{
            String[] letterArr=letterList.get(index);
            for(String[] TempArr: resultList){
                for(String s : letterArr){
                    //复制数组并扩充新元素
                    String[] arrCopy= Arrays.copyOf(TempArr,TempArr.length+1);
                    //补充
                    arrCopy[arrCopy.length-1]=s;
                    //累加到结果用于返回
                    tempList.add(arrCopy);
                }
            }

        }
        return makeLetters(letterList,++index,tempList);
    }

}
