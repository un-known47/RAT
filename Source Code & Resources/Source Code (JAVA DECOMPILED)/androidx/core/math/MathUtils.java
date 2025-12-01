package androidx.core.math;

import androidx.core.location.LocationRequestCompat;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i2, int i3) {
        int i4 = i2 + i3;
        if ((i2 >= 0) == (i3 >= 0)) {
            if ((i2 >= 0) != (i4 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i4;
    }

    public static double clamp(double d, double d2, double d3) {
        return d < d2 ? d2 : d > d3 ? d3 : d;
    }

    public static int decrementExact(int i2) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i2) {
        if (i2 != Integer.MAX_VALUE) {
            return i2 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i2, int i3) {
        int i4 = i2 * i3;
        if (i2 == 0 || i3 == 0 || (i4 / i2 == i3 && i4 / i3 == i2)) {
            return i4;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i2) {
        if (i2 != Integer.MIN_VALUE) {
            return -i2;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i2, int i3) {
        int i4 = i2 - i3;
        if ((i2 < 0) != (i3 < 0)) {
            if ((i2 < 0) != (i4 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i4;
    }

    public static int toIntExact(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j;
    }

    public static long addExact(long j, long j2) {
        long j3 = j + j2;
        if ((j >= 0) == (j2 >= 0)) {
            if ((j >= 0) != (j3 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j3;
    }

    public static float clamp(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static long decrementExact(long j) {
        if (j != Long.MIN_VALUE) {
            return j - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j) {
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            return j + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j, long j2) {
        long j3 = j - j2;
        if ((j < 0) != (j2 < 0)) {
            if ((j < 0) != (j3 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j3;
    }

    public static int clamp(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static long multiplyExact(long j, long j2) {
        long j3 = j * j2;
        if (j == 0 || j2 == 0 || (j3 / j == j2 && j3 / j2 == j)) {
            return j3;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }
}
