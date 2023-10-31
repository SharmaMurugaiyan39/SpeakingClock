package com.sharma.Service;

import com.sharma.model.ModelSpeakingTime;

public interface SpeakingTimeService {
    ModelSpeakingTime convertTimeFormatToWord(String Time);

    String timeZoneGet(String time);
}
