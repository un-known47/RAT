package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Route;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class ConnectionListener {
    public static final Companion Companion = new Companion(null);
    private static final ConnectionListener NONE = new ConnectionListener() { // from class: okhttp3.internal.connection.ConnectionListener$Companion$NONE$1
    };

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ConnectionListener getNONE() {
            return ConnectionListener.NONE;
        }

        private Companion() {
        }
    }

    public void connectEnd(Connection connection, Route route, Call call) {
        j.e(connection, "connection");
        j.e(route, "route");
        j.e(call, "call");
    }

    public void connectFailed(Route route, Call call, IOException failure) {
        j.e(route, "route");
        j.e(call, "call");
        j.e(failure, "failure");
    }

    public void connectStart(Route route, Call call) {
        j.e(route, "route");
        j.e(call, "call");
    }

    public void connectionAcquired(Connection connection, Call call) {
        j.e(connection, "connection");
        j.e(call, "call");
    }

    public void connectionClosed(Connection connection) {
        j.e(connection, "connection");
    }

    public void connectionReleased(Connection connection, Call call) {
        j.e(connection, "connection");
        j.e(call, "call");
    }

    public void noNewExchanges(Connection connection) {
        j.e(connection, "connection");
    }
}
