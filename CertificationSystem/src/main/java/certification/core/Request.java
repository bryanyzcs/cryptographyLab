package certification.core;

/**.
 * Generate request by client's information
 */
public class Request {
    private String CN;
    private String OU;
    private String L;
    private String ST;
    private String O;
    private String C;
    private String EM;

    public String getCN() {
        return CN;
    }

    public Request(String c, String st, String l, String o, String ou, String cn, String em){
        CN = cn;
        OU = ou;
        L = l;
        ST = st;
        O = o;
        C = c;
        EM = em;
    }

    /**
     * Construct Body Name.
     * C = country
     * ST = state or province
     * L:location or city
     * O:organization
     * OU:organization unit
     * CN: common name or IP
     * @return the subject
     */
    public String constructBodyName(){
        return
                "EMAILADDRESS="+EM+", CN="+CN+", OU="+OU+", O="+O+", L="+L+", ST="+ST+", C="+C;
    }
}
