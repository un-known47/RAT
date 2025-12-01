package com.google.android.material.datepicker;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class f {
    public static /* bridge */ /* synthetic */ Class e() {
        return CompletableFuture.class;
    }

    public static /* bridge */ /* synthetic */ ExtendedSSLSession i(SSLSession sSLSession) {
        return (ExtendedSSLSession) sSLSession;
    }

    public static /* bridge */ /* synthetic */ SNIHostName j(Object obj) {
        return (SNIHostName) obj;
    }

    public static /* bridge */ /* synthetic */ SNIServerName k(Object obj) {
        return (SNIServerName) obj;
    }

    public static /* bridge */ /* synthetic */ boolean t(Object obj) {
        return obj instanceof SNIHostName;
    }

    public static /* bridge */ /* synthetic */ boolean v(SSLSession sSLSession) {
        return sSLSession instanceof ExtendedSSLSession;
    }

    public static /* bridge */ /* synthetic */ Class w() {
        return Optional.class;
    }
}
