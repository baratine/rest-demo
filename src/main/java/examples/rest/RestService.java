package examples.rest;

import io.baratine.service.Service;
import io.baratine.web.Get;
import io.baratine.web.Query;
import io.baratine.web.RequestWeb;
import io.baratine.web.Web;
import io.baratine.web.WebServer;

@Service
public class RestService
{
  @Get("/hello")
  public void hello(@Query("name") String name, RequestWeb requestWeb)
  {
    requestWeb.ok("Hello " + name + "!");
  }

  public static void main(String[] args)
  {
    Web.include(RestService.class);

    WebServer server = Web.start();

    //
    RestClient restClient = new RestClient();

    String response = restClient.execute();

    if (!"Hello World!".equals(response))
      throw new AssertionError("unexpected response: " + response);

    server.close();
  }
}
