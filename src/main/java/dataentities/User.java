package dataentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "email",
        "password",
        "id",
        "isActive",
        "balance",
        "picture",
        "age",
        "eyeColor",
        "name",
        "gender",
        "company",
        "phone",
        "address",
        "about",
        "registered",
        "latitude",
        "longitude",
        "tags",
        "friends",
        "greeting",
        "favoriteFruit"})

public class User {
    private String email;

    @JsonCreator
    public User(@JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("age") int age,
                @JsonProperty("name") String name,
                @JsonProperty("gender") String gender) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    private String password;
    private int id;
    private boolean isActive;
    private String balance;
    private String picture;
    private int age;
    private String eyeColor;
    private String name;
    private String gender;
    private String company;
    private String phone;
    private String address;
    private String about;
    private String registered;
    private double latitude;
    private double longitude;
    private List<String> tags;
    private List<Friend> friends;
    private String greeting;
    private String favoriteFruit;


    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
    @JsonProperty("id")
    public int getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty("isActive")
    public boolean isActive() {
        return isActive;
    }
    @JsonProperty("isActive")
    public void setActive(boolean active) {
        isActive = active;
    }
    @JsonProperty("balance")
    public String getBalance() {
        return balance;
    }
    @JsonProperty("balance")
    public void setBalance(String balance) {
        this.balance = balance;
    }
    @JsonProperty("picture")
    public String getPicture() {
        return picture;
    }
    @JsonProperty("picture")
    public void setPicture(String picture) {
        this.picture = picture;
    }
    @JsonProperty("age")
    public int getAge() {
        return age;
    }
    @JsonProperty("age")
    public void setAge(int age) {
        this.age = age;
    }
    @JsonProperty("eyeColor")
    public String getEyeColor() {
        return eyeColor;
    }
    @JsonProperty("eyeColor")
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }
    @JsonProperty("company")
    public String getCompany() {
        return company;
    }
    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }
    @JsonProperty("about")
    public String getAbout() {
        return about;
    }
    @JsonProperty("about")
    public void setAbout(String about) {
        this.about = about;
    }
    @JsonProperty("registered")
    public String getRegistered() {
        return registered;
    }
    @JsonProperty("registered")
    public void setRegistered(String registered) {
        this.registered = registered;
    }
    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }
    @JsonProperty("latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }
    @JsonProperty("longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    @JsonProperty("friends")
    public List<Friend> getFriends() {
        return friends;
    }
    @JsonProperty("friends")
    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
    @JsonProperty("greeting")
    public String getGreeting() {
        return greeting;
    }
    @JsonProperty("greeting")
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    @JsonProperty("favoriteFruit")
    public String getFavoriteFruit() {
        return favoriteFruit;
    }
    @JsonProperty("favoriteFruit")
    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

}
