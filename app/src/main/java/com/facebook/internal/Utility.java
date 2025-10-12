package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk.DataUtil;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Utility.kt */
@Metadata(bv = {}, d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002Ò\u0001B\u000b\b\u0002¢\u0006\u0006\bÑ\u0001\u0010Ì\u0001J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u001a\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0007J$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0007J,\u0010#\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010!H\u0007J$\u0010%\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J$\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010*\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0007J\u0012\u0010-\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010+H\u0007J\u0012\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0007J\u001c\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001032\u0006\u00102\u001a\u000201H\u0007J\u001c\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006032\u0006\u00102\u001a\u000201H\u0007J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060!2\u0006\u00107\u001a\u000206H\u0007J&\u0010:\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u0002012\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u00109\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010=\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010;H\u0007J\u001a\u0010A\u001a\u00020@2\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010?\u001a\u00020>H\u0007J\u001c\u0010C\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010E\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020.2\u0006\u0010D\u001a\u00020\u0006H\u0002J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020.H\u0007J\"\u0010K\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010\u00062\u000e\u0010J\u001a\n\u0018\u00010Hj\u0004\u0018\u0001`IH\u0007J\u001c\u0010K\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010\u00062\b\u0010L\u001a\u0004\u0018\u00010\u0006H\u0007J&\u0010K\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010\u00062\b\u0010L\u001a\u0004\u0018\u00010\u00062\b\u0010N\u001a\u0004\u0018\u00010MH\u0007J)\u0010P\u001a\u00020\u0004\"\u0004\b\u0000\u0010O2\b\u0010B\u001a\u0004\u0018\u00018\u00002\b\u0010\u001d\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\bP\u0010QJ\u001c\u0010T\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u0001012\b\u0010S\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010V\u001a\u0004\u0018\u0001012\b\u0010R\u001a\u0004\u0018\u0001012\b\u0010U\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010W\u001a\u0004\u0018\u0001062\b\u0010R\u001a\u0004\u0018\u0001012\b\u0010U\u001a\u0004\u0018\u00010\u0006H\u0007J\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00060!2\u0006\u00107\u001a\u000206H\u0007J\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00060Y2\u0006\u00107\u001a\u000206H\u0007J \u0010\\\u001a\u00020\u00062\u0016\u0010[\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000603H\u0007J\u001c\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006032\u0006\u0010]\u001a\u00020\u0006H\u0007J4\u0010d\u001a\u00020\u001f2\u0006\u0010_\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010`2\b\u0010b\u001a\u0004\u0018\u00010\u00062\u0006\u0010c\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0007J\n\u0010e\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010g\u001a\u00020\u001f2\u0006\u0010_\u001a\u0002012\u0006\u0010f\u001a\u00020.H\u0007JE\u0010n\u001a\u0004\u0018\u00010m2\n\u0010i\u001a\u0006\u0012\u0002\b\u00030h2\u0006\u0010j\u001a\u00020\u00062\u001e\u0010l\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010h0k\"\b\u0012\u0002\b\u0003\u0018\u00010hH\u0007¢\u0006\u0004\bn\u0010oJA\u0010n\u001a\u0004\u0018\u00010m2\u0006\u0010p\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u00062\u001e\u0010l\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010h0k\"\b\u0012\u0002\b\u0003\u0018\u00010hH\u0007¢\u0006\u0004\bn\u0010qJ;\u0010u\u001a\u0004\u0018\u00010\u00012\b\u0010r\u001a\u0004\u0018\u00010\u00012\u0006\u0010s\u001a\u00020m2\u0016\u0010t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010k\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\bu\u0010vJ\u0012\u0010w\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0007J\u0014\u0010x\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J\u0012\u0010y\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J\u0012\u0010z\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J\u0012\u0010{\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J\u0010\u0010~\u001a\u00020}2\u0006\u0010|\u001a\u00020\u0019H\u0007J(\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010&\u001a\u0004\u0018\u00010\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u007fH\u0007J-\u0010\u0084\u0001\u001a\u00020\u001f2\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0018\u0010[\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u000103H\u0007J%\u0010\u0085\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001032\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0007J)\u0010\u0086\u0001\u001a\u00020\u001f2\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0014\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000103H\u0007J!\u0010\u0087\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001032\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0007J\u0015\u0010\u008a\u0001\u001a\u00020\u00042\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0007J\u0014\u0010\u008c\u0001\u001a\u00020\u00062\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u0090\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020\u00062\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0007J\u0014\u0010\u0091\u0001\u001a\u0004\u0018\u0001012\u0007\u0010\u008d\u0001\u001a\u00020\u0006H\u0007J\u0013\u0010\u0093\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010\u0095\u0001\u001a\u00020\u00062\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u000b\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\t\u0010\u0097\u0001\u001a\u00020@H\u0002J\u0011\u0010\u0098\u0001\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020.H\u0002J\t\u0010\u0099\u0001\u001a\u00020\u001fH\u0002J\u0011\u0010\u009a\u0001\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020.H\u0002J\t\u0010\u009b\u0001\u001a\u00020\u0004H\u0002J\t\u0010\u009c\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u009d\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010\u009f\u0001\u001a\u00020}2\u0007\u0010\u000e\u001a\u00030\u009e\u0001H\u0002J+\u0010 \u0001\u001a\u00020\u001f2\u0006\u0010_\u001a\u0002012\u0006\u0010a\u001a\u00020`2\b\u0010b\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020.H\u0002J!\u0010¡\u0001\u001a\u00020\u001f2\u0006\u0010_\u001a\u0002012\u0006\u0010a\u001a\u00020`2\u0006\u0010/\u001a\u00020.H\u0002J\u0011\u0010¢\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0002J\u0012\u0010¤\u0001\u001a\u00020\u00062\u0007\u0010£\u0001\u001a\u00020@H\u0007J\u0011\u0010¥\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0007J\u0011\u0010¦\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0007J\u0011\u0010§\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0007J\u0015\u0010ª\u0001\u001a\u00020\u001f2\n\u0010©\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0007J\u0011\u0010«\u0001\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.H\u0007R\u0017\u0010¬\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0017\u0010®\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b®\u0001\u0010\u00ad\u0001R\u0017\u0010¯\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b¯\u0001\u0010\u00ad\u0001R\u0017\u0010°\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b°\u0001\u0010\u00ad\u0001R\u0017\u0010±\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b±\u0001\u0010\u00ad\u0001R\u0017\u0010²\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b²\u0001\u0010\u00ad\u0001R\u0017\u0010³\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b³\u0001\u0010\u00ad\u0001R\u0017\u0010´\u0001\u001a\u00020@8\u0006X\u0086T¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0017\u0010¶\u0001\u001a\u00020@8\u0002X\u0082T¢\u0006\b\n\u0006\b¶\u0001\u0010µ\u0001R\u0017\u0010·\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b·\u0001\u0010\u00ad\u0001R\u0019\u0010¸\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010µ\u0001R\u0019\u0010¹\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010»\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010º\u0001R\u0019\u0010¼\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010º\u0001R\u0019\u0010½\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u00ad\u0001R\u0019\u0010¾\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010\u00ad\u0001R\u0019\u0010¿\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010\u00ad\u0001R\u0017\u0010À\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\bÀ\u0001\u0010\u00ad\u0001R\u0017\u0010Á\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\bÁ\u0001\u0010\u00ad\u0001R\u0017\u0010Â\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\bÂ\u0001\u0010\u00ad\u0001R\u0017\u0010Æ\u0001\u001a\u0005\u0018\u00010Ã\u00018G¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u0015\u0010È\u0001\u001a\u00030Ã\u00018G¢\u0006\b\u001a\u0006\bÇ\u0001\u0010Å\u0001R\u001f\u0010É\u0001\u001a\u00020\u00048FX\u0087\u0004¢\u0006\u0010\u0012\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0016\u0010Ï\u0001\u001a\u0004\u0018\u0001018G¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0014\u0010Ð\u0001\u001a\u00020\u00048G¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ê\u0001¨\u0006Ó\u0001"}, d2 = {"Lcom/facebook/internal/Utility;", "", "", "c", "", "isNullOrEmpty", "", "s", "valueIfNullOrEmpty", "coerceValueIfNullOrEmpty", "key", "md5hash", "sha1hash", "", "bytes", "sha256hash", "algorithm", "hashWithAlgorithm", "Ljava/security/MessageDigest;", "hash", "hashBytes", "authority", "path", "Landroid/os/Bundle;", "parameters", "Landroid/net/Uri;", "buildUri", "queryString", "parseUrlQueryString", "b", "value", "Lkotlin/t;", "putNonEmptyString", "", "list", "putCommaSeparatedStringList", ShareConstants.MEDIA_URI, "putUri", "bundle", "putJSONValueInBundle", "Ljava/io/Closeable;", "closeable", "closeQuietly", "Ljava/net/URLConnection;", "connection", "disconnectQuietly", "Landroid/content/Context;", "context", "getMetadataApplicationId", "Lorg/json/JSONObject;", "jsonObject", "", "convertJSONObjectToHashMap", "convertJSONObjectToStringMap", "Lorg/json/JSONArray;", "jsonArray", "convertJSONArrayToList", "nonJSONPropertyKey", "getStringPropertyAsJSON", "Ljava/io/InputStream;", "inputStream", "readStreamToString", "Ljava/io/OutputStream;", "outputStream", "", "copyAndCloseInputStream", "a", "stringsEqualOrEmpty", "domain", "clearCookiesForDomain", "clearFacebookCookies", ViewHierarchyConstants.TAG_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "logd", "msg", "", "t", "T", "areObjectsEqual", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "response", "propertyName", "safeGetStringFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "tryGetJSONArrayFromResponse", "jsonArrayToStringList", "", "jsonArrayToSet", "map", "mapToJsonStr", "str", "jsonStrToMap", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", "anonymousAppDeviceGUID", "limitEventUsage", "setAppEventAttributionParameters", "getAppVersion", "appContext", "setAppEventExtendedDeviceInfoParameters", "Ljava/lang/Class;", "clazz", "methodName", "", "parameterTypes", "Ljava/lang/reflect/Method;", "getMethodQuietly", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "receiver", "method", "args", "invokeMethodQuietly", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "getActivityName", "getUriString", "isWebUri", "isContentUri", "isFileUri", "contentUri", "", "getContentSize", "Ljava/util/Date;", "dateBase", "getBundleLongAsDate", "Landroid/os/Parcel;", "parcel", "writeStringMapToParcel", "readStringMapFromParcel", "writeNonnullStringMapToParcel", "readNonnullStringMapFromParcel", "Lcom/facebook/AccessToken;", "token", "isCurrentAccessToken", "tokenGraphDomain", "getGraphDomainFromTokenDomain", "accessToken", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "callback", "getGraphMeRequestWithCacheAsync", "awaitGetGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCache", "graphDomain", "getProfileFieldsForGraphDomain", "getCurrentTokenDomainWithDefault", "refreshBestGuessNumberOfCPUCores", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshCarrierName", "externalStorageExists", "refreshAvailableExternalStorage", "refreshTotalExternalStorage", "", "convertBytesToGB", "appendAnonIdUnderCompliance", "appendAttributionIdUnderCompliance", "isGooglePlayServicesAvailable", "length", "generateRandomString", "mustFixWindowParamsForAutofill", "isAutofillAvailable", "isChromeOS", "Ljava/lang/Runnable;", "runnable", "runOnNonUiThread", "getAppName", "LOG_TAG", "Ljava/lang/String;", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "URL_SCHEME", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "UTF8", "DEFAULT_STREAM_BUFFER_SIZE", "I", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "NO_CARRIER", "numCPUCores", "timestampOfLastCheck", "J", "totalExternalStorageGB", "availableExternalStorageGB", "deviceTimezoneAbbreviation", "deviceTimeZoneName", "carrierName", "ARC_DEVICE_PATTERN", "FACEBOOK_PROFILE_FIELDS", "INSTAGRAM_PROFILE_FIELDS", "Ljava/util/Locale;", "getResourceLocale", "()Ljava/util/Locale;", "resourceLocale", "getCurrentLocale", "currentLocale", "isAutoAppLinkSetup", "()Z", "isAutoAppLinkSetup$annotations", "()V", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "dataProcessingOptions", "isDataProcessingRestricted", "<init>", "GraphMeRequestWithCacheCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Utility {

    @NotNull
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;

    @NotNull
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";

    @NotNull
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";

    @NotNull
    private static final String HASH_ALGORITHM_MD5 = "MD5";

    @NotNull
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";

    @NotNull
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";

    @NotNull
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";

    @NotNull
    public static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;

    @NotNull
    private static final String URL_SCHEME = "https";

    @NotNull
    private static final String UTF8 = "UTF-8";
    private static int numCPUCores;

    @NotNull
    public static final Utility INSTANCE = new Utility();
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;
    private static long availableExternalStorageGB = -1;

    @NotNull
    private static String deviceTimezoneAbbreviation = "";

    @NotNull
    private static String deviceTimeZoneName = "";

    @NotNull
    private static final String NO_CARRIER = "NoCarrier";

    @NotNull
    private static String carrierName = NO_CARRIER;

    /* compiled from: Utility.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "Lorg/json/JSONObject;", "userInfo", "Lkotlin/t;", "onSuccess", "Lcom/facebook/FacebookException;", "error", "onFailure", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(@Nullable FacebookException facebookException);

        void onSuccess(@Nullable JSONObject jSONObject);
    }

    private Utility() {
    }

    private final void appendAnonIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, Context context) throws JSONException {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            jSONObject.put("anon_id", str);
        } else {
            if (attributionIdentifiers.getIsTrackingLimited()) {
                return;
            }
            jSONObject.put("anon_id", str);
        }
    }

    private final void appendAttributionIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, Context context) throws JSONException {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
        } else {
            if (attributionIdentifiers.getIsTrackingLimited()) {
                return;
            }
            jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
        }
    }

    @JvmStatic
    public static final <T> boolean areObjectsEqual(@Nullable T a2, @Nullable T b2) {
        return a2 == null ? b2 == null : kotlin.jvm.internal.s.a(a2, b2);
    }

    @JvmStatic
    @Nullable
    public static final JSONObject awaitGetGraphMeRequestWithCache(@NotNull String accessToken) {
        kotlin.jvm.internal.s.e(accessToken, "accessToken");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse graphResponseExecuteAndWait = INSTANCE.getGraphMeRequestWithCache(accessToken).executeAndWait();
        if (graphResponseExecuteAndWait.getError() != null) {
            return null;
        }
        return graphResponseExecuteAndWait.getJsonObject();
    }

    @JvmStatic
    @NotNull
    public static final Uri buildUri(@Nullable String authority, @Nullable String path, @Nullable Bundle parameters) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(authority);
        builder.path(path);
        if (parameters != null) {
            for (String str : parameters.keySet()) {
                Object obj = parameters.get(str);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str, (String) obj);
                }
            }
        }
        Uri uriBuild = builder.build();
        kotlin.jvm.internal.s.d(uriBuild, "builder.build()");
        return uriBuild;
    }

    private final void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        Object[] array = StringsKt__StringsKt.c0(cookie, new String[]{";"}, false, 0, 6, null).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArr[i2];
            i2++;
            Object[] array2 = StringsKt__StringsKt.c0(str2, new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr2 = (String[]) array2;
            if (strArr2.length > 0) {
                String str3 = strArr2[0];
                int length2 = str3.length() - 1;
                int i3 = 0;
                boolean z2 = false;
                while (i3 <= length2) {
                    boolean z3 = kotlin.jvm.internal.s.f(str3.charAt(!z2 ? i3 : length2), 32) <= 0;
                    if (z2) {
                        if (!z3) {
                            break;
                        } else {
                            length2--;
                        }
                    } else if (z3) {
                        i3++;
                    } else {
                        z2 = true;
                    }
                }
                cookieManager.setCookie(str, kotlin.jvm.internal.s.m(str3.subSequence(i3, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
            }
        }
        cookieManager.removeExpiredCookie();
    }

    @JvmStatic
    public static final void clearFacebookCookies(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        try {
            Utility utility = INSTANCE;
            utility.clearCookiesForDomain(context, FacebookSdk.FACEBOOK_COM);
            utility.clearCookiesForDomain(context, ".facebook.com");
            utility.clearCookiesForDomain(context, "https://facebook.com");
            utility.clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void closeQuietly(@Nullable Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    @JvmStatic
    @Nullable
    public static final String coerceValueIfNullOrEmpty(@Nullable String s2, @Nullable String valueIfNullOrEmpty) {
        return isNullOrEmpty(s2) ? valueIfNullOrEmpty : s2;
    }

    private final long convertBytesToGB(double bytes) {
        return Math.round(bytes / 1.073741824E9d);
    }

    @JvmStatic
    @NotNull
    public static final List<String> convertJSONArrayToList(@NotNull JSONArray jsonArray) throws JSONException {
        kotlin.jvm.internal.s.e(jsonArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int length = jsonArray.length();
            if (length <= 0) {
                return arrayList;
            }
            while (true) {
                int i3 = i2 + 1;
                String string = jsonArray.getString(i2);
                kotlin.jvm.internal.s.d(string, "jsonArray.getString(i)");
                arrayList.add(string);
                if (i3 >= length) {
                    return arrayList;
                }
                i2 = i3;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    @JvmStatic
    @NotNull
    public static final Map<String, Object> convertJSONObjectToHashMap(@NotNull JSONObject jsonObject) throws JSONException {
        kotlin.jvm.internal.s.e(jsonObject, "jsonObject");
        HashMap map = new HashMap();
        JSONArray jSONArrayNames = jsonObject.names();
        if (jSONArrayNames == null) {
            return map;
        }
        int i2 = 0;
        int length = jSONArrayNames.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                try {
                    String string = jSONArrayNames.getString(i2);
                    kotlin.jvm.internal.s.d(string, "keys.getString(i)");
                    Object value = jsonObject.get(string);
                    if (value instanceof JSONObject) {
                        value = convertJSONObjectToHashMap((JSONObject) value);
                    }
                    kotlin.jvm.internal.s.d(value, "value");
                    map.put(string, value);
                } catch (JSONException unused) {
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return map;
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> convertJSONObjectToStringMap(@NotNull JSONObject jsonObject) {
        kotlin.jvm.internal.s.e(jsonObject, "jsonObject");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jsonObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            String strOptString = jsonObject.optString(key);
            if (strOptString != null) {
                kotlin.jvm.internal.s.d(key, "key");
                map.put(key, strOptString);
            }
        }
        return map;
    }

    @JvmStatic
    public static final int copyAndCloseInputStream(@Nullable InputStream inputStream, @NotNull OutputStream outputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        kotlin.jvm.internal.s.e(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[DEFAULT_STREAM_BUFFER_SIZE];
            int i2 = 0;
            while (true) {
                int i3 = bufferedInputStream.read(bArr);
                if (i3 == -1) {
                    break;
                }
                outputStream.write(bArr, 0, i3);
                i2 += i3;
            }
            bufferedInputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            return i2;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @JvmStatic
    public static final void disconnectQuietly(@Nullable URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    private final boolean externalStorageExists() {
        return kotlin.jvm.internal.s.a("mounted", Environment.getExternalStorageState());
    }

    @JvmStatic
    @NotNull
    public static final String generateRandomString(int length) {
        String string = new BigInteger(length * 5, new Random()).toString(32);
        kotlin.jvm.internal.s.d(string, "BigInteger(length * 5, r).toString(32)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final String getActivityName(@Nullable Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        kotlin.jvm.internal.s.d(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    @JvmStatic
    @NotNull
    public static final String getAppName(@NotNull Context context) {
        String string;
        kotlin.jvm.internal.s.e(context, "context");
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            if (i2 == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i2);
                kotlin.jvm.internal.s.d(string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    @JvmStatic
    @Nullable
    public static final String getAppVersion() throws PackageManager.NameNotFoundException {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Date getBundleLongAsDate(@Nullable Bundle bundle, @Nullable String key, @NotNull Date dateBase) throws NumberFormatException {
        long jLongValue;
        kotlin.jvm.internal.s.e(dateBase, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(key);
        if (!(obj instanceof Long)) {
            if (obj instanceof String) {
                try {
                    jLongValue = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        jLongValue = ((Number) obj).longValue();
        return jLongValue == 0 ? new Date(Long.MAX_VALUE) : new Date(dateBase.getTime() + (jLongValue * 1000));
    }

    @JvmStatic
    public static final long getContentSize(@NotNull Uri contentUri) {
        kotlin.jvm.internal.s.e(contentUri, "contentUri");
        Cursor cursorQuery = null;
        try {
            cursorQuery = FacebookSdk.getApplicationContext().getContentResolver().query(contentUri, null, null, null, null);
            if (cursorQuery == null) {
                return 0L;
            }
            int columnIndex = cursorQuery.getColumnIndex("_size");
            cursorQuery.moveToFirst();
            long j2 = cursorQuery.getLong(columnIndex);
            cursorQuery.close();
            return j2;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @JvmStatic
    @NotNull
    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.s.d(locale, "getDefault()");
        return locale;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        return (currentAccessToken == null || currentAccessToken.getGraphDomain() == null) ? AccessToken.DEFAULT_GRAPH_DOMAIN : currentAccessToken.getGraphDomain();
    }

    @JvmStatic
    @Nullable
    public static final JSONObject getDataProcessingOptions() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getGraphDomainFromTokenDomain(@Nullable String tokenGraphDomain) {
        String facebookDomain = FacebookSdk.getFacebookDomain();
        return tokenGraphDomain == null ? facebookDomain : kotlin.jvm.internal.s.a(tokenGraphDomain, FacebookSdk.GAMING) ? kotlin.text.s.s(facebookDomain, FacebookSdk.FACEBOOK_COM, FacebookSdk.FB_GG, false, 4, null) : kotlin.jvm.internal.s.a(tokenGraphDomain, FacebookSdk.INSTAGRAM) ? kotlin.text.s.s(facebookDomain, FacebookSdk.FACEBOOK_COM, FacebookSdk.INSTAGRAM_COM, false, 4, null) : facebookDomain;
    }

    private final GraphRequest getGraphMeRequestWithCache(String accessToken) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", accessToken);
        GraphRequest graphRequestNewMeRequest = GraphRequest.INSTANCE.newMeRequest(null, null);
        graphRequestNewMeRequest.setParameters(bundle);
        graphRequestNewMeRequest.setHttpMethod(HttpMethod.GET);
        return graphRequestNewMeRequest;
    }

    @JvmStatic
    public static final void getGraphMeRequestWithCacheAsync(@NotNull final String accessToken, @NotNull final GraphMeRequestWithCacheCallback callback) {
        kotlin.jvm.internal.s.e(accessToken, "accessToken");
        kotlin.jvm.internal.s.e(callback, "callback");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            callback.onSuccess(profileInformation);
            return;
        }
        GraphRequest.Callback callback2 = new GraphRequest.Callback() { // from class: com.facebook.internal.r
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                Utility.m110getGraphMeRequestWithCacheAsync$lambda3(callback, accessToken, graphResponse);
            }
        };
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(accessToken);
        graphMeRequestWithCache.setCallback(callback2);
        graphMeRequestWithCache.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getGraphMeRequestWithCacheAsync$lambda-3, reason: not valid java name */
    public static final void m110getGraphMeRequestWithCacheAsync$lambda3(GraphMeRequestWithCacheCallback callback, String accessToken, GraphResponse response) {
        kotlin.jvm.internal.s.e(callback, "$callback");
        kotlin.jvm.internal.s.e(accessToken, "$accessToken");
        kotlin.jvm.internal.s.e(response, "response");
        if (response.getError() != null) {
            callback.onFailure(response.getError().getException());
            return;
        }
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject jsonObject = response.getJsonObject();
        if (jsonObject == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ProfileInformationCache.putProfileInformation(accessToken, jsonObject);
        callback.onSuccess(response.getJsonObject());
    }

    @JvmStatic
    @NotNull
    public static final String getMetadataApplicationId(@Nullable Context context) {
        Validate.notNull(context, "context");
        return FacebookSdk.getApplicationId();
    }

    @JvmStatic
    @Nullable
    public static final Method getMethodQuietly(@NotNull Class<?> clazz, @NotNull String methodName, @NotNull Class<?>... parameterTypes) {
        kotlin.jvm.internal.s.e(clazz, "clazz");
        kotlin.jvm.internal.s.e(methodName, "methodName");
        kotlin.jvm.internal.s.e(parameterTypes, "parameterTypes");
        try {
            return clazz.getMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String getProfileFieldsForGraphDomain(String graphDomain) {
        return kotlin.jvm.internal.s.a(graphDomain, FacebookSdk.INSTAGRAM) ? INSTAGRAM_PROFILE_FIELDS : FACEBOOK_PROFILE_FIELDS;
    }

    @JvmStatic
    @Nullable
    public static final Locale getResourceLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Object getStringPropertyAsJSON(@NotNull JSONObject jsonObject, @Nullable String key, @Nullable String nonJSONPropertyKey) throws JSONException {
        kotlin.jvm.internal.s.e(jsonObject, "jsonObject");
        Object objOpt = jsonObject.opt(key);
        if (objOpt != null && (objOpt instanceof String)) {
            objOpt = new JSONTokener((String) objOpt).nextValue();
        }
        if (objOpt == null || (objOpt instanceof JSONObject) || (objOpt instanceof JSONArray)) {
            return objOpt;
        }
        if (nonJSONPropertyKey == null) {
            throw new FacebookException("Got an unexpected non-JSON object.");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt(nonJSONPropertyKey, objOpt);
        return jSONObject;
    }

    @JvmStatic
    @Nullable
    public static final String getUriString(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    private final String hashBytes(MessageDigest hash, byte[] bytes) {
        hash.update(bytes);
        byte[] digest = hash.digest();
        StringBuilder sb = new StringBuilder();
        kotlin.jvm.internal.s.d(digest, "digest");
        int length = digest.length;
        int i2 = 0;
        while (i2 < length) {
            byte b2 = digest[i2];
            i2++;
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString((b2 >> 0) & 15));
        }
        String string = sb.toString();
        kotlin.jvm.internal.s.d(string, "builder.toString()");
        return string;
    }

    private final String hashWithAlgorithm(String algorithm, String key) {
        Charset charset = kotlin.text.d.UTF_8;
        if (key == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = key.getBytes(charset);
        kotlin.jvm.internal.s.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm(algorithm, bytes);
    }

    @JvmStatic
    @Nullable
    public static final Object invokeMethodQuietly(@Nullable Object receiver, @NotNull Method method, @NotNull Object... args) {
        kotlin.jvm.internal.s.e(method, "method");
        kotlin.jvm.internal.s.e(args, "args");
        try {
            return method.invoke(receiver, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.f3460a;
            String str = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            kotlin.jvm.internal.s.d(str, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(str));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            kotlin.jvm.internal.s.d(listQueryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.s.a(packageName, it.next().activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @JvmStatic
    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    @JvmStatic
    public static final boolean isAutofillAvailable(@NotNull Context context) {
        AutofillManager autofillManager;
        kotlin.jvm.internal.s.e(context, "context");
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    @JvmStatic
    public static final boolean isChromeOS(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String DEVICE = Build.DEVICE;
        if (DEVICE != null) {
            kotlin.jvm.internal.s.d(DEVICE, "DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).matches(DEVICE)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isContentUri(@Nullable Uri uri) {
        return uri != null && kotlin.text.s.l("content", uri.getScheme(), true);
    }

    @JvmStatic
    public static final boolean isCurrentAccessToken(@Nullable AccessToken token) {
        return token != null && kotlin.jvm.internal.s.a(token, AccessToken.INSTANCE.getCurrentAccessToken());
    }

    @JvmStatic
    public static final boolean isDataProcessingRestricted() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
                int length = jSONArray.length();
                if (length > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        String string = jSONArray.getString(i2);
                        kotlin.jvm.internal.s.d(string, "options.getString(i)");
                        String lowerCase = string.toLowerCase();
                        kotlin.jvm.internal.s.d(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (kotlin.jvm.internal.s.a(lowerCase, "ldu")) {
                            return true;
                        }
                        if (i3 >= length) {
                            break;
                        }
                        i2 = i3;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isFileUri(@Nullable Uri uri) {
        return uri != null && kotlin.text.s.l(ShareInternalUtility.STAGING_PARAM, uri.getScheme(), true);
    }

    private final boolean isGooglePlayServicesAvailable(Context context) throws ClassNotFoundException {
        Method methodQuietly = getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object objInvokeMethodQuietly = invokeMethodQuietly(null, methodQuietly, context);
        return (objInvokeMethodQuietly instanceof Integer) && kotlin.jvm.internal.s.a(objInvokeMethodQuietly, 0);
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(@Nullable Collection<?> c2) {
        return c2 == null || c2.isEmpty();
    }

    @JvmStatic
    public static final boolean isWebUri(@Nullable Uri uri) {
        return uri != null && (kotlin.text.s.l("http", uri.getScheme(), true) || kotlin.text.s.l("https", uri.getScheme(), true) || kotlin.text.s.l("fbstaging", uri.getScheme(), true));
    }

    @JvmStatic
    @NotNull
    public static final Set<String> jsonArrayToSet(@NotNull JSONArray jsonArray) throws JSONException {
        kotlin.jvm.internal.s.e(jsonArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jsonArray.length();
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                String string = jsonArray.getString(i2);
                kotlin.jvm.internal.s.d(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return hashSet;
    }

    @JvmStatic
    @NotNull
    public static final List<String> jsonArrayToStringList(@NotNull JSONArray jsonArray) throws JSONException {
        kotlin.jvm.internal.s.e(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                arrayList.add(jsonArray.getString(i2));
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> jsonStrToMap(@NotNull String str) throws JSONException {
        kotlin.jvm.internal.s.e(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                kotlin.jvm.internal.s.d(key, "key");
                String string = jSONObject.getString(key);
                kotlin.jvm.internal.s.d(string, "jsonObject.getString(key)");
                map.put(key, string);
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    @JvmStatic
    public static final void logd(@Nullable String str, @Nullable Exception exc) {
        if (!FacebookSdk.isDebugEnabled() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + ((Object) exc.getMessage()));
    }

    @JvmStatic
    @NotNull
    public static final String mapToJsonStr(@NotNull Map<String, String> map) throws JSONException {
        kotlin.jvm.internal.s.e(map, "map");
        String string = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                string = jSONObject.toString();
            } catch (JSONException unused) {
            }
            kotlin.jvm.internal.s.d(string, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return string;
    }

    @JvmStatic
    @Nullable
    public static final String md5hash(@NotNull String key) {
        kotlin.jvm.internal.s.e(key, "key");
        return INSTANCE.hashWithAlgorithm("MD5", key);
    }

    @JvmStatic
    public static final boolean mustFixWindowParamsForAutofill(@NotNull Context context) {
        kotlin.jvm.internal.s.e(context, "context");
        return isAutofillAvailable(context);
    }

    @JvmStatic
    @NotNull
    public static final Bundle parseUrlQueryString(@Nullable String queryString) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(queryString)) {
            if (queryString == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Object[] array = StringsKt__StringsKt.c0(queryString, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                i2++;
                Object[] array2 = StringsKt__StringsKt.c0(str, new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
                if (array2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr2 = (String[]) array2;
                try {
                    if (strArr2.length == 2) {
                        bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                    } else if (strArr2.length == 1) {
                        bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e2) {
                    logd(LOG_TAG, e2);
                }
            }
        }
        return bundle;
    }

    @JvmStatic
    public static final void putCommaSeparatedStringList(@NotNull Bundle b2, @Nullable String str, @Nullable List<String> list) {
        kotlin.jvm.internal.s.e(b2, "b");
        if (list != null) {
            b2.putString(str, TextUtils.join(",", list));
        }
    }

    @JvmStatic
    public static final boolean putJSONValueInBundle(@NotNull Bundle bundle, @Nullable String key, @Nullable Object value) {
        kotlin.jvm.internal.s.e(bundle, "bundle");
        if (value == null) {
            bundle.remove(key);
            return true;
        }
        if (value instanceof Boolean) {
            bundle.putBoolean(key, ((Boolean) value).booleanValue());
            return true;
        }
        if (value instanceof boolean[]) {
            bundle.putBooleanArray(key, (boolean[]) value);
            return true;
        }
        if (value instanceof Double) {
            bundle.putDouble(key, ((Number) value).doubleValue());
            return true;
        }
        if (value instanceof double[]) {
            bundle.putDoubleArray(key, (double[]) value);
            return true;
        }
        if (value instanceof Integer) {
            bundle.putInt(key, ((Number) value).intValue());
            return true;
        }
        if (value instanceof int[]) {
            bundle.putIntArray(key, (int[]) value);
            return true;
        }
        if (value instanceof Long) {
            bundle.putLong(key, ((Number) value).longValue());
            return true;
        }
        if (value instanceof long[]) {
            bundle.putLongArray(key, (long[]) value);
            return true;
        }
        if (value instanceof String) {
            bundle.putString(key, (String) value);
            return true;
        }
        if (value instanceof JSONArray) {
            bundle.putString(key, ((JSONArray) value).toString());
            return true;
        }
        if (!(value instanceof JSONObject)) {
            return false;
        }
        bundle.putString(key, ((JSONObject) value).toString());
        return true;
    }

    @JvmStatic
    public static final void putNonEmptyString(@NotNull Bundle b2, @Nullable String str, @Nullable String str2) {
        kotlin.jvm.internal.s.e(b2, "b");
        if (isNullOrEmpty(str2)) {
            return;
        }
        b2.putString(str, str2);
    }

    @JvmStatic
    public static final void putUri(@NotNull Bundle b2, @Nullable String str, @Nullable Uri uri) {
        kotlin.jvm.internal.s.e(b2, "b");
        if (uri != null) {
            putNonEmptyString(b2, str, uri.toString());
        }
    }

    @JvmStatic
    @Nullable
    public static final Map<String, String> readNonnullStringMapFromParcel(@NotNull Parcel parcel) {
        kotlin.jvm.internal.s.e(parcel, "parcel");
        int i2 = parcel.readInt();
        if (i2 < 0) {
            return null;
        }
        HashMap map = new HashMap();
        int i3 = 0;
        if (i2 > 0) {
            do {
                i3++;
                String string = parcel.readString();
                String string2 = parcel.readString();
                if (string != null && string2 != null) {
                    map.put(string, string2);
                }
            } while (i3 < i2);
        }
        return map;
    }

    @JvmStatic
    @NotNull
    public static final String readStreamToString(@Nullable InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            inputStreamReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[2048];
            while (true) {
                int i2 = inputStreamReader.read(cArr);
                if (i2 == -1) {
                    String string = sb.toString();
                    kotlin.jvm.internal.s.d(string, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    return string;
                }
                sb.append(cArr, 0, i2);
            }
        } catch (Throwable th4) {
            th = th4;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    @JvmStatic
    @Nullable
    public static final Map<String, String> readStringMapFromParcel(@NotNull Parcel parcel) {
        kotlin.jvm.internal.s.e(parcel, "parcel");
        int i2 = parcel.readInt();
        if (i2 < 0) {
            return null;
        }
        HashMap map = new HashMap();
        int i3 = 0;
        if (i2 > 0) {
            do {
                i3++;
                map.put(parcel.readString(), parcel.readString());
            } while (i3 < i2);
        }
        return map;
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i2 = numCPUCores;
        if (i2 > 0) {
            return i2;
        }
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.s
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return Utility.m111refreshBestGuessNumberOfCPUCores$lambda4(file, str);
                }
            });
            if (fileArrListFiles != null) {
                numCPUCores = fileArrListFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshBestGuessNumberOfCPUCores$lambda-4, reason: not valid java name */
    public static final boolean m111refreshBestGuessNumberOfCPUCores$lambda4(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    private final void refreshCarrierName(Context context) {
        if (kotlin.jvm.internal.s.a(carrierName, NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService(DataUtil.USER_COLUMN.PHONE);
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                }
                String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                kotlin.jvm.internal.s.d(networkOperatorName, "telephonyManager.networkOperatorName");
                carrierName = networkOperatorName;
            } catch (Exception unused) {
            }
        }
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            kotlin.jvm.internal.s.d(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            String id = timeZone.getID();
            kotlin.jvm.internal.s.d(id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = statFs.getBlockCount() * statFs.getBlockSize();
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void runOnNonUiThread(@Nullable Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    @NotNull
    public static final String safeGetStringFromResponse(@Nullable JSONObject response, @Nullable String propertyName) {
        if (response == null) {
            return "";
        }
        String strOptString = response.optString(propertyName, "");
        kotlin.jvm.internal.s.d(strOptString, "response.optString(propertyName, \"\")");
        return strOptString;
    }

    @JvmStatic
    public static final void setAppEventAttributionParameters(@NotNull JSONObject params, @Nullable AttributionIdentifiers attributionIdentifiers, @Nullable String str, boolean z2, @NotNull Context context) throws JSONException {
        kotlin.jvm.internal.s.e(params, "params");
        kotlin.jvm.internal.s.e(context, "context");
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.Feature feature = FeatureManager.Feature.ServiceUpdateCompliance;
        if (!FeatureManager.isEnabled(feature)) {
            params.put("anon_id", str);
        }
        params.put("application_tracking_enabled", !z2);
        params.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (FeatureManager.isEnabled(feature)) {
                INSTANCE.appendAnonIdUnderCompliance(params, attributionIdentifiers, str, context);
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                if (FeatureManager.isEnabled(feature)) {
                    INSTANCE.appendAttributionIdUnderCompliance(params, attributionIdentifiers, context);
                } else {
                    params.put("attribution", attributionIdentifiers.getAttributionId());
                }
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                params.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                params.put("advertiser_tracking_enabled", !attributionIdentifiers.getIsTrackingLimited());
            }
            if (!attributionIdentifiers.getIsTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (!(allHashedUserData.length() == 0)) {
                    params.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                params.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    @JvmStatic
    public static final void setAppEventExtendedDeviceInfoParameters(@NotNull JSONObject params, @NotNull Context appContext) throws JSONException, PackageManager.NameNotFoundException {
        String str;
        Locale locale;
        int i2;
        Display display;
        PackageInfo packageInfo;
        kotlin.jvm.internal.s.e(params, "params");
        kotlin.jvm.internal.s.e(appContext, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(appContext);
        String packageName = appContext.getPackageName();
        int i3 = 0;
        int i4 = -1;
        try {
            packageInfo = appContext.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        if (packageInfo == null) {
            return;
        }
        i4 = packageInfo.versionCode;
        str = packageInfo.versionName;
        jSONArray.put(packageName);
        jSONArray.put(i4);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = appContext.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + '_' + ((Object) locale.getCountry()));
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        double d2 = 0.0d;
        try {
            Object systemService = appContext.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
            display = null;
            DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
            if (displayManager != null) {
                display = displayManager.getDisplay(0);
            }
        } catch (Exception unused3) {
        }
        if (display != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            int i5 = displayMetrics.widthPixels;
            try {
                int i6 = displayMetrics.heightPixels;
                try {
                    d2 = displayMetrics.density;
                } catch (Exception unused4) {
                }
                i2 = i6;
                i3 = i5;
            } catch (Exception unused5) {
                i3 = i5;
            }
        } else {
            i2 = 0;
        }
        jSONArray.put(i3);
        jSONArray.put(i2);
        jSONArray.put(new DecimalFormat("#.##").format(d2));
        jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        params.put(Constants.EXTINFO, jSONArray.toString());
    }

    @JvmStatic
    @Nullable
    public static final String sha1hash(@NotNull String key) {
        kotlin.jvm.internal.s.e(key, "key");
        return INSTANCE.hashWithAlgorithm("SHA-1", key);
    }

    @JvmStatic
    @Nullable
    public static final String sha256hash(@Nullable String key) {
        if (key == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", key);
    }

    @JvmStatic
    public static final boolean stringsEqualOrEmpty(@Nullable String a2, @Nullable String b2) {
        boolean z2 = a2 == null || a2.length() == 0;
        boolean z3 = b2 == null || b2.length() == 0;
        if (z2 && z3) {
            return true;
        }
        if (z2 || z3) {
            return false;
        }
        return kotlin.jvm.internal.s.a(a2, b2);
    }

    @JvmStatic
    @Nullable
    public static final JSONArray tryGetJSONArrayFromResponse(@Nullable JSONObject response, @Nullable String propertyKey) {
        if (response == null) {
            return null;
        }
        return response.optJSONArray(propertyKey);
    }

    @JvmStatic
    @Nullable
    public static final JSONObject tryGetJSONObjectFromResponse(@Nullable JSONObject response, @Nullable String propertyKey) {
        if (response == null) {
            return null;
        }
        return response.optJSONObject(propertyKey);
    }

    @JvmStatic
    public static final void writeNonnullStringMapToParcel(@NotNull Parcel parcel, @Nullable Map<String, String> map) {
        kotlin.jvm.internal.s.e(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    @JvmStatic
    public static final void writeStringMapToParcel(@NotNull Parcel parcel, @Nullable Map<String, String> map) {
        kotlin.jvm.internal.s.e(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    @JvmStatic
    @Nullable
    public static final Method getMethodQuietly(@NotNull String className, @NotNull String methodName, @NotNull Class<?>... parameterTypes) throws ClassNotFoundException {
        kotlin.jvm.internal.s.e(className, "className");
        kotlin.jvm.internal.s.e(methodName, "methodName");
        kotlin.jvm.internal.s.e(parameterTypes, "parameterTypes");
        try {
            Class<?> clazz = Class.forName(className);
            kotlin.jvm.internal.s.d(clazz, "clazz");
            return getMethodQuietly(clazz, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String hashWithAlgorithm(String algorithm, byte[] bytes) throws NoSuchAlgorithmException {
        try {
            MessageDigest hash = MessageDigest.getInstance(algorithm);
            kotlin.jvm.internal.s.d(hash, "hash");
            return hashBytes(hash, bytes);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(@Nullable String s2) {
        if (s2 != null) {
            if (!(s2.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    @Nullable
    public static final String sha1hash(@NotNull byte[] bytes) {
        kotlin.jvm.internal.s.e(bytes, "bytes");
        return INSTANCE.hashWithAlgorithm("SHA-1", bytes);
    }

    @JvmStatic
    @Nullable
    public static final String sha256hash(@Nullable byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", bytes);
    }

    @JvmStatic
    public static final void logd(@Nullable String str, @Nullable String str2) {
        if (!FacebookSdk.isDebugEnabled() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    @JvmStatic
    public static final void logd(@Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (!FacebookSdk.isDebugEnabled() || isNullOrEmpty(str)) {
            return;
        }
        Log.d(str, str2, th);
    }
}
