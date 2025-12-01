package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.p;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RequiresApi(30)
/* loaded from: classes.dex */
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    @Nullable
    public static ResourcesLoader create(@NonNull Context context, @NonNull Map<Integer, Integer> map) throws Throwable {
        FileDescriptor fileDescriptorMemfd_create;
        try {
            byte[] bArrCreate = ColorResourcesTableCreator.create(context, map);
            int length = bArrCreate.length;
            if (bArrCreate.length != 0) {
                try {
                    fileDescriptorMemfd_create = Os.memfd_create("temp.arsc", 0);
                    if (fileDescriptorMemfd_create != null) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptorMemfd_create);
                            try {
                                fileOutputStream.write(bArrCreate);
                                ParcelFileDescriptor parcelFileDescriptorDup = ParcelFileDescriptor.dup(fileDescriptorMemfd_create);
                                try {
                                    p.j();
                                    ResourcesLoader resourcesLoaderA = p.a();
                                    resourcesLoaderA.addProvider(ResourcesProvider.loadFromTable(parcelFileDescriptorDup, null));
                                    if (parcelFileDescriptorDup != null) {
                                        parcelFileDescriptorDup.close();
                                    }
                                    fileOutputStream.close();
                                    Os.close(fileDescriptorMemfd_create);
                                    return resourcesLoaderA;
                                } finally {
                                }
                            } finally {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileDescriptorMemfd_create != null) {
                                Os.close(fileDescriptorMemfd_create);
                            }
                            throw th;
                        }
                    }
                    if (fileDescriptorMemfd_create != null) {
                        Os.close(fileDescriptorMemfd_create);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileDescriptorMemfd_create = null;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
