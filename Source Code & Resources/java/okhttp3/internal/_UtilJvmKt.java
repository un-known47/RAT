package okhttp3.internal;

import androidx.core.location.LocationRequestCompat;
import androidx.core.view.inputmethod.a;
import c1.d;
import f1.q;
import g1.c;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;
import m0.i;
import m0.m;
import m0.t;
import o1.l;
import o1.n;
import o1.p0;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Header;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class _UtilJvmKt {
    public static final TimeZone UTC;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        j.b(timeZone);
        UTC = timeZone;
        assertionsEnabled = false;
        String strZ0 = f1.j.z0(OkHttpClient.class.getName(), "okhttp3.");
        if (q.h0(strZ0, "Client", false)) {
            strZ0 = strZ0.substring(0, strZ0.length() - 6);
            j.d(strZ0, "substring(...)");
        }
        okHttpName = strZ0;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        j.e(eventListener, "<this>");
        return new a(7, eventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener asFactory$lambda$9(EventListener eventListener, Call it) {
        j.e(it, "it");
        return eventListener;
    }

    public static final void assertLockNotHeld(Dispatcher dispatcher) {
        j.e(dispatcher, "<this>");
        if (assertionsEnabled && Thread.holdsLock(dispatcher)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
        }
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl other) {
        j.e(httpUrl, "<this>");
        j.e(other, "other");
        return j.a(httpUrl.host(), other.host()) && httpUrl.port() == other.port() && j.a(httpUrl.scheme(), other.scheme());
    }

    public static final int checkDuration(String name, long j, TimeUnit unit) {
        j.e(name, "name");
        j.e(unit, "unit");
        if (j < 0) {
            throw new IllegalStateException(name.concat(" < 0").toString());
        }
        long millis = unit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(name.concat(" too large").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(name.concat(" too small").toString());
    }

    /* renamed from: checkDuration-HG0u8IE, reason: not valid java name */
    public static final int m229checkDurationHG0u8IE(String name, long j) {
        j.e(name, "name");
        int i2 = g1.a.c;
        if (j < 0) {
            throw new IllegalStateException(name.concat(" < 0").toString());
        }
        long jA = ((((int) j) & 1) != 1 || j == g1.a.f508a || j == g1.a.f509b) ? g1.a.a(j, c.c) : j >> 1;
        if (jA > 2147483647L) {
            throw new IllegalArgumentException(name.concat(" too large").toString());
        }
        if (jA != 0 || j <= 0) {
            return (int) jA;
        }
        throw new IllegalArgumentException(name.concat(" too small").toString());
    }

    public static final void closeQuietly(Socket socket) {
        j.e(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!j.a(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean discard(p0 p0Var, int i2, TimeUnit timeUnit) {
        j.e(p0Var, "<this>");
        j.e(timeUnit, "timeUnit");
        try {
            return skipAll(p0Var, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String format(String format, Object... args) {
        j.e(format, "format");
        j.e(args, "args");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        return String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final long headersContentLength(Response response) {
        j.e(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return _UtilCommonKt.toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        j.e(elements, "elements");
        return toImmutableList(elements);
    }

    public static final boolean isHealthy(Socket socket, n source) throws SocketException {
        j.e(socket, "<this>");
        j.e(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !source.q();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final String peerName(Socket socket) {
        j.e(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        j.d(hostName, "getHostName(...)");
        return hostName;
    }

    public static final Charset readBomAsCharset(n nVar, Charset charset) {
        j.e(nVar, "<this>");
        j.e(charset, "default");
        int iC = nVar.c(_UtilCommonKt.getUNICODE_BOMS());
        if (iC == -1) {
            return charset;
        }
        if (iC == 0) {
            return f1.a.f458a;
        }
        if (iC == 1) {
            return f1.a.f459b;
        }
        if (iC == 2) {
            Charset charset2 = f1.a.f458a;
            Charset charset3 = f1.a.f460e;
            if (charset3 != null) {
                return charset3;
            }
            Charset charsetForName = Charset.forName("UTF-32LE");
            j.d(charsetForName, "forName(...)");
            f1.a.f460e = charsetForName;
            return charsetForName;
        }
        if (iC == 3) {
            return f1.a.c;
        }
        if (iC != 4) {
            throw new AssertionError();
        }
        Charset charset4 = f1.a.f458a;
        Charset charset5 = f1.a.f461f;
        if (charset5 != null) {
            return charset5;
        }
        Charset charsetForName2 = Charset.forName("UTF-32BE");
        j.d(charsetForName2, "forName(...)");
        f1.a.f461f = charsetForName2;
        return charsetForName2;
    }

    public static final <T> T readFieldOrNull(Object instance, Class<T> fieldType, String fieldName) {
        T tCast;
        Object fieldOrNull;
        j.e(instance, "instance");
        j.e(fieldType, "fieldType");
        j.e(fieldName, "fieldName");
        Class<?> superclass = instance.getClass();
        while (true) {
            tCast = null;
            if (superclass.equals(Object.class)) {
                if (fieldName.equals("delegate") || (fieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, fieldType, fieldName);
            }
            try {
                Field declaredField = superclass.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(instance);
                if (!fieldType.isInstance(obj)) {
                    break;
                }
                tCast = fieldType.cast(obj);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                j.d(superclass, "getSuperclass(...)");
            }
        }
        return tCast;
    }

    public static final boolean skipAll(p0 p0Var, int i2, TimeUnit timeUnit) {
        j.e(p0Var, "<this>");
        j.e(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = p0Var.timeout().hasDeadline() ? p0Var.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        p0Var.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            l lVar = new l();
            while (p0Var.read(lVar, 8192L) != -1) {
                lVar.a();
            }
            if (jDeadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                p0Var.timeout().clearDeadline();
                return true;
            }
            p0Var.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                p0Var.timeout().clearDeadline();
                return false;
            }
            p0Var.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                p0Var.timeout().clearDeadline();
            } else {
                p0Var.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(final String name, final boolean z2) {
        j.e(name, "name");
        return new ThreadFactory() { // from class: m1.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return _UtilJvmKt.threadFactory$lambda$1(name, z2, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadFactory$lambda$1(String str, boolean z2, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z2);
        return thread;
    }

    public static final void threadName(String name, y0.a block) {
        j.e(name, "name");
        j.e(block, "block");
        Thread threadCurrentThread = Thread.currentThread();
        String name2 = threadCurrentThread.getName();
        threadCurrentThread.setName(name);
        try {
            block.invoke();
        } finally {
            threadCurrentThread.setName(name2);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        j.e(headers, "<this>");
        d dVarV = p.a.V(0, headers.size());
        ArrayList arrayList = new ArrayList(m.k0(dVarV, 10));
        Iterator it = dVarV.iterator();
        while (it.hasNext()) {
            int iNextInt = ((t) it).nextInt();
            arrayList.add(new Header(headers.name(iNextInt), headers.value(iNextInt)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        j.e(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().r(), header.component2().r());
        }
        return builder.build();
    }

    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        j.d(hexString, "toHexString(...)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z2) {
        String strHost;
        j.e(httpUrl, "<this>");
        if (f1.j.r0(httpUrl.host(), ":")) {
            strHost = "[" + httpUrl.host() + ']';
        } else {
            strHost = httpUrl.host();
        }
        if (!z2 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return toHostHeader(httpUrl, z2);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        j.e(list, "<this>");
        if (list.isEmpty()) {
            return m0.q.f867a;
        }
        if (list.size() == 1) {
            List<T> listSingletonList = Collections.singletonList(list.get(0));
            j.d(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        Object[] array = list.toArray();
        j.d(array, "toArray(...)");
        List<T> listUnmodifiableList = Collections.unmodifiableList(i.g0(array));
        j.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final <T> List<T> unmodifiable(List<? extends T> list) {
        j.e(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(list);
        j.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final String toHexString(int i2) {
        String hexString = Integer.toHexString(i2);
        j.d(hexString, "toHexString(...)");
        return hexString;
    }

    public static final <T> Set<T> unmodifiable(Set<? extends T> set) {
        j.e(set, "<this>");
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(set);
        j.d(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public static final <K, V> Map<K, V> unmodifiable(Map<K, ? extends V> map) {
        j.e(map, "<this>");
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        j.d(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    public static final void closeQuietly(ServerSocket serverSocket) throws IOException {
        j.e(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final <T> List<T> toImmutableList(T[] tArr) {
        if (tArr != null && tArr.length != 0) {
            if (tArr.length == 1) {
                List<T> listSingletonList = Collections.singletonList(tArr[0]);
                j.d(listSingletonList, "singletonList(...)");
                return listSingletonList;
            }
            List<T> listUnmodifiableList = Collections.unmodifiableList(i.g0((Object[]) tArr.clone()));
            j.d(listUnmodifiableList, "unmodifiableList(...)");
            return listUnmodifiableList;
        }
        return m0.q.f867a;
    }

    public static final void skipAll(n nVar) {
        j.e(nVar, "<this>");
        while (!nVar.q()) {
            nVar.skip(nVar.b().f919b);
        }
    }
}
