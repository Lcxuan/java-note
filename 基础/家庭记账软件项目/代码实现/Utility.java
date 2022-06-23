package com.lcxuan.familyAccount;

import java.util.Scanner;

public class Utility {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 从键盘读取信息
     * @param limit
     * @return
     */
    private static String readKeyBoard(int limit) {

        label:for (;;){
            String str = scanner.next();
            if (str.length() > limit){
                System.out.println("输入过长，请重新输入：");
                continue label;
            }else {
                return str;
            }
        }
    }

    /**
     * 用于界面的选择，该方法读取键盘，如果用户键入”1-4“中的任意字符，则方法返回。返回值为用户键入字符
     */
    public static char readMenuSelection(){
        char c;
        for (;;){
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4'){
                System.out.print("选择错误，请重新输入：");
            }else break;
        }
        return c;
    }

    /**
     * 用于收入和支出金额的输入，该方法从键盘读取一个不超过4为长度的正数，并将其作为方法的返回值
     */
    public static int readNumber(){
        int n;
        for (;;){
            String str = readKeyBoard(4);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入有误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 用于收入和支出说明的输入，该方法从键盘读取一个不超过八位长度的字符串，并将其作为方法的返回值
     */
    public static String readString(){
        String str = readKeyBoard(8);
        return str;
    }

    /**
     * 用于确定选择的输入。该方法从键盘读取Y或者N，并将其作为返回值
     */
    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c =='N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }
}
