package androidx.constraintlayout.core.motion.utils;

import androidx.appcompat.app.g;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class Utils {
    private static int clamp(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static void log(String str, String str2) {
        System.out.println(str + " : " + str2);
    }

    public static void logStack(String str, int i2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i2, stackTrace.length - 1);
        String strH = " ";
        for (int i3 = 1; i3 <= iMin; i3++) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            String str2 = ".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") " + stackTrace[i3].getMethodName();
            strH = g.h(strH, " ");
            System.out.println(str + strH + str2 + strH);
        }
    }

    public static void loge(String str, String str2) {
        System.err.println(str + " : " + str2);
    }

    public static int rgbaTocColor(float f2, float f3, float f4, float f5) {
        int iClamp = clamp((int) (f2 * 255.0f));
        int iClamp2 = clamp((int) (f3 * 255.0f));
        return (iClamp << 16) | (clamp((int) (f5 * 255.0f)) << 24) | (iClamp2 << 8) | clamp((int) (f4 * 255.0f));
    }

    public static void socketSend(String str) throws IOException {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
        System.out.println(str2 + " " + str);
    }
}
