import retrofit2.http.* 
 interface BitriseAPIService{
     
/**
* List all the available Bitrise addons
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/addons")
fun getListOfAvailableBitriseAddons() : Any

     
/**
* Show details of a specific Bitrise addon
* @param addonid 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/addons/{addonid}")
fun getASpecificBitriseAddon(@Path("addonid") addonid : String) : Any

     
/**
* List all the android keystore files that have been uploaded to a specific app.
* @param appslug 
* @param next Slug of the first android keystore file in the response
* @param limit Max number of build certificates per page is 50.
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/android-keystore-files")
fun getAListOfTheAndroidKeystoreFiles(@Path("appslug") appslug : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Add a new Android keystore file to an app
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/android-keystore-files")
fun createAnAndroidKeystoreFile(@Path("appslug") appslug : String) : Any

     
/**
* Add new avatar candidates to a specific app
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/avatar-candidates")
fun createAvatarCandidates(@Path("appslug") appslug : String) : Any

     
/**
* Promotes an avatar candidate for an app
* @param appslug 
* @param avatarslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@PATCH("https://api.bitrise.io/v0.1/apps/{appslug}/avatar-candidates/{avatarslug}")
fun promoteAnAvatarCandidate(@Path("appslug") appslug : String, @Path("avatarslug") avatarslug : String) : Any

     
/**
* Get the full `bitrise.yml` configuration of an application, by providing the app slug. It returns the current `bitrise.yml` that is stored on bitrise.io in full, including the trigger map, the different workflows and the Steps.
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/bitrise.yml")
fun getBitriseymlOfASpecificApp(@Path("appslug") appslug : String) : Any

     
/**
* Upload a new bitrise.yml for your application.
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/bitrise.yml")
fun uploadANewBitriseymlForYourApplication(@Path("appslug") appslug : String) : Any

     
/**
* Retrieve data of a specific build certificate. You can fetch the build certificate slug for this endpoint if you first call the [GET /apps/{app-slug}/build-certificates](https://api-docs.bitrise.io/#/build-certificate/build-certificate-list) endpoint to list all available build certificates of an app. Read more in our [Getting a specific iOS code signing file's data](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#getting-a-specific-ios-code-signing-files-data) guide.
* @param appslug 
* @param buildcertificateslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/build-certificates/{buildcertificateslug}")
fun getASpecificBuildCertificate(@Path("appslug") appslug : String, @Path("buildcertificateslug") buildcertificateslug : String) : Any

     
/**
* Delete an app's build certificate. You can fetch the build certificate slug for this endpoint if you first call the [GET /apps/{app-slug}/build-certificates](https://api-docs.bitrise.io/#/build-certificate/build-certificate-list) endpoint to list all available build certificates of an app. Read more in our [Deleting an iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#deleting-an-ios-code-signing-file) guide.
* @param appslug 
* @param buildcertificateslug 
**/
@Headers("Authorization: <API Key>)")
@DELETE("https://api.bitrise.io/v0.1/apps/{appslug}/build-certificates/{buildcertificateslug}")
fun deleteABuildCertificate(@Path("appslug") appslug : String, @Path("buildcertificateslug") buildcertificateslug : String) : Any

     
/**
* Update an uploaded build certificate's attributes. You can fetch the build certificate slug for this endpoint if you first call the [GET /apps/{app-slug}/build-certificates](https://api-docs.bitrise.io/#/build-certificate/build-certificate-list) endpoint. Read more in our [Updating an uploaded iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#confirming-the-ios-code-signing-file-upload) guide.
* @param appslug 
* @param buildcertificateslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@PATCH("https://api.bitrise.io/v0.1/apps/{appslug}/build-certificates/{buildcertificateslug}")
fun updateABuildCertificate(@Path("appslug") appslug : String, @Path("buildcertificateslug") buildcertificateslug : String) : Any

     
/**
* This is the last step of uploading a build certificate to Bitrise. Confirm the build certificate upload and view the file on the Code Signing tab of a specific app. Read more in our [Confirming the iOS code signing file upload](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#confirming-the-ios-code-signing-file-upload) guide.
* @param appslug 
* @param buildcertificateslug 
**/
@Headers("Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/build-certificates/{buildcertificateslug}/uploaded")
fun confirmABuildCertificateUpload(@Path("appslug") appslug : String, @Path("buildcertificateslug") buildcertificateslug : String) : Any

     
/**
* List all the build certificates that have been uploaded to a specific app. Read more in our [Listing the uploaded iOS code signing files of an app](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#listing-the-uploaded-ios-code-signing-files-of-an-app) guide.
* @param appslug 
* @param next Slug of the first build certificate in the response
* @param limit Max number of build certificates per page is 50.
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/build-certificates")
fun getAListOfTheBuildCertificates(@Path("appslug") appslug : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Create a temporary pre-signed upload URL for the build certificate and upload the file to AWS with a simple `curl` request. To complete the uploading process and view your files on the Code Signing tab of your app, continue with the [POST /apps/{app-slug}/build-certificates/{build-certificate-slug}/uploaded](https://api-docs.bitrise.io/#/build-certificate/build-certificate-confirm) endpoint. Read more in our [Creating and uploading an iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#creating--uploading-an-ios-code-signing-file) guide.
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/build-certificates")
fun createABuildCertificate(@Path("appslug") appslug : String) : Any

     
/**
* List the existing open build requests of a specified Bitrise app
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/build-requests")
fun listTheOpenBuildRequestsForAnApp(@Path("appslug") appslug : String) : Any

     
/**
* Update a specific build request of a specific app
* @param appslug 
* @param buildrequestslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@PATCH("https://api.bitrise.io/v0.1/apps/{appslug}/build-requests/{buildrequestslug}")
fun updateABuildRequest(@Path("appslug") appslug : String, @Path("buildrequestslug") buildrequestslug : String) : Any

     
/**
* Retrieve data of a specific build artifact. The response output contains a time-limited download url (expires in 10 minutes) and a public install page URL. You can view the build artifact with both URLs, but the public install page url will not work unless you [enable it](https://devcenter.bitrise.io/tutorials/deploy/bitrise-app-deployment/#enabling-public-page-for-the-app).
* @param appslug 
* @param buildslug 
* @param artifactslug 
* @param download Setting this will result in a redirect to the artifact download location
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/builds/{buildslug}/artifacts/{artifactslug}")
fun getASpecificBuildArtifact(@Path("appslug") appslug : String, @Path("buildslug") buildslug : String, @Path("artifactslug") artifactslug : String, @Query("download") download : String) : Any

     
/**
* Delete a build artifact of an app's build. The required parameters are app slug, build slug and artifact slug. You can fetch the build artifact slug if you first list all build artifacts of an app with the [/apps/](https://api-docs.bitrise.io/#/build-artifact/artifact-list) endpoint.
* @param appslug 
* @param buildslug 
* @param artifactslug 
**/
@Headers("Authorization: <API Key>)")
@DELETE("https://api.bitrise.io/v0.1/apps/{appslug}/builds/{buildslug}/artifacts/{artifactslug}")
fun deleteABuildArtifact(@Path("appslug") appslug : String, @Path("buildslug") buildslug : String, @Path("artifactslug") artifactslug : String) : Any

     
/**
* Update the `is_public_page_enabled` attribute of your app's build. The required parameters are app slug, build slug and artifact slug. You can fetch the build artifact slug if you first list all build artifacts of an app with the [GET /apps/](https://api-docs.bitrise.io/#/build-artifact/artifact-list) endpoint.
* @param appslug 
* @param buildslug 
* @param artifactslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@PATCH("https://api.bitrise.io/v0.1/apps/{appslug}/builds/{buildslug}/artifacts/{artifactslug}")
fun updateABuildArtifact(@Path("appslug") appslug : String, @Path("buildslug") buildslug : String, @Path("artifactslug") artifactslug : String) : Any

     
/**
* List all build artifacts that have been generated for an app's build. You can use the created build artifact slugs from the response output to retrieve data of a specific build artifact with the [GET/apps/](https://api-docs.bitrise.io/#/build-artifact/artifact-show) endpoint or update a build artifact with the [PATCH/apps](https://api-docs.bitrise.io/#/build-artifact/artifact-update) endpoint.
* @param appslug 
* @param buildslug 
* @param next Slug of the first build artifact in the response
* @param limit Max number of build artifacts per page is 50.
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/builds/{buildslug}/artifacts")
fun getAListOfAllBuildArtifacts(@Path("appslug") appslug : String, @Path("buildslug") buildslug : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Get the specified build of a given Bitrise app. You need to provide both an app slug and a build slug. You can get the build slug either by calling the [/builds](https://api-docs.bitrise.io/#/builds/build-list) endpoint or by clicking on the build on bitrise.io and copying the slug from the URL. The endpoint returns all the relevant data of the build.
* @param appslug 
* @param buildslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/builds/{buildslug}")
fun getABuildOfAGivenApp(@Path("appslug") appslug : String, @Path("buildslug") buildslug : String) : Any

     
/**
* Abort a specific build. Set an abort reason with the `abort_reason` parameter. Use the `abort_with_success` parameter to abort a build but still count it as a successful one.
* @param appslug 
* @param buildslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/builds/{buildslug}/abort")
fun abortASpecificBuild(@Path("appslug") appslug : String, @Path("buildslug") buildslug : String) : Any

     
/**
* Get the bitrise.yml file of one of the builds of a given app. This will return the `bitrise.yml` configuration with which the build ran. You can compare it to [the current bitrise.yml configuration](https://api-docs.bitrise.io/#/application/app-config-datastore-show) of the app.
* @param appslug 
* @param buildslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/builds/{buildslug}/bitrise.yml")
fun getTheBitriseymlOfABuild(@Path("appslug") appslug : String, @Path("buildslug") buildslug : String) : Any

     
/**
* Get the build log of a specified build of a Bitrise app. You can get the build slug either by calling the [/builds](https://api-docs.bitrise.io/#/builds/build-list) endpoint or by clicking on the build on bitrise.io and copying the slug from the URL.
* @param appslug 
* @param buildslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/builds/{buildslug}/log")
fun getTheBuildLogOfABuild(@Path("appslug") appslug : String, @Path("buildslug") buildslug : String) : Any

     
/**
* List all the builds of a specified Bitrise app. Set parameters to filter builds: for example, you can search for builds run with a given workflow or all builds that were triggered by Pull Requests. It returns all the relevant data of the build.
* @param appslug 
* @param sort_by Order of builds: sort them based on when they were created or the time when they were triggered
* @param branch The branch which was built
* @param workflow The name of the workflow used for the build
* @param commit_message The commit message of the build
* @param trigger_event_type The event that triggered the build (push, pull-request, tag)
* @param pull_request_id The id of the pull request that triggered the build
* @param build_number The build number
* @param after List builds run after a given date (Unix Timestamp)
* @param before List builds run before a given date (Unix Timestamp)
* @param status The status of the build: not finished (0), successful (1), failed (2), aborted with failure (3), aborted with success (4)
* @param next Slug of the first build in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/builds")
fun listAllBuildsOfAnApp(@Path("appslug") appslug : String, @Query("sort_by") sort_by : String, @Query("branch") branch : String, @Query("workflow") workflow : String, @Query("commit_message") commit_message : String, @Query("trigger_event_type") trigger_event_type : String, @Query("pull_request_id") pull_request_id : String, @Query("build_number") build_number : String, @Query("after") after : String, @Query("before") before : String, @Query("status") status : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Trigger a new build. Specify an app slug and at least one parameter out of three: a git tag or git commit hash, a branch, or a workflow ID. You can also set specific parameters for Pull Request builds and define additional environment variables for your build. [Check out our detailed guide](https://devcenter.bitrise.io/api/build-trigger/).
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/builds")
fun triggerANewBuild(@Path("appslug") appslug : String) : Any

     
/**
* Retrieve data of a specific generic project file to check its attributes and optionally modify them with the [PATCH /apps/](https://api-docs.bitrise.io/#/generic-project-file/generic-project-file-update) endpoint. Read more in our [Retrieving a specific file's data](https://devcenter.bitrise.io/api/managing-files-in-generic-file-storage/#retrieving-a-specific-files-data) guide.
* @param appslug 
* @param genericprojectfileslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/generic-project-files/{genericprojectfileslug}")
fun getASpecificGenericProjectFile(@Path("appslug") appslug : String, @Path("genericprojectfileslug") genericprojectfileslug : String) : Any

     
/**
* Delete an app's generic project file. You can fetch an app's generic project file slug if you first list all the uploaded files with the [GET /apps/{app-slug}/generic-project-files](https://api-docs.bitrise.io/#/generic-project-file/generic-project-file-list) endpoint. Read more in our [Deleting a file](https://devcenter.bitrise.io/api/managing-files-in-generic-file-storage/#deleting-a-file) guide.
* @param appslug 
* @param genericprojectfileslug 
**/
@Headers("Authorization: <API Key>)")
@DELETE("https://api.bitrise.io/v0.1/apps/{appslug}/generic-project-files/{genericprojectfileslug}")
fun deleteAGenericProjectFile(@Path("appslug") appslug : String, @Path("genericprojectfileslug") genericprojectfileslug : String) : Any

     
/**
* Update a generic project file's attributes. You can fetch an app's generic project file slug if you first list all the uploaded files with the [GET /apps/{app-slug}/generic-project-files](https://api-docs.bitrise.io/#/generic-project-file/generic-project-file-list) endpoint. Read more in our [Updating an uploaded file](https://devcenter.bitrise.io/api/managing-files-in-generic-file-storage/#updating-an-uploaded-file) guide.
* @param appslug 
* @param genericprojectfileslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@PATCH("https://api.bitrise.io/v0.1/apps/{appslug}/generic-project-files/{genericprojectfileslug}")
fun updateAGenericProjectFile(@Path("appslug") appslug : String, @Path("genericprojectfileslug") genericprojectfileslug : String) : Any

     
/**
* This is the last step of uploading a generic project file to Bitrise. Confirm the generic project file upload and view the file on the Code Signing tab of a specific app. Read more in our [Confirming the upload](https://devcenter.bitrise.io/api/managing-files-in-generic-file-storage/#confirming-the-file-upload) guide.
* @param appslug 
* @param genericprojectfileslug 
**/
@Headers("Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/generic-project-files/{genericprojectfileslug}/uploaded")
fun confirmAGenericProjectFileUpload(@Path("appslug") appslug : String, @Path("genericprojectfileslug") genericprojectfileslug : String) : Any

     
/**
* List all the generic project files that have been uploaded to a specific app. Read more in our [Listing the uploaded files of an app](https://devcenter.bitrise.io/api/managing-files-in-generic-file-storage/#listing-the-uploaded-files-of-an-app) guide.
* @param appslug 
* @param next Slug of the first generic project file in the response
* @param limit Max number of build certificates per page is 50.
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/generic-project-files")
fun getAListOfTheGenericProjectFiles(@Path("appslug") appslug : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Create a temporary pre-signed upload URL (expires in 10 minutes) for the generic project file and upload it to AWS with a simple `curl` request. To complete the uploading process and view your files on the Code Signing tab of your app, continue with the [POST /apps/{app-slug}/generic-project-files/{generic-project-file-slug}/uploaded](https://api-docs.bitrise.io/#/generic-project-file/generic-project-file-confirm) endpoint. Read more in our [Creating and uploading files to Generic File Storage](https://devcenter.bitrise.io/api/managing-files-in-generic-file-storage/#creating-and-uploading-files-to-generic-file-storage) guide.
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/generic-project-files")
fun createAGenericProjectFile(@Path("appslug") appslug : String) : Any

     
/**
* Get the specified delivery item of an outgoing webhook of a Bitrise application
* @param appslug 
* @param appwebhookslug 
* @param webhookdeliveryitemslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/outgoing-webhooks/{appwebhookslug}/delivery-items/{webhookdeliveryitemslug}")
fun getASpecificDeliveryItemOfAWebhook(@Path("appslug") appslug : String, @Path("appwebhookslug") appwebhookslug : String, @Path("webhookdeliveryitemslug") webhookdeliveryitemslug : String) : Any

     
/**
* Re-deliver the delivery item of a specified webhook of a Bitrise application
* @param appslug 
* @param appwebhookslug 
* @param webhookdeliveryitemslug 
**/
@Headers("Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/outgoing-webhooks/{appwebhookslug}/delivery-items/{webhookdeliveryitemslug}/redeliver")
fun redeliverTheWebhookDeliveryItemsOfAnApp(@Path("appslug") appslug : String, @Path("appwebhookslug") appwebhookslug : String, @Path("webhookdeliveryitemslug") webhookdeliveryitemslug : String) : Any

     
/**
* List all the delivery items of an outgoing webhook of a Bitrise application
* @param appslug 
* @param appwebhookslug 
* @param next Slug of the first delivery item in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/outgoing-webhooks/{appwebhookslug}/delivery-items")
fun listTheWebhookDeliveryItemsOfAnApp(@Path("appslug") appslug : String, @Path("appwebhookslug") appwebhookslug : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Update an existing outgoing webhook (URL, events, secrets and headers) for a specified Bitrise app. Even if you do not want to change one of the parameters, you still have to provide that parameter as well: simply use its existing value.
* @param appslug 
* @param appwebhookslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@PUT("https://api.bitrise.io/v0.1/apps/{appslug}/outgoing-webhooks/{appwebhookslug}")
fun updateAnOutgoingWebhookOfAnApp(@Path("appslug") appslug : String, @Path("appwebhookslug") appwebhookslug : String) : Any

     
/**
* Delete an existing outgoing webhook for a specified Bitrise app.
* @param appslug 
* @param appwebhookslug 
**/
@Headers("Authorization: <API Key>)")
@DELETE("https://api.bitrise.io/v0.1/apps/{appslug}/outgoing-webhooks/{appwebhookslug}")
fun deleteAnOutgoingWebhookOfAnApp(@Path("appslug") appslug : String, @Path("appwebhookslug") appwebhookslug : String) : Any

     
/**
* List all the outgoing webhooks registered for a specified Bitrise app. This returns all the relevant data of the webhook, including the slug of the webhook and its URL.
* @param appslug 
* @param next Slug of the first webhook in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/outgoing-webhooks")
fun listTheOutgoingWebhooksOfAnApp(@Path("appslug") appslug : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Create an outgoing webhook for a specified Bitrise app: this can be used to send build events to a specified URL with custom headers. Currently, only build events can trigger outgoing webhooks.
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/outgoing-webhooks")
fun createAnOutgoingWebhookForAnApp(@Path("appslug") appslug : String) : Any

     
/**
* Retrieve data of a specific provisioning profile. You can fetch the provisioning profile's slug if you call the [GET /apps/{app-slug}/provisioning-profiles](https://api-docs.bitrise.io/#/provisioning-profile/provisioning-profile-list) endpoint. Read more in our [Getting a specific iOS code signing file's data](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#getting-a-specific-ios-code-signing-files-data) guide.
* @param appslug 
* @param provisioningprofileslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/provisioning-profiles/{provisioningprofileslug}")
fun getASpecificProvisioningProfile(@Path("appslug") appslug : String, @Path("provisioningprofileslug") provisioningprofileslug : String) : Any

     
/**
* Delete an app's provisioning profile. You can fetch the provisioning profile's slug if you call the [GET /apps/{app-slug}/provisioning-profiles](https://api-docs.bitrise.io/#/provisioning-profile/provisioning-profile-list) endpoint. Read more in our [Deleting an iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#deleting-an-ios-code-signing-file) guide.
* @param appslug 
* @param provisioningprofileslug 
**/
@Headers("Authorization: <API Key>)")
@DELETE("https://api.bitrise.io/v0.1/apps/{appslug}/provisioning-profiles/{provisioningprofileslug}")
fun deleteAProvisioningProfile(@Path("appslug") appslug : String, @Path("provisioningprofileslug") provisioningprofileslug : String) : Any

     
/**
* Update an uploaded provisioning profile's attributes. You can fetch the provisioning profile's slug if you call the [GET /apps/{app-slug}/provisioning-profiles](https://api-docs.bitrise.io/#/provisioning-profile/provisioning-profile-list) endpoint. Read more in our [Updating an uploaded iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#confirming-the-ios-code-signing-file-upload) guide.
* @param appslug 
* @param provisioningprofileslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@PATCH("https://api.bitrise.io/v0.1/apps/{appslug}/provisioning-profiles/{provisioningprofileslug}")
fun updateAProvisioningProfile(@Path("appslug") appslug : String, @Path("provisioningprofileslug") provisioningprofileslug : String) : Any

     
/**
* This is the last step of the upload process. Confirm the provisioning profile upload and view the file on the Code Signing tab of a specific app. Read more in our [Confirming the iOS code signing file upload](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#confirming-the-ios-code-signing-file-upload) guide.
* @param appslug 
* @param provisioningprofileslug 
**/
@Headers("Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/provisioning-profiles/{provisioningprofileslug}/uploaded")
fun confirmAProvisioningProfileUpload(@Path("appslug") appslug : String, @Path("provisioningprofileslug") provisioningprofileslug : String) : Any

     
/**
* List all the provisioning profiles that have been uploaded to a specific app. Read more in our [Listing the uploaded iOS code signing files of an app](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#listing-the-uploaded-ios-code-signing-files-of-an-app) guide.
* @param appslug 
* @param next Slug of the first provisioning profile in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/provisioning-profiles")
fun getAListOfTheProvisioningProfiles(@Path("appslug") appslug : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Create a temporary pre-signed upload URL (expires in 10 minutes) for the provisioning profile and upload it to AWS with a simple `curl` request. To complete the upload process, continue with the [POST /apps/{app-slug}/provisioning-profiles/{provisioning-profile-slug}/uploaded](https://api-docs.bitrise.io/#/provisioning-profile/provisioning-profile-confirm) endpoint. Read more in our [Creating and uploading an iOS code signing file](https://devcenter.bitrise.io/api/managing-ios-code-signing-files/#creating--uploading-an-ios-code-signing-file) guide.
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/provisioning-profiles")
fun createAProvisioningProfile(@Path("appslug") appslug : String) : Any

     
/**
* Get the details of a specific app by providing the app slug. You can get the app slug by calling the [/apps](https://api-docs.bitrise.io/#/application/app-list) endpoint or by opening the app on bitrise.io and copying the slug from the URL.
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}")
fun getASpecificApp(@Path("appslug") appslug : String) : Any

     
/**
* List all the provisioned addons for the authorized apps
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/addons")
fun getListOfTheAddonsForApps(@Path("appslug") appslug : String) : Any

     
/**
* Lists only those branches of a specified Bitrise app that have existing builds.
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/branches")
fun listTheBranchesWithExistingBuildsOfAnAppsRepository(@Path("appslug") appslug : String) : Any

     
/**
* List the workflows that were triggered at any time for a given Bitrise app. Note that it might list workflows that are currently not defined in the app's `bitrise.yml` configuration - and conversely, workflows that were never triggered will not be listed even if they are defined in the `bitrise.yml` file.
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/build-workflows")
fun listTheWorkflowsOfAnApp(@Path("appslug") appslug : String) : Any

     
/**
* Save the application after registering it on Bitrise and registering an SSH key (and, optionally, adding a webhook). With this endpoint you can define the initial configuration, define application-level environment variables, determine the project type, and set an Organization to be the owner of the app. Read more about the app registration process in our [detailed guide](https://devcenter.bitrise.io/api/adding-and-managing-apps/#adding-a-new-app).
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/finish")
fun saveTheApplicationAtTheEndOfTheAppRegistrationProcess(@Path("appslug") appslug : String) : Any

     
/**
* Add an SSH-key to a specific app. After creating an app, you need to register the SSH key so that Bitrise will be able to access and clone your repository during the build process. This requires the app slug of your newly created app.
* @param appslug 
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/register-ssh-key")
fun addAnSshkeyToASpecificApp(@Path("appslug") appslug : String) : Any

     
/**
* [Register an incoming webhook](https://devcenter.bitrise.io/api/incoming-and-outgoing-webhooks/#incoming-webhooks) for a specific application. You can do this during the app registration process or at any other time in an app's life. When calling this endpoint, a webhook is registered at your git provider: this is necessary to automatically trigger builds on Bitrise.
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/{appslug}/register-webhook")
fun registerAnIncomingWebhookForASpecificApplication(@Path("appslug") appslug : String) : Any

     
/**
* List registered test devices of all members of a specified Bitrise app
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps/{appslug}/test-devices")
fun listTheTestDevicesForAnApp(@Path("appslug") appslug : String) : Any

     
/**
* List all the apps available for the authenticated account, including those that are owned by other users or Organizations.
* @param sort_by Order of the applications: sort them based on when they were created or the time of their last build
* @param next Slug of the first app in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/apps")
fun getListOfTheApps(@Query("sort_by") sort_by : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Add a new app to Bitrise. This is the first step of the app registration process. To successfully set it up, you need to provide the required app parameters: your git provider, the repository URL, the slug of the repository as it appears at the provider, and the slug of the owner of the repository. Read more about the app creation process in our [detailed guide](https://devcenter.bitrise.io/api/adding-and-managing-apps/#adding-a-new-app).
**/
@Headers("Content-Type: application/json ",
"Authorization: <API Key>)")
@POST("https://api.bitrise.io/v0.1/apps/register")
fun addANewApp() : Any

     
/**
* Lists the active addon tokens of the user with some extra details.
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/me/addon-tokens")
fun theActiveAddonTokensOfTheUser() : Any

     
/**
* Removes the active addon token of the user.
* @param addonid 
**/
@Headers("Authorization: <API Key>)")
@DELETE("https://api.bitrise.io/v0.1/me/addon-tokens/{addonid}")
fun removesAnActiveAddonTokenOfTheUser(@Path("addonid") addonid : String) : Any

     
/**
* Shows the authenticated users profile data
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/me")
fun getYourProfileData() : Any

     
/**
* List all the Bitrise activity events
* @param next Slug of the first activity event in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/me/activities")
fun getListOfBitriseActivityEvents(@Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* Get the subscription of the user: the current plan, any pending plans, and the duration of a trial period if applicable
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/me/plan")
fun theSubscriptionPlanOfTheUser() : Any

     
/**
* Get a specified Bitrise organization that the user is part of.
* @param orgslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/organizations/{orgslug}")
fun getASpecifiedOrganization(@Path("orgslug") orgslug : String) : Any

     
/**
* List all the available apps owned by a given organization. [Find the organization URL](https://devcenter.bitrise.io/team-management/organizations/org-url/) of the organisations you are part of; be aware that the endpoint will not return any apps if the authenticated account is not a member of the given organisation.
* @param orgslug 
* @param sort_by Order of applications: sort them based on when they were created or the time of their last build
* @param next Slug of the first app in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/organizations/{orgslug}/apps")
fun getListOfTheAppsForAnOrganization(@Path("orgslug") orgslug : String, @Query("sort_by") sort_by : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* List all Bitrise organizations that the user is part of
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/organizations")
fun listTheOrganizationsThatTheUserIsPartOf() : Any

     
/**
* List all the provisioned addons for organization
* @param organizationslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/organizations/{organizationslug}/addons")
fun getListOfTheAddonsForOrganization(@Path("organizationslug") organizationslug : String) : Any

     
/**
* Show information about a specific user
* @param userslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/users/{userslug}")
fun getASpecificUser(@Path("userslug") userslug : String) : Any

     
/**
* List all the provisioned addons for the authenticated user
* @param userslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/users/{userslug}/addons")
fun getListOfTheAddonsForUser(@Path("userslug") userslug : String) : Any

     
/**
* List Apple API credentials for a specific Bitrise user
* @param userslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/users/{userslug}/apple-api-credentials")
fun listAppleApiCredentialsForASpecificUser(@Path("userslug") userslug : String) : Any

     
/**
* List all the available apps for the given user.  It needs the user slug that you can get from the [GET /me](https://api-docs.bitrise.io/#/user/user-profile) endpoint.
* @param userslug 
* @param sort_by Order of applications
* @param next Slug of the first app in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/users/{userslug}/apps")
fun getListOfTheAppsForAUser(@Path("userslug") userslug : String, @Query("sort_by") sort_by : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* List all the Bitrise builds that can be accessed with the authenticated account. Filter builds based on their owner, using the owner slug, or the status of the build.
* @param owner_slug The slug of the owner of the app or apps
* @param is_on_hold Indicates whether the build has started yet (true: the build hasn't started)
* @param status The status of the build: not finished (0), successful (1), failed (2), aborted with failure (3), aborted with success (4)
* @param next Slug of the first build in the response
* @param limit Max number of elements per page (default: 50)
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/builds")
fun listAllBuilds(@Query("owner_slug") owner_slug : String, @Query("is_on_hold") is_on_hold : String, @Query("status") status : String, @Query("next") next : String, @Query("limit") limit : String) : Any

     
/**
* List all available avatar candidates for an application
* @param appslug 
**/
@Headers("Authorization: <API Key>)")
@GET("https://api.bitrise.io/v0.1/v0.1/apps/{appslug}/avatar-candidates")
fun getListOfTheAvatarCandidates(@Path("appslug") appslug : String) : Any

}