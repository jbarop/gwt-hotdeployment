package shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Corresponding GWT client interface for {@link HelloWorldService}.
 *
 * @author Johannes Barop <jb@barop.de>
 */
public interface HelloWorldServiceAsync {

  void helloWorld(AsyncCallback<String> callback);

}
