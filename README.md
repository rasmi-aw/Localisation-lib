# Localisation-lib
A java application to add localisation to your apps

Localisation is an open sour java Library, it's used to add localisation layer to your java apps, till now it contains, Countries,States and cities, later we will add languages separately.  

**Note**: This library executes an **http request** to fetch the needed data.

# 1- Integration   
This library can be used in many different ways, all versions are published on Maven Central, as all other libraries to use it you need to include its dependency in your code, the next steps give you a hint about that.

## 1.1 Maven   

```xml
 <dependency>
   <groupId>com.beastwall</groupId>
   <artifactId>localisation</artifactId>
   <version>1.0.1</version>
 </dependency> 
```

## 1.2 Gradle   
```gradle 
implementation 'com.beastwall:localisation:1.0.1'
```

## 1.3 Other methods   
For other usages (gradle kotlin, scala etc...), see the link below  
https://search.maven.org/artifact/com.beastwall/localisation/1.0.1/jar

# 2- How to use it ?
Till now, the only way to use this library is as follows:

```java

// Fetch all countries with their cities and states
 List<Country> countries = Localisation.getAllCountriesStatesAndCities();

```

You might want to get states for a specific Country:
```java
 //Get states for country
 if (countries != null && !countries.isEmpty()) {
     State[] states = countries.get(0).getStates();
     State state = states[0];
 }

```

You might want to get cities for a specific state:
```java
//Get cities for a state
 if (state != null) {
     City city = state.getCities()[0];
 }

```

# Android
As you all know, Google has removed HttpClient java class from Android Sdk, and since this library uses **HttpClient**, there's a solution which is telling the system that we still want to use HttpClient, by adding the next line in your gradle file.

**Note**: don't forget to add Network permission in your Manifest.xml

```groovy
android {
useLibrary 'org.apache.http.legacy'
}     
```

