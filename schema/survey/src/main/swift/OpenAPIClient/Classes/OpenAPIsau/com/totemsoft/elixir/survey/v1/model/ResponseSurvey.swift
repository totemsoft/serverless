//
// ResponseSurvey.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation


public struct ResponseSurvey: Codable { 


    /** Reference */
    public var reference: String
    /** Survey Id */
    public var surveyId: String

    public init(reference: String, surveyId: String) {
        self.reference = reference
        self.surveyId = surveyId
    }

}
