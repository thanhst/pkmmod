package com.sfyvctwaqbjhki.uwmpqfh.biohepbeans;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RfybaJKCLilYpc implements Cloneable {
    private String channel;
    private String code;
    private String codeImg;
    private String description;
    private String discountImg;
    private String exInfo;
    private String hotImg;
    private int isOfficial;
    private String name;
    private List<RfybaJKCLilYpc> nodes;
    private List<Products> products;
    private Products selectedProduct;
    private String showMethod;
    private int showProductList;

    public class Products {
        private String amount;
        private String currency;
        private String discountDesc;
        private String gameCoin;
        private String gameCurrency;
        private int itemType;
        private String productDesc;
        private String productName;
        private String shortCurrency;

        public Products() {
        }

        public String getAmount() {
            String str = this.amount;
            return str == null ? "" : str;
        }

        public String getCurrency() {
            String str = this.currency;
            return str == null ? "" : str;
        }

        public String getDiscountDesc() {
            String str = this.discountDesc;
            return str == null ? "" : str;
        }

        public String getGameCoin() {
            String str = this.gameCoin;
            return str == null ? "" : str;
        }

        public String getGameCurrency() {
            String str = this.gameCurrency;
            return str == null ? "" : str;
        }

        public int getItemType() {
            return this.itemType;
        }

        public String getProductDesc() {
            String str = this.productDesc;
            return str == null ? "" : str;
        }

        public String getProductName() {
            String str = this.productName;
            return str == null ? "" : str;
        }

        public String getShortCurrency() {
            String str = this.shortCurrency;
            return str == null ? "" : str;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setDiscountDesc(String str) {
            this.discountDesc = str;
        }

        public void setGameCoin(String str) {
            this.gameCoin = str;
        }

        public void setGameCurrency(String str) {
            this.gameCurrency = str;
        }

        public void setItemType(int i2) {
            this.itemType = i2;
        }

        public void setProductDesc(String str) {
            this.productDesc = str;
        }

        public void setProductName(String str) {
            this.productName = str;
        }

        public void setShortCurrency(String str) {
            this.shortCurrency = str;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getChannel() {
        String str = this.channel;
        return str == null ? "" : str;
    }

    public String getCode() {
        String str = this.code;
        return str == null ? "" : str;
    }

    public String getCodeImg() {
        String str = this.codeImg;
        return str == null ? "" : str;
    }

    public String getDescription() {
        String str = this.description;
        return str == null ? "" : str;
    }

    public String getDiscountImg() {
        String str = this.discountImg;
        return str == null ? "" : str;
    }

    public String getExInfo() {
        String str = this.exInfo;
        return str == null ? "" : str;
    }

    public String getHotImg() {
        String str = this.hotImg;
        return str == null ? "" : str;
    }

    public int getIsOfficial() {
        return this.isOfficial;
    }

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public List<RfybaJKCLilYpc> getNodes() {
        if (this.nodes == null) {
            this.nodes = new ArrayList();
        }
        return this.nodes;
    }

    public List<Products> getProducts() {
        if (this.products == null) {
            this.products = new ArrayList();
        }
        return this.products;
    }

    public Products getSelectedProduct() {
        if (this.selectedProduct == null) {
            this.selectedProduct = new Products();
        }
        return this.selectedProduct;
    }

    public String getShowMethod() {
        String str = this.showMethod;
        return str == null ? "" : str;
    }

    public int getShowProductList() {
        return this.showProductList;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCodeImg(String str) {
        this.codeImg = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDiscountImg(String str) {
        this.discountImg = str;
    }

    public void setExInfo(String str) {
        this.exInfo = str;
    }

    public void setHotImg(String str) {
        this.hotImg = str;
    }

    public void setIsOfficial(int i2) {
        this.isOfficial = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNodes(List<RfybaJKCLilYpc> list) {
        this.nodes = list;
    }

    public void setProducts(List<Products> list) {
        this.products = list;
    }

    public void setSelectedProduct(Products products) {
        this.selectedProduct = products;
    }

    public void setShowMethod(String str) {
        this.showMethod = str;
    }

    public void setShowProductList(int i2) {
        this.showProductList = i2;
    }
}
