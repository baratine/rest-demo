package examples.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestClient
{
  public String execute()
  {
    Client client = ClientBuilder.newClient();

    WebTarget target = client.target("http://localhost:8080/hello?name=World");

    Response response = target.request().buildGet().invoke();

    return response.readEntity(String.class);
  }
}
