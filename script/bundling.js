const shell = require("shelljs");

const bundles = ['ListNoteComponent','DetailNoteComponent', 'AddNoteComponent']; //add your entry file for react-native bundle here

bundles.forEach((bundle) => {
  shell.exec(`react-native bundle --platform android --dev false --entry-file ${bundle}.js --bundle-output android/app/src/main/assets/${bundle}.android.bundle --assets-dest android/app/src/main/res`);
})
