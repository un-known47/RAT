package okhttp3;

import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionUser;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteDatabase;
import y0.q;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskRunner f951a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f952b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f953e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f954f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f955g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f956h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ RouteDatabase f957i;

    public /* synthetic */ b(TaskRunner taskRunner, int i2, int i3, int i4, int i5, int i6, boolean z2, boolean z3, RouteDatabase routeDatabase) {
        this.f951a = taskRunner;
        this.f952b = i2;
        this.c = i3;
        this.d = i4;
        this.f953e = i5;
        this.f954f = i6;
        this.f955g = z2;
        this.f956h = z3;
        this.f957i = routeDatabase;
    }

    public final ExchangeFinder a(Object obj, Object obj2, Object obj3) {
        return ConnectionPool._init_$lambda$0(this.f951a, this.f952b, this.c, this.d, this.f953e, this.f954f, this.f955g, this.f956h, this.f957i, (RealConnectionPool) obj, (Address) obj2, (ConnectionUser) obj3);
    }
}
