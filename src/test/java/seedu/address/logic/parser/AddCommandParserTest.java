package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_NULL;
import static seedu.address.logic.commands.CommandTestUtil.BIRTHDAY_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.BIRTHDAY_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.BIRTHDAY_DESC_NULL;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_NULL;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ADDRESS_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_BIRTHDAY_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ORGANISATION_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_REMARK_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.ORGANISATION_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.ORGANISATION_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.ORGANISATION_DESC_NULL;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_NULL;
import static seedu.address.logic.commands.CommandTestUtil.REMARK_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.REMARK_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.REMARK_DESC_NULL;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BIRTHDAY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BIRTHDAY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ORGANISATION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ORGANISATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REMARK_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REMARK_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.person.Address;
import seedu.address.model.person.Birthday;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Organisation;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.PersonBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();
    @Test
    public void parse_allFieldsPresent_success() {
        Person expectedPerson = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
                .withBirthday(VALID_BIRTHDAY_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withOrganisation(VALID_ORGANISATION_BOB).withRemark(VALID_REMARK_BOB)
                .withTags(VALID_TAG_FRIEND).build();

        // multiple names - last name accepted
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_AMY + NAME_DESC_BOB + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                        + REMARK_DESC_BOB + TAG_DESC_FRIEND,
                new AddCommand(expectedPerson));

        // multiple phones - last phone accepted
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_AMY + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                        + REMARK_DESC_BOB + TAG_DESC_FRIEND,
                new AddCommand(expectedPerson));

        // multiple birthdays - last birthday accepted
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB + BIRTHDAY_DESC_AMY
                        + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                        + REMARK_DESC_BOB + TAG_DESC_FRIEND,
                new AddCommand(expectedPerson));

        // multiple emails - last email accepted
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_AMY
                        + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                        + REMARK_DESC_BOB + TAG_DESC_FRIEND,
                new AddCommand(expectedPerson));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + BIRTHDAY_DESC_BOB + ADDRESS_DESC_AMY + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                        + REMARK_DESC_BOB + TAG_DESC_FRIEND,
                new AddCommand(expectedPerson));

        // multiple organisations - last organisation accepted
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                        + BIRTHDAY_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_AMY + ORGANISATION_DESC_BOB
                        + REMARK_DESC_BOB + TAG_DESC_FRIEND,
                new AddCommand(expectedPerson));

        // multiple remarks - last remark accepted
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                        + BIRTHDAY_DESC_BOB + ADDRESS_DESC_BOB + REMARK_DESC_AMY + ORGANISATION_DESC_BOB
                        + REMARK_DESC_BOB + TAG_DESC_FRIEND,
                new AddCommand(expectedPerson));

        // multiple tags - all accepted
        Person expectedPersonMultipleTags = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
                .withBirthday(VALID_BIRTHDAY_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withOrganisation(VALID_ORGANISATION_BOB).withRemark(VALID_REMARK_BOB)
                .withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND).build();
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB
                        + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                        + REMARK_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND,
                new AddCommand(expectedPersonMultipleTags));
    }
    //@@author darrinloh
    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero tags
        Person expectedPerson = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
                .withBirthday(VALID_BIRTHDAY_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withOrganisation(VALID_ORGANISATION_AMY).withRemark(VALID_REMARK_AMY).withTags().build();
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_AMY + PHONE_DESC_AMY
                + BIRTHDAY_DESC_AMY + EMAIL_DESC_AMY + ADDRESS_DESC_AMY + ORGANISATION_DESC_AMY + REMARK_DESC_AMY,
                new AddCommand(expectedPerson));

        //missing phone field -> accepted
        Person expectedPersonWithoutPhone = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(null)
                .withBirthday(VALID_BIRTHDAY_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withOrganisation(VALID_ORGANISATION_AMY).withRemark(VALID_REMARK_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_AMY + PHONE_DESC_NULL
                + BIRTHDAY_DESC_AMY + EMAIL_DESC_AMY + ADDRESS_DESC_AMY + ORGANISATION_DESC_AMY
                + REMARK_DESC_AMY + TAG_DESC_FRIEND, new AddCommand(expectedPersonWithoutPhone));

        //missing birthday field -> accepted
        Person expectedPersonWithoutBirthday = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
                .withBirthday(null).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withOrganisation(VALID_ORGANISATION_AMY).withRemark(VALID_REMARK_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_AMY + PHONE_DESC_AMY
                + BIRTHDAY_DESC_NULL + EMAIL_DESC_AMY + ADDRESS_DESC_AMY + ORGANISATION_DESC_AMY
                + REMARK_DESC_AMY + TAG_DESC_FRIEND, new AddCommand(expectedPersonWithoutBirthday));

        //missing email field -> accepted
        Person expectedPersonWithoutEmail = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
                .withBirthday(VALID_BIRTHDAY_AMY).withEmail(null).withAddress(VALID_ADDRESS_AMY)
                .withOrganisation(VALID_ORGANISATION_AMY).withRemark(VALID_REMARK_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_AMY + PHONE_DESC_AMY
                + BIRTHDAY_DESC_AMY + EMAIL_DESC_NULL + ADDRESS_DESC_AMY + ORGANISATION_DESC_AMY
                + REMARK_DESC_AMY + TAG_DESC_FRIEND, new AddCommand(expectedPersonWithoutEmail));

        //missing address field -> accepted
        Person expectedPersonWithoutAddress = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
                .withBirthday(VALID_BIRTHDAY_AMY).withEmail(VALID_EMAIL_AMY).withAddress(null)
                .withOrganisation(VALID_ORGANISATION_AMY).withRemark(VALID_REMARK_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_AMY + PHONE_DESC_AMY
                + BIRTHDAY_DESC_AMY + EMAIL_DESC_AMY + ADDRESS_DESC_NULL + ORGANISATION_DESC_AMY
                + REMARK_DESC_AMY + TAG_DESC_FRIEND, new AddCommand(expectedPersonWithoutAddress));

        //missing organisation field -> accepted
        Person expectedPersonWithoutOrganisation = new PersonBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withBirthday(VALID_BIRTHDAY_AMY).withEmail(VALID_EMAIL_AMY)
                .withAddress(VALID_ADDRESS_AMY).withOrganisation(null).withRemark(VALID_REMARK_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_AMY + PHONE_DESC_AMY
                + BIRTHDAY_DESC_AMY + EMAIL_DESC_AMY + ADDRESS_DESC_AMY + ORGANISATION_DESC_NULL
                + REMARK_DESC_AMY + TAG_DESC_FRIEND, new AddCommand(expectedPersonWithoutOrganisation));

        //missing remark field -> accepted
        Person expectedPersonWithoutRemark = new PersonBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withBirthday(VALID_BIRTHDAY_AMY).withEmail(VALID_EMAIL_AMY)
                .withAddress(VALID_ADDRESS_AMY).withOrganisation(VALID_ORGANISATION_AMY).withRemark(null)
                .withTags(VALID_TAG_FRIEND).build();
        assertParseSuccess(parser, AddCommand.COMMAND_WORD + NAME_DESC_AMY + PHONE_DESC_AMY
                + BIRTHDAY_DESC_AMY + EMAIL_DESC_AMY + ADDRESS_DESC_AMY + ORGANISATION_DESC_AMY
                + REMARK_DESC_NULL + TAG_DESC_FRIEND, new AddCommand(expectedPersonWithoutRemark));

    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, AddCommand.COMMAND_WORD + VALID_NAME_BOB + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                + REMARK_DESC_BOB, expectedMessage);


        // all prefixes missing
        assertParseFailure(parser, AddCommand.COMMAND_WORD + VALID_NAME_BOB + VALID_PHONE_BOB
                + VALID_BIRTHDAY_BOB + VALID_EMAIL_BOB + VALID_ADDRESS_BOB + VALID_ORGANISATION_BOB
                + VALID_ADDRESS_BOB, expectedMessage);

    }
    //@@author

    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, AddCommand.COMMAND_WORD + INVALID_NAME_DESC + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                + REMARK_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Name.MESSAGE_NAME_CONSTRAINTS);

        // invalid phone
        assertParseFailure(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + INVALID_PHONE_DESC
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                + REMARK_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Phone.MESSAGE_PHONE_CONSTRAINTS);

        // invalid birthday
        assertParseFailure(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB
                + INVALID_BIRTHDAY_DESC + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                + REMARK_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Birthday.MESSAGE_BIRTHDAY_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + INVALID_EMAIL_DESC + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                + REMARK_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Email.MESSAGE_EMAIL_CONSTRAINTS);

        // invalid address
        assertParseFailure(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + INVALID_ADDRESS_DESC + ORGANISATION_DESC_BOB
                + REMARK_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Address.MESSAGE_ADDRESS_CONSTRAINTS);

        // invalid organisation
        assertParseFailure(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + INVALID_ORGANISATION_DESC
                + REMARK_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Organisation.MESSAGE_ORGANISATION_CONSTRAINTS);

        // invalid remark
        assertParseFailure(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB + INVALID_REMARK_DESC
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Remark.MESSAGE_REMARK_CONSTRAINTS);

        // invalid tag
        assertParseFailure(parser, AddCommand.COMMAND_WORD + NAME_DESC_BOB + PHONE_DESC_BOB
                + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB + ORGANISATION_DESC_BOB
                + REMARK_DESC_BOB + INVALID_TAG_DESC + VALID_TAG_FRIEND, Tag.MESSAGE_TAG_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, AddCommand.COMMAND_WORD + INVALID_NAME_DESC + PHONE_DESC_BOB
                        + BIRTHDAY_DESC_BOB + EMAIL_DESC_BOB + INVALID_ADDRESS_DESC + VALID_ORGANISATION_BOB
                        + REMARK_DESC_BOB, Name.MESSAGE_NAME_CONSTRAINTS);
    }
}
