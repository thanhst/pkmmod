package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import u.a_u;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileTracker.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H$J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/facebook/ProfileTracker;", "", "Lkotlin/t;", "addBroadcastReceiver", "Lcom/facebook/Profile;", "oldProfile", "currentProfile", "onCurrentProfileChanged", "startTracking", "stopTracking", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/BroadcastReceiver;", "Lu/a;", "broadcastManager", "Lu/a;", "", "<set-?>", "isTracking", "Z", "()Z", "<init>", "()V", "ProfileBroadcastReceiver", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ProfileTracker {

    @NotNull
    private final a_u broadcastManager;
    private boolean isTracking;

    @NotNull
    private final BroadcastReceiver receiver;

    /* compiled from: ProfileTracker.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/ProfileTracker$ProfileBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lkotlin/t;", "onReceive", "<init>", "(Lcom/facebook/ProfileTracker;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private final class ProfileBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ ProfileTracker this$0;

        public ProfileBroadcastReceiver(ProfileTracker this$0) {
            kotlin.jvm.internal.s.e(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            kotlin.jvm.internal.s.e(context, "context");
            kotlin.jvm.internal.s.e(intent, "intent");
            if (kotlin.jvm.internal.s.a(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED, intent.getAction())) {
                this.this$0.onCurrentProfileChanged((Profile) intent.getParcelableExtra(ProfileManager.EXTRA_OLD_PROFILE), (Profile) intent.getParcelableExtra(ProfileManager.EXTRA_NEW_PROFILE));
            }
        }
    }

    public ProfileTracker() {
        Validate.sdkInitialized();
        this.receiver = new ProfileBroadcastReceiver(this);
        a_u aUVarB = a_u.b(FacebookSdk.getApplicationContext());
        kotlin.jvm.internal.s.d(aUVarB, "getInstance(FacebookSdk.getApplicationContext())");
        this.broadcastManager = aUVarB;
        startTracking();
    }

    private final void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED);
        this.broadcastManager.c(this.receiver, intentFilter);
    }

    /* renamed from: isTracking, reason: from getter */
    public final boolean getIsTracking() {
        return this.isTracking;
    }

    protected abstract void onCurrentProfileChanged(@Nullable Profile profile, @Nullable Profile profile2);

    public final void startTracking() {
        if (this.isTracking) {
            return;
        }
        addBroadcastReceiver();
        this.isTracking = true;
    }

    public final void stopTracking() {
        if (this.isTracking) {
            this.broadcastManager.e(this.receiver);
            this.isTracking = false;
        }
    }
}
