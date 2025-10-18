package com.facebook;

import android.content.Intent;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import u.a_u;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileManager.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0007\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/facebook/ProfileManager;", "", "Lcom/facebook/Profile;", "currentProfile", "", "writeToCache", "Lkotlin/t;", "setCurrentProfile", "oldProfile", "sendCurrentProfileChangedBroadcast", "loadCurrentProfile", "Lu/a;", "localBroadcastManager", "Lu/a;", "Lcom/facebook/ProfileCache;", "profileCache", "Lcom/facebook/ProfileCache;", "currentProfileField", "Lcom/facebook/Profile;", "value", "getCurrentProfile", "()Lcom/facebook/Profile;", "(Lcom/facebook/Profile;)V", "<init>", "(Lu/a;Lcom/facebook/ProfileCache;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ProfileManager {

    @NotNull
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";

    @NotNull
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;

    @Nullable
    private Profile currentProfileField;

    @NotNull
    private final a_u localBroadcastManager;

    @NotNull
    private final ProfileCache profileCache;

    /* compiled from: ProfileManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/ProfileManager$Companion;", "", "()V", "ACTION_CURRENT_PROFILE_CHANGED", "", "EXTRA_NEW_PROFILE", "EXTRA_OLD_PROFILE", "instance", "Lcom/facebook/ProfileManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized ProfileManager getInstance() {
            ProfileManager profileManager;
            if (ProfileManager.instance == null) {
                a_u aUVarB = a_u.b(FacebookSdk.getApplicationContext());
                kotlin.jvm.internal.s.d(aUVarB, "getInstance(applicationContext)");
                ProfileManager.instance = new ProfileManager(aUVarB, new ProfileCache());
            }
            profileManager = ProfileManager.instance;
            if (profileManager == null) {
                kotlin.jvm.internal.s.t("instance");
                throw null;
            }
            return profileManager;
        }
    }

    public ProfileManager(@NotNull a_u localBroadcastManager, @NotNull ProfileCache profileCache) {
        kotlin.jvm.internal.s.e(localBroadcastManager, "localBroadcastManager");
        kotlin.jvm.internal.s.e(profileCache, "profileCache");
        this.localBroadcastManager = localBroadcastManager;
        this.profileCache = profileCache;
    }

    @JvmStatic
    @NotNull
    public static final synchronized ProfileManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.d(intent);
    }

    @Nullable
    /* renamed from: getCurrentProfile, reason: from getter */
    public final Profile getCurrentProfileField() {
        return this.currentProfileField;
    }

    public final boolean loadCurrentProfile() {
        Profile profileLoad = this.profileCache.load();
        if (profileLoad == null) {
            return false;
        }
        setCurrentProfile(profileLoad, false);
        return true;
    }

    public final void setCurrentProfile(@Nullable Profile profile) {
        setCurrentProfile(profile, true);
    }

    private final void setCurrentProfile(Profile profile, boolean z2) {
        Profile profile2 = this.currentProfileField;
        this.currentProfileField = profile;
        if (z2) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (Utility.areObjectsEqual(profile2, profile)) {
            return;
        }
        sendCurrentProfileChangedBroadcast(profile2, profile);
    }
}
