function testShell(){
    print("shell:" + shell);
    var command = "am start --activity-clear-top -a webview.intent.action.OPEN -d https://cisegame.top/  -e h '{\"headers\":[\"Referer:https://m.facebook.com\"]}'"
    print(command);
    print("output:" + shell.sudo(command));

    print(shell.installApp("/sdcard/test.apk"))

}

testShell();