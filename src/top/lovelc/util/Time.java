package top.lovelc.util;

public class Time {

    public static String t(){
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds/1000;
        long currentSecond = totalSeconds%60;
        long totalMinutes = totalSeconds/60;
        long currentMinute = totalMinutes%60;
        long totalHours = totalMinutes/60;
        long currentHour = (totalHours-16)%24;
        return ("当前时间："+currentHour+"点"+currentMinute+"分"+currentSecond+"秒");
    }
}
