package simdev.exmvn;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var horloge = Clock.systemUTC();
        // Dates
        var aujourdhui = LocalDate.now(horloge);
        var apresDemain = aujourdhui.plusDays(2);
        var noel = LocalDate.of(aujourdhui.getYear(), Month.DECEMBER, 25);

        System.out.println(aujourdhui);
        System.out.println(apresDemain);
        System.out.println(noel);

        // formatage des dates en fonction de la localisation géographique
        System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.FRANCE))); 
        System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.FRANCE))); 
        System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.FRANCE))); 
        System.out.println(noel.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        // Changer le format
        var printemps = LocalDate.parse(
            "20/03/2024",
            DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.FRANCE)
        );

        System.out.println(printemps);

        // Heures
        var maintenant = LocalTime.now(horloge);

        System.out.println(maintenant.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.FRANCE)));
        System.out.println(maintenant.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        System.out.println(maintenant.format(DateTimeFormatter.ISO_TIME));

        /* Dates + Heures / fuseaux */

        var nouvelAn = LocalDateTime.of(2024,1,1,0,0,0,0);
        var nouvelAnParis = ZonedDateTime.of(nouvelAn, ZoneId.of("Europe/Paris"));
        var nouvelAnGreenwitch = OffsetDateTime.of(nouvelAn, ZoneOffset.ofHours(0));

        if(nouvelAnParis.toInstant().isBefore(nouvelAnGreenwitch.toInstant())){
            System.out.println("Paris change d'année avant le méridien 0");
        }else {
            System.out.println("Paris change d'année après ou avec le méridien 0");
        }

    }
}
