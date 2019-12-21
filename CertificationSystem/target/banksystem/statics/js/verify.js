$(function () {
    var CA_PubKey;
    var server_pubKey;
    var aesKey;
    var certPEM = requestCert();
    if(certPEM == null){
        alert("无法从服务器获取证书");
    }
    var x = new X509();
    x.readCertPEM(certPEM);
    /*if(!verifyCert(x, certPEM)){
        alert("所获取的证书无效");
    }*/
    console.log(x.getInfo());
    
    /*获取证书中的公钥*/
    server_pubKey = x.getPublicKeyHex();


   // alert(server_pubKey);
    //exchangekey(server_pubKey, aesKey);

});

/**
 * request certificate from server
 */
function requestCert() {
    var cert = null;
    $.ajax({
        type: "GET",
        dataType: "text",
        url: "/Ecommerce/cert",
        async: false,
        success: function(result){
            console.log(result);
            cert = result;
        },
        error: function () {
            alert("error");
        },
    });
    return cert;
}

/**
 * verify the certificate
 */
function verifyCert(x, sCertPEM, CApubKey) {
    return x.verifySignature(CApubKey);
}

/**
 * encrypt the ASE key with the server public key
 * @param server_pubKey
 * @param aseKey
 */
function exchangekey(server_pubKey, aseKey){
    var criper;
    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(server_pubKey);
    criper = encrypt.encrypt(aseKey);
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/Ecommerce/verify",
        data:{
            encryAesKey: criper
        },
        success: function(result){
            if(result.code != 200){
                alert("认证失败，该网站可能不安全！")
            }
        },
        error: function () {
            alert("wrong");
        },
    });
}