package info.dmerej;

public class User {
    private String name;
    private String email;
    private Address address;

    private boolean isMajor;
    private boolean isVerified;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Address getAddress() {
        return address;
    }

    public boolean isMajor() {
        return isMajor;
    }
    public boolean isVerified() {
        return isVerified;
    }

    private User(UserBuilder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
        this.isMajor = builder.isMajor;
        this.isVerified = builder.isVerified;
    }

    static class UserBuilder {
        private String name;
        private String email;
        private Address address;
        private boolean isMajor;
        private boolean isVerified;

        public UserBuilder(String name, String email, Address address){
            this.name = name;
            this.email = email;
            this.address = address;
        }

        public UserBuilder isMajor(boolean isMajor){
            this.isMajor = isMajor;
            return this;
        }

        public UserBuilder isVerified(boolean isVerified){
            this.isVerified = isVerified;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}

