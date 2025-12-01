package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import i.d;
import i.e;
import k.s;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class LifecycleCallback {

    /* renamed from: a, reason: collision with root package name */
    public final Object f225a;

    public LifecycleCallback(e eVar) {
        this.f225a = eVar;
    }

    @Keep
    private static e getChimeraLifecycleFragmentImpl(d dVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [i.e, java.lang.Object] */
    public final Activity a() {
        Activity activityC = this.f225a.c();
        s.b(activityC);
        return activityC;
    }

    public void d() {
    }

    public void f() {
    }

    public void g() {
    }

    public void c(Bundle bundle) {
    }

    public void e(Bundle bundle) {
    }

    public void b(int i2, int i3, Intent intent) {
    }
}
