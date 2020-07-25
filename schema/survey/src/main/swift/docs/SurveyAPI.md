# SurveyAPI

All URIs are relative to *https://$.execute-api.$.amazonaws.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**survey**](SurveyAPI.md#survey) | **POST** /survey | Get/Create Survey
[**surveyQuestions**](SurveyAPI.md#surveyquestions) | **POST** /survey/questions | Get Survey Questions
[**surveyUpload**](SurveyAPI.md#surveyupload) | **POST** /survey/upload | Uploads a file.


# **survey**
```swift
    open class func survey(surveyRequest: RequestSurvey, completion: @escaping (_ data: ResponseSurvey?, _ error: Error?) -> Void)
```

Get/Create Survey

Obtain a survey (will create one if does not exists)

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let surveyRequest = RequestSurvey(surveyId: "surveyId_example") // RequestSurvey | Survey Request

// Get/Create Survey
SurveyAPI.survey(surveyRequest: surveyRequest) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **surveyRequest** | [**RequestSurvey**](RequestSurvey.md) | Survey Request | 

### Return type

[**ResponseSurvey**](ResponseSurvey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **surveyQuestions**
```swift
    open class func surveyQuestions(reference: String, surveyRequest: RequestSurvey, completion: @escaping (_ data: ResponseSurveyQuestions?, _ error: Error?) -> Void)
```

Get Survey Questions

Obtain a list of survey questions

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = "reference_example" // String | Reference of request. See [HTTP Headers](#request-headers).
let surveyRequest = RequestSurvey(surveyId: "surveyId_example") // RequestSurvey | Survey Request

// Get Survey Questions
SurveyAPI.surveyQuestions(reference: reference, surveyRequest: surveyRequest) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String** | Reference of request. See [HTTP Headers](#request-headers). | 
 **surveyRequest** | [**RequestSurvey**](RequestSurvey.md) | Survey Request | 

### Return type

[**ResponseSurveyQuestions**](ResponseSurveyQuestions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **surveyUpload**
```swift
    open class func surveyUpload(reference: String, fileUpload: URL, fileNote: String? = nil, completion: @escaping (_ data: ResponseUpload?, _ error: Error?) -> Void)
```

Uploads a file.

Uploads a file.

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = "reference_example" // String | Reference of request. See [HTTP Headers](#request-headers).
let fileUpload = URL(string: "https://example.com")! // URL | The file to upload.
let fileNote = "fileNote_example" // String | Description of file content. (optional)

// Uploads a file.
SurveyAPI.surveyUpload(reference: reference, fileUpload: fileUpload, fileNote: fileNote) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | **String** | Reference of request. See [HTTP Headers](#request-headers). | 
 **fileUpload** | **URL** | The file to upload. | 
 **fileNote** | **String** | Description of file content. | [optional] 

### Return type

[**ResponseUpload**](ResponseUpload.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

