
package hangman.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "GameManagerService", targetNamespace = "http://server.hangman.wi.msarelo.pl.com/", wsdlLocation = "http://localhost:8080/hangman?wsdl")
public class GameManagerService
    extends Service
{

    private final static URL GAMEMANAGERSERVICE_WSDL_LOCATION;
    private final static WebServiceException GAMEMANAGERSERVICE_EXCEPTION;
    private final static QName GAMEMANAGERSERVICE_QNAME = new QName("http://server.hangman.wi.msarelo.pl.com/", "GameManagerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/hangman?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GAMEMANAGERSERVICE_WSDL_LOCATION = url;
        GAMEMANAGERSERVICE_EXCEPTION = e;
    }

    public GameManagerService() {
        super(__getWsdlLocation(), GAMEMANAGERSERVICE_QNAME);
    }

    public GameManagerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), GAMEMANAGERSERVICE_QNAME, features);
    }

    public GameManagerService(URL wsdlLocation) {
        super(wsdlLocation, GAMEMANAGERSERVICE_QNAME);
    }

    public GameManagerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GAMEMANAGERSERVICE_QNAME, features);
    }

    public GameManagerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GameManagerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GameManager
     */
    @WebEndpoint(name = "GameManagerPort")
    public GameManager getGameManagerPort() {
        return super.getPort(new QName("http://server.hangman.wi.msarelo.pl.com/", "GameManagerPort"), GameManager.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GameManager
     */
    @WebEndpoint(name = "GameManagerPort")
    public GameManager getGameManagerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.hangman.wi.msarelo.pl.com/", "GameManagerPort"), GameManager.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GAMEMANAGERSERVICE_EXCEPTION!= null) {
            throw GAMEMANAGERSERVICE_EXCEPTION;
        }
        return GAMEMANAGERSERVICE_WSDL_LOCATION;
    }

}
