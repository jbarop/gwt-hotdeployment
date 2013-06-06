package server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import shared.HelloWorldService;

/**
 * Simple implementation of an "Hello World" servlet.
 *
 * Try changing the message while running the development mode.
 * If your IDE does not auto compile your changes don't forget to hit "compile"!
 *
 * @author Johannes Barop <jb@barop.de>
 */
public class HelloWorldServiceImpl extends RemoteServiceServlet implements HelloWorldService {

  @Override
  public String helloWorld() {
    return "Hello World!";
  }

}
