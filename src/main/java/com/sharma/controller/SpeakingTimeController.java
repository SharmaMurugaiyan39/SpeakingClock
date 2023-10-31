package com.sharma.controller;

import com.sharma.Service.SpeakingTimeService;
import com.sharma.model.ModelSpeakingTime;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Speaking Time", description = "APIs Calls")
@RequestMapping("/speaking-time")
public class SpeakingTimeController {

	@Autowired
	SpeakingTimeService speakingTimeService;

	@GetMapping("/find:format-time")
	@ApiOperation(value = "Convert hour time to words")
	public ResponseEntity<?> timeWordFormat(@RequestParam String time) {

		ModelSpeakingTime modelData= speakingTimeService.convertTimeFormatToWord(time);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "Custom-Value");

		HttpStatus status = HttpStatus.OK;

		return new ResponseEntity<>(modelData, headers, status);
	}
	@GetMapping("/find:dayzone")
	@ApiOperation(value = "Find midnight and midday ")
	public ResponseEntity<String> findTimeZone(@RequestParam String time) {

		String timezone= speakingTimeService.timeZoneGet(time);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "Custom-Value");
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<>(timezone, headers, status);
	}
}
