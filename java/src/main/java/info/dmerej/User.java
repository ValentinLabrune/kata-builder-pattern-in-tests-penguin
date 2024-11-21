package info.dmerej;

public class User {
    private final boolean isAmerican;
    private final boolean isMajor;
    private final boolean isVerified;

    public boolean isAmerican() {
        return isAmerican;
    }

    public boolean isMajor() {
        return isMajor;
    }

    public boolean isVerified() {
        return isVerified;
    }

    private User(UserBuilder builder){
        this.isAmerican = builder.isAmerican;
        this.isMajor = builder.isMajor;
        this.isVerified = builder.isVerified;
    }

    static class UserBuilder {
        private boolean isAmerican = true;
        private boolean isMajor = true;
        private boolean isVerified = true;

        public UserBuilder isNotMajor(){
            this.isMajor = false;
            return this;
        }

        public UserBuilder isNotVerified(){
            this.isVerified = false;
            return this;
        }

        public UserBuilder isNotAmerican(){
            this.isAmerican = false;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}

