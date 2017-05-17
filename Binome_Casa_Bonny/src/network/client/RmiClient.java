package network.client;

import network.server.RmiInterface;

import java.lang.reflect.Method;
import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Pierre on 17/05/2017.
 */
public class RmiClient {

    public static void main(String[] args){
        /*if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }*/
        try {
            Remote r = Naming.lookup("rmi://"+ InetAddress.getLocalHost().getHostAddress()+"/Miaou");
            if (r instanceof RmiInterface) {
                String s = ((RmiInterface) r).quit();
                System.out.println("reponse :" + s);
                Class cls = ((RmiInterface) r).getClass();
                Method methlist[] = cls.
                        getDeclaredMethods
                                ();
                for (int i = 0; i < methlist.length; i++) {
                    Method m = methlist[i];
                    System.out.println("name = " + m.getName());
                    System.out.println("decl class = " +  m.getDeclaringClass());
                    Class pvec[] = m.getParameterTypes();
                    for (int j = 0; j < pvec.length; j++)
                        System.out.println("param #" + j + " " + pvec[j]);
                    Class evec[] = m.getExceptionTypes();
                    for (int j = 0; j < evec.length; j++)
                        System.out.println("exc #" + j + " " + evec[j]);
                    System.out.println("return type = " +  m.getReturnType());}
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (java.net.UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
