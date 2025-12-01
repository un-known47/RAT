package okhttp3;

import kotlin.jvm.internal.j;
import o1.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i2, String reason) {
        j.e(webSocket, "webSocket");
        j.e(reason, "reason");
    }

    public void onClosing(WebSocket webSocket, int i2, String reason) {
        j.e(webSocket, "webSocket");
        j.e(reason, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable t2, Response response) {
        j.e(webSocket, "webSocket");
        j.e(t2, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        j.e(webSocket, "webSocket");
        j.e(text, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        j.e(webSocket, "webSocket");
        j.e(response, "response");
    }

    public void onMessage(WebSocket webSocket, o bytes) {
        j.e(webSocket, "webSocket");
        j.e(bytes, "bytes");
    }
}
