package p1;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j extends o1.g {

    /* renamed from: a, reason: collision with root package name */
    public final Socket f1017a;

    public j(Socket socket) {
        kotlin.jvm.internal.j.e(socket, "socket");
        this.f1017a = socket;
    }

    @Override // o1.g
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // o1.g
    public final void timedOut() throws IOException {
        Socket socket = this.f1017a;
        try {
            socket.close();
        } catch (AssertionError e2) {
            if (!n.a(e2)) {
                throw e2;
            }
            n.f1041a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        } catch (Exception e3) {
            n.f1041a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e3);
        }
    }
}
