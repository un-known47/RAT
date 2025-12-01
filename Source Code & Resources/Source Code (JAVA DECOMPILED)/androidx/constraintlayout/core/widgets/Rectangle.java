package androidx.constraintlayout.core.widgets;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f50x;

    /* renamed from: y, reason: collision with root package name */
    public int f51y;

    public boolean contains(int i2, int i3) {
        int i4;
        int i5 = this.f50x;
        return i2 >= i5 && i2 < i5 + this.width && i3 >= (i4 = this.f51y) && i3 < i4 + this.height;
    }

    public int getCenterX() {
        return (this.f50x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f51y + this.height) / 2;
    }

    public void grow(int i2, int i3) {
        this.f50x -= i2;
        this.f51y -= i3;
        this.width = (i2 * 2) + this.width;
        this.height = (i3 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i2;
        int i3;
        int i4 = this.f50x;
        int i5 = rectangle.f50x;
        return i4 >= i5 && i4 < i5 + rectangle.width && (i2 = this.f51y) >= (i3 = rectangle.f51y) && i2 < i3 + rectangle.height;
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        this.f50x = i2;
        this.f51y = i3;
        this.width = i4;
        this.height = i5;
    }
}
