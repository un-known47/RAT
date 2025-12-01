package d0;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g extends a0.b0 {
    public static final e c = new e();

    /* renamed from: a, reason: collision with root package name */
    public final f f396a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f397b;

    public g() {
        ArrayList arrayList = new ArrayList();
        this.f397b = arrayList;
        this.f396a = f.f395a;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (c0.j.f175a >= 9) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        Date dateB;
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        String strV = aVar.V();
        synchronized (this.f397b) {
            try {
                ArrayList arrayList = this.f397b;
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        try {
                            dateB = e0.a.b(strV, new ParsePosition(0));
                            break;
                        } catch (ParseException e2) {
                            StringBuilder sbS = androidx.appcompat.app.g.s("Failed parsing '", strV, "' as Date; at path ");
                            sbS.append(aVar.J(true));
                            throw new a0.p(sbS.toString(), e2);
                        }
                    }
                    Object obj = arrayList.get(i2);
                    i2++;
                    DateFormat dateFormat = (DateFormat) obj;
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strV);
                            break;
                        } catch (ParseException unused) {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } finally {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f396a.getClass();
        return dateB;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.K();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f397b.get(0);
        synchronized (this.f397b) {
            str = dateFormat.format(date);
        }
        bVar.R(str);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f397b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
