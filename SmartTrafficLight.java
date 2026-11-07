public class SmartTrafficLight extends IoTDevice implements SmartDevice {

    private int kepadatan;
    private int durasiHijau;

    public SmartTrafficLight(String deviceId, String lokasi) {
        super(deviceId, lokasi);
        this.kepadatan = 0;
        this.durasiHijau = 30;
        setMenyala(true);
    }

    public int getKepadatan() { return this.kepadatan; }
    public void setKepadatan(int kepadatan) { this.kepadatan = kepadatan; }

    public int getDurasiHijau() { return this.durasiHijau; }
    public void setDurasiHijau(int durasiHijau) { this.durasiHijau = durasiHijau; }

    @Override
    public void processSensorData(int data) {
        this.kepadatan = data;
        if (data > 50) {
            this.durasiHijau = 60;
        } else {
            this.durasiHijau = 30;
        }
    }

    @Override
    public void info() {
        super.info();
        System.out.println(" Jenis: Smart Traffic Light | Kepadatan: " + this.kepadatan + " | Durasi hijau: " + this.durasiHijau + " detik");
    }

    @Override
    public void connectToNetwork() {
        System.out.println(getDeviceId() + " terhubung ke server lalu lintas kota.");
    }
}