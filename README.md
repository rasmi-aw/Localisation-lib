# Localisation
Localisation is an open source java Library, it's used to add localisation layer to your java apps, till now it contains, Countries,States and cities, later we will add languages separately.  

**Note**: This library executes an **http request** to fetch the needed data.

# 1- Integration   
This library can be used in many different ways, all versions are published on Maven Central, as all other libraries to use it you need to include its dependency in your code, the next steps give you a hint about that.

## 1.1 Maven   

```xml
 <dependency>
   <groupId>com.beastwall</groupId>
   <artifactId>localisation</artifactId>
   <version>1.0.2</version>
 </dependency> 
```

## 1.2 Gradle   
```gradle 
implementation 'com.beastwall:localisation:1.0.2'
```

## 1.3 Other methods   
For other usages (gradle kotlin, scala etc...), see the link below  
https://search.maven.org/artifact/com.beastwall/localisation/1.0.2/jar

# 2- How to use it ?
Till now, the only way to use this library is as follows:


## 2.1 Getting countries
```java

// Fetch all countries with their cities and states
 List<Country> countries = Localisation.getAllCountriesStatesAndCities();

```
## 2.2 Getting states

You might want to get states for a specific Country:
```java
 //Get states for country
 if (countries != null && !countries.isEmpty()) {
     State[] states = countries.get(0).getStates();
     State state = states[0];
 }

```
## 2.3 Getting cities
You might want to get cities for a specific state:
```java
//Get cities for a state
 if (state != null) {
     City city = state.getCities()[0];
 }

```

## 2.4 Getting country flag
In some cases you might want to display a specific country flag, and **getCountryFlagSVG(...)** method returns a byte array of a flag than can be saved as an SVG file, since it was an svg file before fetching it.

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
//Get cities for a state
String filePath = FileSaver.get().save(dz,"dz.svg");

```


# 3- Android
As you all know, Google has removed HttpClient java class from Android Sdk, and since this library uses **HttpClient**, there's a solution which is telling the system that we still want to use HttpClient, by adding the next line in your gradle file.

**Note**: don't forget to add Network permission in your Manifest.xml

```groovy
android {
useLibrary 'org.apache.http.legacy'
}     
```

for more information check this response:  
https://stackoverflow.com/questions/49644066/what-are-the-implications-of-the-removal-of-httpclient-in-android-m

