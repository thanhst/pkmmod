package com.facebook.internal;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.result.ActivityResultRegistry;
import androidx.annotation.VisibleForTesting;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.List;

import d.a_d;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FacebookDialogBase.kt */
@Metadata(bv = {}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b&\u0018\u0000 F*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0002FGB\u0019\b\u0014\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\bC\u0010DB\u0019\b\u0014\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\bC\u0010EB\u0011\b\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\bC\u0010<J!\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u00120\u000fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J&\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00172\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H$J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020!0 2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0004J\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020!0 2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001f\u0010#\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b#\u0010$J\u0018\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0015H\u0004J\b\u0010(\u001a\u00020\u0007H$R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R.\u0010/\u001a\u001a\u0012\u0014\u0012\u00120\u000fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R$\u0010\u000b\u001a\u0004\u0018\u00010\n8A@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010\u0016\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010?\u001a\u0004\u0018\u00010)8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R*\u0010B\u001a\u0018\u0012\u0014\u0012\u00120\u000fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u000e8$X¤\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006H"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase;", "CONTENT", "RESULT", "Lcom/facebook/FacebookDialog;", "content", "", "mode", "Lcom/facebook/internal/AppCall;", "createAppCallForMode", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "Lcom/facebook/CallbackManager;", "callbackManager", "Lkotlin/t;", "memorizeCallbackManager", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "cachedModeHandlers", "setCallbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallback", "", "requestCode", "Lcom/facebook/internal/CallbackManagerImpl;", "registerCallbackImpl", "", "canShow", "(Ljava/lang/Object;)Z", "canShowImpl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "show", "(Ljava/lang/Object;)V", "Ld/a;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "createActivityResultContractForShowingDialog", "showImpl", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Landroid/content/Intent;", "intent", "startActivityForResult", "createBaseAppCall", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "modeHandlers", "Ljava/util/List;", "requestCodeField", "I", "Lcom/facebook/CallbackManager;", "getCallbackManager$facebook_common_release", "()Lcom/facebook/CallbackManager;", "setCallbackManager$facebook_common_release", "(Lcom/facebook/CallbackManager;)V", "value", "getRequestCode", "()I", "setRequestCode", "(I)V", "getActivityContext", "()Landroid/app/Activity;", "activityContext", "getOrderedModeHandlers", "()Ljava/util/List;", "orderedModeHandlers", "<init>", "(Landroid/app/Activity;I)V", "(Lcom/facebook/internal/FragmentWrapper;I)V", "Companion", "ModeHandler", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {

    @NotNull
    private static final String TAG = "FacebookDialog";

    @Nullable
    private final Activity activity;

    @Nullable
    private CallbackManager callbackManager;

    @Nullable
    private final FragmentWrapper fragmentWrapper;

    @Nullable
    private List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    private int requestCodeField;

    @JvmField
    @NotNull
    public static final Object BASE_AUTOMATIC_MODE = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: FacebookDialogBase.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b¤\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "", "(Lcom/facebook/internal/FacebookDialogBase;)V", "mode", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "(Ljava/lang/Object;Z)Z", "createAppCall", "Lcom/facebook/internal/AppCall;", "(Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public abstract class ModeHandler {

        @NotNull
        private Object mode;
        final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

        public ModeHandler(FacebookDialogBase this$0) {
            kotlin.jvm.internal.s.e(this$0, "this$0");
            this.this$0 = this$0;
            this.mode = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }

        public abstract boolean canShow(CONTENT content, boolean isBestEffort);

        @Nullable
        public abstract AppCall createAppCall(CONTENT content);

        @NotNull
        public Object getMode() {
            return this.mode;
        }

        public void setMode(@NotNull Object obj) {
            kotlin.jvm.internal.s.e(obj, "<set-?>");
            this.mode = obj;
        }
    }

    protected FacebookDialogBase(@NotNull Activity activity, int i2) {
        kotlin.jvm.internal.s.e(activity, "activity");
        this.activity = activity;
        this.fragmentWrapper = null;
        this.requestCodeField = i2;
        this.callbackManager = null;
    }

    private final List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> list = this.modeHandlers;
        if (list != null) {
            return list;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase.ModeHandler<CONTENT of com.facebook.internal.FacebookDialogBase, RESULT of com.facebook.internal.FacebookDialogBase>>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCall createAppCallForMode(CONTENT content, Object mode) throws PackageManager.NameNotFoundException {
        boolean z2 = mode == BASE_AUTOMATIC_MODE;
        AppCall appCallCreateBaseAppCall = null;
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = cachedModeHandlers().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FacebookDialogBase<CONTENT, RESULT>.ModeHandler next = it.next();
            if (!z2) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(next.getMode(), mode)) {
                    continue;
                }
            }
            if (next.canShow(content, true)) {
                try {
                    appCallCreateBaseAppCall = next.createAppCall(content);
                    break;
                } catch (FacebookException e2) {
                    appCallCreateBaseAppCall = createBaseAppCall();
                    DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                    DialogPresenter.setupAppCallForValidationError(appCallCreateBaseAppCall, e2);
                }
            }
        }
        if (appCallCreateBaseAppCall != null) {
            return appCallCreateBaseAppCall;
        }
        AppCall appCallCreateBaseAppCall2 = createBaseAppCall();
        DialogPresenter.setupAppCallForCannotShowError(appCallCreateBaseAppCall2);
        return appCallCreateBaseAppCall2;
    }

    private final void memorizeCallbackManager(CallbackManager callbackManager) {
        CallbackManager callbackManager2 = this.callbackManager;
        if (callbackManager2 == null) {
            this.callbackManager = callbackManager;
        } else if (callbackManager2 != callbackManager) {
            Log.w(TAG, "You're registering a callback on a Facebook dialog with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    @Override // com.facebook.FacebookDialog
    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    protected boolean canShowImpl(CONTENT content, @NotNull Object mode) {
        kotlin.jvm.internal.s.e(mode, "mode");
        boolean z2 = mode == BASE_AUTOMATIC_MODE;
        for (FacebookDialogBase<CONTENT, RESULT>.ModeHandler modeHandler : cachedModeHandlers()) {
            if (!z2) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(modeHandler.getMode(), mode)) {
                    continue;
                }
            }
            if (modeHandler.canShow(content, false)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    protected final a_d<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(@Nullable final CallbackManager callbackManager, @NotNull final Object mode) {
        kotlin.jvm.internal.s.e(mode, "mode");
        return new a_d<CONTENT, CallbackManager.ActivityResultParameters>(this) { // from class: com.facebook.internal.FacebookDialogBase.createActivityResultContractForShowingDialog.1
            final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

            {
                this.this$0 = this;
            }

            @Override // d.a
            @NotNull
            public Intent createIntent(@NotNull Context context, CONTENT content) throws PackageManager.NameNotFoundException {
                kotlin.jvm.internal.s.e(context, "context");
                AppCall appCallCreateAppCallForMode = this.this$0.createAppCallForMode(content, mode);
                Intent requestIntent = appCallCreateAppCallForMode == null ? null : appCallCreateAppCallForMode.getRequestIntent();
                if (requestIntent != null) {
                    appCallCreateAppCallForMode.setPending();
                    return requestIntent;
                }
                throw new FacebookException("Content " + content + " is not supported");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a
            @NotNull
            public CallbackManager.ActivityResultParameters parseResult(int resultCode, @Nullable Intent intent) {
                CallbackManager callbackManager2 = callbackManager;
                if (callbackManager2 != null) {
                    callbackManager2.onActivityResult(this.this$0.getRequestCodeField(), resultCode, intent);
                }
                return new CallbackManager.ActivityResultParameters(this.this$0.getRequestCodeField(), resultCode, intent);
            }
        };
    }

    @NotNull
    protected abstract AppCall createBaseAppCall();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Activity getActivityContext() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity;
        }
        FragmentWrapper fragmentWrapper = this.fragmentWrapper;
        if (fragmentWrapper == null) {
            return null;
        }
        return fragmentWrapper.getActivity();
    }

    @VisibleForTesting(otherwise = 2)
    @Nullable
    /* renamed from: getCallbackManager$facebook_common_release, reason: from getter */
    public final CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    @NotNull
    protected abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    /* renamed from: getRequestCode, reason: from getter */
    public final int getRequestCodeField() {
        return this.requestCodeField;
    }

    @Override // com.facebook.FacebookDialog
    public void registerCallback(@NotNull CallbackManager callbackManager, @NotNull FacebookCallback<RESULT> callback) {
        kotlin.jvm.internal.s.e(callbackManager, "callbackManager");
        kotlin.jvm.internal.s.e(callback, "callback");
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        memorizeCallbackManager(callbackManager);
        registerCallbackImpl((CallbackManagerImpl) callbackManager, callback);
    }

    protected abstract void registerCallbackImpl(@NotNull CallbackManagerImpl callbackManagerImpl, @NotNull FacebookCallback<RESULT> facebookCallback);

    public final void setCallbackManager(@Nullable CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public final void setCallbackManager$facebook_common_release(@Nullable CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public final void setRequestCode(int i2) {
        if (!FacebookSdk.isFacebookRequestCode(i2)) {
            this.requestCodeField = i2;
            return;
        }
        throw new IllegalArgumentException(("Request code " + i2 + " cannot be within the range reserved by the Facebook SDK.").toString());
    }

    @Override // com.facebook.FacebookDialog
    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    protected void showImpl(CONTENT content, @NotNull Object mode) throws PackageManager.NameNotFoundException {
        kotlin.jvm.internal.s.e(mode, "mode");
        AppCall appCallCreateAppCallForMode = createAppCallForMode(content, mode);
        if (appCallCreateAppCallForMode == null) {
            Log.e(TAG, "No code path should ever result in a null appCall");
            if (!(!FacebookSdk.isDebugEnabled())) {
                throw new IllegalStateException("No code path should ever result in a null appCall".toString());
            }
            return;
        }
        if (getActivityContext() instanceof android.view.result.c) {
            ComponentCallbacks2 activityContext = getActivityContext();
            if (activityContext == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            ActivityResultRegistry activityResultRegistry = ((android.view.result.c) activityContext).getActivityResultRegistry();
            kotlin.jvm.internal.s.d(activityResultRegistry, "registryOwner.activityResultRegistry");
            DialogPresenter.present(appCallCreateAppCallForMode, activityResultRegistry, this.callbackManager);
            appCallCreateAppCallForMode.setPending();
            return;
        }
        FragmentWrapper fragmentWrapper = this.fragmentWrapper;
        if (fragmentWrapper != null) {
            DialogPresenter.present(appCallCreateAppCallForMode, fragmentWrapper);
            return;
        }
        Activity activity = this.activity;
        if (activity != null) {
            DialogPresenter.present(appCallCreateAppCallForMode, activity);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void startActivityForResult(@org.jetbrains.annotations.NotNull android.content.Intent r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.s.e(r5, r0)
            android.app.Activity r0 = r4.getActivityContext()
            boolean r1 = r0 instanceof android.view.result.c
            if (r1 == 0) goto L20
            com.facebook.internal.DialogPresenter r1 = com.facebook.internal.DialogPresenter.INSTANCE
            androidx.activity.result.c r0 = (android.view.result.c) r0
            androidx.activity.result.ActivityResultRegistry r0 = r0.getActivityResultRegistry()
            java.lang.String r1 = "activity as ActivityResultRegistryOwner).activityResultRegistry"
            kotlin.jvm.internal.s.d(r0, r1)
            com.facebook.CallbackManager r1 = r4.callbackManager
            com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX(r0, r1, r5, r6)
            goto L2d
        L20:
            if (r0 == 0) goto L26
            r0.startActivityForResult(r5, r6)
            goto L2d
        L26:
            com.facebook.internal.FragmentWrapper r0 = r4.fragmentWrapper
            if (r0 == 0) goto L2f
            r0.startActivityForResult(r5, r6)
        L2d:
            r5 = 0
            goto L31
        L2f:
            java.lang.String r5 = "Failed to find Activity or Fragment to startActivityForResult "
        L31:
            if (r5 == 0) goto L48
            com.facebook.internal.Logger$Companion r6 = com.facebook.internal.Logger.INSTANCE
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r1 = 6
            java.lang.Class r2 = r4.getClass()
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "this.javaClass.name"
            kotlin.jvm.internal.s.d(r2, r3)
            r6.log(r0, r1, r2, r5)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    @Override // com.facebook.FacebookDialog
    @NotNull
    public a_d<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(@Nullable CallbackManager callbackManager) {
        return createActivityResultContractForShowingDialog(callbackManager, BASE_AUTOMATIC_MODE);
    }

    @Override // com.facebook.FacebookDialog
    public void registerCallback(@NotNull CallbackManager callbackManager, @NotNull FacebookCallback<RESULT> callback, int i2) {
        kotlin.jvm.internal.s.e(callbackManager, "callbackManager");
        kotlin.jvm.internal.s.e(callback, "callback");
        memorizeCallbackManager(callbackManager);
        setRequestCode(i2);
        registerCallback(callbackManager, callback);
    }

    protected FacebookDialogBase(@NotNull FragmentWrapper fragmentWrapper, int i2) {
        kotlin.jvm.internal.s.e(fragmentWrapper, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper;
        this.activity = null;
        this.requestCodeField = i2;
        if (fragmentWrapper.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity".toString());
        }
    }

    protected FacebookDialogBase(int i2) {
        this.requestCodeField = i2;
        this.activity = null;
        this.fragmentWrapper = null;
    }
}
