package com.mycompany.mavenproject1;

public class HttpParseException extends Exception {

    public HttpParseException(String string) {
        super(string);
        System.err.println("Exception:" + string);
    }

}
