package a0;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class t extends o {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f19a;

    public t(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f19a = bool;
    }

    public static boolean d(t tVar) {
        Serializable serializable = tVar.f19a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final BigInteger a() {
        Serializable serializable = this.f19a;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (d(this)) {
            return BigInteger.valueOf(b().longValue());
        }
        String strC = c();
        c0.i.c(strC);
        return new BigInteger(strC);
    }

    public final Number b() {
        Serializable serializable = this.f19a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new c0.k((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final String c() {
        Serializable serializable = this.f19a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return b().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        Serializable serializable = tVar.f19a;
        Serializable serializable2 = this.f19a;
        if (serializable2 == null) {
            return serializable == null;
        }
        if (d(this) && d(tVar)) {
            return ((serializable2 instanceof BigInteger) || (serializable instanceof BigInteger)) ? a().equals(tVar.a()) : b().longValue() == tVar.b().longValue();
        }
        if (!(serializable2 instanceof Number) || !(serializable instanceof Number)) {
            return serializable2.equals(serializable);
        }
        if ((serializable2 instanceof BigDecimal) && (serializable instanceof BigDecimal)) {
            return (serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : c0.i.i(c())).compareTo(serializable instanceof BigDecimal ? (BigDecimal) serializable : c0.i.i(tVar.c())) == 0;
        }
        double dDoubleValue = serializable2 instanceof Number ? b().doubleValue() : Double.parseDouble(c());
        double dDoubleValue2 = serializable instanceof Number ? tVar.b().doubleValue() : Double.parseDouble(tVar.c());
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f19a;
        if (serializable == null) {
            return 31;
        }
        if (d(this)) {
            jDoubleToLongBits = b().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(b().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public t(Number number) {
        Objects.requireNonNull(number);
        this.f19a = number;
    }

    public t(String str) {
        Objects.requireNonNull(str);
        this.f19a = str;
    }
}
