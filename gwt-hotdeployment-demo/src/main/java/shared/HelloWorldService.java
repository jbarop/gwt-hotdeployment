package shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Simple {@link RemoteService} for a "Hello World" like RPC servlet.
 *
 * @author Johannes Barop <jb@barop.de>
 */
@RemoteServiceRelativePath("helloWorld")
public interface HelloWorldService extends RemoteService {

	String helloWorld();

}
