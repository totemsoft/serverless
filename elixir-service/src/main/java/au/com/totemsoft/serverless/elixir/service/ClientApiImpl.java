package au.com.totemsoft.serverless.elixir.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import au.com.totemsoft.elixir.survey.v1.api.ClientApi;
import au.com.totemsoft.elixir.survey.v1.model.ClientResponse;

@Service("clientApi")
public class ClientApiImpl extends AbstractServiceImpl implements ClientApi {

    /** The name of an existing bucket, or access point ARN, where users data stored, eg "_users". */
    @Value("#{environment.AWS_USERS_FOLDER}")
    private String usersFolderId;

    @Override
    public ClientApi getDelegate() {
        return this;
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findClients() {
        try {
            return entity(findClients(null), null, null);
        } catch (Exception e) {
            List<ClientResponse> error = Arrays.asList(
                new ClientResponse()
                    .company(error(e)));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findClientsByUser(String userId) {
        try {
            return entity(findClients(userId), null, null);
        } catch (Exception e) {
            List<ClientResponse> error = Arrays.asList(
                new ClientResponse()
                    .company(error(e)));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    private List<ClientResponse> findClients(String userId) throws IOException {
        // retrieve subject from token
        if (StringUtils.isBlank(userId)) {
            userId = userId();
        }
        //
        ClientResponse[] result = readValue(usersFolderId, userId, ClientResponse[].class);
        //
        return Arrays.asList(result);
    }

}
