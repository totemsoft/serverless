/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package au.com.totemsoft.elixir.survey.v1.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.totemsoft.elixir.survey.v1.model.ClientResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Validated
@Api(value = "client", description = "the client API")
public interface ClientApi {

    ClientApi getDelegate();

    /**
     * GET /client/find : Receives all clients.
     * Receives all clients for a user.
     *
     * @return An array of Client(s) (status code 200)
     */
    @ApiOperation(value = "Receives all clients.", nickname = "findClients", notes = "Receives all clients for a user.", response = ClientResponse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Client(s)", response = ClientResponse.class, responseContainer = "List") })
    @RequestMapping(value = "/client/find",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<ClientResponse>> findClients() {
        return getDelegate().findClients();
    }


    /**
     * GET /client/find/{userId} : Receives all clients.
     * Receives all clients for a user.
     *
     * @param userId User Id (required)
     * @return An array of Client(s) (status code 200)
     */
    @ApiOperation(value = "Receives all clients.", nickname = "findClientsByUser", notes = "Receives all clients for a user.", response = ClientResponse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of Client(s)", response = ClientResponse.class, responseContainer = "List") })
    @RequestMapping(value = "/client/find/{userId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<ClientResponse>> findClientsByUser(@ApiParam(value = "User Id",required=true) @PathVariable("userId") String userId) {
        return getDelegate().findClientsByUser(userId);
    }

}
