package au.com.totemsoft.ping;

import org.apache.http.HttpStatus;

public interface PcvConstants {

    Integer BUSINESS_ERROR = HttpStatus.SC_INTERNAL_SERVER_ERROR;

    String FORM_TEMPLATE_NAME = "HTML Form Template Name";
    String FORM_TEMPLATE_NAME_DESC = "HTML template (in <pf_home>/server/default/conf/template) to render for form submission.";

    String SVC_URL = "Service URL";
    String SVC_URL_DESC = "Fully qualified url of the service";

    String CLIENT_CERT = "Client certificate";
    String CLIENT_CERT_DESC = "This certificate will be rendered by the client to the web services";

    String ACCESS_TOKEN_MANAGER = "Access Token Manager";
    String ACCESS_TOKEN_MANAGER_DESC = "Access Token Manager";

    String SCOPE = "Scope";
    String SCOPE_DESC = "Scopes";

    String LDAP_DATA_STORE = "LDAP Data Store";
    String LDAP_DATA_STORE_DESC = "Select the LDAP data store";

    String CLIENT_ID_ATTRIBUTE = "clientId";
    String USERNAME_ATTRIBUTE = "username";

}
