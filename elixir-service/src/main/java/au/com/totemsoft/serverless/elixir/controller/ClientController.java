package au.com.totemsoft.serverless.elixir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import au.com.totemsoft.elixir.survey.v1.api.ClientApi;

@RestController("clientController")
public class ClientController implements ClientApi {

    @Autowired @Qualifier("clientApi")
    private ClientApi clientApi;

    @Override
    public ClientApi getDelegate() {
        return this.clientApi;
    }

}
