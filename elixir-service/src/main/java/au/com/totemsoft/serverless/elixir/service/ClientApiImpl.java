package au.com.totemsoft.serverless.elixir.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            List<ClientResponse> result = new ArrayList<>();
            //
            result.add(new ClientResponse().company("Totem Software P/L"));
            //
            return entity(result, null);
        } catch (Exception e) {
            List<ClientResponse> error = Arrays.asList(
                new ClientResponse()
                    .company(error(e)));
            return entity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
