public abstract class IoTDevice {

    public static final String DEFAULT_LOKASI = "Belum ditentukan";

    private final String deviceId;

    private String lokasi;
    private boolean menyala;

    public IoTDevice(String deviceId) {
        this(deviceId, DEFAULT_LOKASI);
    }

    public IoTDevice(String deviceId, String lokasi) {
        this.deviceId = deviceId;
        this.lokasi = lokasi;
        this.menyala = false;
    }

    public String getDeviceId() { return this.deviceId; }

    public String getLokasi() { return this.lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public boolean isMenyala() { return this.menyala; }
    public void setMenyala(boolean menyala) { this.menyala = menyala; }

    public abstract void processSensorData(int data);

    public void info() {
        String status = this.menyala ? "MENYALA" : "MATI";
        System.out.println("ID: " + this.deviceId + " | Lokasi: " + this.lokasi + " | Status: " + status);
    }
}