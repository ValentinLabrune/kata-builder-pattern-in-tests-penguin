package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest {

    private final Address fsfAddress = new Address(
        "51 Franklin Street",
        "Fifth Floor",
        "Boston",
        "02110",
        "USA"
    );

    private final Address parisAddress = new Address(
        "33 quai d'Orsay",
        "",
        "Paris",
        "75007",
        "France"
    );


    @Test
    public void happy_path() {
        final User user = new User.UserBuilder("Bob", "bob@domain.tld", fsfAddress)
            .isMajor(true)
            .isVerified(true)
            .build();

        assertTrue(Shop.canOrder(user));
        assertFalse(Shop.mustPayForeignFee(user));
    }

    @Test
    public void minors_cannot_order_from_shop() {
        final User user = new User.UserBuilder("Bob", "bob@domain.tld", fsfAddress)
                .isMajor(false)
                .isVerified(true)
                .build();
        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void must_be_verified_to_order_from_shop() {
        final User user = new User.UserBuilder("Bob", "bob@domain.tld", fsfAddress)
                .isMajor(true)
                .isVerified(false)
                .build();
        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void foreigners_must_pay_foreign_fee() {
        final User user = new User.UserBuilder("Bob", "bob@domain.tld", parisAddress)
                .isMajor(true)
                .isVerified(true)
                .build();
        assertTrue(Shop.mustPayForeignFee(user));
    }

}
