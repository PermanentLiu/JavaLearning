
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtils 
{
    
    public static Date getEndOfDay(Date day)
    {
        // your code here
    	Instant instant = day.toInstant();
    	ZoneId zoneId = ZoneId.systemDefault().systemDefault();
    	
    	LocalDate localDate = instant.atZone(zoneId).toLocalDate();
    	
    	
    	
    	LocalDateTime localDateTime = localDate.atTime(23, 59, 59);
    	
//    	ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
//    	
//    	day = Date.from(zdt.toInstant());
    	
    	ZoneId zoneId2 = zoneId.systemDefault();
    	ZonedDateTime zonedDateTime = null;
    	zonedDateTime = localDateTime.atZone(zoneId2);
    	day = Date.from(zonedDateTime.toInstant());
    	
        return day;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Date());
        System.out.println(getEndOfDay(new Date()));
    }

}
