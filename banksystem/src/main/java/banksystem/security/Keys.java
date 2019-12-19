package banksystem.security;

public class Keys {

    private final static String rsaPrivateKey = /*"-----BEGIN PRIVATE KEY-----" +*/
            "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAK5dtsRi2Mvz4ESg" +
                    "saIHQGFrrXlCMVCVj2+cx2Aa6W5cisGqVs52/39xAS2MlVC5KDOejTBdivoLtfbB" +
                    "MHXdMNu+6S06r4uISzb3FZPLyCGSt2G9SGd1SEhwRoYLduim2HS2e1G6esfTfJZZ" +
                    "r6148yAG97+8tE0uv667wq4Pza2dAgMBAAECgYEAlqkMyeWq85c2mbXLpnfjjgnP" +
                    "K24hVELWXBc4Qnceaah2kF4RgXZaz5Ah92x4e/ZwoSGHV1oMQn+p65sDt2O22Utm" +
                    "1P/QuCW/yur5WRGMVZTpVT6jjaRGDG6rJ5Ojb/bgehTpEh4vFyzCI1ynjQF1NYEN" +
                    "c4wEmgAS4Y4v2/keB0ECQQDa15k1a/5SaSKK0T+XvBA3oAIoVDKKy/Cg2ljEc2Ss" +
                    "suhb6eXrHkD7Ae+ZUsW9NJ3aQyjVKAip8sA0l/2qdshRAkEAy/jf6uQG6utXA/mg" +
                    "eEl238JpvYCDaoaJ7Lp0H7yisdND4P+LH+BLECbH3gdkHUsUKyVc6M3VOOx6ylbx" +
                    "Ss6JjQJBANC1KVJ/ie7CgcTuRr3JB5ZlLWmU0xb35KcjVeEVRABIJ73w1etj0QkS" +
                    "EZWiER+fHKRZxIl1Qr4B2zjNc4is++ECQAtqfn3TDWAQk+oxCn4w/mo/o1Nr4e8Q" +
                    "YJ/TP7SXBjQVsvLg2pSKJSleQkl2+G97SEGx8aVF/+0Trzur6g1ZyfECQQCEjduu" +
                    "H3/mr5pEqIf09zfGALylS8b8qanffHbeTYZnwWpbrOhbm1q0INsQnNNPsMgs2go6" +
                    "ygH2m/4tG1stVNJ8"/* +
                "-----END PRIVATE KEY-----"*/;
    private final static String rsaPublicKey = /*"-----BEGIN PUBLIC KEY-----" +*/
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuXbbEYtjL8+BEoLGiB0Bha615" +
                    "QjFQlY9vnMdgGuluXIrBqlbOdv9/cQEtjJVQuSgzno0wXYr6C7X2wTB13TDbvukt" +
                    "Oq+LiEs29xWTy8ghkrdhvUhndUhIcEaGC3bopth0tntRunrH03yWWa+tePMgBve/" +
                    "vLRNLr+uu8KuD82tnQIDAQAB" /*+
                "-----END PUBLIC KEY-----"*/;

    /**
     * Get the private key
      * @return the string of the private key of the rsa
     */
    public static String getRsaPrivateKey(){
        return rsaPrivateKey;
    }

    /**
     * Get the public key
     * @return the String of the public key of the rsa
     */
    public static String getRsaPublicKey(){
        return rsaPublicKey;
    }

}
