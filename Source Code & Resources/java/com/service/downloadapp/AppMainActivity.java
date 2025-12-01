package com.service.downloadapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.protect.download.R;
import g.g;
import h.c;
import i.i;
import i.m;
import k.s;
import p.a;
import v.e;
import y.d;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class AppMainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public SwitchMaterial f362a;

    /* renamed from: b, reason: collision with root package name */
    public SwitchMaterial f363b;
    public SwitchMaterial c;

    public static void h(SwitchCompat switchCompat, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 24) {
            switchCompat.setText(Html.fromHtml("<font color=\"#212121\"><big>" + str + "</big></font><br/><font color=\"#757575\">" + str2 + "</font>", 0));
        } else {
            switchCompat.setText(Html.fromHtml("<font color=\"#212121\"><big>" + str + "</big></font><br/><font color=\"#757575\">" + str2 + "</font>"));
        }
        switchCompat.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) throws Resources.NotFoundException {
        AppMainActivity appMainActivity;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 10) {
            appMainActivity = this;
            if (i2 != 20) {
                return;
            }
        } else {
            c cVar = v.c.f1190a;
            g gVar = new g(3);
            Looper mainLooper = getMainLooper();
            s.c(mainLooper, "Looper must not be null.");
            appMainActivity = this;
            e eVar = new e(appMainActivity, this, cVar, null, new h.e(gVar, mainLooper));
            i iVar = new i();
            iVar.f610b = true;
            iVar.c = 4201;
            iVar.d = new g(eVar);
            y.g gVarB = eVar.b(0, iVar.a());
            j0.c cVar2 = new j0.c(this, 1);
            gVarB.getClass();
            gVarB.f1218b.a(new y.e(d.f1212a, cVar2));
            synchronized (gVarB.f1217a) {
                try {
                    if (gVarB.c) {
                        gVarB.f1218b.b(gVarB);
                    }
                } finally {
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (getPackageManager().canRequestPackageInstalls()) {
                appMainActivity.f363b.setChecked(true);
            } else {
                appMainActivity.f363b.setChecked(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws PackageManager.NameNotFoundException {
        if (view.getId() == R.id.button_download) {
            if (Build.VERSION.SDK_INT >= 26 && !this.f363b.isChecked()) {
                a.c(this, getString(R.string.settings_unknow_sources_info_error));
                return;
            }
            if (!this.c.isChecked()) {
                a.c(this, getString(R.string.settings_uninstall_old_version));
                return;
            }
            Intent intent = new Intent(this, (Class<?>) DownloadAPPActivity.class);
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_logo_app);
        findViewById(R.id.button_download).setOnClickListener(this);
        this.f362a = (SwitchMaterial) findViewById(R.id.switchSettingPP);
        this.f363b = (SwitchMaterial) findViewById(R.id.switchSettingUnknownSources);
        this.c = (SwitchMaterial) findViewById(R.id.switchSettingUninstallOldVersion);
        c cVar = v.c.f1190a;
        g gVar = new g(3);
        Looper mainLooper = getMainLooper();
        s.c(mainLooper, "Looper must not be null.");
        e eVar = new e(this, this, cVar, null, new h.e(gVar, mainLooper));
        i iVar = new i();
        iVar.f610b = true;
        iVar.c = 4201;
        iVar.d = new g(eVar);
        y.g gVarB = eVar.b(0, iVar.a());
        j0.c cVar2 = new j0.c(this, 0);
        gVarB.getClass();
        gVarB.f1218b.a(new y.e(d.f1212a, cVar2));
        synchronized (gVarB.f1217a) {
            try {
                if (gVarB.c) {
                    gVarB.f1218b.b(gVarB);
                }
            } finally {
            }
        }
        if (a.h(this) != null) {
            h(this.c, getString(R.string.settings_old_version_title), getString(R.string.settings_old_version_info));
            this.c.setOnCheckedChangeListener(new j0.a(1, this));
            this.c.setVisibility(0);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            h(this.f363b, getString(R.string.settings_unknow_sources_title), getString(R.string.settings_unknow_sources_info));
            this.f363b.setOnCheckedChangeListener(new j0.a(0, this));
            this.f363b.setVisibility(0);
            if (getPackageManager().canRequestPackageInstalls()) {
                this.f363b.setChecked(true);
            }
        }
        new Thread(new m(3, this)).start();
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_uninstall) {
            return false;
        }
        a.U(this, getPackageName());
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPostResume() throws Resources.NotFoundException {
        super.onPostResume();
        this.c.setChecked(a.h(this) == null);
    }
}
