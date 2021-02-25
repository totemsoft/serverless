# DefaultAPI

All URIs are relative to *https://$.execute-api.$.amazonaws.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSurvey**](DefaultAPI.md#createsurvey) | **POST** /survey/create | Create Survey.
[**download**](DefaultAPI.md#download) | **GET** /survey/download/{reference}/{folderId} | Download a file.
[**findClients**](DefaultAPI.md#findclients) | **GET** /client/find | Receives all clients.
[**findClientsByUser**](DefaultAPI.md#findclientsbyuser) | **GET** /client/find/{userId} | Receives all clients.
[**findSurvey**](DefaultAPI.md#findsurvey) | **GET** /survey/find/{reference}/{folderId} | Get Survey.
[**findSurveys**](DefaultAPI.md#findsurveys) | **GET** /survey/find | Find all Surveys for user.
[**updateSurvey**](DefaultAPI.md#updatesurvey) | **PUT** /survey/update | Update Survey.
[**upload**](DefaultAPI.md#upload) | **POST** /survey/upload/{reference}/{folderId} | Upload a file.


# **createSurvey**
```swift
    open class func createSurvey(client: String, surveyRequest: SurveyRequest, location: String? = nil, completion: @escaping (_ data: SurveySummaryResponse?, _ error: Error?) -> Void)
```

Create Survey.

Create Survey for user (current selected client/location).

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let client = "client_example" // String | Client Name
let surveyRequest = SurveyRequest(reference: 123, folderId: "folderId_example", broker: BrokerDetails(id: "id_example", client: "client_example"), insured: InsuredDetails(firstname: "firstname_example", surname: "surname_example", mobile: "mobile_example", email: "email_example", companyName: "companyName_example", tradingName: "tradingName_example", position: "position_example"), survey: "survey_example") // SurveyRequest | Survey Request
let location = "location_example" // String | Location Name (optional)

// Create Survey.
DefaultAPI.createSurvey(client: client, surveyRequest: surveyRequest, location: location) { (response, error) in
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
 **client** | **String** | Client Name | 
 **surveyRequest** | [**SurveyRequest**](SurveyRequest.md) | Survey Request | 
 **location** | **String** | Location Name | [optional] 

### Return type

[**SurveySummaryResponse**](SurveySummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **download**
```swift
    open class func download(reference: UUID, folderId: String, filename: String, completion: @escaping (_ data: URL?, _ error: Error?) -> Void)
```

Download a file.

Download a file (for Survey).

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = 987 // UUID | Reference (Survey Id)
let folderId = "folderId_example" // String | Folder Id
let filename = "filename_example" // String | File name

// Download a file.
DefaultAPI.download(reference: reference, folderId: folderId, filename: filename) { (response, error) in
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
 **folderId** | **String** | Folder Id | 
 **filename** | **String** | File name | 

### Return type

**URL**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/_*, image/_*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **findClients**
```swift
    open class func findClients(completion: @escaping (_ data: [ClientResponse]?, _ error: Error?) -> Void)
```

Receives all clients.

Receives all clients for a user.

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient


// Receives all clients.
DefaultAPI.findClients() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[ClientResponse]**](ClientResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **findClientsByUser**
```swift
    open class func findClientsByUser(userId: String, completion: @escaping (_ data: [ClientResponse]?, _ error: Error?) -> Void)
```

Receives all clients.

Receives all clients for a user.

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let userId = "userId_example" // String | User Id

// Receives all clients.
DefaultAPI.findClientsByUser(userId: userId) { (response, error) in
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
 **userId** | **String** | User Id | 

### Return type

[**[ClientResponse]**](ClientResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **findSurvey**
```swift
    open class func findSurvey(client: String, reference: UUID, folderId: String, location: String? = nil, completion: @escaping (_ data: SurveyResponse?, _ error: Error?) -> Void)
```

Get Survey.

Get Survey (by reference).

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let client = "client_example" // String | Client Name
let reference = 987 // UUID | Reference (Survey Id)
let folderId = "folderId_example" // String | Folder Id
let location = "location_example" // String | Location Name (optional)

// Get Survey.
DefaultAPI.findSurvey(client: client, reference: reference, folderId: folderId, location: location) { (response, error) in
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
 **client** | **String** | Client Name | 
 **reference** | **UUID** | Reference (Survey Id) | 
 **folderId** | **String** | Folder Id | 
 **location** | **String** | Location Name | [optional] 

### Return type

[**SurveyResponse**](SurveyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **findSurveys**
```swift
    open class func findSurveys(client: String, location: String? = nil, completion: @escaping (_ data: [SurveySummaryResponse]?, _ error: Error?) -> Void)
```

Find all Surveys for user.

Find all Surveys for user (current selected client/location).

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let client = "client_example" // String | Client Name
let location = "location_example" // String | Location Name (optional)

// Find all Surveys for user.
DefaultAPI.findSurveys(client: client, location: location) { (response, error) in
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
 **client** | **String** | Client Name | 
 **location** | **String** | Location Name | [optional] 

### Return type

[**[SurveySummaryResponse]**](SurveySummaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateSurvey**
```swift
    open class func updateSurvey(client: String, surveyRequest: SurveyRequest, location: String? = nil, completion: @escaping (_ data: SurveyResponse?, _ error: Error?) -> Void)
```

Update Survey.

Update Survey (for reference).

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let client = "client_example" // String | Client Name
let surveyRequest = SurveyRequest(reference: 123, folderId: "folderId_example", broker: BrokerDetails(id: "id_example", client: "client_example"), insured: InsuredDetails(firstname: "firstname_example", surname: "surname_example", mobile: "mobile_example", email: "email_example", companyName: "companyName_example", tradingName: "tradingName_example", position: "position_example"), survey: "survey_example") // SurveyRequest | Survey Request
let location = "location_example" // String | Location Name (optional)

// Update Survey.
DefaultAPI.updateSurvey(client: client, surveyRequest: surveyRequest, location: location) { (response, error) in
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
 **client** | **String** | Client Name | 
 **surveyRequest** | [**SurveyRequest**](SurveyRequest.md) | Survey Request | 
 **location** | **String** | Location Name | [optional] 

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
    open class func upload(reference: UUID, folderId: String, fileUpload: URL, completion: @escaping (_ data: UploadResponse?, _ error: Error?) -> Void)
```

Upload a file.

Uploads a file (for Survey).

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let reference = 987 // UUID | Reference (Survey Id)
let folderId = "folderId_example" // String | Folder Id
let fileUpload = URL(string: "https://example.com")! // URL | The file to upload.

// Upload a file.
DefaultAPI.upload(reference: reference, folderId: folderId, fileUpload: fileUpload) { (response, error) in
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
 **folderId** | **String** | Folder Id | 
 **fileUpload** | **URL** | The file to upload. | 

### Return type

[**UploadResponse**](UploadResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

