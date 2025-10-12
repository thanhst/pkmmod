package com.lomfsqxinjb.KRgTbxlWh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import com.helpergames.NHelper;
import j0.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class GmRXkjgJBQEyF {

    /* renamed from: a, reason: collision with root package name */
    private static Context f2949a;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f2950a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2951b;

        /* renamed from: c, reason: collision with root package name */
        private final int f2952c;

        /* renamed from: d, reason: collision with root package name */
        private final String[] f2953d;

        a(int i2, int i3, String[] strArr) {
            this.f2950a = i2;
            this.f2952c = i3;
            this.f2951b = i3 * strArr.length;
            this.f2953d = strArr;
        }
    }

    private static a a(String str, int i2, int i3, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int iCeil = (int) Math.ceil(fontMetricsInt.bottom - fontMetricsInt.top);
        String[] strArrL = l(str, i2, i3, paint);
        if (i2 == 0) {
            int i4 = 0;
            for (String str2 : strArrL) {
                int iCeil2 = (int) Math.ceil(paint.measureText(str2, 0, str2.length()));
                if (iCeil2 > i4) {
                    i4 = iCeil2;
                }
            }
            i2 = i4;
        }
        return new a(i2, iCeil, strArrL);
    }

    private static int b(String str, int i2, int i3) {
        if (i3 == 2) {
            return i2;
        }
        if (i3 != 3) {
            return 0;
        }
        return i2 / 2;
    }

    private static int c(Paint.FontMetricsInt fontMetricsInt, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = fontMetricsInt.top;
        int i8 = -i7;
        if (i2 <= i3) {
            return i8;
        }
        if (i4 == 1) {
            return -i7;
        }
        if (i4 == 2) {
            i5 = -i7;
            i6 = i2 - i3;
        } else {
            if (i4 != 3) {
                return i8;
            }
            i5 = -i7;
            i6 = (i2 - i3) / 2;
        }
        return i5 + i6;
    }

    public static void d(String str, String str2, int i2, int i3, int i4, int i5) {
        e(str, str2, i2, 1.0f, 1.0f, 1.0f, i3, i4, i5, false, 0.0f, 0.0f, 0.0f, false, 1.0f, 1.0f, 1.0f, 1.0f);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    public static void e(java.lang.String r18, java.lang.String r19, int r20, float r21, float r22, float r23, int r24, int r25, int r26, boolean r27, float r28, float r29, float r30, boolean r31, float r32, float r33, float r34, float r35) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lomfsqxinjb.KRgTbxlWh.GmRXkjgJBQEyF.e(java.lang.String, java.lang.String, int, float, float, float, int, int, int, boolean, float, float, float, boolean, float, float, float, float):void");
    }

    private static LinkedList<String> f(String str, int i2, Paint paint) {
        int length = str.length();
        LinkedList<String> linkedList = new LinkedList<>();
        int i3 = 1;
        int i4 = 0;
        while (i3 <= length) {
            int iCeil = (int) Math.ceil(paint.measureText(str, i4, i3));
            if (iCeil >= i2) {
                int iLastIndexOf = str.substring(0, i3).lastIndexOf(" ");
                if (iLastIndexOf != -1 && iLastIndexOf > i4) {
                    linkedList.add(str.substring(i4, iLastIndexOf));
                    i3 = iLastIndexOf + 1;
                } else if (iCeil > i2) {
                    linkedList.add(str.substring(i4, i3 - 1));
                    i3--;
                } else {
                    linkedList.add(str.substring(i4, i3));
                }
                while (i3 < length && str.charAt(i3) == ' ') {
                    i3++;
                }
                i4 = i3;
            }
            i3++;
        }
        if (i4 < length) {
            linkedList.add(str.substring(i4));
        }
        return linkedList;
    }

    private static byte[] g(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        byte[] bArr = new byte[bitmap.getWidth() * bitmap.getHeight() * 4];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.nativeOrder());
        bitmap.copyPixelsToBuffer(byteBufferWrap);
        return bArr;
    }

    private static void h(Bitmap bitmap, boolean z2) {
        byte[] bArrG = g(bitmap);
        if (bArrG == null) {
            z2 = false;
        }
        NHelper.b();
        NHelper.ncallback_bcb44ae41a5fd5b04fa2371a56fd3879(bitmap.getWidth(), bitmap.getHeight(), z2, bArrG);
    }

    private static Paint i(String str, int i2, int i3) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize(i2);
        paint.setAntiAlias(true);
        try {
            paint.setTypeface(l.a(f2949a, str));
        } catch (Exception unused) {
            Log.e("GmRXkjgJBQEyF", "error to create ttf type face: " + str);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        }
        if (i3 == 2) {
            paint.setTextAlign(Paint.Align.RIGHT);
        } else if (i3 != 3) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else {
            paint.setTextAlign(Paint.Align.CENTER);
        }
        return paint;
    }

    private static String j(String str) {
        if (str.compareTo("") == 0) {
            return " ";
        }
        StringBuilder sb = new StringBuilder(str);
        int i2 = 0;
        for (int iIndexOf = sb.indexOf("\n"); iIndexOf != -1; iIndexOf = sb.indexOf("\n", i2)) {
            if (iIndexOf == 0 || sb.charAt(iIndexOf - 1) == '\n') {
                sb.insert(i2, " ");
                i2 = iIndexOf + 2;
            } else {
                i2 = iIndexOf + 1;
            }
            if (i2 > sb.length() || iIndexOf == sb.length()) {
                break;
            }
        }
        return sb.toString();
    }

    public static void k(Context context) {
        f2949a = context;
    }

    private static String[] l(String str, int i2, int i3, Paint paint) {
        String[] strArrSplit = str.split("\\n");
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int iCeil = i3 / ((int) Math.ceil(fontMetricsInt.bottom - fontMetricsInt.top));
        int i4 = 0;
        if (i2 == 0) {
            if (i3 == 0 || strArrSplit.length <= iCeil) {
                return strArrSplit;
            }
            LinkedList linkedList = new LinkedList();
            while (i4 < iCeil) {
                linkedList.add(strArrSplit[i4]);
                i4++;
            }
            String[] strArr = new String[linkedList.size()];
            linkedList.toArray(strArr);
            return strArr;
        }
        LinkedList linkedList2 = new LinkedList();
        int length = strArrSplit.length;
        while (i4 < length) {
            String str2 = strArrSplit[i4];
            if (((int) Math.ceil(paint.measureText(str2))) > i2) {
                linkedList2.addAll(f(str2, i2, paint));
            } else {
                linkedList2.add(str2);
            }
            if (iCeil > 0 && linkedList2.size() >= iCeil) {
                break;
            }
            i4++;
        }
        if (iCeil > 0 && linkedList2.size() > iCeil) {
            while (linkedList2.size() > iCeil) {
                linkedList2.removeLast();
            }
        }
        String[] strArr2 = new String[linkedList2.size()];
        linkedList2.toArray(strArr2);
        return strArr2;
    }
}
