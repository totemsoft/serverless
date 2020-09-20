//
// DefaultAPI.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation



open class DefaultAPI {
    /**
     Create Survey
     
     - parameter surveyRequest: (body) Survey Request 
     - parameter apiResponseQueue: The queue on which api response is dispatched.
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func create(surveyRequest: SurveyRequest, apiResponseQueue: DispatchQueue = OpenAPIClientAPI.apiResponseQueue, completion: @escaping ((_ data: SurveyResponse?,_ error: Error?) -> Void)) {
        createWithRequestBuilder(surveyRequest: surveyRequest).execute(apiResponseQueue) { result -> Void in
            switch result {
            case let .success(response):
                completion(response.body, nil)
            case let .failure(error):
                completion(nil, error)
            }
        }
    }

    /**
     Create Survey
     - POST /survey/create
     - Create Survey
     - parameter surveyRequest: (body) Survey Request 
     - returns: RequestBuilder<SurveyResponse> 
     */
    open class func createWithRequestBuilder(surveyRequest: SurveyRequest) -> RequestBuilder<SurveyResponse> {
        let path = "/survey/create"
        let URLString = OpenAPIClientAPI.basePath + path
        let parameters = JSONEncodingHelper.encodingParameters(forEncodableObject: surveyRequest)

        let url = URLComponents(string: URLString)

        let requestBuilder: RequestBuilder<SurveyResponse>.Type = OpenAPIClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "POST", URLString: (url?.string ?? URLString), parameters: parameters, isBody: true)
    }

    /**
     Download a file.
     
     - parameter reference: (path) Reference (Survey Id) 
     - parameter folderId: (path) Folder Id 
     - parameter filename: (query) File name 
     - parameter apiResponseQueue: The queue on which api response is dispatched.
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func download(reference: UUID, folderId: String, filename: String, apiResponseQueue: DispatchQueue = OpenAPIClientAPI.apiResponseQueue, completion: @escaping ((_ data: URL?,_ error: Error?) -> Void)) {
        downloadWithRequestBuilder(reference: reference, folderId: folderId, filename: filename).execute(apiResponseQueue) { result -> Void in
            switch result {
            case let .success(response):
                completion(response.body, nil)
            case let .failure(error):
                completion(nil, error)
            }
        }
    }

    /**
     Download a file.
     - GET /survey/download/{reference}/{folderId}
     - Download a file.
     - parameter reference: (path) Reference (Survey Id) 
     - parameter folderId: (path) Folder Id 
     - parameter filename: (query) File name 
     - returns: RequestBuilder<URL> 
     */
    open class func downloadWithRequestBuilder(reference: UUID, folderId: String, filename: String) -> RequestBuilder<URL> {
        var path = "/survey/download/{reference}/{folderId}"
        let referencePreEscape = "\(APIHelper.mapValueToPathItem(reference))"
        let referencePostEscape = referencePreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{reference}", with: referencePostEscape, options: .literal, range: nil)
        let folderIdPreEscape = "\(APIHelper.mapValueToPathItem(folderId))"
        let folderIdPostEscape = folderIdPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{folderId}", with: folderIdPostEscape, options: .literal, range: nil)
        let URLString = OpenAPIClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        
        var url = URLComponents(string: URLString)
        url?.queryItems = APIHelper.mapValuesToQueryItems([
            "filename": filename.encodeToJSON()
        ])

        let requestBuilder: RequestBuilder<URL>.Type = OpenAPIClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }

    /**
     Get Survey
     
     - parameter reference: (path) Reference (Survey Id) 
     - parameter folderId: (path) Folder Id 
     - parameter apiResponseQueue: The queue on which api response is dispatched.
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func find(reference: UUID, folderId: String, apiResponseQueue: DispatchQueue = OpenAPIClientAPI.apiResponseQueue, completion: @escaping ((_ data: SurveyResponse?,_ error: Error?) -> Void)) {
        findWithRequestBuilder(reference: reference, folderId: folderId).execute(apiResponseQueue) { result -> Void in
            switch result {
            case let .success(response):
                completion(response.body, nil)
            case let .failure(error):
                completion(nil, error)
            }
        }
    }

    /**
     Get Survey
     - GET /survey/find/{reference}/{folderId}
     - Get Survey
     - parameter reference: (path) Reference (Survey Id) 
     - parameter folderId: (path) Folder Id 
     - returns: RequestBuilder<SurveyResponse> 
     */
    open class func findWithRequestBuilder(reference: UUID, folderId: String) -> RequestBuilder<SurveyResponse> {
        var path = "/survey/find/{reference}/{folderId}"
        let referencePreEscape = "\(APIHelper.mapValueToPathItem(reference))"
        let referencePostEscape = referencePreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{reference}", with: referencePostEscape, options: .literal, range: nil)
        let folderIdPreEscape = "\(APIHelper.mapValueToPathItem(folderId))"
        let folderIdPostEscape = folderIdPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{folderId}", with: folderIdPostEscape, options: .literal, range: nil)
        let URLString = OpenAPIClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        
        let url = URLComponents(string: URLString)

        let requestBuilder: RequestBuilder<SurveyResponse>.Type = OpenAPIClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }

    /**
     Find all Surveys for user
     
     - parameter apiResponseQueue: The queue on which api response is dispatched.
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func findAll(apiResponseQueue: DispatchQueue = OpenAPIClientAPI.apiResponseQueue, completion: @escaping ((_ data: [SurveyResponse]?,_ error: Error?) -> Void)) {
        findAllWithRequestBuilder().execute(apiResponseQueue) { result -> Void in
            switch result {
            case let .success(response):
                completion(response.body, nil)
            case let .failure(error):
                completion(nil, error)
            }
        }
    }

    /**
     Find all Surveys for user
     - GET /survey/find
     - Find all Surveys for user
     - returns: RequestBuilder<[SurveyResponse]> 
     */
    open class func findAllWithRequestBuilder() -> RequestBuilder<[SurveyResponse]> {
        let path = "/survey/find"
        let URLString = OpenAPIClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        
        let url = URLComponents(string: URLString)

        let requestBuilder: RequestBuilder<[SurveyResponse]>.Type = OpenAPIClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }

    /**
     Update Survey
     
     - parameter surveyRequest: (body) Survey Request 
     - parameter apiResponseQueue: The queue on which api response is dispatched.
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func update(surveyRequest: SurveyRequest, apiResponseQueue: DispatchQueue = OpenAPIClientAPI.apiResponseQueue, completion: @escaping ((_ data: SurveyResponse?,_ error: Error?) -> Void)) {
        updateWithRequestBuilder(surveyRequest: surveyRequest).execute(apiResponseQueue) { result -> Void in
            switch result {
            case let .success(response):
                completion(response.body, nil)
            case let .failure(error):
                completion(nil, error)
            }
        }
    }

    /**
     Update Survey
     - PUT /survey/update
     - Update Survey
     - parameter surveyRequest: (body) Survey Request 
     - returns: RequestBuilder<SurveyResponse> 
     */
    open class func updateWithRequestBuilder(surveyRequest: SurveyRequest) -> RequestBuilder<SurveyResponse> {
        let path = "/survey/update"
        let URLString = OpenAPIClientAPI.basePath + path
        let parameters = JSONEncodingHelper.encodingParameters(forEncodableObject: surveyRequest)

        let url = URLComponents(string: URLString)

        let requestBuilder: RequestBuilder<SurveyResponse>.Type = OpenAPIClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "PUT", URLString: (url?.string ?? URLString), parameters: parameters, isBody: true)
    }

    /**
     Upload a file.
     
     - parameter reference: (path) Reference (Survey Id) 
     - parameter folderId: (path) Folder Id 
     - parameter fileUpload: (form) The file to upload. 
     - parameter fileNote: (form) Description of file content. (optional)
     - parameter apiResponseQueue: The queue on which api response is dispatched.
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func upload(reference: UUID, folderId: String, fileUpload: URL, fileNote: String? = nil, apiResponseQueue: DispatchQueue = OpenAPIClientAPI.apiResponseQueue, completion: @escaping ((_ data: UploadResponse?,_ error: Error?) -> Void)) {
        uploadWithRequestBuilder(reference: reference, folderId: folderId, fileUpload: fileUpload, fileNote: fileNote).execute(apiResponseQueue) { result -> Void in
            switch result {
            case let .success(response):
                completion(response.body, nil)
            case let .failure(error):
                completion(nil, error)
            }
        }
    }

    /**
     Upload a file.
     - POST /survey/upload/{reference}/{folderId}
     - Uploads a file.
     - parameter reference: (path) Reference (Survey Id) 
     - parameter folderId: (path) Folder Id 
     - parameter fileUpload: (form) The file to upload. 
     - parameter fileNote: (form) Description of file content. (optional)
     - returns: RequestBuilder<UploadResponse> 
     */
    open class func uploadWithRequestBuilder(reference: UUID, folderId: String, fileUpload: URL, fileNote: String? = nil) -> RequestBuilder<UploadResponse> {
        var path = "/survey/upload/{reference}/{folderId}"
        let referencePreEscape = "\(APIHelper.mapValueToPathItem(reference))"
        let referencePostEscape = referencePreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{reference}", with: referencePostEscape, options: .literal, range: nil)
        let folderIdPreEscape = "\(APIHelper.mapValueToPathItem(folderId))"
        let folderIdPostEscape = folderIdPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{folderId}", with: folderIdPostEscape, options: .literal, range: nil)
        let URLString = OpenAPIClientAPI.basePath + path
        let formParams: [String:Any?] = [
            "fileUpload": fileUpload.encodeToJSON(),
            "fileNote": fileNote?.encodeToJSON()
        ]

        let nonNullParameters = APIHelper.rejectNil(formParams)
        let parameters = APIHelper.convertBoolToString(nonNullParameters)
        
        let url = URLComponents(string: URLString)

        let requestBuilder: RequestBuilder<UploadResponse>.Type = OpenAPIClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "POST", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }

}
