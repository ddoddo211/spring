package kr.or.ddit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//NoFileException
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFileException extends Exception{

	
	
}
