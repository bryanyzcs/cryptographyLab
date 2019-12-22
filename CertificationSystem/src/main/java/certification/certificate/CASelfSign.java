package certification.certificate;

import certification.core.Request;

public class CASelfSign {
    public void genCASelfSignCert(){
        Request request = new Request("CN","ST","Harbin","hit","O","127.0.0.1","1354922069@qq.com");
        DigitalCertificate caCert = new DigitalCertificate(request.constructBodyName());
    }
}
