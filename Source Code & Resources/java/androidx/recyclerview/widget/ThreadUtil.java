package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
interface ThreadUtil<T> {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public interface BackgroundCallback<T> {
        void loadTile(int i2, int i3);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i2);

        void updateRange(int i2, int i3, int i4, int i5, int i6);
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public interface MainThreadCallback<T> {
        void addTile(int i2, TileList.Tile<T> tile);

        void removeTile(int i2, int i3);

        void updateItemCount(int i2, int i3);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
