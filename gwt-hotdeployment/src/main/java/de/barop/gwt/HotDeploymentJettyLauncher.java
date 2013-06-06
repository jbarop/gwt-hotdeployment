package de.barop.gwt;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.dev.shell.jetty.JettyLauncher;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.util.Scanner;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Extends GWT's original {@link JettyLauncher} and configure it to reload the web application
 * context automatically when classes change.
 *
 * @author Johannes Barop <jb@barop.de>
 */
public class HotDeploymentJettyLauncher extends JettyLauncher {

  private static class ChangeListener implements Scanner.BulkListener {
    private final TreeLogger logger;

    private final JettyServletContainer servletContainer;

    ChangeListener(TreeLogger logger, JettyServletContainer servletContainer) {
      this.logger = logger;
      this.servletContainer = servletContainer;
    }

    @Override
    public void filesChanged(List list) throws Exception {
      logger.log(TreeLogger.Type.TRACE, "filesChanged - " + list);
      servletContainer.refresh();
    }
  }

  private static class NoServerClassFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
      // TODO: filter out client classes?
      // but may be needed for rpc stuff?
      return name.endsWith(".class");
    }
  }

  @Override
  protected JettyServletContainer createServletContainer(TreeLogger logger, File appRootDir, Server server,
                                                         WebAppContext wac, int localPort) {
    JettyServletContainer servletContainer =  super.createServletContainer(logger, appRootDir, server, wac, localPort);

    Scanner scanner = new Scanner();
    scanner.setScanDirs(new ArrayList<File>(Arrays.asList(appRootDir)));
    scanner.setScanInterval(1);
    scanner.setRecursive(true);
    scanner.addListener(new ChangeListener(logger, servletContainer));
    scanner.setReportExistingFilesOnStartup(false);
    scanner.setFilenameFilter(new NoServerClassFilter());
    scanner.start();
    server.getContainer().addBean(scanner);

    return servletContainer;
  }

}
