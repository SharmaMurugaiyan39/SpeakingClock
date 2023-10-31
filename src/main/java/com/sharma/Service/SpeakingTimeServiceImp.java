package com.sharma.Service;

import com.sharma.model.ModelSpeakingTime;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SpeakingTimeServiceImp implements SpeakingTimeService {
    String[] numberWords = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    String[] tensWords = {
            "twenty", "thirty", "forty", "fifty"
    };
    @Override
    public ModelSpeakingTime convertTimeFormatToWord(String time) {
        try {
            LocalTime currentTime = LocalTime.parse(time);
            int hours = currentTime.getHour();
            int minutes = currentTime.getMinute();
            System.out.println(currentTime+"Minit"+LocalTime.NOON);
            String timezoneReport;
            if (currentTime.equals(LocalTime.NOON)) {
               timezoneReport="It's Midday";
            }
            else if (currentTime.equals(LocalTime.MIDNIGHT)) {
                timezoneReport=   "It's Midnight";
            } else {
                timezoneReport  ="It's neither Midday nor Midnight";
            }
            String timeInWords = convertToTimeFormat(hours, minutes);

            String timeFormatWord = "It's " + timeInWords;

            ModelSpeakingTime modelSpeakingTime = new ModelSpeakingTime(timezoneReport, timeFormatWord);
            return modelSpeakingTime;
        }
        catch (Exception e)
        {
            ModelSpeakingTime modelSpeakingTime = new ModelSpeakingTime("Error", "Please proper format like  hh:mm ");
            return modelSpeakingTime;
        }
    }

    @Override
    public String timeZoneGet(String time) {
        try {
            LocalTime currentTime = LocalTime.parse(time);
            int hours = currentTime.getHour();
            int minutes = currentTime.getMinute();
            System.out.println(currentTime + "Minit" + LocalTime.NOON);
            String timezoneReport;
            if (currentTime.equals(LocalTime.NOON)) {
                timezoneReport = "It's Midday";
            } else if (currentTime.equals(LocalTime.MIDNIGHT)) {
                timezoneReport = "It's Midnight";
            } else {
                timezoneReport = "It's neither Midday nor Midnight";
            }
            return timezoneReport;
        }
        catch (Exception e)
        {
            return "please proper input like hh:mm like 00:00 only ";
        }

    }

    private String convertToTimeFormat(int hours, int minutes) {

        if (minutes < 20) {
            return numberWords[hours] + " " + numberWords[minutes];
        } else {
            return numberWords[hours] + " " + tensWords[minutes / 10 - 2] + " " + numberWords[minutes % 10];
        }
    }
}
