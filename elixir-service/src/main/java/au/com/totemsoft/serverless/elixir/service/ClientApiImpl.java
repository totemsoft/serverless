package au.com.totemsoft.serverless.elixir.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import au.com.totemsoft.elixir.survey.v1.api.ClientApi;
import au.com.totemsoft.elixir.survey.v1.model.ClientResponse;

@Service("clientApi")
public class ClientApiImpl extends AbstractServiceImpl implements ClientApi {

    @Override
    public ClientApi getDelegate() {
        return this;
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findClients() {
        try {
            return entity(findClients(null), null);
        } catch (Exception e) {
            List<ClientResponse> error = Arrays.asList(
                new ClientResponse()
                    .company(error(e)));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findClientsByUser(String userId) {
        try {
            return entity(findClients(userId), null);
        } catch (Exception e) {
            List<ClientResponse> error = Arrays.asList(
                new ClientResponse()
                    .company(error(e)));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private List<ClientResponse> findClients(String userId) {
        // validation
        if (StringUtils.isBlank(userId)) {
            userId = sub();
        }
        //
        List<ClientResponse> result = new ArrayList<>();
        //
        result.add(new ClientResponse()
            .company("Totem Software P/L :: " + userId)
            .firstName("Valeri")
            .lastName("Shibaev")
        );
        //
        return result;
    }

}
