package com.mycompany.mavenproject1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

public class MyHttpResponder {

    private static final String STARTLINE = "HTTP/1.1 200 OK\n";
    private static final String TYPEHEADER = "content-type: text/plain; charset=us-ascii\n";
    private static final String BADREQUEST = "HTTP/1.1 400 Bad Request: ";
    private static final String SERVER = "Server: The Server\n";
    private static final String AUTH = "WWW-Authenticate: Basic realm='my_realm:'\n";
    private static final String NOTAUTH = "HTTP/1.1 401 Not Authorized\n";

    public static void respond(MyHttpRequest req, DataOutputStream dos) throws IOException {
        if (req.getHeader("Authorization")!= null){
            dos.writeBytes(STARTLINE);
            dos.writeBytes(TYPEHEADER);
            dos.writeBytes(SERVER);
            
            dos.writeBytes("\n");
    //        dos.writeBytes(new Date().toString() + "\n");
            dos.writeBytes("Hello " + req.getHeader("User-Agent"));
        } else {
            dos.writeBytes(NOTAUTH);
            dos.writeBytes(AUTH);
        }
        dos.close();
    }

    public static void reportError(String message, DataOutputStream dos) throws IOException {
        dos.writeBytes(BADREQUEST + message);
        dos.writeBytes("\n\n");
        dos.close();

    }
}
