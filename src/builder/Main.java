package builder;

public class Main {
    public static void main(String[] args) {
        //User Run
        User user = new User.UserBuilder("Shakeel","Ahmed")
                .age(15)
                .phone("030695343252")
                .build();
        System.out.println(user.toString());

        // Phone Run
        Phone phone = new Phone.PhoneBuilder("12314244255","Samsung",8,64,"BLACK")
                .addBluetooth(true)
                .addWifi(true)
                .build();

        System.out.println(phone.toString());
    }
}
