/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package au.com.totemsoft.elixir.survey.v1.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.totemsoft.elixir.survey.v1.model.RequestSurvey;
import au.com.totemsoft.elixir.survey.v1.model.ResponseSurvey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Validated
@Api(value = "survey", description = "the survey API")
public interface SurveyApi {

    SurveyApi getDelegate();

    /**
     * POST /survey/questions : Get Survey Questions
     * Obtain a list of survey questions
     *
     * @param xV Version of the API end point requested by the client. Must be set to a positive integer. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers). (required)
     * @param surveyRequest Survey Request (optional)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "Get Survey Questions", nickname = "surveyQuestions", notes = "Obtain a list of survey questions", response = ResponseSurvey.class, tags={ "Survey", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = ResponseSurvey.class) })
    @RequestMapping(value = "/survey/questions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ResponseSurvey> surveyQuestions(@ApiParam(value = "Version of the API end point requested by the client. Must be set to a positive integer. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)." ,required=true) @RequestHeader(value="x-v", required=true) String xV,@ApiParam(value = "Survey Request"  )  @Valid @RequestBody(required = false) RequestSurvey surveyRequest) {
        return getDelegate().surveyQuestions(xV, surveyRequest);
    }

}
