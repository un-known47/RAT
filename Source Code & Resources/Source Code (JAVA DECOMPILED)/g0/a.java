package g0;

import a0.b0;
import a0.c0;
import a0.m;
import a0.p;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final C0004a f500b = new C0004a();

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f501a;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: g0.a$a, reason: collision with other inner class name */
    public class C0004a implements c0 {
        @Override // a0.c0
        public final b0 a(m mVar, h0.a aVar) {
            if (aVar.f525a == Date.class) {
                return new a(0);
            }
            return null;
        }
    }

    public /* synthetic */ a(int i2) {
        this();
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        Date date;
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        String strV = aVar.V();
        synchronized (this) {
            TimeZone timeZone = this.f501a.getTimeZone();
            try {
                try {
                    date = new Date(this.f501a.parse(strV).getTime());
                } catch (ParseException e2) {
                    throw new p("Failed parsing '" + strV + "' as SQL Date; at path " + aVar.J(true), e2);
                }
            } finally {
                this.f501a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.K();
            return;
        }
        synchronized (this) {
            str = this.f501a.format((java.util.Date) date);
        }
        bVar.R(str);
    }

    private a() {
        this.f501a = new SimpleDateFormat("MMM d, yyyy");
    }
}
