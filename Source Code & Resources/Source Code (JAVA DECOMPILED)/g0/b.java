package g0;

import a0.b0;
import a0.c0;
import a0.m;
import a0.p;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f502b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f503a;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public class a implements c0 {
        @Override // a0.c0
        public final b0 a(m mVar, h0.a aVar) {
            if (aVar.f525a == Time.class) {
                return new b(0);
            }
            return null;
        }
    }

    public /* synthetic */ b(int i2) {
        this();
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        Time time;
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        String strV = aVar.V();
        synchronized (this) {
            TimeZone timeZone = this.f503a.getTimeZone();
            try {
                try {
                    time = new Time(this.f503a.parse(strV).getTime());
                } catch (ParseException e2) {
                    throw new p("Failed parsing '" + strV + "' as SQL Time; at path " + aVar.J(true), e2);
                }
            } finally {
                this.f503a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            bVar.K();
            return;
        }
        synchronized (this) {
            str = this.f503a.format((Date) time);
        }
        bVar.R(str);
    }

    private b() {
        this.f503a = new SimpleDateFormat("hh:mm:ss a");
    }
}
