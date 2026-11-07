public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULASI SMART STREET LIGHT ===\n");

        SmartStreetLight lampu = new SmartStreetLight("SSL-01", "Jl. Jenderal Soedirman");

        System.out.println("--- 1. Malam hari (LDR 25), jalan sepi ---");
        lampu.setAdaGerakan(false);
        lampu.processSensorData(25);
        lampu.info();
        System.out.println("Energi dihemat: " + lampu.penghematanEnergi() + "%\n");

        System.out.println("--- 2. Malam hari (LDR 25), kendaraan lewat ---");
        lampu.setAdaGerakan(true);
        lampu.processSensorData(25);
        lampu.info();
        System.out.println("Energi dihemat: " + lampu.penghematanEnergi() + "%\n");

        System.out.println("--- 3. Pagi hari (LDR 85) ---");
        lampu.processSensorData(85);
        lampu.info();
        System.out.println("Energi dihemat: " + lampu.penghematanEnergi() + "%\n");

        System.out.println("--- 4. Polimorfisme interface ---");
        SmartDevice perangkat = lampu;
        perangkat.connectToNetwork();
        EfisiensiEnergi hemat = lampu;
        System.out.println("Energi dihemat via interface: " + hemat.penghematanEnergi() + "%\n");

        System.out.println("--- 5. Smart Traffic Light ---");
        SmartDevice lampuLalin = new SmartTrafficLight("STL-01", "Perempatan");
        lampuLalin.connectToNetwork();
        SmartTrafficLight stl = new SmartTrafficLight("STL-02", "Pertigaan");
        stl.processSensorData(80);
        stl.info();
    }
}