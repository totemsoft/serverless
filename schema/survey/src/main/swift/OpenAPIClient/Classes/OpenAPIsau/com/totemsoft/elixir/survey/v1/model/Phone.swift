//
// Phone.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation


public struct Phone: Codable { 


    public var type: PhoneType
    public var number: String

    public init(type: PhoneType, number: String) {
        self.type = type
        self.number = number
    }

}
