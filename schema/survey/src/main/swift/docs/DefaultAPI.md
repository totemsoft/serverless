# DefaultAPI

All URIs are relative to *https://$.execute-api.$.amazonaws.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](DefaultAPI.md#create) | **POST** /survey/create | Create Survey
[**download**](DefaultAPI.md#download) | **GET** /survey/download/{reference} | Download a file.
[**find**](DefaultAPI.md#find) | **GET** /survey/find/{reference} | Get Survey
[**update**](DefaultAPI.md#update) | **PUT** /survey/update | Update Survey
[**upload**](DefaultAPI.md#upload) | **POST** /survey/upload/{reference} | Upload a file.


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

let surveyRequest = SurveyRequest(reference: 123, folderId: "folderId_example", details: InsuredDetails(firstname: "firstname_example", surname: "surname_example", mobile: "mobile_example", email: "email_example", companyName: "companyName_example", tradingName: "tradingName_example", position: "position_example")) // SurveyRequest | Survey Request

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

# **download**
```swift
    open class func download(reference: UUID, filename: String, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Download a file.

Download a file.

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = 987 // UUID | Reference (Survey Id)
let filename = "filename_example" // String | File name

// Download a file.
DefaultAPI.download(reference: reference, filename: filename) { (response, error) in
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
 **reference** | **UUID** | Reference (Survey Id) | 
 **filename** | **String** | File name | 

### Return type

**URL**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/_*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **find**
```swift
    open class func find(reference: UUID, completion: @escaping (_ data: SurveyResponse?, _ error: Error?) -> Void)
```

Get Survey

Get Survey

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = 987 // UUID | Reference (Survey Id)

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
 **reference** | **UUID** | Reference (Survey Id) | 

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

let surveyRequest = SurveyRequest(reference: 123, folderId: "folderId_example", details: InsuredDetails(firstname: "firstname_example", surname: "surname_example", mobile: "mobile_example", email: "email_example", companyName: "companyName_example", tradingName: "tradingName_example", position: "position_example")) // SurveyRequest | Survey Request

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
    open class func upload(reference: UUID, fileUpload: URL, fileNote: String? = nil, completion: @escaping (_ data: UploadResponse?, _ error: Error?) -> Void)
```

Upload a file.

Uploads a file.

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = 987 // UUID | Reference (Survey Id)
let fileUpload = URL(string: "https://example.com")! // URL | The file to upload.
let fileNote = "fileNote_example" // String | Description of file content. (optional)

// Upload a file.
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
 **reference** | **UUID** | Reference (Survey Id) | 
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

