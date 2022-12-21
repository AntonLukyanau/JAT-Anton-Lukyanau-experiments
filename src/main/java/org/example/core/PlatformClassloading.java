package org.example.core;


import javax.lang.model.AnnotatedConstruct;
import javax.lang.model.SourceVersion;
import javax.net.ssl.CertPathTrustManagerParameters;
import javax.tools.ForwardingFileObject;
import java.awt.datatransfer.Clipboard;

public class PlatformClassloading {
    public static void main(String[] args) {
        System.out.println(CertPathTrustManagerParameters.class.getClassLoader());
        System.out.println(SourceVersion.class.getClassLoader());
        System.out.println(AnnotatedConstruct.class.getClassLoader());
        System.out.println(ForwardingFileObject.class.getClassLoader());
//        sun.datatransfer.DataFlavorUtil
        System.out.println(Clipboard.class.getClassLoader());

    }
}
