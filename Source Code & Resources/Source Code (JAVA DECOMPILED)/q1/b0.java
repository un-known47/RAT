package q1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b0 implements d {

    /* renamed from: a, reason: collision with root package name */
    public final r0 f1058a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1059b;
    public final Object[] c;
    public final Call.Factory d;

    /* renamed from: e, reason: collision with root package name */
    public final m f1060e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f1061f;

    /* renamed from: g, reason: collision with root package name */
    public Call f1062g;

    /* renamed from: h, reason: collision with root package name */
    public Throwable f1063h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1064i;

    public b0(r0 r0Var, Object obj, Object[] objArr, Call.Factory factory, m mVar) {
        this.f1058a = r0Var;
        this.f1059b = obj;
        this.c = objArr;
        this.d = factory;
        this.f1060e = mVar;
    }

    @Override // q1.d
    public final void D(g gVar) {
        Call call;
        Throwable th;
        synchronized (this) {
            try {
                if (this.f1064i) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f1064i = true;
                call = this.f1062g;
                th = this.f1063h;
                if (call == null && th == null) {
                    try {
                        Call callA = a();
                        this.f1062g = callA;
                        call = callA;
                    } catch (Throwable th2) {
                        th = th2;
                        b1.r(th);
                        this.f1063h = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            gVar.e(this, th);
            return;
        }
        if (this.f1061f) {
            call.cancel();
        }
        call.enqueue(new h.c(8, this, gVar));
    }

    public final Call a() {
        HttpUrl httpUrlResolve;
        r0 r0Var = this.f1058a;
        b1[] b1VarArr = r0Var.j;
        Object[] objArr = this.c;
        int length = objArr.length;
        if (length != b1VarArr.length) {
            StringBuilder sbQ = androidx.appcompat.app.g.q("Argument count (", length, ") doesn't match expected count (");
            sbQ.append(b1VarArr.length);
            sbQ.append(")");
            throw new IllegalArgumentException(sbQ.toString());
        }
        p0 p0Var = new p0(r0Var.c, r0Var.f1133b, r0Var.d, r0Var.f1134e, r0Var.f1135f, r0Var.f1136g, r0Var.f1137h, r0Var.f1138i);
        if (r0Var.f1139k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(objArr[i2]);
            b1VarArr[i2].a(p0Var, objArr[i2]);
        }
        HttpUrl.Builder builder = p0Var.d;
        if (builder != null) {
            httpUrlResolve = builder.build();
        } else {
            String str = p0Var.c;
            HttpUrl httpUrl = p0Var.f1104b;
            httpUrlResolve = httpUrl.resolve(str);
            if (httpUrlResolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + httpUrl + ", Relative: " + p0Var.c);
            }
        }
        RequestBody o0Var = p0Var.f1110k;
        if (o0Var == null) {
            FormBody.Builder builder2 = p0Var.j;
            if (builder2 != null) {
                o0Var = builder2.build();
            } else {
                MultipartBody.Builder builder3 = p0Var.f1109i;
                if (builder3 != null) {
                    o0Var = builder3.build();
                } else if (p0Var.f1108h) {
                    o0Var = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = p0Var.f1107g;
        Headers.Builder builder4 = p0Var.f1106f;
        if (mediaType != null) {
            if (o0Var != null) {
                o0Var = new o0(o0Var, mediaType);
            } else {
                builder4.add("Content-Type", mediaType.toString());
            }
        }
        Call callNewCall = this.d.newCall(p0Var.f1105e.url(httpUrlResolve).headers(builder4.build()).method(p0Var.f1103a, o0Var).tag((Class<? super Class>) u.class, (Class) new u(this.f1059b, r0Var.f1132a, arrayList)).build());
        if (callNewCall != null) {
            return callNewCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    public final Call b() throws IOException {
        Call call = this.f1062g;
        if (call != null) {
            return call;
        }
        Throwable th = this.f1063h;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            Call callA = a();
            this.f1062g = callA;
            return callA;
        } catch (IOException | Error | RuntimeException e2) {
            b1.r(e2);
            this.f1063h = e2;
            throw e2;
        }
    }

    public final s0 c(Response response) throws IOException {
        ResponseBody responseBodyBody = response.body();
        Response responseBuild = response.newBuilder().body(new a0(responseBodyBody.contentType(), responseBodyBody.contentLength())).build();
        int iCode = responseBuild.code();
        if (iCode < 200 || iCode >= 300) {
            try {
                o1.l lVar = new o1.l();
                responseBodyBody.source().i(lVar);
                Objects.requireNonNull(ResponseBody.create(responseBodyBody.contentType(), responseBodyBody.contentLength(), lVar), "body == null");
                if (responseBuild.isSuccessful()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                return new s0(responseBuild, null);
            } finally {
                responseBodyBody.close();
            }
        }
        if (iCode == 204 || iCode == 205) {
            responseBodyBody.close();
            if (responseBuild.isSuccessful()) {
                return new s0(responseBuild, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        z zVar = new z(responseBodyBody);
        try {
            Object objA = this.f1060e.a(zVar);
            if (responseBuild.isSuccessful()) {
                return new s0(responseBuild, objA);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        } catch (RuntimeException e2) {
            IOException iOException = zVar.c;
            if (iOException == null) {
                throw e2;
            }
            throw iOException;
        }
    }

    @Override // q1.d
    public final void cancel() {
        Call call;
        this.f1061f = true;
        synchronized (this) {
            call = this.f1062g;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public final Object clone() {
        return new b0(this.f1058a, this.f1059b, this.c, this.d, this.f1060e);
    }

    @Override // q1.d
    public final s0 execute() {
        Call callB;
        synchronized (this) {
            if (this.f1064i) {
                throw new IllegalStateException("Already executed.");
            }
            this.f1064i = true;
            callB = b();
        }
        if (this.f1061f) {
            callB.cancel();
        }
        return c(callB.execute());
    }

    @Override // q1.d
    public final boolean isCanceled() {
        boolean z2 = true;
        if (this.f1061f) {
            return true;
        }
        synchronized (this) {
            try {
                Call call = this.f1062g;
                if (call == null || !call.isCanceled()) {
                    z2 = false;
                }
            } finally {
            }
        }
        return z2;
    }

    @Override // q1.d
    public final synchronized Request request() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create request.", e2);
        }
        return b().request();
    }

    @Override // q1.d
    public final d clone() {
        return new b0(this.f1058a, this.f1059b, this.c, this.d, this.f1060e);
    }
}
