package com.service.downloadapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.protect.download.R;
import i.n;
import i.o;
import j0.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;
import p.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class DownloadAPPActivity extends AppCompatActivity {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f364f = 0;

    /* renamed from: a, reason: collision with root package name */
    public ProgressDialog f365a;

    /* renamed from: b, reason: collision with root package name */
    public MaterialTextView f366b;
    public final o c = new o(1, this);
    public MaterialButton d;

    /* renamed from: e, reason: collision with root package name */
    public MaterialButton f367e;

    public static boolean h(DownloadAPPActivity downloadAPPActivity, ResponseBody responseBody) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(downloadAPPActivity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "app.apk");
            InputStream inputStream = null;
            try {
                byte[] bArr = new byte[4096];
                responseBody.contentLength();
                InputStream inputStreamByteStream = responseBody.byteStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int i2 = inputStreamByteStream.read(bArr);
                            if (i2 == -1) {
                                fileOutputStream.flush();
                                inputStreamByteStream.close();
                                fileOutputStream.close();
                                return true;
                            }
                            fileOutputStream.write(bArr, 0, i2);
                        } catch (IOException unused) {
                            inputStream = inputStreamByteStream;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStreamByteStream;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    }
                } catch (IOException unused2) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (IOException unused3) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException unused4) {
        }
    }

    public static void i(Context context, String str) {
        File file = new File(str);
        int i2 = Build.VERSION.SDK_INT;
        Uri uriForFile = i2 >= 24 ? FileProvider.getUriForFile(context, "com.protect.download.provider", file) : Uri.fromFile(file);
        if (i2 >= 24) {
            Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
            intent.setData(uriForFile);
            intent.addFlags(268435456);
            intent.addFlags(1);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent2.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        intent2.addFlags(268435456);
        intent2.addFlags(1);
        context.startActivity(intent2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_download_app);
        setTitle(getString(R.string.app_name));
        int i2 = 1;
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_logo_app);
        this.f366b = (MaterialTextView) findViewById(R.id.tv_url);
        this.d = (MaterialButton) findViewById(R.id.button_install);
        this.f367e = (MaterialButton) findViewById(R.id.button_open_app);
        this.d.setOnClickListener(new f(this, 0));
        this.f367e.setOnClickListener(new f(this, 1));
        try {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f365a = progressDialog;
            progressDialog.setProgressStyle(1);
            this.f365a.setMax(100);
            this.f365a.setTitle(getResources().getString(R.string.wait));
            this.f365a.setMessage(getResources().getString(R.string.download_message));
            this.f365a.setCancelable(false);
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        if (Build.VERSION.SDK_INT <= 33) {
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (strArr[i3].contains("armeabi")) {
                    i2 = 0;
                    break;
                }
                i3++;
            }
        }
        if (this.f365a == null || isFinishing()) {
            return;
        }
        try {
            this.f365a.show();
            new Thread(new n(this, i2, 1)).start();
        } catch (Exception e3) {
            e3.getStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        if (a.h(this) != null) {
            this.f367e.setVisibility(0);
            this.d.setVisibility(8);
            this.f366b.setText(getString(R.string.download_ok));
            this.f366b.setVisibility(0);
        }
    }
}
