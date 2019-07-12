package com.chabeletsv.flutter_module_bot.host;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.labiba.bot.Activities.ChatBotSplashActivity;
import com.labiba.bot.Others.Options;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  private static final String CHANNEL = "demo.gawkat.com/info";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);


    new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(new MethodChannel.MethodCallHandler() {
      @Override
      public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getMessage")){
          String message = "yo yoy oy";
          result.success(message);


          startActivity(new Intent(getApplicationContext(), ChatBotSplashActivity.class));
          finish();

          Options options = new Options(getApplicationContext());
          options.setRecipientId("b474192c-a618-4c49-a5ee-663414fd75e5"); // Your bot id (Required)
          options.setStatusBarColor("a9a9a9"); // To change status bar color .
          options.setToolbarBackground("FFECECEC"); // To change ToolBar color .
          options.setSplashLogo("https://ImageLink.png"); // To change splash screen
        }
      }
    });
  }
}
