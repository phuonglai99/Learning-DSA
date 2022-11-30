import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RemainsBirthday {
    public static LocalDate currentDate;
    //Verifying if leap year

    public static boolean curentIsLeapYear(){
        boolean bool = currentDate.isLeapYear();
        return bool;
    }
    public static int  nextLeapYear(){
        int now = currentDate.getYear();
        int nextYear = now;
        boolean flag = false;
        while(flag != true){

            if ((nextYear % 400 == 0)
                    || (nextYear % 4 == 0 && nextYear % 100 != 0)) {

             flag = true;
            }
            else  nextYear = nextYear+1;
            //System.out.println(nextYear);
        }
       return nextYear;
    }

    /* return -1: current day < birthday, return 1:  current day > birthday, return 0: same day*/
    public static int compareDay(String birthDay) {
        Date date1, date2;
        try {
             date1 = new SimpleDateFormat("dd/MM").parse(birthDay);
             date2 = new SimpleDateFormat("dd/MM").parse(DateTimeFormatter.ofPattern("dd/MM").format(currentDate));
        }  catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date2.compareTo(date1);
    }

    public static boolean isSpecialDay(String birthDay){
        int day = Integer.parseInt(birthDay.split("/")[0]);
        int month = Integer.parseInt(birthDay.split("/")[1]);
        if(day == 29 && month == 2) return true;
        else return false;
    }

    //convert type LocalDate into String format dd/MM
    public static String getCurrentDay(LocalDate date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
        //LocalDateTime now = LocalDateTime.now();
        return dtf.format(date);
    }
    // return next birthday in format dd/mm/yyyy
    public static String getNextBirthday(String birthDay){
        int year=0;
        if(isSpecialDay(birthDay)) {
            if(curentIsLeapYear()){
                if(compareDay(birthDay)==0) year = currentDate.getYear();
                else if (compareDay(birthDay)==-1) year = currentDate.getYear();
                else year = nextLeapYear();

            }
            else year = nextLeapYear();
        }
        else {
            if(compareDay(birthDay)==0) year = currentDate.getYear();
            else if (compareDay(birthDay)==-1) year = currentDate.getYear();
            else year = currentDate.getYear()+1;
        }
        String ret = birthDay + "/"+ year;
        return ret;
    }

    public static long getNumberDay(String birthday){
        String birth=getNextBirthday(birthday);
        Date birthDay;
        Date currentDay = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
             birthDay = sdf.parse(birth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long diffInMillies = Math.abs(birthDay.getTime() - currentDay.getTime());
        long day = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        //int day = 0;
        return day;
    }


    public static void main(String[] args) throws ParseException {
        currentDate = LocalDate.now();
        System.out.println("nhập ngày sinh theo định dạng dd/MM: ");
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine();
        //String s = "29/1";
        System.out.println("Tính từ thời điểm hiện tại đến sinh nhật tiếp còn : "+ getNumberDay(day));
    }
}
