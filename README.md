This is a simple Android Content Provider for serving json to webviews.

An easy way to play around with it is to create an app with [phonegap build](http://build.phonegap.com/),
and use its debug tool to test commands like this into your console.

```javascript
$.ajax({
  url: "content://org.opendatakit.FileContentProviderExample/",
  dataType: 'json',
  data: {},
  success: function(result){
	  alert("hi");
	  console.log(result);
  },
  error: function(e){
  	alert("Error");
  	console.log(e);
  }
});
```

This is a very helpful reference I used to make this example:s
http://helpmeco.de/2012/2/serving-android-webview-resources-with-content-providers