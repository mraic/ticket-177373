package com.citi.test.examples;
public class MemoryStreamProvider implements java.io.Closeable {

    // List of InputStream objects created during document rendering
    public java.util.List<java.io.InputStream> lStream = new java.util.ArrayList<>();

    @Override
    public void close() throws java.io.IOException {
        for (java.io.InputStream stream : lStream) {
            stream.close();
        }
    }
}