//
// SurveyResponse.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation


public struct SurveyResponse: Codable { 


    /** Reference (Survey Id) */
    public var reference: UUID
    /** Folder Id */
    public var folderId: String?
    /** Message (could be error) */
    public var message: String?

    public init(reference: UUID, folderId: String?, message: String?) {
        self.reference = reference
        self.folderId = folderId
        self.message = message
    }

}
