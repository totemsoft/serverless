/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package au.com.totemsoft.elixir.survey.v1.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import au.com.totemsoft.elixir.survey.v1.model.SurveyRequest;
import au.com.totemsoft.elixir.survey.v1.model.SurveyResponse;
import au.com.totemsoft.elixir.survey.v1.model.SurveySummaryResponse;
import au.com.totemsoft.elixir.survey.v1.model.UploadResponse;
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
     * POST /survey/create : Create Survey.
     * Create Survey for user (current selected client/location).
     *
     * @param client Client Name (required)
     * @param surveyRequest Survey Request (required)
     * @param location Location Name (optional)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "Create Survey.", nickname = "createSurvey", notes = "Create Survey for user (current selected client/location).", response = SurveySummaryResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = SurveySummaryResponse.class) })
    @RequestMapping(value = "/survey/create",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<SurveySummaryResponse> createSurvey(@ApiParam(value = "Client Name" ,required=true) @RequestHeader(value="client", required=true) String client,@ApiParam(value = "Survey Request" ,required=true )  @Valid @RequestBody SurveyRequest surveyRequest,@ApiParam(value = "Location Name" ) @RequestHeader(value="location", required=false) Optional<String> location) {
        return getDelegate().createSurvey(client, surveyRequest, location);
    }


    /**
     * GET /survey/download/{reference}/{folderId} : Download a file.
     * Download a file (for Survey).
     *
     * @param reference Reference (Survey Id) (required)
     * @param folderId Folder Id (required)
     * @param filename File name (required)
     * @return Success (status code 200)
     *         or File not found (status code 404)
     */
    @ApiOperation(value = "Download a file.", nickname = "download", notes = "Download a file (for Survey).", response = Resource.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Resource.class),
        @ApiResponse(code = 404, message = "File not found") })
    @RequestMapping(value = "/survey/download/{reference}/{folderId}",
        produces = { "application/_*", "image/_*" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Resource> download(@ApiParam(value = "Reference (Survey Id)",required=true) @PathVariable("reference") UUID reference,@ApiParam(value = "Folder Id",required=true) @PathVariable("folderId") String folderId,@NotNull @ApiParam(value = "File name", required = true) @Valid @RequestParam(value = "filename", required = true) String filename) {
        return getDelegate().download(reference, folderId, filename);
    }


    /**
     * GET /survey/find/{reference}/{folderId} : Get Survey.
     * Get Survey (by reference).
     *
     * @param client Client Name (required)
     * @param reference Reference (Survey Id) (required)
     * @param folderId Folder Id (required)
     * @param location Location Name (optional)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "Get Survey.", nickname = "findSurvey", notes = "Get Survey (by reference).", response = SurveyResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = SurveyResponse.class) })
    @RequestMapping(value = "/survey/find/{reference}/{folderId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<SurveyResponse> findSurvey(@ApiParam(value = "Client Name" ,required=true) @RequestHeader(value="client", required=true) String client,@ApiParam(value = "Reference (Survey Id)",required=true) @PathVariable("reference") UUID reference,@ApiParam(value = "Folder Id",required=true) @PathVariable("folderId") String folderId,@ApiParam(value = "Location Name" ) @RequestHeader(value="location", required=false) Optional<String> location) {
        return getDelegate().findSurvey(client, reference, folderId, location);
    }


    /**
     * GET /survey/find : Find all Surveys for user.
     * Find all Surveys for user (current selected client/location).
     *
     * @param client Client Name (required)
     * @param location Location Name (optional)
     * @return An array of SurveyResponse(s) (status code 200)
     */
    @ApiOperation(value = "Find all Surveys for user.", nickname = "findSurveys", notes = "Find all Surveys for user (current selected client/location).", response = SurveySummaryResponse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of SurveyResponse(s)", response = SurveySummaryResponse.class, responseContainer = "List") })
    @RequestMapping(value = "/survey/find",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<SurveySummaryResponse>> findSurveys(@ApiParam(value = "Client Name" ,required=true) @RequestHeader(value="client", required=true) String client,@ApiParam(value = "Location Name" ) @RequestHeader(value="location", required=false) Optional<String> location) {
        return getDelegate().findSurveys(client, location);
    }


    /**
     * PUT /survey/update : Update Survey.
     * Update Survey (for reference).
     *
     * @param client Client Name (required)
     * @param surveyRequest Survey Request (required)
     * @param location Location Name (optional)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "Update Survey.", nickname = "updateSurvey", notes = "Update Survey (for reference).", response = SurveyResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = SurveyResponse.class) })
    @RequestMapping(value = "/survey/update",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<SurveyResponse> updateSurvey(@ApiParam(value = "Client Name" ,required=true) @RequestHeader(value="client", required=true) String client,@ApiParam(value = "Survey Request" ,required=true )  @Valid @RequestBody SurveyRequest surveyRequest,@ApiParam(value = "Location Name" ) @RequestHeader(value="location", required=false) Optional<String> location) {
        return getDelegate().updateSurvey(client, surveyRequest, location);
    }


    /**
     * POST /survey/upload/base64/{reference}/{folderId} : Upload a file.
     * Uploads a file (for Survey).
     *
     * @param reference Reference (Survey Id) (required)
     * @param folderId Folder Id (required)
     * @param filename File name (required)
     * @param body  (required)
     * @return Success (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access token does not have the required scope (status code 403)
     */
    @ApiOperation(value = "Upload a file.", nickname = "uploadBase64", notes = "Uploads a file (for Survey).", response = UploadResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = UploadResponse.class),
        @ApiResponse(code = 401, message = "Not authenticated"),
        @ApiResponse(code = 403, message = "Access token does not have the required scope") })
    @RequestMapping(value = "/survey/upload/base64/{reference}/{folderId}",
        produces = { "application/json" }, 
        consumes = { "image/_*" },
        method = RequestMethod.POST)
    default ResponseEntity<UploadResponse> uploadBase64(@ApiParam(value = "Reference (Survey Id)",required=true) @PathVariable("reference") UUID reference,@ApiParam(value = "Folder Id",required=true) @PathVariable("folderId") String folderId,@NotNull @ApiParam(value = "File name", required = true) @Valid @RequestParam(value = "filename", required = true) String filename,@ApiParam(value = "" ,required=true )  @Valid @RequestBody String body) {
        return getDelegate().uploadBase64(reference, folderId, filename, body);
    }


    /**
     * POST /survey/upload/binary/{reference}/{folderId} : Upload a file.
     * Uploads a file (for Survey).
     *
     * @param reference Reference (Survey Id) (required)
     * @param folderId Folder Id (required)
     * @param filename File name (required)
     * @param body  (required)
     * @return Success (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access token does not have the required scope (status code 403)
     */
    @ApiOperation(value = "Upload a file.", nickname = "uploadBinary", notes = "Uploads a file (for Survey).", response = UploadResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = UploadResponse.class),
        @ApiResponse(code = 401, message = "Not authenticated"),
        @ApiResponse(code = 403, message = "Access token does not have the required scope") })
    @RequestMapping(value = "/survey/upload/binary/{reference}/{folderId}",
        produces = { "application/json" }, 
        consumes = { "image/_*" },
        method = RequestMethod.POST)
    default ResponseEntity<UploadResponse> uploadBinary(@ApiParam(value = "Reference (Survey Id)",required=true) @PathVariable("reference") UUID reference,@ApiParam(value = "Folder Id",required=true) @PathVariable("folderId") String folderId,@NotNull @ApiParam(value = "File name", required = true) @Valid @RequestParam(value = "filename", required = true) String filename,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Resource body) {
        return getDelegate().uploadBinary(reference, folderId, filename, body);
    }


    /**
     * POST /survey/upload/{reference}/{folderId} : Upload a file.
     * Uploads a file (for Survey).
     *
     * @param reference Reference (Survey Id) (required)
     * @param folderId Folder Id (required)
     * @param fileUpload The file to upload. (required)
     * @param filename File name (optional)
     * @return Success (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access token does not have the required scope (status code 403)
     */
    @ApiOperation(value = "Upload a file.", nickname = "uploadMultipart", notes = "Uploads a file (for Survey).", response = UploadResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = UploadResponse.class),
        @ApiResponse(code = 401, message = "Not authenticated"),
        @ApiResponse(code = 403, message = "Access token does not have the required scope") })
    @RequestMapping(value = "/survey/upload/{reference}/{folderId}",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    default ResponseEntity<UploadResponse> uploadMultipart(@ApiParam(value = "Reference (Survey Id)",required=true) @PathVariable("reference") UUID reference,@ApiParam(value = "Folder Id",required=true) @PathVariable("folderId") String folderId,@ApiParam(value = "The file to upload.") @Valid @RequestPart(value = "fileUpload") MultipartFile fileUpload,@ApiParam(value = "File name") @Valid @RequestParam(value = "filename", required = false) Optional<String> filename) {
        return getDelegate().uploadMultipart(reference, folderId, fileUpload, filename);
    }

}
