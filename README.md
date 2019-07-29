#ReactNativeHybrid
	
## Mengapa ?
karena `react-native` jelek, terus berarti `react-native` ga bakalan booming? terus bagaimana nasib coder2 js kayak aing?

## Apa ?
Ide nya sih membatasi ruang `react-native` per Activity Android, jd load JS nya ga kegedean, tp masih bisa manggil Native Function

### Activity1 -> react-native1.bundle
### Activity2 -> react-native2.bundle

## Bagaimana ?
bikin `react-native` per module ntar di load di activitynya, terus daftarin Native Function yg mau dipake di `react-native` pada activitynya

## Cara Dev nya ?
gini, anda clone ini juga bisa, ato gua kasih general idea nya aja, lu bikin android native project, terus lu pasangin tuh ama `react-native`
linknya yg ini nih `https://facebook.github.io/react-native/docs/integration-with-existing-apps` , nah tp jgn ngikutin step terakhirnya, sesat itu
ikutin langkah gua yg ada di script `package.json`, yg bundle2 itu tiap kali lu pada ngebuild apk, kalo masih dev di bawah ini caranya

## Dev ?
 - buka terminal, masuk ke folder utama
 - seperti biasa `npm i`
 - nyalain server react-nativenya `react-native start`
 - kalo di device jgn lupa `adb reverse tcp:8081 tcp:8081` inget setelah dikonekin device nya, biar ga bolong react nativenya
 - kalo pgn nge log nyalain log nya `react-native log-android` di tab terminal yg lain
 - (opsi 1) terus jalanin android nya `react-native run-android` 
 - (opsi 2) jalanin pake android studio, enakan pake android studio sih ada intellij, buka android studio, terus open project pilih yg folder `/android`
dah tinggal lu utak-utik deh itu java nya ato javascript nya, yg native function ikutin contoh yg ada di sini

## Siapa ?
-  [Aji Agahari](mailto:ajiagahari@efishery.com) or 
    (pembikinjanda@gmail.com) 
-  [Sjarif HD](mailto:sjarif.hd@efishery.com) or (sjarif.hd@gmail.com) 

##Kelanjutan ?
 - develop dengan component yang lebih besar
