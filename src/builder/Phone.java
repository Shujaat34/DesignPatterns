package builder;

/**
 * BUILDER PATTERN ALLOWS CONSTRUCTION OF COMPLEX OBJECTS STEP BY STEP.(IT IS A CREATIONAL DESIGN PATTERN)
 * Note : It is used when you need to create an object with lots
 * of possible configuration options.
 *
 * For Example : A Factory produces different models of phone. Now there are some mobiles in which
 * we don't have bluetooth or WIFI or 4G or Flashlight or Fingerprint Feature or FaceLock.
 *
 * Builder produces products of different kinds (phone manual) using the same building steps.
 */
public class Phone {
    private final String IMEI; //(International Mobile Equipment Identity)
    private final String name;
    private final int ram;
    private final int rom;
    private final String color;
    private final boolean isBluetoothSupported;
    private final boolean isWifiSupported;
    private final boolean is4GSupported;

    public String getIMEI() {
        return IMEI;
    }

    public String getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    public int getRom() {
        return rom;
    }

    public String getColor() {
        return color;
    }

    public boolean isBluetoothSupported() {
        return isBluetoothSupported;
    }

    public boolean isWifiSupported() {
        return isWifiSupported;
    }

    public boolean isIs4GSupported() {
        return is4GSupported;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "IMEI='" + IMEI + '\'' +
                ", name='" + name + '\'' +
                ", ram=" + ram +
                ", rom=" + rom +
                ", color='" + color + '\'' +
                ", isBluetoothSupported=" + isBluetoothSupported +
                ", isWifiSupported=" + isWifiSupported +
                ", isFourGSupported=" + is4GSupported +
                '}';
    }

    private Phone(PhoneBuilder builder) {
        this.IMEI = builder.IMEI; //(International Mobile Equipment Identity)
        this.name = builder.name;
        this.ram = builder.ram;
        this.rom = builder.rom;
        this.color = builder.color;
        this.isBluetoothSupported = builder.isBluetoothSupported;
        this.isWifiSupported = builder.isWifiSupported;
        this.is4GSupported = builder.is4GSupported;
    }

    public static class PhoneBuilder {
        //The Final Fields are mandatory
        private final String IMEI; //(International Mobile Equipment Identity)
        private final String name;
        private final int ram;
        private final int rom;
        private final String color;
        private boolean isBluetoothSupported;
        private boolean isWifiSupported;
        private boolean is4GSupported;

        //These things are mandatory because every mobile has these features.
        //That's why we made them final in Builder class
        public PhoneBuilder(String IMEI, String name, int ram, int rom, String color) {
            this.IMEI = IMEI;
            this.name = name;
            this.ram = ram;
            this.rom = rom;
            this.color = color;
        }

        public PhoneBuilder addBluetooth(boolean isBluetoothSupported) {
            this.isBluetoothSupported = isBluetoothSupported;
            return this;
        }

        public PhoneBuilder addFourG(boolean is4GSupported) {
            this.is4GSupported = is4GSupported;
            return this;
        }

        public PhoneBuilder addWifi(boolean isWifiSupported) {
            this.isWifiSupported = isWifiSupported;
            return this;
        }

        public Phone build() {
            Phone phone = new Phone(this);
            validatePhone(phone);
            return phone;
        }

        public void validatePhone(Phone phone) {
            try {
                if (phone.getRam() == 0 || phone.getRam() > 8) {
                    throw new Exception("--RAM must be greater than 0 and less than 8GB--");
                }
                if (phone.getRom() == 0 || phone.getRam() > 128) {
                    throw new Exception("--ROM must be greater than 0 and less than 128--");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
