package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d, float f2) {
        int length = this.mPeriod.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.mPosition[iBinarySearch] = d;
        this.mPeriod[iBinarySearch] = f2;
        this.mNormalized = false;
    }

    public double getDP(double d) {
        if (d <= 0.0d) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch > 0 || iBinarySearch == 0) {
            return 0.0d;
        }
        int i2 = -iBinarySearch;
        int i3 = i2 - 1;
        float[] fArr = this.mPeriod;
        float f2 = fArr[i3];
        int i4 = i2 - 2;
        float f3 = fArr[i4];
        double[] dArr = this.mPosition;
        double d2 = dArr[i3];
        double d3 = dArr[i4];
        double d4 = (f2 - f3) / (d2 - d3);
        return (f3 - (d4 * d3)) + (d * d4);
    }

    public double getP(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch > 0) {
            return 1.0d;
        }
        if (iBinarySearch == 0) {
            return 0.0d;
        }
        int i2 = -iBinarySearch;
        int i3 = i2 - 1;
        float[] fArr = this.mPeriod;
        float f2 = fArr[i3];
        int i4 = i2 - 2;
        float f3 = fArr[i4];
        double[] dArr = this.mPosition;
        double d2 = dArr[i3];
        double d3 = dArr[i4];
        double d4 = (f2 - f3) / (d2 - d3);
        return ((((d * d) - (d3 * d3)) * d4) / 2.0d) + ((d - d3) * (f3 - (d4 * d3))) + this.mArea[i4];
    }

    public double getSlope(double d, double d2, double d3) {
        double d4;
        double dSignum;
        double p2 = getP(d) + d2;
        double dp = getDP(d) + d3;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                d4 = dp * 4.0d;
                dSignum = Math.signum((((p2 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d5 = this.PI2;
                return Math.sin(d5 * p2) * (-d5) * dp;
            case 6:
                return ((((p2 * 4.0d) + 2.0d) % 4.0d) - 2.0d) * dp * 4.0d;
            case 7:
                return this.mCustomCurve.getSlope(p2 % 1.0d, 0);
            default:
                double d6 = this.PI2;
                d4 = dp * d6;
                dSignum = Math.cos(d6 * p2);
                break;
        }
        return dSignum * d4;
    }

    public double getValue(double d, double d2) {
        double dAbs;
        double p2 = getP(d) + d2;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p2 % 1.0d));
            case 2:
                dAbs = Math.abs((((p2 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p2 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((p2 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d2 + p2) * this.PI2);
            case 6:
                double dAbs2 = 1.0d - Math.abs(((p2 * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p2 % 1.0d, 0);
            default:
                return Math.sin(this.PI2 * p2);
        }
        return 1.0d - dAbs;
    }

    public void normalize() {
        double d = 0.0d;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mPeriod.length) {
                break;
            }
            d += r7[i2];
            i2++;
        }
        double d2 = 0.0d;
        int i3 = 1;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i3 >= fArr.length) {
                break;
            }
            int i4 = i3 - 1;
            float f2 = (fArr[i4] + fArr[i3]) / 2.0f;
            double[] dArr = this.mPosition;
            d2 += (dArr[i3] - dArr[i4]) * f2;
            i3++;
        }
        int i5 = 0;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i5 >= fArr2.length) {
                break;
            }
            fArr2[i5] = (float) (fArr2[i5] * (d / d2));
            i5++;
        }
        this.mArea[0] = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i6 >= fArr3.length) {
                this.mNormalized = true;
                return;
            }
            int i7 = i6 - 1;
            float f3 = (fArr3[i7] + fArr3[i6]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d3 = dArr2[i6] - dArr2[i7];
            double[] dArr3 = this.mArea;
            dArr3[i6] = (d3 * f3) + dArr3[i7];
            i6++;
        }
    }

    public void setType(int i2, String str) {
        this.mType = i2;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
