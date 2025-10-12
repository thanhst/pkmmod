package com.ykiocnwpdseglq.cubgy.managers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.gson.Gson;
import com.ykiocnwpdseglq.cubgy.utils.DeviceUtil;
import com.ykiocnwpdseglq.cubgy.utils.LogUtil;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.AibIyCdHmGwOql;
import com.ykiocnwpdseglq.lbmntzwepqakgu.beans.OEtWoBzalfeg;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.DIUGfDWQpOJHLr;
import com.ykiocnwpdseglq.lbmntzwepqakgu.interfaces.PurchaseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class RgGGKcUwgofnY {
    private static RgGGKcUwgofnY instance;
    private OEtWoBzalfeg commPayParam;
    private BillingClient mBillingClient;
    private boolean mIsServiceConnected;
    private Set<String> mTokensToBeConsumed;
    private PurchaseListener purchaseListener;
    private boolean isApplicationlaunch = false;
    private Gson gson = new Gson();

    private boolean areSubscriptionsSupported() {
        BillingResult billingResultIsFeatureSupported = this.mBillingClient.isFeatureSupported(BillingClient.FeatureType.SUBSCRIPTIONS);
        if (billingResultIsFeatureSupported.getResponseCode() != 0) {
            LogUtil.e("areSubscriptionsSupported() got an error response: " + billingResultIsFeatureSupported.getResponseCode());
        }
        return billingResultIsFeatureSupported.getResponseCode() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void consumeOldOrder(final Context context) {
        LogUtil.e("consume old order..");
        executeServiceRequest(new Runnable() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.2
            @Override // java.lang.Runnable
            public void run() {
                RgGGKcUwgofnY.this.queryPurchases(context);
            }
        });
    }

    private void consumeOrder(final String str, final ConsumeResponseListener consumeResponseListener) {
        Set<String> set = this.mTokensToBeConsumed;
        if (set == null) {
            this.mTokensToBeConsumed = new HashSet();
        } else if (set.contains(str)) {
            LogUtil.e("Token was already scheduled to be consumed - skipping...");
            return;
        }
        this.mTokensToBeConsumed.add(str);
        executeServiceRequest(new Runnable() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.9
            @Override // java.lang.Runnable
            public void run() {
                RgGGKcUwgofnY.this.mBillingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(str).build(), consumeResponseListener);
            }
        });
    }

    private void executeServiceRequest(Runnable runnable) {
        if (this.mIsServiceConnected) {
            runnable.run();
        } else {
            startServiceConnection(runnable);
        }
    }

    public static RgGGKcUwgofnY getInstance() {
        if (instance == null) {
            instance = new RgGGKcUwgofnY();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initiatePurchaseFlow(final Activity activity, final ProductDetails productDetails, final OEtWoBzalfeg oEtWoBzalfeg) {
        executeServiceRequest(new Runnable() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.5
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.e("Launching in-app purchase flow.");
                String str = oEtWoBzalfeg.getPayChannel() + "#" + oEtWoBzalfeg.getPlatTransactionId();
                String offerToken = (productDetails.getSubscriptionOfferDetails() == null || productDetails.getSubscriptionOfferDetails().size() <= 0) ? "" : productDetails.getSubscriptionOfferDetails().get(0).getOfferToken();
                ArrayList arrayList = new ArrayList();
                arrayList.add(BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).setOfferToken(offerToken).build());
                RgGGKcUwgofnY.this.mBillingClient.launchBillingFlow(activity, BillingFlowParams.newBuilder().setProductDetailsParamsList(arrayList).setObfuscatedAccountId(String.valueOf(oEtWoBzalfeg.getUserId())).setObfuscatedProfileId(str).build());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryPurchases(Context context) {
        executeServiceRequest(new Runnable() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.3
            @Override // java.lang.Runnable
            public void run() {
                RgGGKcUwgofnY.this.mBillingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), new PurchasesResponseListener() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.3.1
                    @Override // com.android.billingclient.api.PurchasesResponseListener
                    public void onQueryPurchasesResponse(@NonNull BillingResult billingResult, @NonNull List<Purchase> list) {
                        if (billingResult.getResponseCode() != 0 || list.size() == 0) {
                            return;
                        }
                        for (Purchase purchase : list) {
                            if (purchase.getPurchaseState() == 1) {
                                RgGGKcUwgofnY.this.serverCheckOrder(purchase);
                            }
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serverCheckOrder(Purchase purchase) {
        LogUtil.e("signature:" + purchase.getSignature() + "   receipt:" + purchase.getOriginalJson() + "   token:" + purchase.getPurchaseToken());
        String obfuscatedProfileId = purchase.getAccountIdentifiers() == null ? "" : purchase.getAccountIdentifiers().getObfuscatedProfileId();
        LogUtil.e("profile msg : " + obfuscatedProfileId);
        if (obfuscatedProfileId == null || obfuscatedProfileId.equals("")) {
            LogUtil.e("profile msg is null");
            consumeOrder(purchase.getPurchaseToken(), new ConsumeResponseListener() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.7
                @Override // com.android.billingclient.api.ConsumeResponseListener
                public void onConsumeResponse(@NonNull BillingResult billingResult, @NonNull String str) {
                    LogUtil.e("consume wrong order success");
                }
            });
            return;
        }
        String[] strArrSplit = obfuscatedProfileId.split("#");
        if (strArrSplit.length != 2) {
            consumeOrder(purchase.getPurchaseToken(), new ConsumeResponseListener() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.6
                @Override // com.android.billingclient.api.ConsumeResponseListener
                public void onConsumeResponse(@NonNull BillingResult billingResult, @NonNull String str) {
                    LogUtil.e("consume wrong order success");
                }
            });
            return;
        }
        OEtWoBzalfeg oEtWoBzalfeg = new OEtWoBzalfeg();
        oEtWoBzalfeg.setPayChannel(strArrSplit[0]);
        oEtWoBzalfeg.setPlatTransactionId(strArrSplit[1]);
        AibIyCdHmGwOql aibIyCdHmGwOql = new AibIyCdHmGwOql();
        aibIyCdHmGwOql.setOEtWoBzalfeg(oEtWoBzalfeg);
        aibIyCdHmGwOql.setSignature(purchase.getSignature());
        aibIyCdHmGwOql.setReceipt(purchase.getOriginalJson());
        aibIyCdHmGwOql.setThirdPayToken(purchase.getPurchaseToken());
        PurchaseListener purchaseListener = this.purchaseListener;
        if (purchaseListener != null) {
            purchaseListener.payCallBack(PurchaseListener.PurchaseState.PURCHASE_STATE_PAY_SUCCESS, aibIyCdHmGwOql, null);
        }
    }

    private void startServiceConnection(final Runnable runnable) {
        this.mBillingClient.startConnection(new BillingClientStateListener() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.10
            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingServiceDisconnected() {
                RgGGKcUwgofnY.this.mIsServiceConnected = false;
            }

            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                LogUtil.e("Setup finished. Response code: " + billingResult.getResponseCode());
                if (billingResult.getResponseCode() == 0) {
                    RgGGKcUwgofnY.this.mIsServiceConnected = true;
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }
        });
    }

    public void applicationOnCreate(Application application) {
        if (this.isApplicationlaunch) {
            return;
        }
        this.isApplicationlaunch = true;
        DeviceUtil.makeGAID(application);
    }

    public void consumeClientOrder(Context context, DIUGfDWQpOJHLr.ParamGetter paramGetter) {
        final AibIyCdHmGwOql aibIyCdHmGwOql = (AibIyCdHmGwOql) paramGetter.getPayParam();
        consumeOrder(aibIyCdHmGwOql.getThirdPayToken(), new ConsumeResponseListener() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.8
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public void onConsumeResponse(@NonNull BillingResult billingResult, @NonNull String str) {
                if (billingResult.getResponseCode() == 0) {
                    LogUtil.e("consume order success ,you can buy again!");
                    if (RgGGKcUwgofnY.this.purchaseListener != null) {
                        RgGGKcUwgofnY.this.purchaseListener.payCallBack(PurchaseListener.PurchaseState.PURCHASE_STATE_CONSUME_SUCCESS, aibIyCdHmGwOql, null);
                        return;
                    }
                    return;
                }
                LogUtil.e("consume order fail!!! responseCode:" + billingResult.getResponseCode());
                if (RgGGKcUwgofnY.this.purchaseListener != null) {
                    RgGGKcUwgofnY.this.purchaseListener.payCallBack(PurchaseListener.PurchaseState.PURCHASE_STATE_CONSUME_FAIL, aibIyCdHmGwOql, "responseCode:" + billingResult.getResponseCode());
                }
            }
        });
    }

    public void exit() {
        BillingClient billingClient = this.mBillingClient;
        if (billingClient == null || !billingClient.isReady()) {
            return;
        }
        this.mBillingClient.endConnection();
        this.mBillingClient = null;
    }

    public void initPay(final Context context, DIUGfDWQpOJHLr.ParamGetter paramGetter, final PurchaseListener purchaseListener) {
        this.purchaseListener = purchaseListener;
        this.mBillingClient = BillingClient.newBuilder(context).setListener(new PurchasesUpdatedListener() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.1
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public void onPurchasesUpdated(@NonNull BillingResult billingResult, @Nullable List<Purchase> list) {
                if (billingResult.getResponseCode() == 0 && list != null) {
                    LogUtil.e("buy list size : " + list.size());
                    for (Purchase purchase : list) {
                        if (purchase.getPurchaseState() == 2) {
                            return;
                        } else {
                            RgGGKcUwgofnY.this.serverCheckOrder(purchase);
                        }
                    }
                    return;
                }
                if (billingResult.getResponseCode() == 1) {
                    LogUtil.e("onPurchasesUpdated() - user cancelled the purchase flow - skipping");
                    PurchaseListener purchaseListener2 = purchaseListener;
                    if (purchaseListener2 != null) {
                        purchaseListener2.payCallBack(PurchaseListener.PurchaseState.PURCHASE_STATE_PAY_CANCEL, null, "user cancel");
                        return;
                    }
                    return;
                }
                LogUtil.e("onPurchasesUpdated() got unknown resultCode: " + billingResult.getResponseCode());
                if (billingResult.getResponseCode() == 7) {
                    LogUtil.e("already own stuff,start to cost it");
                    RgGGKcUwgofnY.this.consumeOldOrder(context);
                    return;
                }
                PurchaseListener purchaseListener3 = purchaseListener;
                if (purchaseListener3 != null) {
                    purchaseListener3.payCallBack(PurchaseListener.PurchaseState.PURCHASE_STATE_PAY_FAIL, null, "response code : " + billingResult.getResponseCode());
                }
            }
        }).enablePendingPurchases().build();
        consumeOldOrder(context);
        if (purchaseListener != null) {
            purchaseListener.initCallBack(PurchaseListener.PurchaseInitState.PURCHASE_INIT_STATE_FINISH, null);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void startPay(final Activity activity, DIUGfDWQpOJHLr.ParamGetter paramGetter) {
        this.commPayParam = (OEtWoBzalfeg) paramGetter.getPayParam();
        executeServiceRequest(new Runnable() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId(RgGGKcUwgofnY.this.commPayParam.getProductId()).setProductType("inapp").build());
                LogUtil.e("product id : " + RgGGKcUwgofnY.this.commPayParam.getProductId());
                QueryProductDetailsParams.Builder builderNewBuilder = QueryProductDetailsParams.newBuilder();
                builderNewBuilder.setProductList(arrayList);
                RgGGKcUwgofnY.this.mBillingClient.queryProductDetailsAsync(builderNewBuilder.build(), new ProductDetailsResponseListener() { // from class: com.ykiocnwpdseglq.cubgy.managers.RgGGKcUwgofnY.4.1
                    @Override // com.android.billingclient.api.ProductDetailsResponseListener
                    public void onProductDetailsResponse(@NonNull BillingResult billingResult, @NonNull List<ProductDetails> list) {
                        if (billingResult.getResponseCode() != 0 || list.size() <= 0) {
                            LogUtil.e("get sku details fail!!!");
                        } else {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            RgGGKcUwgofnY.this.initiatePurchaseFlow(activity, list.get(0), RgGGKcUwgofnY.this.commPayParam);
                        }
                    }
                });
            }
        });
    }
}
