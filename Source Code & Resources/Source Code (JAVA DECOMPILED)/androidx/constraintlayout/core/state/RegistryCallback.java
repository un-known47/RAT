package androidx.constraintlayout.core.state;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i2, int i3);

    void onNewMotionScene(String str);

    void onProgress(float f2);

    void setDrawDebug(int i2);

    void setLayoutInformationMode(int i2);
}
