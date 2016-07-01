# OAuth2-Client
Example of utilizing side services using OAuth2 protocol

Refer to [oauth2-intro.adoc](oauth2-intro.adoc) for info on how this app works.

**How to run this app**
Suppose you have maven installed and project pulled from this repo.
 
Go to Facebook-OAuth2/ and run
```
$ mvn clean package && mvn jetty:run
```
Now you have the application app and running on _localhost:8888/facebook-service_.
Test _username_ is "user" and _password_ "user" for login to the app.

Then you are going to be prompted to enter you facebook account and give permissions to the app.

After successful login to Facebook account you are redirected to the page with your user info: name and id.

