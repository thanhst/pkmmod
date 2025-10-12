package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.bolts.AppLinks;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NativeProtocol.kt */
@Metadata(bv = {}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u000eÛ\u0001Ü\u0001Ý\u0001Þ\u0001ß\u0001à\u0001á\u0001B\u000b\b\u0002¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0007J&\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0007J|\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014H\u0007J¢\u0001\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0002Jª\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010)\u001a\u00020(H\u0007J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010*\u001a\u00020(H\u0007J:\u00102\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u000100H\u0007J6\u00105\u001a\u0002042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\u00072\u0006\u0010*\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000100H\u0007J&\u0010:\u001a\u0004\u0018\u00010\u000b2\u0006\u00106\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u0001002\b\u00109\u001a\u0004\u0018\u000108H\u0007J\u0012\u0010;\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010<\u001a\u00020(2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0014\u0010>\u001a\u0004\u0018\u00010=2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010?\u001a\u0004\u0018\u0001002\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0012\u0010@\u001a\u0004\u0018\u0001002\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0012\u0010B\u001a\u0004\u0018\u0001002\u0006\u0010A\u001a\u00020\u000bH\u0007J\u0010\u0010C\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u000bH\u0007J\u0012\u0010D\u001a\u0004\u0018\u0001002\u0006\u0010A\u001a\u00020\u000bH\u0007J\u0014\u0010F\u001a\u0004\u0018\u0001082\b\u0010E\u001a\u0004\u0018\u000100H\u0007J\u0014\u0010H\u001a\u0004\u0018\u0001002\b\u0010G\u001a\u0004\u0018\u000108H\u0007J\u0010\u0010J\u001a\u00020(2\u0006\u0010I\u001a\u00020(H\u0007J\u0018\u0010M\u001a\u00020.2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010L\u001a\u00020KH\u0007J \u0010O\u001a\u00020.2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010L\u001a\u00020KH\u0002J\b\u0010P\u001a\u000204H\u0007J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020(0Q2\u0006\u0010\r\u001a\u00020\u0003H\u0002J(\u0010U\u001a\u00020(2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010Q2\u0006\u0010T\u001a\u00020(2\u0006\u0010L\u001a\u00020KH\u0007J\u0010\u0010W\u001a\u00020V2\u0006\u0010\r\u001a\u00020\u0003H\u0002R\u0014\u0010X\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010[\u001a\n Z*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010\\R\u0014\u0010^\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b^\u0010\\R\u0014\u0010_\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010\\R\u0014\u0010`\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010\\R\u0014\u0010a\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010\\R\u0014\u0010b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\bb\u0010\\R\u0014\u0010c\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\bc\u0010\\R\u0014\u0010d\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\bd\u0010\\R\u0014\u0010e\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\be\u0010YR\u0014\u0010f\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bf\u0010YR\u0014\u0010g\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bg\u0010YR\u0014\u0010h\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bh\u0010YR\u0014\u0010i\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bi\u0010YR\u0014\u0010j\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bj\u0010YR\u0014\u0010k\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bk\u0010YR\u0014\u0010l\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bl\u0010YR\u0014\u0010m\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bm\u0010YR\u0014\u0010n\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bn\u0010YR\u0014\u0010o\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bo\u0010YR\u0014\u0010p\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bp\u0010YR\u0014\u0010q\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bq\u0010YR\u0014\u0010r\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\br\u0010YR\u0014\u0010s\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bs\u0010YR\u0014\u0010t\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bt\u0010YR\u0014\u0010u\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bu\u0010YR\u0014\u0010v\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bv\u0010YR\u0014\u0010w\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bw\u0010YR\u0014\u0010x\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bx\u0010YR\u0014\u0010y\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\by\u0010YR\u0014\u0010z\u001a\u00020(8\u0006X\u0086T¢\u0006\u0006\n\u0004\bz\u0010YR\u0014\u0010{\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b{\u0010\\R\u0014\u0010|\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b|\u0010\\R\u0014\u0010}\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b}\u0010\\R\u0014\u0010~\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b~\u0010\\R\u0014\u0010\u007f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u007f\u0010\\R\u0016\u0010\u0080\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\\R\u0016\u0010\u0081\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\\R\u0016\u0010\u0082\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\\R\u0016\u0010\u0083\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010\\R\u0016\u0010\u0084\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010\\R\u0016\u0010\u0085\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010\\R\u0016\u0010\u0086\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010\\R\u0016\u0010\u0087\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010\\R\u0016\u0010\u0088\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010\\R\u0016\u0010\u0089\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010YR\u0016\u0010\u008a\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010YR\u0016\u0010\u008b\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010YR\u0016\u0010\u008c\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010YR\u0016\u0010\u008d\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010YR\u0016\u0010\u008e\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010YR\u0016\u0010\u008f\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010YR\u0016\u0010\u0090\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010YR\u0016\u0010\u0091\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010YR\u0016\u0010\u0092\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010YR\u0016\u0010\u0093\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010YR\u0016\u0010\u0094\u0001\u001a\u00020(8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010YR\u0016\u0010\u0095\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010\\R\u0016\u0010\u0096\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010\\R\u0016\u0010\u0097\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010\\R\u0016\u0010\u0098\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010\\R\u0016\u0010\u0099\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010\\R\u0016\u0010\u009a\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010\\R\u0016\u0010\u009b\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010\\R\u0016\u0010\u009c\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010\\R\u0016\u0010\u009d\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010\\R\u0016\u0010\u009e\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010\\R\u0016\u0010\u009f\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010\\R\u0016\u0010 \u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b \u0001\u0010\\R\u0016\u0010¡\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¡\u0001\u0010\\R\u0016\u0010¢\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¢\u0001\u0010\\R\u0016\u0010£\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b£\u0001\u0010\\R\u0016\u0010¤\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¤\u0001\u0010\\R\u0016\u0010¥\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¥\u0001\u0010\\R\u0016\u0010¦\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¦\u0001\u0010\\R\u0016\u0010§\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b§\u0001\u0010\\R\u0016\u0010¨\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¨\u0001\u0010\\R\u0016\u0010©\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b©\u0001\u0010\\R\u0016\u0010ª\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bª\u0001\u0010\\R\u0016\u0010«\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b«\u0001\u0010\\R\u0016\u0010¬\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¬\u0001\u0010\\R\u0016\u0010\u00ad\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010\\R\u0016\u0010®\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b®\u0001\u0010\\R\u0016\u0010¯\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¯\u0001\u0010\\R\u0016\u0010°\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b°\u0001\u0010\\R\u0016\u0010±\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b±\u0001\u0010\\R\u0016\u0010²\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b²\u0001\u0010\\R\u0016\u0010³\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b³\u0001\u0010\\R\u0016\u0010´\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b´\u0001\u0010\\R\u0016\u0010µ\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bµ\u0001\u0010\\R\u0016\u0010¶\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¶\u0001\u0010\\R\u0016\u0010·\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b·\u0001\u0010\\R\u0016\u0010¸\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¸\u0001\u0010\\R\u0016\u0010¹\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¹\u0001\u0010\\R\u0016\u0010º\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bº\u0001\u0010\\R\u0016\u0010»\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b»\u0001\u0010\\R\u0016\u0010¼\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¼\u0001\u0010\\R\u0016\u0010½\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b½\u0001\u0010\\R\u0016\u0010¾\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¾\u0001\u0010\\R\u0016\u0010¿\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\b¿\u0001\u0010\\R\u0016\u0010À\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÀ\u0001\u0010\\R\u0016\u0010Á\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÁ\u0001\u0010\\R\u0016\u0010Â\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÂ\u0001\u0010\\R\u0016\u0010Ã\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÃ\u0001\u0010\\R\u0016\u0010Ä\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÄ\u0001\u0010\\R\u0016\u0010Å\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÅ\u0001\u0010\\R\u0016\u0010Æ\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÆ\u0001\u0010\\R\u0016\u0010Ç\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÇ\u0001\u0010\\R\u0016\u0010È\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÈ\u0001\u0010\\R\u0016\u0010É\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0007\n\u0005\bÉ\u0001\u0010\\R\u0016\u0010Ê\u0001\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0007\n\u0005\bÊ\u0001\u0010\\R\u0016\u0010Ë\u0001\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0007\n\u0005\bË\u0001\u0010\\R\u0016\u0010Ì\u0001\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0007\n\u0005\bÌ\u0001\u0010\\R\u0016\u0010Í\u0001\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0007\n\u0005\bÍ\u0001\u0010\\R\u001d\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001d\u0010Ð\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ï\u0001R)\u0010Ñ\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ô\u0001\u001a\u00030Ó\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u001e\u0010×\u0001\u001a\t\u0012\u0004\u0012\u00020(0Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001¨\u0006â\u0001"}, d2 = {"Lcom/facebook/internal/NativeProtocol;", "", "", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "buildFacebookAppList", "buildEffectCameraAppInfoList", "", "", "buildActionToAppInfoMap", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "appInfo", "validateActivityIntent", "validateServiceIntent", "applicationId", "", "permissions", "e2e", "", "isRerequest", "isForPublish", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "clientState", "authType", "messengerPageId", "resetMessengerState", "isFamilyLogin", "shouldSkipAccountDedupe", "createInstagramIntent", "ignoreAppSwitchToLoggedOut", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "nonce", "codeChallenge", "codeChallengeMethod", "createNativeAppIntent", "createProxyAuthIntents", "", "getLatestKnownVersion", "version", "isVersionCompatibleWithBucketedIntent", "callId", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "versionResult", "Landroid/os/Bundle;", AppLinks.KEY_NAME_EXTRAS, "createPlatformActivityIntent", NativeProtocol.WEB_DIALOG_PARAMS, "Lkotlin/t;", "setupProtocolRequestIntent", "requestIntent", "results", "Lcom/facebook/FacebookException;", "error", "createProtocolResultIntent", "createPlatformServiceIntent", "getProtocolVersionFromIntent", "Ljava/util/UUID;", "getCallIdFromIntent", "getBridgeArgumentsFromIntent", "getMethodArgumentsFromIntent", "resultIntent", "getSuccessResultsFromIntent", "isErrorResult", "getErrorDataFromResultIntent", "errorData", "getExceptionFromErrorData", "e", "createBundleForException", "minimumVersion", "getLatestAvailableProtocolVersionForService", "", "versionSpec", "getLatestAvailableProtocolVersionForAction", "appInfoList", "getLatestAvailableProtocolVersionForAppInfoList", "updateAllAvailableProtocolVersionsAsync", "Ljava/util/TreeSet;", "fetchAllAvailableProtocolVersionsForAppInfo", "allAvailableFacebookAppVersions", "latestSdkVersion", "computeLatestAvailableVersionFromVersionSpec", "Landroid/net/Uri;", "buildPlatformProviderVersionURI", "NO_PROTOCOL_AVAILABLE", "I", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "FACEBOOK_PROXY_AUTH_ACTIVITY", "FACEBOOK_TOKEN_REFRESH_ACTIVITY", "FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY", "FACEBOOK_PROXY_AUTH_APP_ID_KEY", "FACEBOOK_PROXY_AUTH_E2E_KEY", "FACEBOOK_SDK_VERSION_KEY", "INTENT_ACTION_PLATFORM_ACTIVITY", "INTENT_ACTION_PLATFORM_SERVICE", "PROTOCOL_VERSION_20121101", "PROTOCOL_VERSION_20130502", "PROTOCOL_VERSION_20130618", "PROTOCOL_VERSION_20131024", "PROTOCOL_VERSION_20131107", "PROTOCOL_VERSION_20140204", "PROTOCOL_VERSION_20140313", "PROTOCOL_VERSION_20140324", "PROTOCOL_VERSION_20140701", "PROTOCOL_VERSION_20141001", "PROTOCOL_VERSION_20141028", "PROTOCOL_VERSION_20141107", "PROTOCOL_VERSION_20141218", "PROTOCOL_VERSION_20150401", "PROTOCOL_VERSION_20150702", "PROTOCOL_VERSION_20160327", "PROTOCOL_VERSION_20161017", "PROTOCOL_VERSION_20170213", "PROTOCOL_VERSION_20170411", "PROTOCOL_VERSION_20170417", "PROTOCOL_VERSION_20171115", "PROTOCOL_VERSION_20210906", "EXTRA_PROTOCOL_VERSION", "EXTRA_PROTOCOL_ACTION", "EXTRA_PROTOCOL_CALL_ID", "EXTRA_GET_INSTALL_DATA_PACKAGE", "EXTRA_PROTOCOL_BRIDGE_ARGS", "EXTRA_PROTOCOL_METHOD_ARGS", "EXTRA_PROTOCOL_METHOD_RESULTS", "BRIDGE_ARG_APP_NAME_STRING", "BRIDGE_ARG_ACTION_ID_STRING", "BRIDGE_ARG_ERROR_BUNDLE", "EXTRA_DIALOG_COMPLETE_KEY", "EXTRA_DIALOG_COMPLETION_GESTURE_KEY", "RESULT_ARGS_DIALOG_COMPLETE_KEY", "RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY", "MESSAGE_GET_ACCESS_TOKEN_REQUEST", "MESSAGE_GET_ACCESS_TOKEN_REPLY", "MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST", "MESSAGE_GET_PROTOCOL_VERSIONS_REPLY", "MESSAGE_GET_INSTALL_DATA_REQUEST", "MESSAGE_GET_INSTALL_DATA_REPLY", "MESSAGE_GET_LIKE_STATUS_REQUEST", "MESSAGE_GET_LIKE_STATUS_REPLY", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY", "MESSAGE_GET_LOGIN_STATUS_REQUEST", "MESSAGE_GET_LOGIN_STATUS_REPLY", "EXTRA_PROTOCOL_VERSIONS", "ACTION_FEED_DIALOG", "ACTION_MESSAGE_DIALOG", "ACTION_OGACTIONPUBLISH_DIALOG", "ACTION_OGMESSAGEPUBLISH_DIALOG", "ACTION_LIKE_DIALOG", "ACTION_APPINVITE_DIALOG", "ACTION_CAMERA_EFFECT", "ACTION_SHARE_STORY", "EXTRA_PERMISSIONS", "EXTRA_APPLICATION_ID", "EXTRA_APPLICATION_NAME", "EXTRA_USER_ID", "EXTRA_LOGGER_REF", "EXTRA_TOAST_DURATION_MS", "EXTRA_GRAPH_API_VERSION", "EXTRA_NONCE", "EXTRA_ACCESS_TOKEN", "EXTRA_EXPIRES_SECONDS_SINCE_EPOCH", "EXTRA_DATA_ACCESS_EXPIRATION_TIME", "EXTRA_AUTHENTICATION_TOKEN", "RESULT_ARGS_ACCESS_TOKEN", "RESULT_ARGS_GRAPH_DOMAIN", "RESULT_ARGS_SIGNED_REQUEST", "RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH", "RESULT_ARGS_PERMISSIONS", "OPEN_GRAPH_CREATE_OBJECT_KEY", "IMAGE_USER_GENERATED_KEY", "IMAGE_URL_KEY", "STATUS_ERROR_TYPE", "STATUS_ERROR_DESCRIPTION", "STATUS_ERROR_CODE", "STATUS_ERROR_SUBCODE", "STATUS_ERROR_JSON", "BRIDGE_ARG_ERROR_TYPE", "BRIDGE_ARG_ERROR_DESCRIPTION", "BRIDGE_ARG_ERROR_CODE", "BRIDGE_ARG_ERROR_SUBCODE", "BRIDGE_ARG_ERROR_JSON", "ERROR_UNKNOWN_ERROR", "ERROR_PROTOCOL_ERROR", "ERROR_USER_CANCELED", "ERROR_APPLICATION_ERROR", "ERROR_NETWORK_ERROR", "ERROR_PERMISSION_DENIED", "ERROR_SERVICE_DISABLED", "WEB_DIALOG_URL", "WEB_DIALOG_ACTION", "WEB_DIALOG_PARAMS", "WEB_DIALOG_IS_FALLBACK", "AUDIENCE_ME", "AUDIENCE_FRIENDS", "AUDIENCE_EVERYONE", "CONTENT_SCHEME", "PLATFORM_PROVIDER", "PLATFORM_PROVIDER_VERSIONS", "PLATFORM_PROVIDER_VERSION_COLUMN", "facebookAppInfoList", "Ljava/util/List;", "effectCameraAppInfoList", "actionToAppInfoMap", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "protocolVersionsAsyncUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "KNOWN_PROTOCOL_VERSIONS", "[Ljava/lang/Integer;", "<init>", "()V", "EffectTestAppInfo", "InstagramAppInfo", "KatanaAppInfo", "MessengerAppInfo", "NativeAppInfo", "ProtocolVersionQueryResult", "WakizashiAppInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NativeProtocol {

    @NotNull
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";

    @NotNull
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";

    @NotNull
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";

    @NotNull
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";

    @NotNull
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";

    @NotNull
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";

    @NotNull
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";

    @NotNull
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";

    @NotNull
    public static final String AUDIENCE_EVERYONE = "everyone";

    @NotNull
    public static final String AUDIENCE_FRIENDS = "friends";

    @NotNull
    public static final String AUDIENCE_ME = "only_me";

    @NotNull
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";

    @NotNull
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";

    @NotNull
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";

    @NotNull
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";

    @NotNull
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";

    @NotNull
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";

    @NotNull
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";

    @NotNull
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";

    @NotNull
    private static final String CONTENT_SCHEME = "content://";

    @NotNull
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";

    @NotNull
    public static final String ERROR_NETWORK_ERROR = "NetworkError";

    @NotNull
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";

    @NotNull
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";

    @NotNull
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";

    @NotNull
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";

    @NotNull
    public static final String ERROR_USER_CANCELED = "UserCanceled";

    @NotNull
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";

    @NotNull
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";

    @NotNull
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";

    @NotNull
    public static final String EXTRA_AUTHENTICATION_TOKEN = "com.facebook.platform.extra.ID_TOKEN";

    @NotNull
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";

    @NotNull
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";

    @NotNull
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";

    @NotNull
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";

    @NotNull
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";

    @NotNull
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";

    @NotNull
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";

    @NotNull
    public static final String EXTRA_NONCE = "com.facebook.platform.extra.NONCE";

    @NotNull
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";

    @NotNull
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";

    @NotNull
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";

    @NotNull
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";

    @NotNull
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";

    @NotNull
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";

    @NotNull
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";

    @NotNull
    public static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";

    @NotNull
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";

    @NotNull
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";

    @NotNull
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";

    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";

    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";

    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";

    @NotNull
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";

    @NotNull
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";

    @NotNull
    public static final String IMAGE_URL_KEY = "url";

    @NotNull
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";

    @NotNull
    public static final NativeProtocol INSTANCE;

    @NotNull
    public static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";

    @NotNull
    public static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";

    @NotNull
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;

    @NotNull
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";

    @NotNull
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";

    @NotNull
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";

    @NotNull
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131024 = 20131024;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140313 = 20140313;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20150401 = 20150401;
    public static final int PROTOCOL_VERSION_20150702 = 20150702;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20161017 = 20161017;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final int PROTOCOL_VERSION_20210906 = 20210906;

    @NotNull
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";

    @NotNull
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";

    @NotNull
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";

    @NotNull
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";

    @NotNull
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";

    @NotNull
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";

    @NotNull
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";

    @NotNull
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";

    @NotNull
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";

    @NotNull
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";

    @NotNull
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";

    @NotNull
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static final String TAG;

    @NotNull
    public static final String WEB_DIALOG_ACTION = "action";

    @NotNull
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";

    @NotNull
    public static final String WEB_DIALOG_PARAMS = "params";

    @NotNull
    public static final String WEB_DIALOG_URL = "url";

    @NotNull
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;

    @NotNull
    private static final List<NativeAppInfo> effectCameraAppInfoList;

    @NotNull
    private static final List<NativeAppInfo> facebookAppInfoList;

    @NotNull
    private static final AtomicBoolean protocolVersionsAsyncUpdating;

    /* compiled from: NativeProtocol.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$EffectTestAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class EffectTestAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m108getLoginActivity();
        }

        @Nullable
        /* renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m108getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }
    }

    /* compiled from: NativeProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$InstagramAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class InstagramAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.instagram.android";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES;
        }
    }

    /* compiled from: NativeProtocol.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/NativeProtocol$KatanaAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "isAndroidAPIVersionNotLessThan30", "", "getLoginActivity", "getPackage", "Lkotlin/t;", "onAvailableVersionsNullOrEmpty", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class KatanaAppInfo extends NativeAppInfo {
        private final boolean isAndroidAPIVersionNotLessThan30() {
            return FacebookSdk.getApplicationContext().getApplicationInfo().targetSdkVersion >= 30;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.facebook.katana";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public void onAvailableVersionsNullOrEmpty() {
            if (isAndroidAPIVersionNotLessThan30()) {
                Log.w(NativeProtocol.access$getTAG$p(), "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    /* compiled from: NativeProtocol.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$MessengerAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class MessengerAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m109getLoginActivity();
        }

        @Nullable
        /* renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m109getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.facebook.orca";
        }
    }

    /* compiled from: NativeProtocol.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "", "getPackage", "getLoginActivity", "getResponseType", "Lkotlin/t;", "onAvailableVersionsNullOrEmpty", "Ljava/util/TreeSet;", "", "getAvailableVersions", "", "force", "fetchAvailableVersions", "availableVersions", "Ljava/util/TreeSet;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static abstract class NativeAppInfo {

        @Nullable
        private TreeSet<Integer> availableVersions;

        /* JADX WARN: Removed duplicated region for block: B:11:0x001b A[Catch: all -> 0x0038, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0013, B:12:0x0023, B:14:0x0027, B:20:0x0033, B:8:0x000b, B:11:0x001b), top: B:26:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0033 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0013, B:12:0x0023, B:14:0x0027, B:20:0x0033, B:8:0x000b, B:11:0x001b), top: B:26:0x0003 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized void fetchAvailableVersions(boolean r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                if (r2 != 0) goto L1b
                java.util.TreeSet<java.lang.Integer> r2 = r1.availableVersions     // Catch: java.lang.Throwable -> L38
                if (r2 == 0) goto L1b
                if (r2 != 0) goto Lb
                r2 = 0
                goto L13
            Lb:
                boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L38
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L38
            L13:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L38
                boolean r2 = kotlin.jvm.internal.s.a(r2, r0)     // Catch: java.lang.Throwable -> L38
                if (r2 != 0) goto L23
            L1b:
                com.facebook.internal.NativeProtocol r2 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch: java.lang.Throwable -> L38
                java.util.TreeSet r2 = com.facebook.internal.NativeProtocol.access$fetchAllAvailableProtocolVersionsForAppInfo(r2, r1)     // Catch: java.lang.Throwable -> L38
                r1.availableVersions = r2     // Catch: java.lang.Throwable -> L38
            L23:
                java.util.TreeSet<java.lang.Integer> r2 = r1.availableVersions     // Catch: java.lang.Throwable -> L38
                if (r2 == 0) goto L30
                boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L38
                if (r2 == 0) goto L2e
                goto L30
            L2e:
                r2 = 0
                goto L31
            L30:
                r2 = 1
            L31:
                if (r2 == 0) goto L36
                r1.onAvailableVersionsNullOrEmpty()     // Catch: java.lang.Throwable -> L38
            L36:
                monitor-exit(r1)
                return
            L38:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.util.TreeSet<java.lang.Integer> getAvailableVersions() {
            /*
                r2 = this;
                java.util.TreeSet<java.lang.Integer> r0 = r2.availableVersions
                if (r0 == 0) goto L18
                if (r0 != 0) goto L8
                r0 = 0
                goto L10
            L8:
                boolean r0 = r0.isEmpty()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            L10:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                boolean r0 = kotlin.jvm.internal.s.a(r0, r1)
                if (r0 != 0) goto L1c
            L18:
                r0 = 0
                r2.fetchAvailableVersions(r0)
            L1c:
                java.util.TreeSet<java.lang.Integer> r0 = r2.availableVersions
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.getAvailableVersions():java.util.TreeSet");
        }

        @Nullable
        public abstract String getLoginActivity();

        @NotNull
        public abstract String getPackage();

        @NotNull
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST;
        }

        public void onAvailableVersionsNullOrEmpty() {
        }
    }

    /* compiled from: NativeProtocol.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "", "()V", "<set-?>", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "appInfo", "getAppInfo", "()Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "protocolVersion", "getProtocolVersion", "()I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProtocolVersionQueryResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @Nullable
        private NativeAppInfo appInfo;
        private int protocolVersion;

        /* compiled from: NativeProtocol.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult$Companion;", "", "()V", "create", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "nativeAppInfo", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "protocolVersion", "", "createEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
                this();
            }

            @JvmStatic
            @NotNull
            public final ProtocolVersionQueryResult create(@Nullable NativeAppInfo nativeAppInfo, int protocolVersion) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.appInfo = nativeAppInfo;
                protocolVersionQueryResult.protocolVersion = protocolVersion;
                return protocolVersionQueryResult;
            }

            @JvmStatic
            @NotNull
            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }
        }

        private ProtocolVersionQueryResult() {
        }

        public /* synthetic */ ProtocolVersionQueryResult(kotlin.jvm.internal.o oVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public static final ProtocolVersionQueryResult create(@Nullable NativeAppInfo nativeAppInfo, int i2) {
            return INSTANCE.create(nativeAppInfo, i2);
        }

        @JvmStatic
        @NotNull
        public static final ProtocolVersionQueryResult createEmpty() {
            return INSTANCE.createEmpty();
        }

        @Nullable
        public final NativeAppInfo getAppInfo() {
            return this.appInfo;
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }
    }

    /* compiled from: NativeProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/NativeProtocol$WakizashiAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class WakizashiAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        @NotNull
        public String getPackage() {
            return RemoteServiceWrapper.RECEIVER_SERVICE_PACKAGE_WAKIZASHI;
        }
    }

    static {
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        TAG = NativeProtocol.class.getName();
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        effectCameraAppInfoList = nativeProtocol.buildEffectCameraAppInfoList();
        actionToAppInfoMap = nativeProtocol.buildActionToAppInfoMap();
        protocolVersionsAsyncUpdating = new AtomicBoolean(false);
        KNOWN_PROTOCOL_VERSIONS = new Integer[]{Integer.valueOf(PROTOCOL_VERSION_20210906), Integer.valueOf(PROTOCOL_VERSION_20171115), Integer.valueOf(PROTOCOL_VERSION_20170417), Integer.valueOf(PROTOCOL_VERSION_20170411), Integer.valueOf(PROTOCOL_VERSION_20170213), Integer.valueOf(PROTOCOL_VERSION_20161017), Integer.valueOf(PROTOCOL_VERSION_20160327), Integer.valueOf(PROTOCOL_VERSION_20150702), Integer.valueOf(PROTOCOL_VERSION_20150401), Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140313), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20131024), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)};
    }

    private NativeProtocol() {
    }

    public static final /* synthetic */ TreeSet access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol nativeProtocol, NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessengerAppInfo());
            List<NativeAppInfo> list = facebookAppInfoList;
            map.put(ACTION_OGACTIONPUBLISH_DIALOG, list);
            map.put(ACTION_FEED_DIALOG, list);
            map.put(ACTION_LIKE_DIALOG, list);
            map.put(ACTION_APPINVITE_DIALOG, list);
            map.put(ACTION_MESSAGE_DIALOG, arrayList);
            map.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
            map.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
            map.put(ACTION_SHARE_STORY, list);
            return map;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildEffectCameraAppInfoList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayListF = kotlin.collections.u.f(new EffectTestAppInfo());
            arrayListF.addAll(buildFacebookAppList());
            return arrayListF;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildFacebookAppList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return kotlin.collections.u.f(new KatanaAppInfo(), new WakizashiAppInfo());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo appInfo) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Uri uri = Uri.parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
            kotlin.jvm.internal.s.d(uri, "parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS)");
            return uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final int computeLatestAvailableVersionFromVersionSpec(@Nullable TreeSet<Integer> allAvailableFacebookAppVersions, int latestSdkVersion, @NotNull int[] versionSpec) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            kotlin.jvm.internal.s.e(versionSpec, "versionSpec");
            if (allAvailableFacebookAppVersions == null) {
                return -1;
            }
            int length = versionSpec.length - 1;
            Iterator<Integer> itDescendingIterator = allAvailableFacebookAppVersions.descendingIterator();
            int iMax = -1;
            while (itDescendingIterator.hasNext()) {
                Integer fbAppVersion = itDescendingIterator.next();
                kotlin.jvm.internal.s.d(fbAppVersion, "fbAppVersion");
                iMax = Math.max(iMax, fbAppVersion.intValue());
                while (length >= 0 && versionSpec[length] > fbAppVersion.intValue()) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (versionSpec[length] == fbAppVersion.intValue()) {
                    if (length % 2 == 0) {
                        return Math.min(iMax, latestSdkVersion);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @JvmStatic
    @Nullable
    public static final Bundle createBundleForException(@Nullable FacebookException e2) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || e2 == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, e2.toString());
            if (e2 instanceof FacebookOperationCanceledException) {
                bundle.putString(BRIDGE_ARG_ERROR_TYPE, ERROR_USER_CANCELED);
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Intent createInstagramIntent(@NotNull Context context, @NotNull String applicationId, @NotNull Collection<String> permissions, @NotNull String e2e, boolean isRerequest, boolean isForPublish, @NotNull DefaultAudience defaultAudience, @NotNull String clientState, @NotNull String authType, @Nullable String messengerPageId, boolean resetMessengerState, boolean isFamilyLogin, boolean shouldSkipAccountDedupe) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(context, "context");
            kotlin.jvm.internal.s.e(applicationId, "applicationId");
            kotlin.jvm.internal.s.e(permissions, "permissions");
            kotlin.jvm.internal.s.e(e2e, "e2e");
            kotlin.jvm.internal.s.e(defaultAudience, "defaultAudience");
            kotlin.jvm.internal.s.e(clientState, "clientState");
            kotlin.jvm.internal.s.e(authType, "authType");
            InstagramAppInfo instagramAppInfo = new InstagramAppInfo();
            return validateActivityIntent(context, INSTANCE.createNativeAppIntent(instagramAppInfo, applicationId, permissions, e2e, isForPublish, defaultAudience, clientState, authType, false, messengerPageId, resetMessengerState, LoginTargetApp.INSTAGRAM, isFamilyLogin, shouldSkipAccountDedupe, "", null, null), instagramAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Intent createNativeAppIntent(NativeAppInfo appInfo, String applicationId, Collection<String> permissions, String e2e, boolean isForPublish, DefaultAudience defaultAudience, String clientState, String authType, boolean ignoreAppSwitchToLoggedOut, String messengerPageId, boolean resetMessengerState, LoginTargetApp targetApp, boolean isFamilyLogin, boolean shouldSkipAccountDedupe, String nonce, String codeChallenge, String codeChallengeMethod) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String loginActivity = appInfo.getLoginActivity();
            if (loginActivity == null) {
                return null;
            }
            Intent intentPutExtra = new Intent().setClassName(appInfo.getPackage(), loginActivity).putExtra("client_id", applicationId);
            kotlin.jvm.internal.s.d(intentPutExtra, "Intent()\n            .setClassName(appInfo.getPackage(), activityName)\n            .putExtra(FACEBOOK_PROXY_AUTH_APP_ID_KEY, applicationId)");
            intentPutExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
            if (!Utility.isNullOrEmpty(permissions)) {
                intentPutExtra.putExtra("scope", TextUtils.join(",", permissions));
            }
            if (!Utility.isNullOrEmpty(e2e)) {
                intentPutExtra.putExtra("e2e", e2e);
            }
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_STATE, clientState);
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, appInfo.getResponseType());
            intentPutExtra.putExtra("nonce", nonce);
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            if (isForPublish) {
                intentPutExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
            }
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, authType);
            if (ignoreAppSwitchToLoggedOut) {
                intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_FAIL_ON_LOGGED_OUT, true);
            }
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_MESSENGER_PAGE_ID, messengerPageId);
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESET_MESSENGER_STATE, resetMessengerState);
            if (isFamilyLogin) {
                intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_FX_APP, targetApp.getTargetApp());
            }
            if (shouldSkipAccountDedupe) {
                intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, true);
            }
            return intentPutExtra;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Intent createPlatformActivityIntent(@NotNull Context context, @Nullable String callId, @Nullable String action, @Nullable ProtocolVersionQueryResult versionResult, @Nullable Bundle extras) {
        NativeAppInfo appInfo;
        Intent intentValidateActivityIntent;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(context, "context");
            if (versionResult == null || (appInfo = versionResult.getAppInfo()) == null || (intentValidateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), appInfo)) == null) {
                return null;
            }
            setupProtocolRequestIntent(intentValidateActivityIntent, callId, action, versionResult.getProtocolVersion(), extras);
            return intentValidateActivityIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Intent createPlatformServiceIntent(@NotNull Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(context, "context");
            for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
                Intent intentValidateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
                if (intentValidateServiceIntent != null) {
                    return intentValidateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Intent createProtocolResultIntent(@NotNull Intent requestIntent, @Nullable Bundle results, @Nullable FacebookException error) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(requestIntent, "requestIntent");
            UUID callIdFromIntent = getCallIdFromIntent(requestIntent);
            if (callIdFromIntent == null) {
                return null;
            }
            Intent intent = new Intent();
            intent.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(requestIntent));
            Bundle bundle = new Bundle();
            bundle.putString("action_id", callIdFromIntent.toString());
            if (error != null) {
                bundle.putBundle("error", createBundleForException(error));
            }
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle);
            if (results != null) {
                intent.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, results);
            }
            return intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final List<Intent> createProxyAuthIntents(@Nullable Context context, @NotNull String applicationId, @NotNull Collection<String> permissions, @NotNull String e2e, boolean isRerequest, boolean isForPublish, @NotNull DefaultAudience defaultAudience, @NotNull String clientState, @NotNull String authType, boolean ignoreAppSwitchToLoggedOut, @Nullable String messengerPageId, boolean resetMessengerState, boolean isFamilyLogin, boolean shouldSkipAccountDedupe, @Nullable String nonce, @Nullable String codeChallenge, @Nullable String codeChallengeMethod) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(applicationId, "applicationId");
            kotlin.jvm.internal.s.e(permissions, "permissions");
            kotlin.jvm.internal.s.e(e2e, "e2e");
            kotlin.jvm.internal.s.e(defaultAudience, "defaultAudience");
            kotlin.jvm.internal.s.e(clientState, "clientState");
            kotlin.jvm.internal.s.e(authType, "authType");
            List<NativeAppInfo> list = facebookAppInfoList;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                Intent intentCreateNativeAppIntent = INSTANCE.createNativeAppIntent((NativeAppInfo) it.next(), applicationId, permissions, e2e, isForPublish, defaultAudience, clientState, authType, ignoreAppSwitchToLoggedOut, messengerPageId, resetMessengerState, LoginTargetApp.FACEBOOK, isFamilyLogin, shouldSkipAccountDedupe, nonce, codeChallenge, codeChallengeMethod);
                if (intentCreateNativeAppIntent != null) {
                    arrayList2.add(intentCreateNativeAppIntent);
                }
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static /* synthetic */ List createProxyAuthIntents$default(Context context, String str, Collection collection, String str2, boolean z2, boolean z3, DefaultAudience defaultAudience, String str3, String str4, boolean z4, String str5, boolean z5, boolean z6, boolean z7, String str6, String str7, String str8, int i2, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return createProxyAuthIntents(context, str, collection, str2, z2, z3, defaultAudience, str3, str4, z4, str5, z5, z6, z7, str6, str7, (i2 & 65536) != 0 ? "S256" : str8);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007d A[Catch: all -> 0x008a, TRY_ENTER, TryCatch #4 {all -> 0x008a, blocks: (B:5:0x000c, B:38:0x0089, B:37:0x0086, B:31:0x007d), top: B:47:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005e A[EXC_TOP_SPLITTER, LOOP:0: B:43:0x005e->B:24:0x0064, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.TreeSet<java.lang.Integer> fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol.NativeAppInfo r13) {
        /*
            r12 = this;
            java.lang.String r0 = "version"
            java.lang.String r1 = "Failed to query content resolver."
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r3 = 0
            if (r2 == 0) goto Lc
            return r3
        Lc:
            java.util.TreeSet r2 = new java.util.TreeSet     // Catch: java.lang.Throwable -> L8a
            r2.<init>()     // Catch: java.lang.Throwable -> L8a
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L8a
            android.content.ContentResolver r5 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L8a
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L8a
            android.net.Uri r6 = r12.buildPlatformProviderVersionURI(r13)     // Catch: java.lang.Throwable -> L8a
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L81
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L81
            java.lang.String r13 = r13.getPackage()     // Catch: java.lang.Throwable -> L81
            java.lang.String r8 = ".provider.PlatformProvider"
            java.lang.String r13 = kotlin.jvm.internal.s.m(r13, r8)     // Catch: java.lang.Throwable -> L81
            r8 = 0
            android.content.pm.ProviderInfo r13 = r4.resolveContentProvider(r13, r8)     // Catch: java.lang.RuntimeException -> L39 java.lang.Throwable -> L81
            goto L40
        L39:
            r13 = move-exception
            java.lang.String r4 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L81
            android.util.Log.e(r4, r1, r13)     // Catch: java.lang.Throwable -> L81
            r13 = r3
        L40:
            if (r13 == 0) goto L79
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.IllegalArgumentException -> L4a java.lang.SecurityException -> L50 java.lang.NullPointerException -> L56 java.lang.Throwable -> L81
            goto L5c
        L4a:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L81
            android.util.Log.e(r13, r1)     // Catch: java.lang.Throwable -> L81
            goto L5b
        L50:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L81
            android.util.Log.e(r13, r1)     // Catch: java.lang.Throwable -> L81
            goto L5b
        L56:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L81
            android.util.Log.e(r13, r1)     // Catch: java.lang.Throwable -> L81
        L5b:
            r13 = r3
        L5c:
            if (r13 == 0) goto L7a
        L5e:
            boolean r1 = r13.moveToNext()     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L7a
            int r1 = r13.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L74
            int r1 = r13.getInt(r1)     // Catch: java.lang.Throwable -> L74
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L74
            r2.add(r1)     // Catch: java.lang.Throwable -> L74
            goto L5e
        L74:
            r0 = move-exception
            r11 = r0
            r0 = r13
            r13 = r11
            goto L83
        L79:
            r13 = r3
        L7a:
            if (r13 != 0) goto L7d
            goto L80
        L7d:
            r13.close()     // Catch: java.lang.Throwable -> L8a
        L80:
            return r2
        L81:
            r13 = move-exception
            r0 = r3
        L83:
            if (r0 != 0) goto L86
            goto L89
        L86:
            r0.close()     // Catch: java.lang.Throwable -> L8a
        L89:
            throw r13     // Catch: java.lang.Throwable -> L8a
        L8a:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol$NativeAppInfo):java.util.TreeSet");
    }

    @JvmStatic
    @Nullable
    public static final Bundle getBridgeArgumentsFromIntent(@NotNull Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(intent, "intent");
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final UUID getCallIdFromIntent(@Nullable Intent intent) {
        String stringExtra;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || intent == null) {
            return null;
        }
        try {
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
            } else {
                stringExtra = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            if (stringExtra == null) {
                return null;
            }
            try {
                return UUID.fromString(stringExtra);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Bundle getErrorDataFromResultIntent(@NotNull Intent resultIntent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(resultIntent, "resultIntent");
            if (!isErrorResult(resultIntent)) {
                return null;
            }
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(resultIntent);
            return bridgeArgumentsFromIntent != null ? bridgeArgumentsFromIntent.getBundle("error") : resultIntent.getExtras();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final FacebookException getExceptionFromErrorData(@Nullable Bundle errorData) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || errorData == null) {
            return null;
        }
        try {
            String string = errorData.getString(BRIDGE_ARG_ERROR_TYPE);
            if (string == null) {
                string = errorData.getString(STATUS_ERROR_TYPE);
            }
            String string2 = errorData.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
            if (string2 == null) {
                string2 = errorData.getString(STATUS_ERROR_DESCRIPTION);
            }
            return (string == null || !kotlin.text.s.l(string, ERROR_USER_CANCELED, true)) ? new FacebookException(string2) : new FacebookOperationCanceledException(string2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(@NotNull String action, @NotNull int[] versionSpec) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(action, "action");
            kotlin.jvm.internal.s.e(versionSpec, "versionSpec");
            List<NativeAppInfo> listH = actionToAppInfoMap.get(action);
            if (listH == null) {
                listH = kotlin.collections.u.h();
            }
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(listH, versionSpec);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> appInfoList, int[] versionSpec) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (appInfoList == null) {
                return ProtocolVersionQueryResult.INSTANCE.createEmpty();
            }
            for (NativeAppInfo nativeAppInfo : appInfoList) {
                int iComputeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), versionSpec);
                if (iComputeLatestAvailableVersionFromVersionSpec != -1) {
                    return ProtocolVersionQueryResult.INSTANCE.create(nativeAppInfo, iComputeLatestAvailableVersionFromVersionSpec);
                }
            }
            return ProtocolVersionQueryResult.INSTANCE.createEmpty();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final int getLatestAvailableProtocolVersionForService(int minimumVersion) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{minimumVersion}).getProtocolVersion();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @JvmStatic
    public static final int getLatestKnownVersion() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return KNOWN_PROTOCOL_VERSIONS[0].intValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @JvmStatic
    @Nullable
    public static final Bundle getMethodArgumentsFromIntent(@NotNull Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(intent, "intent");
            return !isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent)) ? intent.getExtras() : intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final int getProtocolVersionFromIntent(@NotNull Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            kotlin.jvm.internal.s.e(intent, "intent");
            return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @JvmStatic
    @Nullable
    public static final Bundle getSuccessResultsFromIntent(@NotNull Intent resultIntent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(resultIntent, "resultIntent");
            int protocolVersionFromIntent = getProtocolVersionFromIntent(resultIntent);
            Bundle extras = resultIntent.getExtras();
            if (isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) && extras != null) {
                return extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
            }
            return extras;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isErrorResult(@NotNull Intent resultIntent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            kotlin.jvm.internal.s.e(resultIntent, "resultIntent");
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(resultIntent);
            Boolean boolValueOf = bridgeArgumentsFromIntent == null ? null : Boolean.valueOf(bridgeArgumentsFromIntent.containsKey("error"));
            return boolValueOf == null ? resultIntent.hasExtra(STATUS_ERROR_TYPE) : boolValueOf.booleanValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isVersionCompatibleWithBucketedIntent(int version) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            return kotlin.collections.n.k(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(version)) && version >= 20140701;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    @JvmStatic
    public static final void setupProtocolRequestIntent(@NotNull Intent intent, @Nullable String str, @Nullable String str2, int i2, @Nullable Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            kotlin.jvm.internal.s.e(intent, "intent");
            String applicationId = FacebookSdk.getApplicationId();
            String applicationName = FacebookSdk.getApplicationName();
            intent.putExtra(EXTRA_PROTOCOL_VERSION, i2).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
            if (!isVersionCompatibleWithBucketedIntent(i2)) {
                intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
                if (!Utility.isNullOrEmpty(applicationName)) {
                    intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
                }
                if (bundle != null) {
                    intent.putExtras(bundle);
                    return;
                }
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    @JvmStatic
    public static final void updateAllAvailableProtocolVersionsAsync() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeProtocol.m107updateAllAvailableProtocolVersionsAsync$lambda1();
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateAllAvailableProtocolVersionsAsync$lambda-1, reason: not valid java name */
    public static final void m107updateAllAvailableProtocolVersionsAsync$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            try {
                Iterator<NativeAppInfo> it = facebookAppInfoList.iterator();
                while (it.hasNext()) {
                    it.next().fetchAvailableVersions(true);
                }
            } finally {
                protocolVersionsAsyncUpdating.set(false);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    @JvmStatic
    @Nullable
    public static final Intent validateActivityIntent(@NotNull Context context, @Nullable Intent intent, @Nullable NativeAppInfo appInfo) {
        ResolveInfo resolveInfoResolveActivity;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(context, "context");
            if (intent == null || (resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            kotlin.jvm.internal.s.d(str, "resolveInfo.activityInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Intent validateServiceIntent(@NotNull Context context, @Nullable Intent intent, @Nullable NativeAppInfo appInfo) {
        ResolveInfo resolveInfoResolveService;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            kotlin.jvm.internal.s.e(context, "context");
            if (intent == null || (resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveInfoResolveService.serviceInfo.packageName;
            kotlin.jvm.internal.s.d(str, "resolveInfo.serviceInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }
}
