package com.faktor73.validation;

public enum ShippingMethodType {

    DHL(1),
    UPS(2),
    KIA(3),  // Kiala
    BAR(4),  // Bartolini
    YOD(5),  // Yodel
    LAP(6),  // La Poste
    TBP(7),  // to be picked up
    TPU(8),
    TNT(9),
    PNO(10), // Post Nord
    OPK(11), // OPEK (PL)
    COL(12), // Colissimo
    DWP(13),
    PCS(14),
    HMS(15),
    BPH(16), // home delivery in BE
    BPP(17), // BPost (pickup shops) in BE
    BPS(18), // BPost (packstations) in BE
    CLH(19), // Celeritas home delivery in Spain
    CLP(20), // Celeritas pickup points in Spain
    TNP(22), // Postnl pickup points in Netherlands
    PNP(23), // Postnord pickup points
    HMP(24), // Hermes pickup points
    PNG(25),
    PCP(26); // PostCH pickup points

    /**
     * German Track 'n Trace page for DHL.
     */
    public static final String DHL_TRACKING_URL_DE =
        "http://nolp.dhl.de/nextt-online-public/set_identcodes.do?lang=de&idc=";

    /**
     * French Track 'n Trace page for DHL.
     */
    public static final String DHL_TRACKING_URL_FR =
        "http://nolp.dhl.de/nextt-online-public/report_popup.jsp?lang=fr&&idc=";

    /**
     * International (english) Track 'n Trace page for DHL.
     */
    public static final String DHL_TRACKING_URL_INT =
        "http://nolp.dhl.de/nextt-online-public/set_identcodes.do?lang=en&idc=";

    /**
     * Track 'n Trace page for UPS.
     */
    // CHECKSTYLE:OFF
    public static final String UPS_TRACKING_URL_DE =
        "http://wwwapps.ups.com/WebTracking/track?HTMLVersion=5.0&loc=de_DE&Requester=UPSHome&track.x=track&trackNums=";
    // CHECKSTYLE:ON

    /**
     * Track 'n Trace page for UPS International (english).
     */
    // CHECKSTYLE:OFF
    public static final String UPS_TRACKING_URL_INT =
        "http://wwwapps.ups.com/WebTracking/track?HTMLVersion=5.0&loc=en_EN&Requester=UPSHome&track.x=track&trackNums=";
    // CHECKSTYLE:ON

    /**
     * Track 'n Trace page for Post AT.
     */
    public static final String POST_AT_TRACKING_URL = "http://post.at/geschaeftlich_ems_sendungsverfolgung.php?pnum1=";

    /**
     * Track 'n Trace page for KIALA.
     */
    public static final String KIA_FR_TRACKING_URL =
        "http://trackandtrace.kiala.com/search?countryid=FR&language=fr&dspid=33600309&dspordernr=";

    public static final String BARTOLINI_TRACKING_URL_IT = "http://as777.bartolini.it/vas/sped_det_show.hsm?nspediz=";

    // CHECKSTYLE:OFF
    public static final String BARTOLINI_TRACKING_URL_INT =
        "http://as777.bartolini.it/vas/sped_det_show.hsm?&lang=en&nspediz=";
    // CHECKSTYLE:ON

    // CHECKSTYLE:OFF
    public static final String YODEL_TRACKING_URL_INT =
        "http://www.dhl.co.uk/content/gb/en/express/tracking.shtml?brand=DHL&AWB=";
    // CHECKSTYLE:ON

    private int id;

    private ShippingMethodType(final int id) {
        this.id = id;
    }

    public static ShippingMethodType getById(final int id) {
        final ShippingMethodType[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].id == id) {
                return values[i];
            }
        }

        return null;
    }

    public static ShippingMethodType getByName(final String name) {
        for (final ShippingMethodType value : values()) {
            if (value.name().equals(name.toUpperCase())) {
                return value;
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public boolean isPickupService() {
        switch (this) {

            case KIA :
            case COL :
            case BPP :
            case BPS :
            case CLP :
            case TNP :
            case PNP :
            case HMP :
            case PCP :
                return true;

            default :
                return false;
        }
    }

}
