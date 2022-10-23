
Contact: abdelouadoudrasmi@gmail.com  
Linkedin: https://www.linkedin.com/in/abdel-wadoud/  

The documentation can be found here:  
https://github.com/rasmi-aw/Localisation-lib/wiki

# Localisation
# 1- Integration   
This library can be used in many different ways, all versions are published on Maven Central, as all other libraries to use it you need to include its dependency in your code, the next steps give you a hint about that.

## 1.1 Maven   
Add these 2 dependencies in  ```xml <dependencies>```, in your **pom.xml**
```xml
<!--Localisation library-->
 <dependency>
   <groupId>com.beastwall</groupId>
   <artifactId>localisation</artifactId>
   <version>1.0.5</version>
 </dependency> 

<!--Gson to parse Json responses-->
 <dependency>
   <groupId>com.google.code.gson</groupId>
   <artifactId>gson</artifactId>
   <version>2.9.1</version>
 </dependency>
```

## 1.2 Gradle   
in your gradle (module) file add these two dependencies

```groovy 
//Use Localisation library along with Gson to parse responses
implementation 'com.beastwall:localisation:1.0.5'
implementation 'com.google.code.gson:gson:2.9.1'
```

### 1.2.1 Android internet permission   
For Android users to use this library you have to include these 2 permission in your Manifest file

```xml
<!--Internet permissions for the library to fetch countries-->

</manifest>
  ...
  <uses-permission android:name="android.permission.INTERNET" />
  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
  ...
</manifest>
```

## 1.3 Other methods   
For other usages (gradle kotlin, scala etc...), see the link below  
https://search.maven.org/artifact/com.beastwall/localisation/1.0.5/jar
https://search.maven.org/artifact/com.google.code.gson/gson/2.9.1/jar

# 2- How to use it ?
The library has one method holder which is **Localisation** class, in contains some static methods to fetch your needed data, and it should be used as follows:

## 2.0 Android Note:  
For android apps (**getAllCountriesStatesAndCities**, **getCountryFlagSVG**) methods have to be called in a separate thread than the main thread, since we're not allowed to execute Network calls in app main thread you can check that in this demo app MainActivity.java class, from here:  
[Android usage example](https://github.com/rasmi-aw/Localisation-lib/blob/master/demo/LocalisationDemoApp/app/src/main/java/com/beastwall/localisationdemoapp/MainActivity.java)

## 2.1 Getting countries
```java

// Fetch all countries with their cities and states
 List<Country> countries = Localisation.getAllCountriesStatesAndCities();

```
## 2.2 Getting states

You might want to get states for a specific Country:
```java
//Get states for country
List<State> states = country.getStates();

```
## 2.3 Getting cities
You might want to get cities for a specific state:
```java
//Get cities for a state
for (State state : states) {
    //Get cities for a state
    List<City> cities = state.getCities();
}

```

## 2.4 Getting country flag
In some cases you might want to display a specific country flag, and **getCountryFlagSVG(...)** method returns a byte array of a flag that can be saved as an SVG file, since it was an svg file before fetching it.

To get a country flag, all you need to do is to specify it's code for examle **Algeria** => **dz**, and the format of the flag, whether it's a **RECTANGLE**, or a **SQUARE**.

```java
//Get countries Svg square flags
for (Country c : countries) {
    byte[] countryFlag = Localisation.getCountryFlagSVG(c.getIso2(), Form.SQUARE);
    //Do something like saving the file
}

//Get Algeria's square flag with code "dz"
byte[] dz = Localisation.getCountryFlagSVG("dz", Form.RECTANGLE);
```
**Note** you can save this svg bytes array into a file and get the full file path with one line of code, using my previously published library:  
https://github.com/rasmi-aw/StorageManager

```java
//Save Svg flag (byte array) into a file and get its path
String filePath = FileSaver.get().save(dz,"dz.svg");

```
## 2.5 Get countries Only
```java
//Get Countries Only
you might want to get countries without states and cities as follows
List<Country> countriesList = Localisation.getCountriesList();
```

## 2.6 Full example

```java
// Fetch all countries with an Http call
List<Country> countries = Localisation.getAllCountriesStatesAndCities();

for (Country country : countries) {
    //Get countries Svg flag
    byte[] countryFlag = Localisation.getCountryFlagSVG(country.getIso2(), Form.SQUARE);

    //Get states for country
    List<State> states = country.getStates();

    for (State state : states) {
        //Get cities for a state
        List<City> cities = state.getCities();
    }
}
```

# 3- Demo(s)
Find Our Java demo here:  
https://github.com/rasmi-aw/Localisation-lib/tree/master/demo/LocalisationDemo

Android demo here:  
https://github.com/rasmi-aw/Localisation-lib/tree/master/demo/LocalisationDemoApp  
<pre>


</pre>
<p align="center">
<img src="https://raw.githubusercontent.com/rasmi-aw/Localisation-lib/master/demo/LocalisationDemoApp/screenshot.png" width="250">
 </p>
