package jp.drjoy.service.model.registration;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * ユーザー
 */
@Document
public class User {
    /**
     * ユーザーID （旧システムのusers.idから移行する）
     */
    private String id;

    private String loginId;

    private String mailAddress;

    private String passwordHash;

    private String lastName;

    private String lastNameKana;

    private String firstName;

    private String firstNameKana;

    private String birthDate;

    private GenderType genderType;

    private Date created;

    private Date deleted;

    private Boolean temporaryRegistering;

    private Profile profile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameKana() {
        return firstNameKana;
    }

    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public Boolean getTemporaryRegistering() {
        return temporaryRegistering;
    }

    public void setTemporaryRegistering(Boolean temporaryRegistering) {
        this.temporaryRegistering = temporaryRegistering;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public enum GenderType {
        UNKNOWN, MALE, FEMALE
    }

    public enum BloodType {
        A, B, AB, O
    }

    /**
     * ユーザープロフィール
     */
    public static class Profile {
        private String placeBornIn;

        private BloodType bloodType;

        private String postalCode;

        private String address1;

        private String address2;

        private String phoneNo;

        private String mobileNo;

        private String mobileEmailAddress;

        private String snsFacebook;

        private String snsTwitter;

        private String snsLine;

        public String getPlaceBornIn() {
            return placeBornIn;
        }

        public void setPlaceBornIn(String placeBornIn) {
            this.placeBornIn = placeBornIn;
        }

        public BloodType getBloodType() {
            return bloodType;
        }

        public void setBloodType(BloodType bloodType) {
            this.bloodType = bloodType;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getMobileEmailAddress() {
            return mobileEmailAddress;
        }

        public void setMobileEmailAddress(String mobileEmailAddress) {
            this.mobileEmailAddress = mobileEmailAddress;
        }

        public String getSnsFacebook() {
            return snsFacebook;
        }

        public void setSnsFacebook(String snsFacebook) {
            this.snsFacebook = snsFacebook;
        }

        public String getSnsTwitter() {
            return snsTwitter;
        }

        public void setSnsTwitter(String snsTwitter) {
            this.snsTwitter = snsTwitter;
        }

        public String getSnsLine() {
            return snsLine;
        }

        public void setSnsLine(String snsLine) {
            this.snsLine = snsLine;
        }
    }
}
