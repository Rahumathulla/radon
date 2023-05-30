/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopaid;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author rahumathulla
 */
public class Shopaid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Period period = Period.between(LocalDate.parse("2016-08-31"), LocalDate.parse("2023-02-24"));
        long months = period.toTotalMonths();
        if (period.getDays() >= 15) {
            months++;
        }
        System.out.println("Months --"+months);
        
        System.out.println("Another Method --"+durationMonths(LocalDate.parse("2016-08-25"), LocalDate.parse("2023-02-24")));
        
        
    }
    
    private static long durationMonths(LocalDate dateBefore, LocalDate dateAfter) {
        System.out.println(dateBefore+"   "+dateAfter);
        if (dateBefore.getDayOfMonth() > 28) {
            dateBefore = dateBefore.minusDays(5);
        } else if (dateAfter.getDayOfMonth() > 28) {
            dateAfter = dateAfter.minusDays(5);
        }
        return ChronoUnit.MONTHS.between(dateBefore, dateAfter);
    }
    
}
