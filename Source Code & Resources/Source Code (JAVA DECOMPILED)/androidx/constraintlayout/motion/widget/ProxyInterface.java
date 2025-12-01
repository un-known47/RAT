package androidx.constraintlayout.motion.widget;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
interface ProxyInterface {
    int designAccess(int i2, String str, Object obj, float[] fArr, int i3, float[] fArr2, int i4);

    float getKeyFramePosition(Object obj, int i2, float f2, float f3);

    Object getKeyframeAtLocation(Object obj, float f2, float f3);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f2, float f3, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i2, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i2, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i2, int i3, float f2, float f3);

    void setToolPosition(float f2);
}
