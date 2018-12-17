package br.com.dsasoft.ft.ws;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateCalcResource {

	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyyMMdd");

	@RequestMapping(value = "howLongSoFarInDays/{ds}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> howLongInDays(@PathVariable("ds") final String ds) {

		LocalDate d0 = LocalDate.parse(ds, DTF);
		LocalDate d1 = LocalDate.now();

		Long days = ChronoUnit.DAYS.between(d0, d1);

		return new ResponseEntity<String>(new JSONObject().put("days", days).toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "daysBetweenDates/{ds}/{df}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> howLongInDays(@PathVariable("ds") final String ds,
			@PathVariable("df") final String df) {

		LocalDate d0 = LocalDate.parse(ds, DTF);
		LocalDate d1 = LocalDate.parse(df, DTF);

		Long days = ChronoUnit.DAYS.between(d0, d1);

		return new ResponseEntity<String>(new JSONObject().put("days", days).toString(), HttpStatus.OK);
	}
}
