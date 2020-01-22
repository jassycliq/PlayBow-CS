package com.jassycliq.playbowcs.network;

import com.google.gson.JsonObject;
import com.jassycliq.playbowcs.activity.data.Result;
import com.jassycliq.playbowcs.activity.data.model.BookingData;
import com.jassycliq.playbowcs.activity.data.model.BookingResponse;
import com.jassycliq.playbowcs.activity.data.model.DaycareCalendarResponse;
import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.activity.data.model.UserTransactionHistoryResponse;
import com.jassycliq.playbowcs.model.AddDepositModel;
import com.jassycliq.playbowcs.model.BookingDetailsResponseModel;
import com.jassycliq.playbowcs.model.BookingRateModel;
import com.jassycliq.playbowcs.model.ClientTokenModel;
import com.jassycliq.playbowcs.model.ConfirmCancelModel;
import com.jassycliq.playbowcs.model.DogBookingListModel;
import com.jassycliq.playbowcs.model.LiveSessionModel;
import com.jassycliq.playbowcs.model.LoginModel;
import com.jassycliq.playbowcs.model.PlayDateCheckoutModel;
import com.jassycliq.playbowcs.model.SendPaymentNonceToServerModel;
import com.jassycliq.playbowcs.model.SettingsModel;
import com.jassycliq.playbowcs.model.StepOneRegisterModel;
import com.jassycliq.playbowcs.model.SuccessMessageModel;
import com.jassycliq.playbowcs.model.TransactionHistoryModel;
import com.jassycliq.playbowcs.model.UserDetailsModel;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiEndpointInterface {

//    @POST("users/login")
    @Multipart
    @POST("login/")
    Call<LoggedInUser> getLogin(@Part("email") RequestBody email,
                                @Part("password") RequestBody password,
                                @Part("android_device_token") RequestBody android_device_token,
                                @Part("iphone_device_token") RequestBody iphone_device_token);

    @POST("canine/{id}/get-users/")
    Call <OwnershipModel> getUsers(@Path(value = "id", encoded = false) int id,
                                   @Header("Authorization") String tokenString);

    @FormUrlEncoded
    @POST("canine/{id}/get-user-booked-dates/")
    Call <BookingResponse> getUserBookedDates(@Path(value = "id", encoded = false) int id,
                                              @Header("Authorization") String tokenString,
                                              @FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("canine/{id}/get-user-booked-dates/")
    Call <Result<BookingData>> setAdminBookedDates(@Path(value = "id", encoded = false) int id,
                                                @Header("Authorization") String tokenString,
                                                @FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("canine/{id}/get-user-booked-dates/")
    Call <Result<BookingData>> setAdminRemovedDates(@Path(value = "id", encoded = false) int id,
                                                    @Header("Authorization") String tokenString,
                                                    @FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("canine/{id}/get-dog-attendance/")
    Call <DaycareCalendarResponse> getDaycareAttendance(@Path(value = "id", encoded = false) int id,
                                                        @Header("Authorization") String tokenString,
                                                        @FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("canine/{id}/update-user/")
    Call <OwnershipModel> updateUser(@Path(value = "id", encoded = false) int id,
                                     @Header("Authorization") String tokenString,
                                     @FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("canine/{id}/financial-history-details/")
    Call <UserTransactionHistoryResponse> getFinancialHistory(@Path(value = "id", encoded = false) int id,
                                                              @Header("Authorization") String tokenString,
                                                              @FieldMap Map<String, String> fields);

//    @POST("users/forgot-password/")
    @Multipart
    @POST("reset-password/")
    Call<SuccessMessageModel> getForgotPassword(@Part("email") RequestBody email);

    /* Register webservice */
    @Multipart
    @POST("create")
    Call<LoginModel> Registeronedogwithimage(@Part("firstname") RequestBody firstname,
                                             @Part("lastname") RequestBody lastname,
                                             @Part("email") RequestBody email,
                                             @Part("password") RequestBody password,
                                             @Part("android_device_token") RequestBody android_device_token,
                                             @Part("iphone_device_token") RequestBody iphone_device_token,
                                             @Part("dog_name_1") RequestBody dog_name_1,
                                             @Part MultipartBody.Part dogImageFile_1,
                                             @Part("dog_name_2") RequestBody dog_name_2,
                                             @Part("dog_name_3") RequestBody dog_name_3,
                                             @Part("dog_image_2") RequestBody dogImageFile_2,
                                             @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register webservice without image*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwithoutimage1(@Part("firstname") RequestBody firstname,
                                              @Part("lastname") RequestBody lastname,
                                              @Part("email") RequestBody email,
                                              @Part("password") RequestBody password,
                                              @Part("android_device_token") RequestBody android_device_token,
                                              @Part("iphone_device_token") RequestBody iphone_device_token,
                                              @Part("dog_name_1") RequestBody dog_name_1,
                                              @Part("dog_image_3") RequestBody dogImageFile_22,
                                              @Part("dog_name_2") RequestBody dog_name_2,
                                              @Part("dog_name_3") RequestBody dog_name_3,
                                              @Part("dog_image_2") RequestBody dogImageFile_2,
                                              @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDog2(@Part("firstname") RequestBody firstname,
                                  @Part("lastname") RequestBody lastname,
                                  @Part("email") RequestBody email,
                                  @Part("password") RequestBody password,
                                  @Part("android_device_token") RequestBody android_device_token,
                                  @Part("iphone_device_token") RequestBody iphone_device_token,
                                  @Part("dog_name_1") RequestBody dog_name_1,
                                  @Part("dog_name_2") RequestBody dog_name_2,
                                  @Part MultipartBody.Part dogImageFile_1,
                                  @Part MultipartBody.Part dogImageFile_2,
                                  @Part("dog_name_3") RequestBody dog_name_3,
                                  @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register with one image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwithoutimageone2(@Part("firstname") RequestBody firstname,
                                                 @Part("lastname") RequestBody lastname,
                                                 @Part("email") RequestBody email,
                                                 @Part("password") RequestBody password,
                                                 @Part("android_device_token") RequestBody android_device_token,
                                                 @Part("iphone_device_token") RequestBody iphone_device_token,
                                                 @Part("dog_name_1") RequestBody dog_name_1,
                                                 @Part("dog_name_2") RequestBody dog_name_2,
                                                 @Part("dog_image_1") RequestBody dogImageFiletwo_3,
                                                 @Part MultipartBody.Part dogImageFile_2,
                                                 @Part("dog_name_3") RequestBody dog_name_3,
                                                 @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register with two image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwithoutimagetwo2(@Part("firstname") RequestBody firstname,
                                                 @Part("lastname") RequestBody lastname,
                                                 @Part("email") RequestBody email,
                                                 @Part("password") RequestBody password,
                                                 @Part("android_device_token") RequestBody android_device_token,
                                                 @Part("iphone_device_token") RequestBody iphone_device_token,
                                                 @Part("dog_name_1") RequestBody dog_name_1,
                                                 @Part("dog_name_2") RequestBody dog_name_2,
                                                 @Part MultipartBody.Part dogImageFile_2,
                                                 @Part("dog_image_2") RequestBody dogImageFiletwo_3,

                                                 @Part("dog_name_3") RequestBody dog_name_3,
                                                 @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register with three image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwithoutimageoneandtwo2(@Part("firstname") RequestBody firstname,
                                                       @Part("lastname") RequestBody lastname,
                                                       @Part("email") RequestBody email,
                                                       @Part("password") RequestBody password,
                                                       @Part("android_device_token") RequestBody android_device_token,
                                                       @Part("iphone_device_token") RequestBody iphone_device_token,
                                                       @Part("dog_name_1") RequestBody dog_name_1,
                                                       @Part("dog_name_2") RequestBody dog_name_2,
                                                       @Part("dog_image_1") RequestBody dogImageFile_1,
                                                       @Part("dog_image_2") RequestBody dogImageFile_2,
                                                       @Part("dog_name_3") RequestBody dog_name_3,
                                                       @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register with one two three image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwithoutonetwothreeimage2(@Part("firstname") RequestBody firstname,
                                                         @Part("lastname") RequestBody lastname,
                                                         @Part("email") RequestBody email,
                                                         @Part("password") RequestBody password,
                                                         @Part("android_device_token") RequestBody android_device_token,
                                                         @Part("iphone_device_token") RequestBody iphone_device_token,
                                                         @Part("dog_name_1") RequestBody dog_name_1,
                                                         @Part("dog_name_2") RequestBody dog_name_2,
                                                         @Part("dog_name_3") RequestBody dog_name_3,
                                                         @Part("dog_image_1") RequestBody dogImageFile_1,
                                                         @Part("dog_image_2") RequestBody dogImageFile_2,
                                                         @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register with one two three image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwithouttwothreeimage2(@Part("firstname") RequestBody firstname,
                                                      @Part("lastname") RequestBody lastname,
                                                      @Part("email") RequestBody email,
                                                      @Part("password") RequestBody password,
                                                      @Part("android_device_token") RequestBody android_device_token,
                                                      @Part("iphone_device_token") RequestBody iphone_device_token,
                                                      @Part("dog_name_1") RequestBody dog_name_1,
                                                      @Part("dog_name_2") RequestBody dog_name_2,
                                                      @Part("dog_name_3") RequestBody dog_name_3,
                                                      @Part("dog_image_1") RequestBody dogImageFile_1,
                                                      @Part("dog_image_2") RequestBody dogImageFile_2,
                                                      @Part MultipartBody.Part dogImageFile_3);

    /*Register without three image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwithreeimage2(@Part("firstname") RequestBody firstname,
                                              @Part("lastname") RequestBody lastname,
                                              @Part("email") RequestBody email,
                                              @Part("password") RequestBody password,
                                              @Part("android_device_token") RequestBody android_device_token,
                                              @Part("iphone_device_token") RequestBody iphone_device_token,
                                              @Part("dog_name_1") RequestBody dog_name_1,
                                              @Part("dog_name_2") RequestBody dog_name_2,
                                              @Part("dog_name_3") RequestBody dog_name_3,
                                              @Part("dog_image_1") RequestBody dogImageFile_1,
                                              @Part MultipartBody.Part dogImageFile_2,
                                              @Part MultipartBody.Part dogImageFile_3);

    /*Register with one two three image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwiwithimage2(@Part("firstname") RequestBody firstname,
                                             @Part("lastname") RequestBody lastname,
                                             @Part("email") RequestBody email,
                                             @Part("password") RequestBody password,
                                             @Part("android_device_token") RequestBody android_device_token,
                                             @Part("iphone_device_token") RequestBody iphone_device_token,
                                             @Part("dog_name_1") RequestBody dog_name_1,
                                             @Part("dog_name_2") RequestBody dog_name_2,
                                             @Part("dog_name_3") RequestBody dog_name_3,
                                             @Part MultipartBody.Part dogImageFile_1,
                                             @Part MultipartBody.Part dogImageFile_2,
                                             @Part MultipartBody.Part dogImageFile_3);

    /*Register with one two three image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwiontthreewithimage2(@Part("firstname") RequestBody firstname,
                                                     @Part("lastname") RequestBody lastname,
                                                     @Part("email") RequestBody email,
                                                     @Part("password") RequestBody password,
                                                     @Part("android_device_token") RequestBody android_device_token,
                                                     @Part("iphone_device_token") RequestBody iphone_device_token,
                                                     @Part("dog_name_1") RequestBody dog_name_1,
                                                     @Part("dog_name_2") RequestBody dog_name_2,
                                                     @Part("dog_name_3") RequestBody dog_name_3,
                                                     @Part MultipartBody.Part dogImageFile_1,
                                                     @Part("dog_image_2") RequestBody dogImageFile_2,
                                                     @Part MultipartBody.Part dogImageFile_3);

    /*Register with one two three image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogwifirstimagetwothreeewithimage2(@Part("firstname") RequestBody firstname,
                                                                @Part("lastname") RequestBody lastname,
                                                                @Part("email") RequestBody email,
                                                                @Part("password") RequestBody password,
                                                                @Part("android_device_token") RequestBody android_device_token,
                                                                @Part("iphone_device_token") RequestBody iphone_device_token,
                                                                @Part("dog_name_1") RequestBody dog_name_1,
                                                                @Part("dog_name_2") RequestBody dog_name_2,
                                                                @Part("dog_name_3") RequestBody dog_name_3,
                                                                @Part MultipartBody.Part dogImageFile_1,
                                                                @Part("dog_image_2") RequestBody dogImageFile_2,
                                                                @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register with one two three image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogtwoimageonethreewithimage2(@Part("firstname") RequestBody firstname,
                                                           @Part("lastname") RequestBody lastname,
                                                           @Part("email") RequestBody email,
                                                           @Part("password") RequestBody password,
                                                           @Part("android_device_token") RequestBody android_device_token,
                                                           @Part("iphone_device_token") RequestBody iphone_device_token,
                                                           @Part("dog_name_1") RequestBody dog_name_1,
                                                           @Part("dog_name_2") RequestBody dog_name_2,
                                                           @Part("dog_name_3") RequestBody dog_name_3,
                                                           @Part("dog_image_1") RequestBody dogImageFile_1,
                                                           @Part MultipartBody.Part dogImageFile_2,
                                                           @Part("dog_image_3") RequestBody dogImageFile_3);

    /*Register with two three and one without one image webservice*/
    @Multipart
//    @POST("users/sign-up")
    @POST("create")
    Call<LoginModel> RegisterDogtwothreeimageonewithoutimage(@Part("firstname") RequestBody firstname,
                                                             @Part("lastname") RequestBody lastname,
                                                             @Part("email") RequestBody email,
                                                             @Part("password") RequestBody password,
                                                             @Part("android_device_token") RequestBody android_device_token,
                                                             @Part("iphone_device_token") RequestBody iphone_device_token,
                                                             @Part("dog_name_1") RequestBody dog_name_1,
                                                             @Part("dog_name_2") RequestBody dog_name_2,
                                                             @Part("dog_name_3") RequestBody dog_name_3,
                                                             @Part("dog_image_1") RequestBody dogImageFile_1,
                                                             @Part MultipartBody.Part dogImageFile_2,
                                                             @Part MultipartBody.Part dogImageFile_3);

    /*EditProfile webservice */
    @Multipart
//    @POST("users/edit-profile")
    @PUT("users/{id}/update/")
    Call<LoginModel> EditProfile1(@Path(value = "id", encoded = false) int id,
                                  @Header("Authorization") String tokenString,
                                  @Part("firstname") RequestBody firstname,
                                  @Part("lastname") RequestBody lastname,
                                  @Part("dog_id_1") RequestBody dognameone,
                                  @Part("dog_name_1") RequestBody dog_name_1,
                                  @Part MultipartBody.Part dogImageFile_1,
                                  @Part("dog_id_2") RequestBody dognametwo,
                                  @Part("dog_name_2") RequestBody dog_name_2,
                                  @Part("dog_name_3") RequestBody dog_name_3,
                                  @Part("dog_id_3") RequestBody dognamethree,
                                  @Part("dog_image_2") RequestBody dogImageFile_2,
                                  @Part("dog_image_3") RequestBody dogImageFile_3);

    /* Editprofile webservice without image*/
    @Multipart
//    @POST("users/edit-profile")
    @PUT("users/{id}/update/")
    Call<LoginModel> EditProfile1_without_image(@Path(value = "id", encoded = false) int id,
                                                @Header("Authorization") String tokenString,
                                                @Part("firstname") RequestBody firstname,
                                                @Part("lastname") RequestBody lastname,
                                                @Part("dog_id_1") RequestBody dognameone,
                                                @Part("dog_name_1") RequestBody dog_name_1,
                                                @Part("dog_image_1") RequestBody dogImageFile_1,
                                                @Part("dog_id_2") RequestBody dognametwo,
                                                @Part("dog_name_2") RequestBody dog_name_2,
                                                @Part("dog_name_3") RequestBody dog_name_3,
                                                @Part("dog_id_3") RequestBody dognamethree,
                                                @Part("dog_image_2") RequestBody dogImageFile_2,
                                                @Part("dog_image_3") RequestBody dogImageFile_3);

    /*EditProfile webservice*/
    @Multipart
//    @POST("users/edit-profile")
    @PUT("users/{id}/update/")
    Call<LoginModel> EditProfile2(@Path(value = "id", encoded = false) int id,
                                  @Header("Authorization") String tokenString,
                                  @Part("firstname") RequestBody firstname,
                                  @Part("lastname") RequestBody lastname,
                                  @Part("dog_id_1") RequestBody dognameone,
                                  @Part("dog_name_1") RequestBody dog_name_1,
                                  @Part MultipartBody.Part dogImageFile_1,
                                  @Part("dog_id_2") RequestBody dognametwo,
                                  @Part("dog_name_2") RequestBody dog_name_2,
                                  @Part MultipartBody.Part dogImageFile_22,
                                  @Part("dog_id_3") RequestBody dognamethree,
                                  @Part("dog_name_3") RequestBody dogImageFile_2,
                                  @Part("dog_image_3") RequestBody dogImageFile_3);

    /*EditProfile webservice_without_image*/
    @Multipart
//    @POST("users/edit-profile")
    @PUT("users/{id}/update/")
    Call<LoginModel> EditProfile2_without_image(@Path(value = "id", encoded = false) int id,
                                                @Header("Authorization") String tokenString,
                                                @Part("firstname") RequestBody firstname,
                                                @Part("lastname") RequestBody lastname,
                                                @Part("dog_id_1") RequestBody dognameone,
                                                @Part("dog_name_1") RequestBody dog_name_1,
                                                @Part("dog_image_1") RequestBody dogImageFile_1,
                                                @Part("dog_id_2") RequestBody dognametwo,
                                                @Part("dog_name_2") RequestBody dog_name_2,
                                                @Part("dog_image_2") RequestBody dogImageFile_2,
                                                @Part("dog_id_3") RequestBody dognamethree,
                                                @Part("dog_name_3") RequestBody dog_name_3,
                                                @Part("dog_image_3") RequestBody dogImageFile_3);

    /*EditProfile webservice*/
    @Multipart
//    @POST("users/edit-profile")
    @PUT("users/{id}/update/")
    Call<LoginModel> EditProfile3(@Path(value = "id", encoded = false) int id,
                                  @Header("Authorization") String tokenString,
                                  @Part("firstname") RequestBody firstname,
                                  @Part("lastname") RequestBody lastname,
                                  @Part("dog_id_1") RequestBody dognameone,
                                  @Part("dog_name_1") RequestBody dog_name_1,
                                  @Part MultipartBody.Part dogImageFile_1,
                                  @Part("dog_id_2") RequestBody dognametwo,
                                  @Part("dog_name_2") RequestBody dog_name_2,
                                  @Part MultipartBody.Part dogImageFilee_2,
                                  @Part("dog_id_3") RequestBody dognamethree,
                                  @Part("dog_name_3") RequestBody dogImageFile_2,
                                  @Part MultipartBody.Part dogImageFilee_3);

    /*EditProfileWebservice without image*/

    @Multipart
//    @POST("users/edit-profile")
    @PUT("users/{id}/update/")
    Call<LoginModel> EditProfile3_without_image(@Path(value = "id", encoded = false) int id,
                                                @Header("Authorization") String tokenString,
                                                @Part("firstname") RequestBody firstname,
                                                @Part("lastname") RequestBody lastname,
                                                @Part("dog_id_1") RequestBody dognameone,
                                                @Part("dog_name_1") RequestBody dog_name_1,
                                                @Part("dog_image_1") RequestBody dogImageFile_1,
                                                @Part("dog_id_2") RequestBody dognametwo,
                                                @Part("dog_name_2") RequestBody dog_name_2,
                                                @Part("dog_image_2") RequestBody dogImageFile_2,
                                                @Part("dog_id_3") RequestBody dognamethree,
                                                @Part("dog_name_3") RequestBody dog_name_3,
                                                @Part("dog_image_3") RequestBody dogImageFile_3);


    // Change Password webservice
    @Multipart
    //@POST("users/change-password")
    @PUT("users/{id}/change-password/")
    Call<SuccessMessageModel> getChangePassword(@Path(value = "id", encoded = false) int id,
                                                @Header("Authorization") String tokenString,
                                                @Part("old_password") RequestBody old_password,
                                                @Part("new_password") RequestBody new_password);

    //GetUserProfile Details Webservice
//    @Multipart
    @GET("users/{id}/profile/")
    Call<LoginModel> getUserProfileDetails(@Path(value = "id", encoded = false) int id,
                                           @Header("Authorization") String tokenString);


    //Notification Webservice
    @Multipart
    @PUT("users/{id}/notification/")
    Call<LoginModel> setNotification(@Path(value = "id", encoded = false) int id,
                                     @Header("Authorization") String tokenString,
                                     @Part("notification_status") RequestBody notification_status);

    //Logout Webservice
    @POST("users/{id}/logout/")
    Call<SuccessMessageModel> setLogout(@Path(value = "id", encoded = false) int id,
                                        @Header("Authorization") String tokenString);


    /*Add Deposit web service*/
    @Multipart
    @POST("users/add-deposit")
    Call<AddDepositModel> AddDeposit(@Part("user_id") RequestBody user_id,
                                     @Part("auth_token") RequestBody auth_token,
                                     @Part("transaction_id") RequestBody transaction_id,
                                     @Part("deposit_amount") RequestBody deposit_amount);

//    GetUserProfile Details Webservice
//    @Multipart
//    @POST("users/get-membership")
//    Call<MonthlymembershipModel> getMonthlyMembership(@Part("user_id") RequestBody user_id,
//                                                      @Part("auth_token") RequestBody auth_token);

    // Get Booking Dog List
    @POST("users/{id}/cancel-booking-info/")
    Call<DogBookingListModel> getBookingDogList(@Path(value = "id", encoded = false) int id,
                                                @Header("Authorization") String tokenString,
                                                @Body JsonObject data);

    // Cancel Booking Dogs
    @Multipart
    @POST("users/{id}/play-dates-checkout/")
    Call<ConfirmCancelModel> ConfirmCancelBooking(@Path(value = "id", encoded = false) int id,
                                                  @Header("Authorization") String tokenString,
                                                  @Part("order_type") RequestBody order_type,
                                                  @Part("booking_dates") RequestBody booking_dates,
                                                  @Part("service_type") RequestBody service_type);

//    //Get Membership start date
//    @Multipart
//    @POST("users/get-membership-start-date")
//    Call<StartMembershipModel> StartMembership(@Part("user_id") RequestBody user_id,
//                                               @Part("auth_token") RequestBody auth_token,
//                                               @Part("day_names") RequestBody day_names,
//                                               @Part("dog_ids") RequestBody dog_ids,
//                                               @Part("membership_plan_id") RequestBody membership_plan_id,
//                                               @Part("start_date") RequestBody start_date);

//    //Monthly Membership Checkout
//    @Multipart
//    @POST("users/monthly-membership-checkout")
//    Call<MembershipCheckoutModel> MembershipCheckout(@Part("user_id") RequestBody user_id,
//                                                     @Part("auth_token") RequestBody auth_token,
//                                                     @Part("day_names") RequestBody day_names,
//                                                     @Part("dog_ids") RequestBody dog_ids,
//                                                     @Part("membership_plan_id") RequestBody membership_plan_id,
//                                                     @Part("tips") RequestBody tips,
//                                                     @Part("start_date") RequestBody start_date,
//                                                     @Part("with_transport")RequestBody with_transport);

    //@HTTP(method="GET", path="users/{id}/get-booking-info", hasBody=true)
    @POST("users/{id}/get-booking-info/")
    Call<BookingDetailsResponseModel> getBookings(@Path(value = "id", encoded = false) int id,
                                                  @Header("Authorization") String tokenString,
                                                  @Body JsonObject data);

    @POST("users/{id}/get-booking-rate/")
    Call<BookingRateModel> getBookingRate(@Path(value = "id", encoded = false) int id,
                                          @Header("Authorization") String tokenString,
                                          @Body JsonObject data);


//    //Get Active Membership
//    @Multipart
//    @POST("users/get-active-membership")
//    Call<GetActiveMembershipModel>getActiveMembership(@Part("user_id") RequestBody user_id,
//                                                      @Part("auth_token") RequestBody auth_token,
//                                                      @Part("dog_ids") RequestBody dog_ids);
    //play dates checkout
    @POST("users/{id}/play-dates-checkout/")
    Call<PlayDateCheckoutModel> PlayDateCheckout(@Path(value = "id", encoded = false) int id,
                                                 @Header("Authorization") String tokenString,
                                                 @Body JsonObject data);

    //get TransactionHistory
    @GET("users/{id}/financial-history-details/")
    Call<TransactionHistoryModel>getTransactionHistory(@Path(value = "id", encoded = false) int id,
                                                       @Header("Authorization") String tokenString);

    //First step Register webservice
//    @POST("users/sign-up-stepone")
    @POST("verify/")
    Call<StepOneRegisterModel>StepOneRegister(@Body JsonObject data );

    //getClient Token
    @GET("users/{id}/get-client-token/")
    Call<ClientTokenModel>getClientToken(@Path(value = "id", encoded = false) int id,
                                         @Header("Authorization") String tokenString);
    //Create transition webservice
    @POST("users/{id}/create-transaction/")
    Call<SendPaymentNonceToServerModel> CreateTransaction(@Path(value = "id", encoded = false) int id,
                                                          @Header("Authorization") String tokenString,
                                                          @Body JsonObject data);
    // UserDetails Webservice
//    @POST("users/get-user-profile")
    @GET("users/{id}/")
    Call<UserDetailsModel>getUserDetails(@Path(value = "id", encoded = false) int id,
                                         @Header("Authorization") String tokenString);

    @HTTP(method = "DELETE", path = "users/{id}/remove-dog/", hasBody = true)
    Call<LoginModel> RemoveDog(@Path(value = "id", encoded = false) int id,
                               @Header("Authorization") String tokenString,
                               @Body JsonObject data);

    //    @POST("users/view-dog-session")
    @PUT("users/{id}/view/")
    Call <LiveSessionModel> LiveSession(@Path(value = "id", encoded = false) int id,
                                        @Header("Authorization") String tokenString);

    //Get latest setting info
    @POST("settings/info/")
    Call<SettingsModel> getSettingsInfo(@Body JsonObject data);
}