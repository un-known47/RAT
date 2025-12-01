package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.j;
import m0.k;
import okhttp3.Route;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class RouteDatabase {
    private final Set<Route> _failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        j.e(route, "route");
        this._failedRoutes.remove(route);
    }

    public final synchronized void failed(Route failedRoute) {
        j.e(failedRoute, "failedRoute");
        this._failedRoutes.add(failedRoute);
    }

    public final synchronized Set<Route> getFailedRoutes() {
        return k.x0(this._failedRoutes);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        j.e(route, "route");
        return this._failedRoutes.contains(route);
    }
}
