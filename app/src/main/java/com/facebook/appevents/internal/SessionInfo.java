package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SessionInfo.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00058F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\rR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010'\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/facebook/appevents/internal/SessionInfo;", "", "Lkotlin/t;", "incrementInterruptionCount", "writeSessionToDisk", "", "sessionStartTime", "Ljava/lang/Long;", "getSessionStartTime", "()Ljava/lang/Long;", "sessionLastEventTime", "getSessionLastEventTime", "setSessionLastEventTime", "(Ljava/lang/Long;)V", "Ljava/util/UUID;", "sessionId", "Ljava/util/UUID;", "getSessionId", "()Ljava/util/UUID;", "setSessionId", "(Ljava/util/UUID;)V", "", "<set-?>", "interruptionCount", "I", "getInterruptionCount", "()I", "diskRestoreTime", "getDiskRestoreTime", "setDiskRestoreTime", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "sourceApplicationInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "getSourceApplicationInfo", "()Lcom/facebook/appevents/internal/SourceApplicationInfo;", "setSourceApplicationInfo", "(Lcom/facebook/appevents/internal/SourceApplicationInfo;)V", "getSessionLength", "()J", "sessionLength", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/UUID;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SessionInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";

    @NotNull
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";

    @NotNull
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";

    @NotNull
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";

    @Nullable
    private Long diskRestoreTime;
    private int interruptionCount;

    @NotNull
    private UUID sessionId;

    @Nullable
    private Long sessionLastEventTime;

    @Nullable
    private final Long sessionStartTime;

    @Nullable
    private SourceApplicationInfo sourceApplicationInfo;

    /* compiled from: SessionInfo.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/internal/SessionInfo$Companion;", "", "Lcom/facebook/appevents/internal/SessionInfo;", "getStoredSessionInfo", "Lkotlin/t;", "clearSavedSessionFromDisk", "", "INTERRUPTION_COUNT_KEY", "Ljava/lang/String;", "LAST_SESSION_INFO_END_KEY", "LAST_SESSION_INFO_START_KEY", "SESSION_ID_KEY", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        @JvmStatic
        public final void clearSavedSessionFromDisk() {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            editorEdit.remove(SessionInfo.LAST_SESSION_INFO_START_KEY);
            editorEdit.remove(SessionInfo.LAST_SESSION_INFO_END_KEY);
            editorEdit.remove(SessionInfo.INTERRUPTION_COUNT_KEY);
            editorEdit.remove(SessionInfo.SESSION_ID_KEY);
            editorEdit.apply();
            SourceApplicationInfo.INSTANCE.clearSavedSourceApplicationInfoFromDisk();
        }

        @JvmStatic
        @Nullable
        public final SessionInfo getStoredSessionInfo() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            long j2 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_START_KEY, 0L);
            long j3 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_END_KEY, 0L);
            String string = defaultSharedPreferences.getString(SessionInfo.SESSION_ID_KEY, null);
            if (j2 == 0 || j3 == 0 || string == null) {
                return null;
            }
            SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j2), Long.valueOf(j3), null, 4, null);
            sessionInfo.interruptionCount = defaultSharedPreferences.getInt(SessionInfo.INTERRUPTION_COUNT_KEY, 0);
            sessionInfo.setSourceApplicationInfo(SourceApplicationInfo.INSTANCE.getStoredSourceApplicatioInfo());
            sessionInfo.setDiskRestoreTime(Long.valueOf(System.currentTimeMillis()));
            UUID uuidFromString = UUID.fromString(string);
            s.d(uuidFromString, "fromString(sessionIDStr)");
            sessionInfo.setSessionId(uuidFromString);
            return sessionInfo;
        }
    }

    @JvmOverloads
    public SessionInfo(@Nullable Long l2, @Nullable Long l3) {
        this(l2, l3, null, 4, null);
    }

    @JvmOverloads
    public SessionInfo(@Nullable Long l2, @Nullable Long l3, @NotNull UUID sessionId) {
        s.e(sessionId, "sessionId");
        this.sessionStartTime = l2;
        this.sessionLastEventTime = l3;
        this.sessionId = sessionId;
    }

    @JvmStatic
    public static final void clearSavedSessionFromDisk() {
        INSTANCE.clearSavedSessionFromDisk();
    }

    @JvmStatic
    @Nullable
    public static final SessionInfo getStoredSessionInfo() {
        return INSTANCE.getStoredSessionInfo();
    }

    @Nullable
    public final Long getDiskRestoreTime() {
        Long l2 = this.diskRestoreTime;
        if (l2 == null) {
            return 0L;
        }
        return l2;
    }

    public final int getInterruptionCount() {
        return this.interruptionCount;
    }

    @NotNull
    public final UUID getSessionId() {
        return this.sessionId;
    }

    @Nullable
    public final Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public final long getSessionLength() {
        Long l2;
        if (this.sessionStartTime == null || (l2 = this.sessionLastEventTime) == null) {
            return 0L;
        }
        if (l2 != null) {
            return l2.longValue() - this.sessionStartTime.longValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Nullable
    public final Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    @Nullable
    public final SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public final void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public final void setDiskRestoreTime(@Nullable Long l2) {
        this.diskRestoreTime = l2;
    }

    public final void setSessionId(@NotNull UUID uuid) {
        s.e(uuid, "<set-?>");
        this.sessionId = uuid;
    }

    public final void setSessionLastEventTime(@Nullable Long l2) {
        this.sessionLastEventTime = l2;
    }

    public final void setSourceApplicationInfo(@Nullable SourceApplicationInfo sourceApplicationInfo) {
        this.sourceApplicationInfo = sourceApplicationInfo;
    }

    public final void writeSessionToDisk() {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        Long l2 = this.sessionStartTime;
        editorEdit.putLong(LAST_SESSION_INFO_START_KEY, l2 == null ? 0L : l2.longValue());
        Long l3 = this.sessionLastEventTime;
        editorEdit.putLong(LAST_SESSION_INFO_END_KEY, l3 != null ? l3.longValue() : 0L);
        editorEdit.putInt(INTERRUPTION_COUNT_KEY, this.interruptionCount);
        editorEdit.putString(SESSION_ID_KEY, this.sessionId.toString());
        editorEdit.apply();
        SourceApplicationInfo sourceApplicationInfo = this.sourceApplicationInfo;
        if (sourceApplicationInfo == null || sourceApplicationInfo == null) {
            return;
        }
        sourceApplicationInfo.writeSourceApplicationInfoToDisk();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SessionInfo(Long l2, Long l3, UUID uuid, int i2, o oVar) {
        if ((i2 & 4) != 0) {
            uuid = UUID.randomUUID();
            s.d(uuid, "randomUUID()");
        }
        this(l2, l3, uuid);
    }
}
