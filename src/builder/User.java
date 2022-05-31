package builder;

/**
 * BUILDER PATTERN ALLOWS CONSTRUCTION OF COMPLEX OBJECTS STEP BY STEP.(IT IS A CREATIONAL DESIGN PATTERN)
 * Note : It is used when you need to create an object with lots
 * of possible configuration options.
 *
 * For Example : A user has to register a form on a website.
 * There are some optional fields and some mandatory in the form there we can use builder
 * design pattern to put some fields optional.
 */

public class User {
    //Making the fields private and final
    //Note : final keyword requires initializing the object. which makes these two fields mandatory.
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class UserBuilder {
        //BY MAKING final firstName and LastName we make them mandatory fields.
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;


        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        //Return the finally consrcuted User object
        public User build() {
            User user = new User(this);
            validateUserObject(user);
            return user;
        }

        private void validateUserObject(User user) {
            //Do some basic validations to check
            //Suppose we want 15+ Age users on our site.
            try {
                if (age != 0 && user.getAge() < 10 ) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("18+ are allowed on this website.");
            }

        }
    }
}
