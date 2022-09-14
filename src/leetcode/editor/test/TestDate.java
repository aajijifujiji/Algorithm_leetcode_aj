package leetcode.editor.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: aajijifujiji
 * @DATE: 2022/5/25 14:56
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
//        String str = "1984-10-07";
//        Date d = new SimpleDateFormat().parse(str);
//        System.out.println(d);

        Calendar fdt = Calendar.getInstance();
        fdt.setTime(new Date());
        System.out.println(fdt.getTime());

        fdt.add(4, 2);

        System.out.println(fdt.getTime());






    }
}
