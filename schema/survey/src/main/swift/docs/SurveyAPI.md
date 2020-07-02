# SurveyAPI

All URIs are relative to *https://survey.holder.com.au/survey-au/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**surveyQuestions**](SurveyAPI.md#surveyquestions) | **POST** /survey/questions | Get Survey Questions


# **surveyQuestions**
```swift
    open class func surveyQuestions(xV: String, surveyRequest: RequestSurvey? = nil, completion: @escaping (_ data: ResponseSurvey?, _ error: Error?) -> Void)
```

Get Survey Questions

Obtain a list of survey questions

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let xV = "xV_example" // String | Version of the API end point requested by the client. Must be set to a positive integer. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers).
let surveyRequest = RequestSurvey(surveyId: "surveyId_example") // RequestSurvey | Survey Request (optional)

// Get Survey Questions
SurveyAPI.surveyQuestions(xV: xV, surveyRequest: surveyRequest) { (response, error) in
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
 **xV** | **String** | Version of the API end point requested by the client. Must be set to a positive integer. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers). | 
 **surveyRequest** | [**RequestSurvey**](RequestSurvey.md) | Survey Request | [optional] 

### Return type

[**ResponseSurvey**](ResponseSurvey.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

