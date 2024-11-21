package info.dmerej;

public class Shop {
    public static boolean canOrder(User user) {
        boolean minor = !user.isMajor();
        boolean verified = user.isVerified();

        return !minor && verified;

    }

    public static boolean mustPayForeignFee(User user) {
        return !user.getAddress().country().equals("USA");
    }
}
