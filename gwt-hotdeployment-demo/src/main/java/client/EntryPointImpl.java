package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import shared.HelloWorldService;
import shared.HelloWorldServiceAsync;

/**
 * Simple GWT application which shows the result of an RPC call.
 *
 * @author Johannes Barop <jb@barop.de>
 */
public class EntryPointImpl implements EntryPoint {

  private final HelloWorldServiceAsync helloWorldService = GWT.create(HelloWorldService.class);

  @Override
  public void onModuleLoad() {
    final Button button = new Button("Click me!");
    final Label label = new Label();
    RootPanel.get().add(button);
    RootPanel.get().add(label);
    button.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        label.setText("");
        helloWorldService.helloWorld(new AsyncCallback<String>() {
          @Override
          public void onFailure(Throwable caught) {
            Window.alert("Ooops! " + caught);
          }

          @Override
          public void onSuccess(String result) {
            label.setText(result);
          }
        });
      }
    });
  }

}
