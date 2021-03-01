//
// ClientResponse.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

/** Client details */
public struct ClientResponse: Codable { 


    /** Client&#39;s company name (has to be unique) */
    public var company: String
    /** Client&#39;s trading name */
    public var tradingName: String?
    /** Client&#39;s firstname */
    public var firstName: String
    /** Client&#39;s surname */
    public var lastName: String
    /** Client&#39;s email */
    public var email: String
    /** Client&#39;s position */
    public var position: String?
    /** Client&#39;s phones */
    public var phones: [Phone]?
    /** Client&#39;s addresses */
    public var addresses: [Address]?
    /** Client&#39;s locations */
    public var locations: [Location]?

    public init(company: String, tradingName: String?, firstName: String, lastName: String, email: String, position: String?, phones: [Phone]?, addresses: [Address]?, locations: [Location]?) {
        self.company = company
        self.tradingName = tradingName
        self.firstName = firstName
        self.lastName = lastName
        self.email = email
        self.position = position
        self.phones = phones
        self.addresses = addresses
        self.locations = locations
    }

}