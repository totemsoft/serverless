/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package au.com.totemsoft.elixir.survey.v1.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import au.com.totemsoft.elixir.survey.v1.model.SurveyRequest;
import au.com.totemsoft.elixir.survey.v1.model.SurveyResponse;
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
     * Create Survey for user (current selected client).
     *
     * @param surveyRequest Survey Request (required)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "Create Survey.", nickname = "createSurvey", notes = "Create Survey for user (current selected client).", response = SurveyResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = SurveyResponse.class) })
    @RequestMapping(value = "/survey/create",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<SurveyResponse> createSurvey(@ApiParam(value = "Survey Request" ,required=true )  @Valid @RequestBody SurveyRequest surveyRequest) {
        return getDelegate().createSurvey(surveyRequest);
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
     * @param reference Reference (Survey Id) (required)
     * @param folderId Folder Id (required)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "Get Survey.", nickname = "findSurvey", notes = "Get Survey (by reference).", response = SurveyResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = SurveyResponse.class) })
    @RequestMapping(value = "/survey/find/{reference}/{folderId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<SurveyResponse> findSurvey(@ApiParam(value = "Reference (Survey Id)",required=true) @PathVariable("reference") UUID reference,@ApiParam(value = "Folder Id",required=true) @PathVariable("folderId") String folderId) {
        return getDelegate().findSurvey(reference, folderId);
    }


    /**
     * GET /survey/find : Find all Surveys for user.
     * Find all Surveys for user (current selected client).
     *
     * @return An array of SurveyResponse(s) (status code 200)
     */
    @ApiOperation(value = "Find all Surveys for user.", nickname = "findSurveys", notes = "Find all Surveys for user (current selected client).", response = SurveyResponse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of SurveyResponse(s)", response = SurveyResponse.class, responseContainer = "List") })
    @RequestMapping(value = "/survey/find",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<SurveyResponse>> findSurveys() {
        return getDelegate().findSurveys();
    }


    /**
     * PUT /survey/update : Update Survey.
     * Update Survey (for reference).
     *
     * @param surveyRequest Survey Request (required)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "Update Survey.", nickname = "updateSurvey", notes = "Update Survey (for reference).", response = SurveyResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = SurveyResponse.class) })
    @RequestMapping(value = "/survey/update",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<SurveyResponse> updateSurvey(@ApiParam(value = "Survey Request" ,required=true )  @Valid @RequestBody SurveyRequest surveyRequest) {
        return getDelegate().updateSurvey(surveyRequest);
    }


    /**
     * POST /survey/upload/{reference}/{folderId} : Upload a file.
     * Uploads a file (for Survey).
     *
     * @param reference Reference (Survey Id) (required)
     * @param folderId Folder Id (required)
     * @param fileUpload The file to upload. (required)
     * @param fileNote Description of file content. (optional)
     * @return Success (status code 200)
     *         or Not authenticated (status code 401)
     *         or Access token does not have the required scope (status code 403)
     */
    @ApiOperation(value = "Upload a file.", nickname = "upload", notes = "Uploads a file (for Survey).", response = UploadResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = UploadResponse.class),
        @ApiResponse(code = 401, message = "Not authenticated"),
        @ApiResponse(code = 403, message = "Access token does not have the required scope") })
    @RequestMapping(value = "/survey/upload/{reference}/{folderId}",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    default ResponseEntity<UploadResponse> upload(@ApiParam(value = "Reference (Survey Id)",required=true) @PathVariable("reference") UUID reference,@ApiParam(value = "Folder Id",required=true) @PathVariable("folderId") String folderId,@ApiParam(value = "The file to upload.") @Valid @RequestPart(value = "fileUpload") MultipartFile fileUpload,@ApiParam(value = "Description of file content.") @RequestPart(value="fileNote", required=false)  String fileNote) {
        return getDelegate().upload(reference, folderId, fileUpload, fileNote);
    }

}
