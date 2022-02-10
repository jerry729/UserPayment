package com.util;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*import dao.CommDAO;*/


public class Info {

    public static String FILEPATH = "D:\\workspace\\kehuhuikuan\\src\\main\\webapp\\upload\\";


    public static HashMap getUser(HttpServletRequest request) {
        HashMap map = (HashMap) (request.getSession().getAttribute("admin") == null ? request.getSession().getAttribute("user") : request.getSession().getAttribute("admin"));
        return map;
    }


    public static int getBetweenDayNumber(String dateA, String dateB) {
        long dayNumber = 0;
        //1小时=60分钟=3600秒=3600000
        long mins = 60L * 1000L;
        //long day= 24L * 60L * 60L * 1000L;计算天数之差
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d1 = df.parse(dateA);
            Date d2 = df.parse(dateB);
            dayNumber = (d2.getTime() - d1.getTime()) / mins;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) dayNumber;
    }

    public static void main(String[] g) {
        System.out.print(Info.getBetweenDayNumber("2012-11-11 11:19", "2012-11-11 11:11"));
    }

    public synchronized static String getID() {
        Random random = new Random();
        StringBuffer ret = new StringBuffer(20);
        String rand = String.valueOf(Math.abs(random.nextInt()));
        ret.append(getDateStr());
        ret.append(rand.substring(0, 6));

        return ret.toString();
    }

    public static String getImgUpInfo(int height) {
        String jscode = "";
        jscode += "<img style=\"cursor: hand\" onclick=\"uploadimg()\" src=\"/pianotrainwebstie/js/nopic.jpg\" id=txt height=\"" + height + "\"/>";
        jscode += "<input type=hidden name=\"filename\" id=\"filename\" value=\"\" />";
        jscode += "<script type=\"text/javascript\"  src=\"/pianotrainwebstie/js/popups.js\"></script>";
        return jscode;
    }


    public static String getDateStr() {
        String dateString = "";
        try {//yyyyMMddHHmmss
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            Date currentTime_1 = new Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }

    public static String getUTFStr(String str) {
        if (str == null) {
            return "";
        }

        try {
            str = new String(str.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    public static String getGBKStr(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return "";
        }
        return new String(str.getBytes("ISO-8859-1"), "GBK");
    }

    public static String getGB2312Str(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return "";
        }
        return new String(str.getBytes("ISO-8859-1"), "gb2312");
    }


    /**
     * 得到多少天之后之前的日期��
     *
     * @return
     */
    public static String getDay(String date, int day) {
        String b = date.substring(0, 10);
        String c = b.substring(0, 4);
        String d = b.substring(5, 7);
        String f = b.substring(8, 10);
        String aa = c + "/" + d + "/" + f;
        String a = "";
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        GregorianCalendar grc = new GregorianCalendar();
        grc.setTime(new Date(aa));
        grc.add(GregorianCalendar.DAY_OF_MONTH, day);
        String resu = dateFormat.format(grc.getTime());
        String t[] = resu.split("-");
        String sesuu = "";
        for (int i = 0; i < t.length; i++) {
            if (t[i].length() == 1) {
                t[i] = "0" + t[i];
            }
            sesuu += t[i] + "-";
        }

        return sesuu.substring(0, 10);
    }


    /**
     * 计算两个时期之间的天数
     */
    public static int dayToday(String DATE1, String DATE2) {
        int i = 0;
        if (DATE1.indexOf(" ") > -1)
            DATE1 = DATE1.substring(0, DATE1.indexOf(" "));
        if (DATE2.indexOf(" ") > -1)
            DATE2 = DATE2.substring(0, DATE2.indexOf(" "));

        String[] d1 = DATE1.split("-");
        if (d1[1].length() == 1) {
            DATE1 = d1[0] + "-0" + d1[1];
        } else {
            DATE1 = d1[0] + "-" + d1[1];
        }

        if (d1[2].length() == 1) {
            DATE1 = DATE1 + "-0" + d1[2];
        } else {
            DATE1 = DATE1 + "-" + d1[2];
        }

        String[] d2 = DATE2.split("-");
        if (d2[1].length() == 1) {
            DATE2 = d2[0] + "-0" + d2[1];
        } else {
            DATE2 = d2[0] + "-" + d2[1];
        }

        if (d2[2].length() == 1) {
            DATE2 = DATE2 + "-0" + d2[2];
        } else {
            DATE2 = DATE2 + "-" + d2[2];
        }


        for (int j = 0; j < 10000; j++) {
            i = j;
            String gday = Info.getDay(DATE1, j);
            if (gday.equals(DATE2)) {
                break;
            }
        }
        return i;
    }


    /**
     * 比较时间大小
     */
    public static String compare_datezq(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {

                return "big";
            } else if (dt1.getTime() < dt2.getTime()) {

                return "small";
            } else {
                return "den";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "den";
    }

    /**
     * 过滤html代码
     */
    public static String filterStrIgnoreCase(String source, String from, String to) {
        String sourceLowcase = source.toLowerCase();
        String sub1, sub2, subLowcase1, subLowcase2;
        sub1 = sub2 = subLowcase1 = subLowcase2 = "";
        int start = 0, end;
        boolean done = true;
        if (source == null) return null;
        if (from == null || from.equals("") || to == null || to.equals(""))
            return source;
        while (done) {
            start = sourceLowcase.indexOf(from, start);
            if (start == -1) {
                break;
            }
            subLowcase1 = sourceLowcase.substring(0, start);
            sub1 = source.substring(0, start);
            end = sourceLowcase.indexOf(to, start);
            if (end == -1) {
                end = sourceLowcase.indexOf("/>", start);
                if (end == -1) {
                    done = false;
                }
            } else {
                end = end + to.length();
                subLowcase2 = sourceLowcase.substring(end, source.length());
                sub2 = source.substring(end, source.length());
                sourceLowcase = subLowcase1 + subLowcase2;
                source = sub1 + sub2;
            }
            //System.out.println(start+" "+end);
        }
        return source;
    }


    public static void delPic(String path, String img) {
        if (img != null) {
            if (!img.equals("")) {
                File file1 = new File(path + "/" + img);
                if (file1.exists()) {
                    file1.deleteOnExit();
                    file1.delete();
                }
            }
        }
    }


    // 文件上传
    public static String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                                    HttpServletRequest request, String img) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println("path===" + path);
        System.out.println("file===" + file);
        String fileName = file.getOriginalFilename();
        System.out.println("fileName===" + fileName);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pa = request.getContextPath() + "/upload/" + fileName;
        System.out.println("path===" + pa);
        if (fileName != null && !fileName.equals("")) {
            img = fileName;
        } else {
            img = null;
        }
        return img;

    }


}

		

