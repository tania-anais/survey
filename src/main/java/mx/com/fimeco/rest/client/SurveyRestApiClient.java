package mx.com.fimeco.rest.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;
import mx.com.fimeco.dto.SurveyData;
import mx.com.fimeco.dto.Token;

/**
 * Dummy Client
 * Send provided answers to Survey Rest API
 * Implements the code to authenticate and consume rest services
 */
@Log4j2
@Component
public class SurveyRestApiClient {

	@Value("${api.auth.url}")	
	private String authUrl;
	
	@Value("${api.key}")	
	private String key;
	
	@Value("${api.secret}")	
	private String secret;
	
	/**
	 * Only transform object into Json, is a dummy method
	 * @param surveyData
	 * @return
	 */
	public boolean sendSolvedSurvey(SurveyData surveyData, Token token) {
		boolean result = Boolean.FALSE;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			log.info(token);
			log.info(objectMapper.writeValueAsString(surveyData));
			result = Boolean.TRUE;
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}
	
	/**
	 * It is a Dummy method but if we consume an API, we could use RestTemplate class
	 * @return
	 */
	public Token getAuthorizationToken() {
		Token token = new Token();
		token.setAccessToken("dummy");
		token.setExpiresIn("300000");
		token.setTokenType("oAuth2");
		return token;
	}
	
}
