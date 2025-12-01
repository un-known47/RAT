package androidx.emoji2.text.flatbuffer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
interface ReadBuf {
    byte[] data();

    byte get(int i2);

    boolean getBoolean(int i2);

    double getDouble(int i2);

    float getFloat(int i2);

    int getInt(int i2);

    long getLong(int i2);

    short getShort(int i2);

    String getString(int i2, int i3);

    int limit();
}
