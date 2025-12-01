package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.g;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            if (pathDataNodeArr[i2].mType != pathDataNodeArr2[i2].mType || pathDataNodeArr[i2].mParams.length != pathDataNodeArr2[i2].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i2 < 0 || i2 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = i3 - i2;
        int iMin = Math.min(i4, length - i2);
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, i2, fArr2, 0, iMin);
        return fArr2;
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int iNextStart = nextStart(str, i2);
            String strTrim = str.substring(i3, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i3 = iNextStart;
            i2 = iNextStart + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            addNode(arrayList, str.charAt(i3), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException(g.v("Error in parsing ", str), e2);
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            pathDataNodeArr2[i2] = new PathDataNode(pathDataNodeArr[i2]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L36
        L27:
            r10.mEndWithNegOrDot = r7
        L29:
            r2 = 0
            r4 = 1
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.mEndWithNegOrDot = r7
            goto L29
        L33:
            r2 = 0
            goto L36
        L35:
            r2 = 1
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i2 = 1;
            int i3 = 0;
            while (i2 < length) {
                extract(str, i2, extractFloatResult);
                int i4 = extractFloatResult.mEndPosition;
                if (i2 < i4) {
                    fArr[i3] = Float.parseFloat(str.substring(i2, i4));
                    i3++;
                }
                i2 = extractFloatResult.mEndWithNegOrDot ? i4 : i4 + 1;
            }
            return copyOfRange(fArr, 0, i3);
        } catch (NumberFormatException e2) {
            throw new RuntimeException(g.i("error in parsing \"", str, "\""), e2);
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f2, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int nextStart(String str, int i2) {
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                }
                i2++;
            }
            if (cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i2++;
        }
        return i2;
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
            c = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i2 = 0; i2 < pathDataNodeArr2.length; i2++) {
            pathDataNodeArr[i2].mType = pathDataNodeArr2[i2].mType;
            for (int i3 = 0; i3 < pathDataNodeArr2[i2].mParams.length; i3++) {
                pathDataNodeArr[i2].mParams[i3] = pathDataNodeArr2[i2].mParams[i3];
            }
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i2;
            int i3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            Path path2 = path;
            float f15 = fArr[0];
            float f16 = fArr[1];
            float f17 = fArr[2];
            float f18 = fArr[3];
            float f19 = fArr[4];
            float f20 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case R.styleable.AppCompatTheme_windowFixedWidthMajor /* 122 */:
                    path2.close();
                    path2.moveTo(f19, f20);
                    f15 = f19;
                    f17 = f15;
                    f16 = f20;
                    f18 = f16;
                    i2 = 2;
                    break;
            }
            float f21 = f15;
            float f22 = f16;
            float f23 = f19;
            float f24 = f20;
            int i4 = 0;
            char c3 = c;
            while (i4 < fArr2.length) {
                if (c2 == 'A') {
                    i3 = i4;
                    int i5 = i3 + 5;
                    int i6 = i3 + 6;
                    drawArc(path, f21, f22, fArr2[i5], fArr2[i6], fArr2[i3], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                    f17 = fArr2[i5];
                    f21 = f17;
                    f18 = fArr2[i6];
                    f22 = f18;
                } else if (c2 == 'C') {
                    i3 = i4;
                    int i7 = i3 + 2;
                    int i8 = i3 + 3;
                    int i9 = i3 + 4;
                    int i10 = i3 + 5;
                    path2.cubicTo(fArr2[i3], fArr2[i3 + 1], fArr2[i7], fArr2[i8], fArr2[i9], fArr2[i10]);
                    float f25 = fArr2[i9];
                    float f26 = fArr2[i10];
                    float f27 = fArr2[i7];
                    float f28 = fArr2[i8];
                    f21 = f25;
                    f22 = f26;
                    f18 = f28;
                    f17 = f27;
                } else if (c2 != 'H') {
                    if (c2 != 'Q') {
                        if (c2 == 'V') {
                            i3 = i4;
                            path2.lineTo(f21, fArr2[i3]);
                            f4 = fArr2[i3];
                        } else if (c2 != 'a') {
                            if (c2 == 'c') {
                                int i11 = i4 + 2;
                                int i12 = i4 + 3;
                                int i13 = i4 + 4;
                                int i14 = i4 + 5;
                                path2.rCubicTo(fArr2[i4], fArr2[i4 + 1], fArr2[i11], fArr2[i12], fArr2[i13], fArr2[i14]);
                                float f29 = fArr2[i11] + f21;
                                float f30 = fArr2[i12] + f22;
                                f21 += fArr2[i13];
                                f22 += fArr2[i14];
                                f17 = f29;
                                f18 = f30;
                            } else if (c2 != 'h') {
                                if (c2 != 'q') {
                                    if (c2 != 'v') {
                                        if (c2 != 'L') {
                                            if (c2 == 'M') {
                                                f9 = fArr2[i4];
                                                f10 = fArr2[i4 + 1];
                                                if (i4 > 0) {
                                                    path2.lineTo(f9, f10);
                                                } else {
                                                    path2.moveTo(f9, f10);
                                                    f21 = f9;
                                                    f23 = f21;
                                                    f22 = f10;
                                                }
                                            } else if (c2 == 'S') {
                                                if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                                    f21 = (f21 * 2.0f) - f17;
                                                    f22 = (f22 * 2.0f) - f18;
                                                }
                                                float f31 = f21;
                                                float f32 = f22;
                                                int i15 = i4 + 1;
                                                int i16 = i4 + 2;
                                                int i17 = i4 + 3;
                                                path2.cubicTo(f31, f32, fArr2[i4], fArr2[i15], fArr2[i16], fArr2[i17]);
                                                f2 = fArr2[i4];
                                                f3 = fArr2[i15];
                                                f21 = fArr2[i16];
                                                f22 = fArr2[i17];
                                                i3 = i4;
                                            } else if (c2 == 'T') {
                                                if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                                    f21 = (f21 * 2.0f) - f17;
                                                    f22 = (f22 * 2.0f) - f18;
                                                }
                                                int i18 = i4 + 1;
                                                path2.quadTo(f21, f22, fArr2[i4], fArr2[i18]);
                                                float f33 = fArr2[i4];
                                                f4 = fArr2[i18];
                                                f17 = f21;
                                                f18 = f22;
                                                i3 = i4;
                                                f21 = f33;
                                            } else if (c2 == 'l') {
                                                int i19 = i4 + 1;
                                                path2.rLineTo(fArr2[i4], fArr2[i19]);
                                                f21 += fArr2[i4];
                                                f8 = fArr2[i19];
                                            } else if (c2 == 'm') {
                                                float f34 = fArr2[i4];
                                                f21 += f34;
                                                float f35 = fArr2[i4 + 1];
                                                f22 += f35;
                                                if (i4 > 0) {
                                                    path2.rLineTo(f34, f35);
                                                } else {
                                                    path2.rMoveTo(f34, f35);
                                                    f23 = f21;
                                                }
                                            } else if (c2 == 's') {
                                                if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                                    f11 = f22 - f18;
                                                    f12 = f21 - f17;
                                                } else {
                                                    f12 = 0.0f;
                                                    f11 = 0.0f;
                                                }
                                                int i20 = i4 + 1;
                                                int i21 = i4 + 2;
                                                int i22 = i4 + 3;
                                                path2.rCubicTo(f12, f11, fArr2[i4], fArr2[i20], fArr2[i21], fArr2[i22]);
                                                f5 = fArr2[i4] + f21;
                                                f6 = fArr2[i20] + f22;
                                                f21 += fArr2[i21];
                                                f7 = fArr2[i22];
                                            } else if (c2 == 't') {
                                                if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                                    f13 = f21 - f17;
                                                    f14 = f22 - f18;
                                                } else {
                                                    f14 = 0.0f;
                                                    f13 = 0.0f;
                                                }
                                                int i23 = i4 + 1;
                                                path2.rQuadTo(f13, f14, fArr2[i4], fArr2[i23]);
                                                float f36 = f13 + f21;
                                                float f37 = f14 + f22;
                                                f21 += fArr2[i4];
                                                f22 += fArr2[i23];
                                                f18 = f37;
                                                f17 = f36;
                                            }
                                            f24 = f22;
                                        } else {
                                            int i24 = i4 + 1;
                                            path2.lineTo(fArr2[i4], fArr2[i24]);
                                            f9 = fArr2[i4];
                                            f10 = fArr2[i24];
                                        }
                                        f21 = f9;
                                        f22 = f10;
                                    } else {
                                        path2.rLineTo(0.0f, fArr2[i4]);
                                        f8 = fArr2[i4];
                                    }
                                    f22 += f8;
                                } else {
                                    int i25 = i4 + 1;
                                    int i26 = i4 + 2;
                                    int i27 = i4 + 3;
                                    path2.rQuadTo(fArr2[i4], fArr2[i25], fArr2[i26], fArr2[i27]);
                                    f5 = fArr2[i4] + f21;
                                    f6 = fArr2[i25] + f22;
                                    f21 += fArr2[i26];
                                    f7 = fArr2[i27];
                                }
                                f22 += f7;
                                f17 = f5;
                                f18 = f6;
                            } else {
                                path2.rLineTo(fArr2[i4], 0.0f);
                                f21 += fArr2[i4];
                            }
                            i3 = i4;
                        } else {
                            int i28 = i4 + 5;
                            int i29 = i4 + 6;
                            float f38 = f22;
                            i3 = i4;
                            float f39 = f21;
                            drawArc(path, f39, f38, fArr2[i28] + f21, fArr2[i29] + f22, fArr2[i4], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                            f21 = f39 + fArr2[i28];
                            f22 = f38 + fArr2[i29];
                            f17 = f21;
                            f18 = f22;
                        }
                        f22 = f4;
                    } else {
                        i3 = i4;
                        int i30 = i3 + 1;
                        int i31 = i3 + 2;
                        int i32 = i3 + 3;
                        path2.quadTo(fArr2[i3], fArr2[i30], fArr2[i31], fArr2[i32]);
                        f2 = fArr2[i3];
                        f3 = fArr2[i30];
                        f21 = fArr2[i31];
                        f22 = fArr2[i32];
                    }
                    f17 = f2;
                    f18 = f3;
                } else {
                    i3 = i4;
                    path2.lineTo(fArr2[i3], f22);
                    f21 = fArr2[i3];
                }
                i4 = i3 + i2;
                path2 = path;
                c3 = c2;
            }
            fArr[0] = f21;
            fArr[1] = f22;
            fArr[2] = f17;
            fArr[3] = f18;
            fArr[4] = f23;
            fArr[5] = f24;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int iCeil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d7);
            double dSin = Math.sin(d7);
            double dCos2 = Math.cos(d8);
            double dSin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * dCos;
            double d13 = d4 * dSin;
            double d14 = (d12 * dSin2) - (d13 * dCos2);
            double d15 = d11 * dSin;
            double d16 = d4 * dCos;
            double d17 = (dCos2 * d16) + (dSin2 * d15);
            double d18 = d9 / iCeil;
            double d19 = d8;
            double d20 = d17;
            double d21 = d14;
            int i2 = 0;
            double d22 = d5;
            double d23 = d6;
            while (i2 < iCeil) {
                double d24 = d19 + d18;
                double dSin3 = Math.sin(d24);
                double dCos3 = Math.cos(d24);
                double d25 = (((d10 * dCos) * dCos3) + d) - (d13 * dSin3);
                int i3 = i2;
                double d26 = (d16 * dSin3) + (d3 * dSin * dCos3) + d2;
                double d27 = (d12 * dSin3) - (d13 * dCos3);
                double d28 = (dCos3 * d16) + (dSin3 * d15);
                double d29 = d24 - d19;
                double dTan = Math.tan(d29 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d29)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d21 * dSqrt) + d22), (float) ((d20 * dSqrt) + d23), (float) (d25 - (dSqrt * d27)), (float) (d26 - (dSqrt * d28)), (float) d25, (float) d26);
                dSin = dSin;
                d18 = d18;
                d22 = d25;
                d15 = d15;
                dCos = dCos;
                d20 = d28;
                d21 = d27;
                d10 = d3;
                d23 = d26;
                i2 = i3 + 1;
                iCeil = iCeil;
                d19 = d24;
            }
        }

        private static void drawArc(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z2, boolean z3) {
            double d;
            double d2;
            double radians = Math.toRadians(f8);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d3 = f2;
            double d4 = f3;
            double d5 = f6;
            double d6 = ((d4 * dSin) + (d3 * dCos)) / d5;
            double d7 = f7;
            double d8 = ((d4 * dCos) + ((-f2) * dSin)) / d7;
            double d9 = f5;
            double d10 = ((d9 * dSin) + (f4 * dCos)) / d5;
            double d11 = ((d9 * dCos) + ((-f4) * dSin)) / d7;
            double d12 = d6 - d10;
            double d13 = d8 - d11;
            double d14 = (d6 + d10) / 2.0d;
            double d15 = (d8 + d11) / 2.0d;
            double d16 = (d13 * d13) + (d12 * d12);
            if (d16 == 0.0d) {
                return;
            }
            double d17 = (1.0d / d16) - 0.25d;
            if (d17 < 0.0d) {
                float fSqrt = (float) (Math.sqrt(d16) / 1.99999d);
                drawArc(path, f2, f3, f4, f5, f6 * fSqrt, fSqrt * f7, f8, z2, z3);
                return;
            }
            double dSqrt = Math.sqrt(d17);
            double d18 = d12 * dSqrt;
            double d19 = dSqrt * d13;
            if (z2 == z3) {
                d = d14 - d19;
                d2 = d15 + d18;
            } else {
                d = d14 + d19;
                d2 = d15 - d18;
            }
            double dAtan2 = Math.atan2(d8 - d2, d6 - d);
            double dAtan22 = Math.atan2(d11 - d2, d10 - d) - dAtan2;
            if (z3 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d20 = d * d5;
            double d21 = d2 * d7;
            arcToBezier(path, (d20 * dCos) - (d21 * dSin), (d21 * dCos) + (d20 * dSin), d5, d7, d3, d4, radians, dAtan2, dAtan22);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f2) {
            this.mType = pathDataNode.mType;
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i2 >= fArr.length) {
                    return;
                }
                this.mParams[i2] = (pathDataNode2.mParams[i2] * f2) + ((1.0f - f2) * fArr[i2]);
                i2++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f2) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                pathDataNodeArr[i2].interpolatePathDataNode(pathDataNodeArr2[i2], pathDataNodeArr3[i2], f2);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
