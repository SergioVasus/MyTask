/**
 * Counts the number of past years, months and days between
 * the date of birth and current date.
 * @version 1.0 04 Aug 2011
 * @author Sergey Palyukh
 */
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *  Class in console mode displays the First name, Second name,
 *  date of birth and number of past years, months and days before the date.
 */
public class SecondTask {
    public static void main(String[] args){
        System.out.println("First name: Sergey");
        System.out.println("Second name: Palyukh");
        /** year,month,day - variables to specify the dates of birth.*/
        int year=1990,
            month = 9,
            day = 26;
        /**
         * countYear,countMonth,countDay - variables to count the number
         * of days elapsed from the date of birth to date.
         */
        int countYear=0,
            countMonth=0,
            countDay=0;
        /** Calendar type variable with a date  of current */
        Calendar currentDate = Calendar.getInstance();
        /** Calendar type variable with a date  of current */
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(year,month-1,day);
        /** SimpleDateFormat type variable for formatting a date. */
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Date of birth: "+dateFormat.format(birthDate.getTime()));
        for (birthDate.get(Calendar.DATE);birthDate.get(Calendar.DATE)!=currentDate.get(Calendar.DATE);birthDate.add(Calendar.DATE,1)) {
             countDay++;
        }
        for (birthDate.get(Calendar.MONTH);birthDate.get(Calendar.MONTH)!=currentDate.get(Calendar.MONTH);birthDate.add(Calendar.MONTH,1)) {
             countMonth++;
        }
        for (birthDate.get(Calendar.YEAR);birthDate.get(Calendar.YEAR)!=currentDate.get(Calendar.YEAR);birthDate.add(Calendar.YEAR,1)) {
             countYear++;
        }
        if (countDay>31) {
            currentDate.set(Calendar.YEAR,1,Calendar.DATE );
            countDay=countDay-currentDate.getActualMaximum(Calendar.DATE);
            countMonth=countMonth+1;
        }
        System.out.println("From date of birth: "+countYear + " y "+countMonth+ " m "+ countDay+ " d");
    }
}