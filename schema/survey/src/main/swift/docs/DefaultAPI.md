# DefaultAPI

All URIs are relative to *https://$.execute-api.$.amazonaws.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](DefaultAPI.md#create) | **POST** /survey/create | Create Survey
[**find**](DefaultAPI.md#find) | **GET** /survey/find/{reference} | Get Survey
[**update**](DefaultAPI.md#update) | **PUT** /survey/update | Update Survey
[**upload**](DefaultAPI.md#upload) | **POST** /survey/upload/{reference} | Uploads a file.


# **create**
```swift
    open class func create(surveyRequest: SurveyRequest, completion: @escaping (_ data: SurveyResponse?, _ error: Error?) -> Void)
```

Create Survey

Create Survey

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let surveyRequest = SurveyRequest(reference: "reference_example") // SurveyRequest | Survey Request

// Create Survey
DefaultAPI.create(surveyRequest: surveyRequest) { (response, error) in
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
 **surveyRequest** | [**SurveyRequest**](SurveyRequest.md) | Survey Request | 

### Return type

[**SurveyResponse**](SurveyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **find**
```swift
    open class func find(reference: String, completion: @escaping (_ data: SurveyResponse?, _ error: Error?) -> Void)
```

Get Survey

Get Survey

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = "reference_example" // String | Reference of request.

// Get Survey
DefaultAPI.find(reference: reference) { (response, error) in
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
 **reference** | **String** | Reference of request. | 

### Return type

[**SurveyResponse**](SurveyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update**
```swift
    open class func update(surveyRequest: SurveyRequest, completion: @escaping (_ data: SurveyResponse?, _ error: Error?) -> Void)
```

Update Survey

Update Survey

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let surveyRequest = SurveyRequest(reference: "reference_example") // SurveyRequest | Survey Request

// Update Survey
DefaultAPI.update(surveyRequest: surveyRequest) { (response, error) in
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
 **surveyRequest** | [**SurveyRequest**](SurveyRequest.md) | Survey Request | 

### Return type

[**SurveyResponse**](SurveyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **upload**
```swift
    open class func upload(reference: String, fileUpload: URL, fileNote: String? = nil, completion: @escaping (_ data: UploadResponse?, _ error: Error?) -> Void)
```

Uploads a file.

Uploads a file.

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = "reference_example" // String | Reference of request.
let fileUpload = URL(string: "https://example.com")! // URL | The file to upload.
let fileNote = "fileNote_example" // String | Description of file content. (optional)

// Uploads a file.
DefaultAPI.upload(reference: reference, fileUpload: fileUpload, fileNote: fileNote) { (response, error) in
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
 **reference** | **String** | Reference of request. | 
 **fileUpload** | **URL** | The file to upload. | 
 **fileNote** | **String** | Description of file content. | [optional] 

### Return type

[**UploadResponse**](UploadResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
