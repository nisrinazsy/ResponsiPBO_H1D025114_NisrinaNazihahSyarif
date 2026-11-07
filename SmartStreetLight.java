public class SmartStreetLight extends IoTDevice implements SmartDevice, EfisiensiEnergi {

    public static final int AMBANG_GELAP = 50;

    private int intensitasCahaya;
    private boolean adaGerakan;
    private int kecerahan;

    public SmartStreetLight(String deviceId, String lokasi) {
        super(deviceId, lokasi);
        this.intensitasCahaya = 0;
        this.adaGerakan = false;
        this.kecerahan = 0;
    }

    public int getIntensitasCahaya() { return this.intensitasCahaya; }
    public void setIntensitasCahaya(int intensitasCahaya) { this.intensitasCahaya = intensitasCahaya; }

    public boolean isAdaGerakan() { return this.adaGerakan; }
    public void setAdaGerakan(boolean adaGerakan) { this.adaGerakan = adaGerakan; }

    public int getKecerahan() { return this.kecerahan; }
    public void setKecerahan(int kecerahan) { this.kecerahan = kecerahan; }

    @Override
    public void processSensorData(int data) {
        this.intensitasCahaya = data;
        if (data < AMBANG_GELAP) {
            setMenyala(true);
            if (this.adaGerakan) {
                this.kecerahan = 100;
            } else {
                this.kecerahan = 30;
            }
        } else {
            setMenyala(false);
            this.kecerahan = 0;
        }
    }

    @Override
    public void info() {
        super.info();
        System.out.println(" Jenis: Smart Street Light | Kecerahan: " + this.kecerahan + "%");
    }

    @Override
    public void connectToNetwork() {
        System.out.println(getDeviceId() + " terhubung ke jaringan Wi-Fi.");
    }

    @Override
    public int penghematanEnergi() {
        return 100 - this.kecerahan;
    }
}